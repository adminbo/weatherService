package com.zjkj.wxy.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/safe")
public class InsuranceController {

	@RequestMapping("/toSafe")
	public String toSafe(Integer sid){
		
		return "insurance_management/insurance_info";
	}
	@RequestMapping("/toSafeList")
	public String toSafeList(){
		return "insurance_management/insurance_statistics";
	}
}
