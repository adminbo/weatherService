package com.zjkj.wxy.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.utils.UUIDUtils;

@Controller
public class SchoolEnvireController {
private Logger logger=Logger.getLogger(SchoolEnvireController.class);
	//spring 资源注入
			@Resource
			private SchoolEnvireService schoolEnvireService;
			@Resource
			private SchoolService schoolService;
			
			 public SchoolEnvireService getSchoolEnvireService() {
				return schoolEnvireService;
			}

			public void setSchoolEnvireService(SchoolEnvireService schoolEnvireService) {
				this.schoolEnvireService = schoolEnvireService;
			}

			      
			  
			     /**
			      * 查询该校的所有校园环境 
			      * @param request
			      * @param model
			      * @return
			      */
			    @RequestMapping("/getAllSchoolEnvire")  
			    public String getAllSchoolEnvire(HttpServletRequest request,Model model){
			    	List<Img> img =new ArrayList<>();
			    	HttpSession session = request.getSession();
			    	User loginUser =(User) session.getAttribute("loginUser");
			    	Integer sid =(Integer) session.getAttribute("SCHOOLID");
			    	Integer schoolid = loginUser.getSid();			    
			    		if(sid!=null ){
		    				//获取学校校id
		    				List<Img> findOfSchool = schoolEnvireService.findOfSchool(sid);
		    				img.addAll(findOfSchool);
			    		}
			    	request.setAttribute("schoolid", sid);
//			        List<Img> img = schoolEnvireService.findAll();
//			        request.setAttribute("img", img);  
			        model.addAttribute("img", img);
			        return "/schoolEnvire/schoollist_cam";
			    }  
			      /**
			       * 添加学校环境
			       * @param pic
			       * @param title
			       * @param request
			       * @return
			       */
			    @RequestMapping("/addSchoolEnv")
			   public String addSchoolEnv(MultipartFile pic,String title,HttpServletRequest request){
			    	HttpSession session = request.getSession();
			    	Integer id =(Integer) session.getAttribute("SCHOOLID");//所选的学校id
			    	if(id!=null){ //只有选择了学校才能上传添加
			    		try {
			    			if(!pic.isEmpty() && title!=null){
			    				Img img = new Img();
			    				img.setTitle(title);
			    				DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			    				String format = df.format(new Date());
			    				User user =(User) request.getSession().getAttribute("loginUser");
			    				School school = user.getSchool();
			    				if(school==null){
			    					school = schoolService.findById(id);
			    				}
			    				//Integer id = school.getId();
			    				String originalFilename = pic.getOriginalFilename();
			    				int lastIndexOf = originalFilename.lastIndexOf(".");
			    				String ex = originalFilename.substring(lastIndexOf+1);
			    				String random = UUIDUtils.getString(4);//4位随机字符串
			    				if(ex.equals("jpg") || ex.equals("png") || ex.equals("gif")){
			    					String realPath = request.getSession().getServletContext().getRealPath("/");
			    					String replace = realPath.replace(File.separator+"wxy-back", "");
			    					String path=File.separator+"uploadImg"+File.separator+"env"+File.separator+id+File.separator+format+"_"+random+"_"+originalFilename;
			    					logger.info("上传校园环境图片-==="+originalFilename);
			    					File file = new File(replace+path);
			    					if(!file.exists()){
			    						file.mkdirs();
			    					}
			    					pic.transferTo(file);
			    					img.setUrl(path);
			    				}
			    				
			    				img.setUptime(System.currentTimeMillis());
			    				img.setState(1);
			    				img.setIsdown(0);//默认上架状态
			    				ImgDetail imgDetail=new ImgDetail();
			    				imgDetail.setSchool(school);
			    				imgDetail.setType(1);
			    				schoolEnvireService.save(imgDetail,img);
			    			}
			    		} catch (IllegalStateException | IOException e) {
			    			// TODO Auto-generated catch block
			    			e.printStackTrace();
			    			logger.error(e.getMessage());;
			    		}
			    	}
				   return "redirect:/getAllSchoolEnvire.do";
			   }
			    /**
			     * 根据id删除
			     * @param id
			     * @return
			     */
			    @RequestMapping("/env/deleteById.do")
			    public String deleteById(Integer id){
			    	schoolEnvireService.deleteById(id);
			    	return "redirect:/getAllSchoolEnvire.do";
			    }
			    /***
			     * 上架显示图片
			     * @param id
			     * @return
			     */
			    @RequestMapping("/env/showPicById.do")
			    public String showPic(Integer id){
			    	schoolEnvireService.updateToShow(id);
			    	return "redirect:/getAllSchoolEnvire.do";
			    }
			    /**
			     * 下架图片不显示
			     * @param id
			     * @return
			     */
			    @RequestMapping("/env/noShowPicById.do")
			    public String downPic(Integer id){
			    	schoolEnvireService.updateToNoShow(id);
			    	return "redirect:/getAllSchoolEnvire.do";
			    }
			    
			    
	public static void main(String[] args) {
//		String s="jj.jj.js";
//		int lastIndexOf = s.lastIndexOf(".");
//		String substring = s.substring(lastIndexOf);
//		System.out.println(substring);
	}
}
