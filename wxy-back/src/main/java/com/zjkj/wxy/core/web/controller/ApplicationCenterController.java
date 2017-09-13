package com.zjkj.wxy.core.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Menu;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.ApplicationCenterService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.service.SchoolService;

@Controller
public class ApplicationCenterController {

	//spring 资源注入
	@Resource
	private ApplicationCenterService applicationCenterService;
	@Resource
	private SchoolService schoolService;
	//离线查询对象
	protected DetachedCriteria detachedCriteria = null;

	public ApplicationCenterService getApplicationCenterService() {
		return applicationCenterService;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}



	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public void setApplicationCenterService(ApplicationCenterService applicationCenterService) {
		this.applicationCenterService = applicationCenterService;
	}

	@RequestMapping("/getAllMenu")
	public String findallApplicationCenter(HttpServletRequest request, Model model, String name, HttpSession session) {
		//在这里获取全部学校信息，传到前端，前端进行循环到select里面即可
		List<School> listes=schoolService.findAll();
//		request.getAttribute("listes",listes);
		model.addAttribute("listes", listes);
		return "/emploeey/application_centers";
	}

	@ResponseBody
	@RequestMapping("/getAppMenu")
	public Map<String, Object> getAppMenu(HttpServletRequest request, HttpSession session,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		User loginUser = (User) session.getAttribute("loginUser");
		School school = loginUser.getSchool();//所属学校id
		//String name = school.getName();
		String name = request.getParameter("name");
			try {
				name = URLDecoder.decode(name,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		detachedCriteria = DetachedCriteria.forClass(School.class);
		if (name != null) {
			detachedCriteria.add(Restrictions.like("name", "%" + name + "%"));
		}
		Map<String, Object> result = new HashMap<>();
		List<Menu> menus = applicationCenterService.applicationList();
		List<Menu> moduleMenus = applicationCenterService.applicationModuleList();
		result.put("menu", menus);
		result.put("module", moduleMenus);
		result.put("name", name);
		return result;
	}

	@ResponseBody
	@RequestMapping("/saveAppMenu")
	public String saveAppMenu(String jsonData, HttpServletRequest request) {
		JSONObject json = new JSONObject(jsonData);
		applicationCenterService.updParentId(json);
		return "1";
	}
}
