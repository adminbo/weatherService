package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.service.SystemAgentService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/system")
public class SystemAgentController {
	protected Logger  logger = Logger.getLogger(this.getClass());
	@Resource
	private SystemAgentService systemAgentService;
	
	/**
	 * 查询所有的代理商
	 */
	@RequestMapping("/listAgent.do")
	public void listAgent(HttpServletResponse response){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"schools"});
		response.setCharacterEncoding("utf-8");
		logger.info("添加用户，ajax查询所有代理商信息！！");
		List<Agent> agens = systemAgentService.getAll();
		try {
			 JSONArray jsonArray = JSONArray.fromObject( agens ,jsonConfig);  
			response.getWriter().print(jsonArray.toString());
			logger.info("ajax查询所有代理信息，正确响应！！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ajax查询所有代理信息，响应错误！！");
		}
	}
}
