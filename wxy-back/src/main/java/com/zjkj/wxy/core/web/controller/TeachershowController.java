package com.zjkj.wxy.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.SubjectService;
import com.zjkj.wxy.core.service.SystemRoleService;
import com.zjkj.wxy.core.service.TeacherService;
import com.zjkj.wxy.core.service.TeachershowService;
import com.zjkj.wxy.core.utils.PageBean;
import com.zjkj.wxy.core.utils.UUIDUtils;

@Controller
@RequestMapping("/teachers")
public class TeachershowController {
	private Logger logger = Logger.getLogger(TeachershowController.class);
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
		
		//分页查询，模糊查询
		@RequestMapping("/listTeachershow")  
	    public String listTeacher(Integer schoolId,Integer currentPage,Integer pageSize,Model model,HttpServletRequest request){
			   PageBean<Teacher> pg = new PageBean<>("fm",request);
			    List<Teacher> teachers=null;	
				HttpSession session = request.getSession();
				if(currentPage==null){
					currentPage=1;//默认第一页
				}
				if(pageSize==null){
					pageSize=10;//默认每页显示10条
				}
				pg.setCurrentPage(currentPage);
				pg.setPageSize(pageSize);
				Integer id=(Integer) session.getAttribute("SCHOOLID");//学校id
				schoolId=id;
	    		User user=(User) session.getAttribute("loginUser");
	    		Integer type = user.getType();
	    		if(type==4 || type==null){ //学校人员
	    			//离线查询对象
	    			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);	
	    			School school = user.getSchool();
	    			detachedCriteria.add(Restrictions.eq("school", school));
	    			detachedCriteria.add(Restrictions.eq("isshow", 1));
	    			pg.setDetachedCriteria(detachedCriteria);
	    			teaservice.pageQuery(pg);
	    		}
	    		if(type==2 || type==3){//代理商查询必须先选择学校
	    			Agent agent = user.getAgent();
	    			Integer aid = agent.getId();
	    			if(id!=null){
	    				School findById = schoolService.findById(id);
	    				//离线查询对象
	    				DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);
	    				detachedCriteria.add(Restrictions.eq("school", findById));
	    				detachedCriteria.add(Restrictions.eq("isshow", 1));
	    				pg.setDetachedCriteria(detachedCriteria);
	    				teaservice.pageQuery(pg);
	    			}
	    		}
	    		if(type==1){ //超级管理员查询 可以查询所有
	    			if(id==null){
	    				DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);
	    				detachedCriteria.add(Restrictions.eq("isshow", 1));
	    				pg.setDetachedCriteria(detachedCriteria);
	    				teaservice.pageQuery(pg);
	    			}else{
	    				School findById = schoolService.findById(id);
		    			//离线查询对象
		    			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);
		    			detachedCriteria.add(Restrictions.eq("school", findById));
		    			detachedCriteria.add(Restrictions.eq("isshow", 1));
		    			pg.setDetachedCriteria(detachedCriteria);
		    			teaservice.pageQuery(pg);
	    			}
	    		}
        		request.setAttribute("teachers", teachers);  
        		model.addAttribute("pageBean", pg);
        		return "/teacher/teacherlist";
	    }
		/**
		 * 根据id 查询
		 * @param id 查询id
		 */
		@RequestMapping(value = "/getById",produces = "application/json;charset=utf-8")
		@ResponseBody
		public Teacher getById(Integer id,HttpServletResponse response){
			Teacher findById = teaservice.findByIdForJson(id);
			String string = findById.toString();
			findById.setSchool(null);
			findById.setTrain(null);
			findById.setGradeClasses(null);
			findById.setTeaAcherattds(null);
			return findById;
		}
		
		/**
		 * 根据id删除
		 * @return
		 */
		@RequestMapping("/deleteById")
		public String deleteById(Integer id){
			teaservice.deleteById(id);

		return "redirect:listTeachershow.do";	
		}
		
		/**
		 * 根据id查询某个教师，和全部的职位信息
		 * @return
		 */
		@RequestMapping("/getTea")
		@ResponseBody
		public Map<String,Object>  getTea(Integer id,HttpServletRequest request){
			HttpSession session = request.getSession();
			Integer sid = (Integer) session.getAttribute("SCHOOLID");
			Map<String,Object> map = new HashMap<>();		
			Teacher tea = teaservice.findByIdForJson(id);
			tea.setSchool(null);
			tea.setTrain(null);
			tea.setGradeClasses(null);
			tea.setTeaAcherattds(null);
			map.put("teacher", tea);
			return map;
		}
		/**
		 * 查询该小所有的角色
		 * @param id
		 * @param request
		 * @return
		 */
		@RequestMapping("/getAllStation")
		@ResponseBody
		public Map<String,Object>  getAllStation(Integer id,HttpServletRequest request){
			HttpSession session = request.getSession();
			Integer sid = (Integer) session.getAttribute("SCHOOLID");
			Map<String,Object> map = new HashMap<>();
			DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
			criteria.add(Restrictions.eq("sid", sid));
			List<Role> roles = systemRoleService.findByCriteria(criteria );
			for (Role role : roles) {
				role.setParRole(null);
				role.setAuthoritys(null);
				role.setUsers(null);
			}
			map.put("roles", roles);
			return map;
		}
		/**
		 * 更新教师信息
		 * @return
		 */
		@RequestMapping("/updateTea")
		public String update(HttpServletRequest request,MultipartFile pic ,Integer tid,String introduce,String name,String station){
			String path=null;
			if(tid!=null){ 
	    		try {
	    			if(!pic.isEmpty() ){
	    				String originalFilename = pic.getOriginalFilename();
	    				int lastIndexOf = originalFilename.lastIndexOf(".");
	    				String ex = originalFilename.substring(lastIndexOf+1);
	    				String random = UUIDUtils.getString(4);//4位随机字符串
	    				if(ex.equals("jpg") || ex.equals("png") || ex.equals("gif")){
	    					String realPath = request.getSession().getServletContext().getRealPath("/");
	    					String replace = realPath.replace(File.separator+"wxy-back", "");
	    					path=File.separator+"uploadImg"+File.separator+"tea"+File.separator+random+"_"+originalFilename;
	    					logger.info("教师更新头像，，，上传图片-==="+originalFilename);
	    					File file = new File(replace+path);
	    					if(!file.exists()){
	    						file.mkdirs();
	    					}
	    					pic.transferTo(file);
	    				}
	    				teaservice.updateTea(path,tid,name,introduce,station);
	    			}
	    		} catch (IllegalStateException | IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			logger.error(e.getMessage());;
	    		}
	    	}
			return "redirect:listTeachershow.do";
		}

}
