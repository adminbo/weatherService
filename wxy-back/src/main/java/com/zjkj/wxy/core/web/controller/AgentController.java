package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.service.AgentService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 代理商管理
 * @author smil
 *
 */
@Controller
@RequestMapping("/agent")
public class AgentController {

	@Resource
	private AgentService agentService;
	/**
	 * 查询所有代理商
	 * @return
	 */
	@RequestMapping("/getAll.do")
	public void getAll(HttpServletResponse response){
		response.setContentType("text/json;charset=utf-8");
		try {
			List<Agent> agents =  agentService.getAll();
			JsonConfig jc=new JsonConfig();
			jc.setExcludes(new String[]{"schools"});
			JSONArray ja = JSONArray.fromObject(agents,jc);
			String json = ja.toString();
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
