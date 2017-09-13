package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.AgentService;
import com.zjkj.wxy.core.service.SystemRoleService;
import com.zjkj.wxy.core.service.SystemUserService;
import com.zjkj.wxy.core.service.TeacherService;
import com.zjkj.wxy.core.utils.MD5Utils;
import com.zjkj.wxy.core.utils.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 系统-用户管理
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/system")
public class SystemUserController {
	protected Logger  logger = Logger.getLogger(this.getClass());
	//离线查询对象
	protected DetachedCriteria detachedCriteria=null;
	//分页查询对象
	protected PageBean pageBean=new PageBean();
	
	@Resource
	private SystemUserService systemUserService;
	@Resource
	private SystemRoleService systemRoleService;
	@Resource
	private AgentService agentService;
	@Resource
	private TeacherService teacherService;
	/**
	 * 查询所有用户，分页
	 * 
	 */
	@RequestMapping("/listUser.do")
	public String listUser(Integer currentPage,Integer pageSize,Model model,
			String userName,String companyName,
			String realName,Integer type,HttpSession session,String regTime){
		//离线查询条件
		detachedCriteria=DetachedCriteria.forClass(User.class);
		//学校id
		Integer sid = null;
		//角色id
		Integer roleid=null;
		//角色集合
		List<Role> roles=null;		
		
		//获取当前登录用户
		User loginUser =(User) session.getAttribute("loginUser");
		model.addAttribute("user", loginUser);
		sid = loginUser.getSid();//所属学校id	
		if(sid!=null){
			List<Role> rs =systemRoleService.getBySid(sid);
			model.addAttribute("roles", rs);
		}
		if(sid==null){
			DetachedCriteria criteria=DetachedCriteria.forClass(Role.class);
				//获取用户角色
				Integer type2 = loginUser.getType();
				if(1==type2){  //系统管理员
					criteria.add(Restrictions.ge("id", type2));
					criteria.add(Restrictions.le("id", 4));
				}
				if(1!=type2){
					criteria.add(Restrictions.gt("id", type2));
					criteria.add(Restrictions.le("id", 4));	
				}
				List<Role> list = systemRoleService.findByCriteria(criteria);
				model.addAttribute("roles", list);			
		}

//**********************************  分割线  ***************************************************	
		if(sid!=null){
			//获取用户角色
			Integer type2 = loginUser.getType();
		
				School shcool = loginUser.getSchool();
				detachedCriteria.add(Restrictions.eq("school", shcool));	//添加查询条件 所属学校		
			
		}							
		//PageBean pageBean=new PageBean();
		if(currentPage==null){
			currentPage=1;//默认第一页
		}
		if(pageSize==null){
			pageSize=10;//默认每页显示10条
		}
		//封装pageBean
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		//设置离线查询条件
		if(userName!=null){
			detachedCriteria.add(Restrictions.like("name", "%"+userName+"%"));			
			model.addAttribute("userName", userName);
		}
		if(companyName!=null){
			detachedCriteria.add(Restrictions.like("companyname", "%"+companyName+"%"));			
			model.addAttribute("companyName", companyName);
		}
		if(realName!=null){
			detachedCriteria.add(Restrictions.like("realName", "%"+realName+"%"));			
			model.addAttribute("realName", realName);
		}
		Role findById=null;
		if(type!=null){
			if(type<4){
				detachedCriteria.add(Restrictions.eq("type", type));							
			}
			if(type>4){
				 findById = systemRoleService.findById(type);
//				Set<Role> set = new HashSet<>();
//				set.add(findById);
//				detachedCriteria.add(Restrictions.in("roles", set));
			}
			model.addAttribute("type", type);
		}
		if(regTime!=null){
			detachedCriteria.add(Restrictions.eq("regtime", regTime));			
			model.addAttribute("regTime", regTime);
		}
		detachedCriteria.add(Restrictions.eq("isShow", 1));
		pageBean.setDetachedCriteria(detachedCriteria);
		//查询分页对象的集合数据
		systemUserService.pageQuery(pageBean);
List<User> rows = pageBean.getRows();
Iterator<User> iterator = rows.iterator();
while(iterator.hasNext()){
	User next = iterator.next();
	Set<Role> roles2 = next.getRoles();
	if(findById!=null){
		if(!roles2.contains(findById)){
			iterator.remove();
		}
	}
}

		model.addAttribute("pageBean", pageBean);
		return "system/user/user";
	}
	
	@RequestMapping("/listUserByPage.do")
	public void listUserByPage(Integer currentPage,Integer pageSize,Model model,
			String userName,String companyName,HttpServletResponse response,
			String realName,Integer type,HttpSession session,String regTime){
		response.setCharacterEncoding("utf-8");
		//离线查询条件
		detachedCriteria=DetachedCriteria.forClass(User.class);
		//学校id
		Integer sid = null;
		//角色id
		Integer roleid=null;
		//角色集合
		List<Role> roles=null;		
		
		//获取当前登录用户
		User loginUser =(User) session.getAttribute("loginUser");
		model.addAttribute("user", loginUser);
		sid = loginUser.getSid();//所属学校id	
		if(sid!=null){
			List<Role> rs =systemRoleService.getBySid(sid);
			model.addAttribute("roles", rs);
		}
		if(sid==null){
			DetachedCriteria criteria=DetachedCriteria.forClass(Role.class);
			criteria.add(Restrictions.eq("isshow", 1));
			//获取用户角色
			Integer type2 = loginUser.getType();
			if(1==type2){  //系统管理员
				criteria.add(Restrictions.ge("id", type2));
				criteria.add(Restrictions.le("id", 4));
			}
			if(1!=type2){
				criteria.add(Restrictions.gt("id", type2));
				criteria.add(Restrictions.le("id", 4));	
			}
			List<Role> list = systemRoleService.findByCriteria(criteria);
			model.addAttribute("roles", list);
//			Set<Role> roles2 = loginUser.getRoles();
//			//当前用户的角色名集合
//			List<String> rolenames=new ArrayList<>();
//			if(roles2!=null){
//				for (Role role : roles2) {
//					BigDecimal id = role.getId();
//					if(id.intValue()<=4 ){
//						roleid=id.intValue();
//						roles= systemRoleService.getSameRole(roleid,4);
//						model.addAttribute("roles", roles);
//					}
//				}
//			}
			
		}
		
//**********************************  分割线  ***************************************************	
		if(sid!=null){
			//获取用户角色
			Integer type2 = loginUser.getType();
		
				School shcool = loginUser.getSchool();
				detachedCriteria.add(Restrictions.eq("school", shcool));	//添加查询条件 所属学校		
			
		}							
		//PageBean pageBean=new PageBean();
		if(currentPage==null){
			currentPage=1;//默认第一页
		}
		if(pageSize==null){
			pageSize=10;//默认每页显示10条
		}
		//封装pageBean
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		//设置离线查询条件
		if(userName!=null){
			detachedCriteria.add(Restrictions.like("name", "%"+userName+"%"));			
			model.addAttribute("userName", userName);
		}
		if(companyName!=null){
			detachedCriteria.add(Restrictions.like("companyname", "%"+companyName+"%"));			
			model.addAttribute("companyName", companyName);
		}
		if(realName!=null){
			detachedCriteria.add(Restrictions.like("realName", "%"+realName+"%"));			
			model.addAttribute("realName", realName);
		}
		Role findById=null;
		if(type!=null){
			if(type<4){
				detachedCriteria.add(Restrictions.eq("type", type));							
			}
			if(type>4){
				findById = systemRoleService.findById(type);
//				Set<Role> set = new HashSet<>();
//				set.add(findById);
//				detachedCriteria.add(Restrictions.in("roles", set));
			}
			model.addAttribute("type", type);
		}
		if(regTime!=null){
			detachedCriteria.add(Restrictions.eq("regtime", regTime));			
			model.addAttribute("regTime", regTime);
		}
		detachedCriteria.add(Restrictions.eq("isShow", 1));
		pageBean.setDetachedCriteria(detachedCriteria);
		//查询分页对象的集合数据
		systemUserService.pageQuery(pageBean);
		List<User> rows = pageBean.getRows();
		Iterator<User> iterator = rows.iterator();
		while(iterator.hasNext()){
			User next = iterator.next();
			Set<Role> roles2 = next.getRoles();
			if(findById!=null){
				if(!roles2.contains(findById)){
					iterator.remove();
				}
			}
		}
//		List<User> rows = pageBean.getRows();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"school","communications","systems","agent","roles"});
		try {
			 JSONArray jsonArray = JSONArray.fromObject( rows,jsonConfig );  
			response.getWriter().print(jsonArray.toString());
			logger.info("ajax查询所有角色信息，正确响应！！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ajax查询所有角色信息，响应错误！！");
		}
	}
	/**
	 * 天假用户
	 * @return
	 */
	@RequestMapping("/addUsers.do")
	public String addUsers(String userName,String companyName,Integer[] typeId
			,String realName,String phoneNum,String email,Integer agentId,HttpSession session){
		//获取登录用户
		User loginUser =(User) session.getAttribute("loginUser");
		logger.info("用户"+loginUser.getName()+"进行添加用户的操作。。。。。。。。");
		Integer sid = loginUser.getSid();
		School school = loginUser.getSchool();
	//当前系统时间，并格式化
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String regTime = df.format(date);
		User user = new User();
		//封装数据
		user.setName(userName);
		user.setRealName(realName);
		user.setAid(agentId);
		user.setCompanyname(companyName);
		user.setRegemail(email);
		user.setPhoneNum(phoneNum);
		Set<Role> roles = new HashSet<>();
		if(typeId!=null){
			for (Integer rid : typeId) {
				if(rid<=4){
					user.setType(rid);					
				}
				Role role = systemRoleService.findById(rid);
				roles.add(role);
			}
		}

		user.setRegtime(regTime);
		user.setIsShow(1);
		user.setPwd(MD5Utils.md5("666666"));//初始密码666666
		user.setSchool(school);
		try {
			systemUserService.saveUser(user,roles);
			logger.info("添加用户成功了");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("添加用户失败----------");
		}
		return "redirect:/system/listUser.do";
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
	}
	/**
	 * 根据用户id查询
	 */
	@RequestMapping("/findById.do")
	public void findById(Integer id,HttpServletResponse response){
		logger.info("查看用户信息------------");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"roles","systems","communications","school","schools"});
		response.setCharacterEncoding("utf-8");
		//System.out.println(id);
		User user = systemUserService.findById(id);
		Integer aid = user.getAid();
		if(aid!=null){
			Agent agent = agentService.findById(aid);
			user.setAgent(agent);		
		}
		try {
			 JSONObject jsonObject = JSONObject.fromObject( user,jsonConfig );  
			response.getWriter().print(jsonObject.toString());
			logger.info("ajax查询所有角色信息，正确响应！！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ajax查询所有角色信息，响应错误！！");
		}
	}
	/**
	 * 根据id修改用户
	 * @return
	 */
	@RequestMapping("/updateUser.do")
	public String updateUser(Integer uid,Integer[] typeId
			,String realName,String phoneNum,String email){
		logger.info("修改用户信息------------");
		User user = systemUserService.findById(uid);
		//封装数据
		Set<Role> roles = new HashSet<>();
		if(typeId!=null){
			for (Integer rid : typeId) {
				if(rid<=4){
					user.setType(rid);					
				}
				Role role = systemRoleService.findById(rid);
				roles.add(role);
			}
		}
		user.getRoles().clear();
		user.setRoles(roles);
		user.setRealName(realName);
		user.setPhoneNum(phoneNum);
		user.setRegemail(email);

		//更新用户数据
		try {
			logger.info("修改用户信息-----ing----");
			systemUserService.updateUser(user);
			logger.info("修改用户信息-----yes----");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("修改用户信息-----no----");
		}
		return "redirect:/system/listUser.do";
	}
	
	/**
	 * 删除用户信息，不可见，数据库仍然存在
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/deleteUser.do")
	public String deleteUserById(Integer id){
		logger.info("删除用户操作。。。。。。。。。。。。");
		try {
			systemUserService.deleteById(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("删除失败-----ou*no----");
		}
		return "redirect:/system/listUser.do";
	}
}
