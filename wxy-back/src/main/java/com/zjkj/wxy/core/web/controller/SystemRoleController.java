package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.SystemRoleService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/system")
public class SystemRoleController {
	private User user =null;
	protected Logger  logger = Logger.getLogger(this.getClass());
	@Resource
	private SystemRoleService systemRoleService;
	/**
	 * 查询所有角色
	 */
	@RequestMapping("/listRole.do")
	public void listRole(HttpServletResponse response,HttpSession session){
		logger.info("添加用户，ajax查询所有角色信息！！");
		//设置响应编码
		response.setCharacterEncoding("utf-8");
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		//用户类型
		Integer type = user.getType();
		Integer sid2 = user.getSid();
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
	//	criteria.add(Restrictions.eq("isshow",1));		//可用的角色
		if(sid2==null){
			//如果是系统管理员,查询1-4
			if(type!=null && type.intValue()==1){
				criteria.add(Restrictions.le("id", 4));			
			}
			//如果不是系统管理员，查询2-4
			if(type!=null && type.intValue()<4 && type.intValue()>1){
				criteria.add(Restrictions.gt("id", type));
				criteria.add(Restrictions.le("id", 4));			
			}			
		}
		if(sid2!=null){
			//如是学校管理，查询下级
			criteria.add(Restrictions.eq("sid", sid2));			
		}
		List<Role> roles =systemRoleService.findByCriteria( criteria);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"authoritys","users","parRole"});
		try {
			 JSONArray jsonArray = JSONArray.fromObject( roles,jsonConfig );  
			response.getWriter().print(jsonArray.toString());
			logger.info("ajax查询所有角色信息，正确响应！！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ajax查询所有角色信息，响应错误！！");
		}
	}
	
	/**
	 * 根据角色名称查询
	 */
	@RequestMapping("/findRoleByName.do")
	public void findByName(HttpServletResponse response,HttpSession session,String name){
		logger.info("ajax查询固定名称的角色---------");
		response.setContentType("text/html;charset=UTF-8");
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		
		School school = user.getSchool();
		//学校标示
		Integer sid =null;
	if(school!=null){
		sid= school.getId();
	}
		//查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		criteria.add(Restrictions.eq("sid", sid));
		criteria.add(Restrictions.eq("name", name));
		//criteria.add(Restrictions.eq("isshow", 1));
		
		List<Role> roles = systemRoleService.findByCriteria(criteria );
		if(roles!=null && roles.size()>0){
			logger.info("根据名称查询到了---------");
			try {
				response.getWriter().print(1);
				logger.info("查询到了，正确响应 1---------");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("查询到了，响应1 错误---------");
			}
		}else{
			logger.info("根据名称没有查询到--------");
			try {
				response.getWriter().print(0);
				logger.info("没查询到用户，正确响应 0---------");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("没查询到用户，响应0 错误---------");
			}
		}
		
	}
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("/addRole.do")
	public String addRole(String name,HttpSession session){
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		
		Role role = new Role();
		//封装数据
	//	role.setIsshow(1);//可见，未删除
		role.setpId(4);//父级id 学校管理员
		if(name!=null){
			try {
				name = new String(name.getBytes("iso8859-1"),"utf-8");
				role.setName(name);//名称
				School school = user.getSchool();
				if(school!=null){
					Integer id = school.getId();
					role.setSid(id);//学校id			
				}
				systemRoleService.add(role);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/system/toAuth.do";
	}
	/**
	 * 更新角色名称
	 * @return
	 */
	@RequestMapping("/updateRole.do")
	public String updateRole(String prename,String name,HttpSession session,HttpServletRequest request){
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
			if(prename!=null){
				prename = new String(prename.getBytes("iso8859-1"),"utf-8");
				criteria.add(Restrictions.eq("name", prename));//角色名称
			}
			if(name!=null){
				name = new String(name.getBytes("iso8859-1"),"utf-8");				
			}
			Integer sid = user.getSid();
			//设置离线查询对象
			//criteria.add(Restrictions.eq("isshow",1));		//可用的角色
			criteria.add(Restrictions.eq("sid", sid));
			systemRoleService.updateRole(name,criteria);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/system/toAuth.do";
	}
	/**
	 * 删除角色，可见性给位0
	 * @return
	 */
	@RequestMapping("/deleteRole.do")
	public String deleteRole(String name,HttpSession session){
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		Integer sid = user.getSid();
		//设置离线查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		//criteria.add(Restrictions.eq("isshow",1));		//可用的角色
		criteria.add(Restrictions.eq("sid", sid));
			try {
				if(name!=null){
				name = new String(name.getBytes("iso8859-1"),"utf-8");
				criteria.add(Restrictions.eq("name", name));//角色名称
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		systemRoleService.deleteRole(criteria);
		return "redirect:/system/toAuth.do";
	}
	
}
