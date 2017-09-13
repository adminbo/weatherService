package com.zjkj.wxy.core.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.ConfigWxmanagementService;
import com.zjkj.wxy.core.utils.Const;
import com.zjkj.wxy.core.utils.LogisticsUtil;
import com.zjkj.wxy.core.utils.PageBean;

@Controller
public class ConfigWxmanagementController {

	// spring 资源注入
	@Resource
	private ConfigWxmanagementService configWxmanagementService;

	// 离线查询对象
	protected DetachedCriteria detachedCriteria = null;

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	public ConfigWxmanagementService getConfigWxmanagementService() {
		return configWxmanagementService;
	}

	public void setConfigWxmanagementService(ConfigWxmanagementService configWxmanagementService) {
		this.configWxmanagementService = configWxmanagementService;
	}

	@RequestMapping("/toAddwechar")
	public String toAddUser() {
		return "/wechatConfig/wctConfig";
	}

	// 请求url地址映射，类似Struts的action-mapping
	@RequestMapping("/addWechar")
	public String addWechar(Wechat wechat,HttpServletResponse response) throws IOException {
		wechat.setDeletestate(1);
		String appId = wechat.getAppId();
		String secret = wechat.getSecret();
		String pre = wechat.getPre();
		try {
			String sendGet = LogisticsUtil.sendGet(Const.URL+"/zhuojiao/write", "pre="+pre+"&appid="+appId+"&secret="+secret);
			System.out.println(sendGet);
			if("1".equals(sendGet)){
				configWxmanagementService.addWechats(wechat);
				return "redirect:/getAllWechateslist.do";				
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception			
			return null;
		}
	}

	// 分页查询，模糊查询
	@RequestMapping("/getAllWechateslist")
	public String getAllWechateslist(String serviceids, String name, Integer regemail, String operator_1, Integer begintime, Integer regtype, Integer authenstate, Integer authentype, HttpSession session, Model model, HttpServletRequest request) {
		// 分页
		PageBean<Wechat> pageBean = new PageBean<Wechat>("form1", request);
		// 设置离线查询条件
		detachedCriteria = DetachedCriteria.forClass(Wechat.class);
		if (serviceids != null) {
			detachedCriteria.add(Restrictions.like("serviceids", "%" + serviceids + "%"));
		}
		if (name != null) {
			detachedCriteria.add(Restrictions.like("name", "%" + name + "%"));
		}
		if (regemail != null) {
			detachedCriteria.add(Restrictions.like("regemail", "%" + regemail + "%"));
		}
		if (authenstate != null) {
			detachedCriteria.add(Restrictions.like("authenstate", "%" + authenstate + "%"));
		}
		if (operator_1 != null) {
			detachedCriteria.add(Restrictions.like("operator_1", "%" + operator_1 + "%"));
		}
		if (begintime != null) {
			detachedCriteria.add(Restrictions.eq("begintime", "%" + begintime + "%"));
		}
		if (authentype != null) {
			detachedCriteria.add(Restrictions.eq("authentype", "%" + authentype + "%"));
		}
		if (regtype != null) {
			detachedCriteria.add(Restrictions.eq("regtype", "%" + regtype + "%"));
		}
		detachedCriteria.add(Restrictions.eq("deletestate", 1));
		pageBean.setDetachedCriteria(detachedCriteria);
		try{
			configWxmanagementService.pageQuery(pageBean);
			model.addAttribute("pageBean", pageBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/account_management/account_managementlist";
	}

	//修改页面
	@RequestMapping("/getWechat")
	public String getWechar(Integer id, HttpServletRequest request, Model model) {
		Wechat wechar = configWxmanagementService.getWechatid(id);
		request.setAttribute("wechat", wechar);
		return "/account_management/account_revise";
	}

	// 公眾號在數據庫假删
	@RequestMapping(value = "/deleteWechat")
	public String deleteWechat(Integer id) {
		configWxmanagementService.deleteById(id);
		return "redirect:/getAllWechateslist.do";
	}

	@RequestMapping(value = "/updaterevise", method = RequestMethod.GET)
	public String updaterevise(Wechat wechat, Operator operator, HttpServletRequest request, Model model, HttpSession session) {
		wechat.setDeletestate(1);
		configWxmanagementService.updateWechat(wechat);
		return "redirect:/getAllWechateslist.do";
	}

	//查看页面Wechat.authentication.appliletterurl    wechat.authentication.orgcodeurl 
	@RequestMapping("/showWechat")
	public String showWechar(HttpServletRequest request, Integer id) {
		Wechat wechat = configWxmanagementService.getWechatid(id);
		request.setAttribute("wechat", wechat);
		return "/account_management/account_showlook";
	}

}
