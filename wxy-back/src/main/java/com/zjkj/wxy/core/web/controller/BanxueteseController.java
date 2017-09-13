package com.zjkj.wxy.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.CharacteristicService;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.SubjectService;
import com.zjkj.wxy.core.service.SystemRoleService;
import com.zjkj.wxy.core.service.TeachershowService;
import com.zjkj.wxy.core.utils.PageBean;
import com.zjkj.wxy.core.utils.UUIDUtils;

@Controller
@RequestMapping("/banxue")
public class BanxueteseController {
private Logger logger = Logger.getLogger(BanxueteseController.class);
			@Resource
			private TeachershowService teaservice;
			@Resource
			private GradeService gradeService;
			@Resource
			private SystemRoleService systemRoleService;
			@Resource
			private SubjectService subjectService;
			@Resource
			private SchoolService schoolService;
			@Resource
			private ClassesService classesService;
			@Resource
			private CharacteristicService characteristicService;
			
			//分页查询，模糊查询
			@RequestMapping("/banxuelist")  
		    public String banxuelist(Integer sid,Integer currentPage,Integer pageSize,Model model,HttpServletRequest request){
					HttpSession session = request.getSession();
					Integer id =(Integer) session.getAttribute("SCHOOLID");
					sid=id;
					PageBean<Trait> pg = new PageBean<>(request);
					DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Trait.class);
					User user =(User) session.getAttribute("loginUser");
					School school = user.getSchool();
					if(school==null){
						school = schoolService.findById(id);
					}
					detachedCriteria.add(Restrictions.eq("school", school));
					pg.setDetachedCriteria(detachedCriteria);
					characteristicService.pageQuery(pg);
					model.addAttribute("pageBean", pg);
	        		return "/banxue/banxuelist";
		    }
	/**
	 * 根据id查询，返回json对像
	 * @param id
	 * @return
	 */
			@RequestMapping(value = "/getById",produces = "application/json;charset=utf-8")
			@ResponseBody
			public Trait getById(Integer id){
				Trait trait = characteristicService.getTrait(id);
				System.out.println(trait);
				trait.setSchool(null);
				return trait;
			}
			/**
			 * 根据id删除
			 * @return
			 */
			@RequestMapping("/deleteById")
			public String deleteById(Integer id){
				characteristicService.deletById(id);
				return "redirect:banxuelist.do";
			}
			
			/**
			 * 添加新的教学特色
			 * @return
			 */
			@RequestMapping("/addNew")
			public String addNew(String title,String introduce,MultipartFile imgurl,HttpServletRequest request){
				String path=null;
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				HttpSession session = request.getSession();
				Integer id =(Integer) session.getAttribute("SCHOOLID");
				User user =(User) session.getAttribute("loginUser");
				School school = user.getSchool();
				if(school==null){
					school = schoolService.findById(id);
				}
				Trait t = new Trait();
				t.setSchool(school);
				t.setTitle(title);
				t.setIntroduce(introduce);
				try {
	    			if(!imgurl.isEmpty() ){
	    				String originalFilename = imgurl.getOriginalFilename();
	    				int lastIndexOf = originalFilename.lastIndexOf(".");
	    				String ex = originalFilename.substring(lastIndexOf+1);
	    				String random = UUIDUtils.getString(4);//4位随机字符串
	    				if(ex.equals("jpg") || ex.equals("png") || ex.equals("gif")){
	    					String realPath = request.getSession().getServletContext().getRealPath("/");
	    					String replace = realPath.replace(File.separator+"wxy-back", "");
	    					path=File.separator+"uploadImg"+File.separator+"trait"+File.separator+id+File.separator+random+"_"+originalFilename;
	    					logger.info("办学特色，，，上传图片-==="+originalFilename);
	    					File file = new File(replace+path);
	    					if(!file.exists()){
	    						file.mkdirs();
	    					}
	    					imgurl.transferTo(file);
	    					t.setImgurl(path);
	    					t.setPublishtime(df.format(new Date()));
	    					characteristicService.save(t);
	    				}
	    				
	    			}
	    		} catch (IllegalStateException | IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			logger.error(e.getMessage());;
	    		}
				return "redirect:banxuelist.do";
			}
}
