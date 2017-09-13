package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Authority;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.SystemAuthService;
import com.zjkj.wxy.core.service.SystemRoleService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
/**
 * 权限管理
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/system")
public class SystemAuthController {
	private User user=null;
	protected Logger  logger = Logger.getLogger(this.getClass());
	@Resource
	private SystemAuthService systemAuthService;
	@Resource
	private SystemRoleService systemRoleService;
	/**
	 * 去权限页
	 * @return
	 */
	@RequestMapping("/toAuth.do")
	public String toAuth(HttpServletResponse response,HttpSession session,Model model){
		logger.info("权限管理，---------------------");

		return "system/auth/auth";
	}
	
	/**
	 * ajax加载角色
	 * @param response
	 */
	@RequestMapping("/findRole.do")
	public void findRole(HttpServletResponse response,HttpSession session){
		logger.info("角色管理，ajax查询所有角色信息！！");
		//设置响应编码
		response.setCharacterEncoding("utf-8");
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		//用户类型
		Integer type = user.getType();
		//学校校id
		Integer sid = user.getSid();
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		//criteria.add(Restrictions.eq("isshow",1));			
		//如果是系统管理员,查询1-4
		if(type!=null && type.intValue()==1){
			criteria.add(Restrictions.le("id", 4));			
		}
		//如果不是系统管理员，查询2-4
		if(type!=null && type.intValue()<4 && type.intValue()>1){
			criteria.add(Restrictions.gt("id", type));
			criteria.add(Restrictions.le("id", 4));			
		}
		//如是学校管理，查询下级
		
		if(type!=null && type.intValue()==4){
			
			criteria.add(Restrictions.ge("id", type));
			criteria.add(Restrictions.eq("sid", sid));
		}
		//如果是学校管理员下级，只查询下级
		if(type!=null && type.intValue()>4){
			criteria.add(Restrictions.eq("id", type));
			criteria.add(Restrictions.eq("sid",sid));
		}
		
		List<Role> roles =systemRoleService.findByCriteria( criteria);
		//把学校管理员加入集合
		if(type!=null && type.intValue()==4){
			Role prole = systemRoleService.findById(4);
			roles.add(prole);					
		}
		//不是学校管理员设置父级
		if(type!=null && type.intValue()!=4 ){
			//设置父级角色
			for (Role role : roles) {
				Integer parid = role.getpId();			
				Role r =systemRoleService.findById(parid);
				role.setParRole(r);
			}
			
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"users","authoritys"});
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
	 * 加载权限
	 */
	@RequestMapping("/findAuth.do")
	public void listAuth(HttpServletResponse response,HttpSession session){
		logger.info("权限管理，ajax查询所有模块权限信息！！");
		//设置响应编码
		response.setCharacterEncoding("utf-8");
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		//用户类型
		Integer type = user.getType();
		//学校校id
		Integer sid = user.getSid();
		//查询所有的模块权限
		DetachedCriteria criteria = DetachedCriteria.forClass(Authority.class);
		criteria.add(Restrictions.eq("isModel", 1));
		List<Authority> auths=systemAuthService.findByCriteria(criteria);
		for (Authority authority : auths) {
			
			Authority auth = authority.getAuthority();
			authority.setAuthority(auth);
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"roles","authoritys"});
		try {
			 JSONArray jsonArray = JSONArray.fromObject( auths,jsonConfig );  
			response.getWriter().print(jsonArray.toString());
			logger.info("ajax查询所有模块权限信息，正确响应！！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ajax查询所有模块权限信息，响应错误！！");
		}
	}
	/**
	 * 查询操作权限
	 */
	@RequestMapping("/findAuthForOper.do")
	public void listAuthForOper(HttpServletResponse response,HttpSession session){
		//设置响应编码
				response.setCharacterEncoding("utf-8");
		//查询所有的模块权限
				DetachedCriteria criteria = DetachedCriteria.forClass(Authority.class);
				//criteria.add(Restrictions.eq("isModel", 1));
				List<Authority> auths=systemAuthService.findByCriteria(criteria);
				for (Authority authority : auths) {
					
					Authority auth = authority.getAuthority();
					authority.setAuthority(auth);
				}
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"roles","authoritys"});
				try {
					 JSONArray jsonArray = JSONArray.fromObject( auths,jsonConfig );  
					response.getWriter().print(jsonArray.toString());
					logger.info("ajax查询所有模块权限信息，正确响应！！");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("ajax查询所有模块权限信息，响应错误！！");
				}
	}
	/**
	 * 根据名查询权限
	 */
	@RequestMapping("/findAuthByName.do")
	public void findByName(String name,HttpSession session,HttpServletResponse response){
	
		response.setCharacterEncoding("utf-8");
		if(user==null){
			//获取当前用户
			user =(User) session.getAttribute("loginUser");			
		}
		//学校id
		Integer sid = user.getSid();
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
		criteria.add(Restrictions.eq("sid", sid));
		criteria.add(Restrictions.eq("name", name));
		List<Role> roles = systemRoleService.findByCriteria(criteria);
		Role role = roles.get(0);
		//当前角色id
		Integer id = role.getId();
		
		List<Authority> list =systemAuthService.getByRoleId(id);
		//返回json数据
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"roles","authoritys"});
		try {
			 JSONArray jsonArray = JSONArray.fromObject( list,jsonConfig );  
			response.getWriter().print(jsonArray.toString());
			logger.info("ajax查询所有模块权限信息，正确响应！！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ajax查询所有模块权限信息，响应错误！！");
		}
	}
	/**
	 * 添加或者更新角色权限
	 * @return
	 */
	@RequestMapping("updateOrAddAuth.do")
	public String addOrUpdateAuth(String[] auths,String rolename,HttpSession session){
		try {
			if(rolename!=null){
				rolename = new String(rolename.getBytes("iso8859-1"),"utf-8");				
			}
			if(user==null){
				//获取当前用户
				user =(User) session.getAttribute("loginUser");			
			}
			//学校id
			Integer sid = user.getSid();
			//条件查询角色
			DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
			criteria.add(Restrictions.eq("sid", sid));//学校id
			criteria.add(Restrictions.eq("name", rolename));//角色名称
			List<Role> roles = systemRoleService.findByCriteria(criteria);
			Role role = roles.get(0);
			if(auths!=null && auths.length>0){
				systemAuthService.updateRelation(role,auths);	
				logger.info("用户"+user.getName()+"修改了"+role.getName()+"的权限--------------");
			}else{
				logger.warn("用户"+user.getName()+"修改"+role.getName()+"的权限时失败--------------");
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("用户"+user.getName()+"修改权限时失败--------------");
		}
		return "system/auth/auth";
	}
}
