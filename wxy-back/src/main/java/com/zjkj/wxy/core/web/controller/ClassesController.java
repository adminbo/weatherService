package com.zjkj.wxy.core.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;

@Controller
@RequestMapping("/classes")
public class ClassesController {
	@Resource
	private GradeService gradeService;
	@Resource
	private ClassesService classesService;
	
	
}
