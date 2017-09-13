package com.zjkj.wxy.core.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.SubjectService;
import com.zjkj.wxy.core.service.SystemRoleService;
import com.zjkj.wxy.core.service.TeachershowService;
import com.zjkj.wxy.core.utils.PageBean;

@Controller
public class PresidentController {
	protected DetachedCriteria detachedCriteria=null;
	//分页查询对象
	protected PageBean pageBean=new PageBean();
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
	@RequestMapping("/president")  
    public String foodweeklist(Integer currentPage,Integer pageSize,Model model,HttpServletRequest request){
    		List<Teacher> img = teaservice.findAll();
    		request.setAttribute("img", img);  
    		model.addAttribute("img", img);
    		return "/president/president_email";
    }

}
