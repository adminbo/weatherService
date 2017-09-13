package com.zjkj.wxy.core.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.ConfigWxService;


@Controller
public class ConfigWxController {

	//spring 资源注入
			@Resource
			private ConfigWxService configWxService;

			
	//公众号配置
	 @RequestMapping("/toAddwxcharconfig")  
	    public String toAddUser(){  
	        return "/addwxcharconfig";  
	    }  
	      
	    @RequestMapping("/addwxcharconfig")// 请求url地址映射，类似Struts的action-mapping   
	    public String addwxcharconfig(Wechat wechat){  
	    	configWxService.addWechatswe(wechat);
	        return "redirect:/addwxcharconfig";  
	    }  
	
}
