package com.zjkj.wxy.core.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.UserService;
import com.zjkj.wxy.core.utils.MD5Utils;

/**
 * 资源跳转controller
 * @author Lenovo
 *
 */
@Controller
public class CommonController {
	@Resource
	private UserService userService;
	protected Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 去登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/user/toLogin.do")
	public String toLogin(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model){
		//获取登录用户，如果不为空说明已经登录，直接跳转进入系统
		User u = (User) request.getSession().getAttribute("loginUser");
		if(u!=null){
			return "index";
		}
		String uName =null;
		String uPwd = null;
		//判定是否之前有用户信息的cookie
		Cookie keepUserCookie = this.getCookieFromName(request, response, "keepUser");
		if(keepUserCookie!=null){
			session.setAttribute("keepUser", "yes");
			//获取用户名和密码
			String userMsg = keepUserCookie.getValue();
			try {
				userMsg=URLDecoder.decode(userMsg,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] split = userMsg.split("-");
			uName=split[0];
			uPwd=split[1];
			//把用户名和密码带到登录页面
			session.setAttribute("userName", uName);
			session.setAttribute("passWord", uPwd);
			//判断是否自动登录
			Boolean autoLogin = this.getAutoLogin(request, response);
			if(autoLogin!=null){
				if(autoLogin){
//********************************华丽的分割线***************************************//				
					Subject subject = SecurityUtils.getSubject();
					AuthenticationToken token = new UsernamePasswordToken(uName, MD5Utils.md5(uPwd));
					//进行登录认证
					try {
						//进行登录认证
						subject.login(token);
						
					} catch (UnknownAccountException e ) { //用户名错误
						// TODO: handle exception
						e.printStackTrace();
						//查询不到用户，存入错误信息
						session.setAttribute("error", "用户名或密码错误！");
						session.setAttribute("un", uName);
						return "redirect:/login.jsp";
					}catch (IncorrectCredentialsException e) { //密码错误
						// TODO: handle exception
						e.printStackTrace();
						//查询不到用户，存入错误信息
						session.setAttribute("error", "用户名或密码错误！");
						session.setAttribute("un", uName);
						return "redirect:/login.jsp";
					}catch(ExcessiveAttemptsException e){
						e.printStackTrace();
						session.setAttribute("error", "登录失败次数过多，10分钟后再试");
						return "redirect:/login.jsp";
						
					}catch (LockedAccountException e) {
						e.printStackTrace();
						session.setAttribute("error", "账户已被锁定，稍后重试");
						return "redirect:/login.jsp";
					}catch (AuthenticationException e) {
						logger.info( (new Date()).toString()+uName+"尝试登录///，连接失效。。登录失败");
						e.printStackTrace();
						session.setAttribute("error", "连接失效，请重新登陆");
						return "redirect:/login.jsp";
					}
						//获取当前认证用户
						User  user= (User) subject.getPrincipal();					
					
//********************************华丽的分割线***************************************//	
					//User user=userService.login(uName,uPwd);
					if(user!=null){
						School school = user.getSchool();
						if(school!=null){
							Integer id = school.getId();
							user.setSid(id.intValue());
							
						}
						//放到session中，跳转页面
						request.getSession().setAttribute("loginUser", user);
						session.setAttribute("autoLogin", "yes");
						return "index";								
					}
					session.setAttribute("error", "用户名或密码错误！");
				}
			}
			//记住密码状态
//如果没有
}
		return "redirect:/login.jsp";
	}
	/**
	 * 去密码找回页面
	 * @return
	 */
	@RequestMapping("/user/toBackPwd.do")
	public String backPwd(){
		return "/pwd/backPwd";
	}
	
	
	/**
	 * 获取制定name的cookie
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	public Cookie getCookieFromName(HttpServletRequest request,
			HttpServletResponse response,String name){
		//获取cookie
		Cookie[] cookies = request.getCookies();
		//cookie不为空
		if(cookies != null){
			//遍历cookie
			for (Cookie cookie : cookies) {
				String cName = cookie.getName();
				if(cName != null){
					//获取登录名和密码
					if(name.equals(cName)){
						
						return cookie;
					}
				}
			}
		}
		return null;
	}
	
	
	/**
	 * 获取cookie中的用户
	 * @param request
	 * @param response
	 * @return
	 */
	public String getUnameAndPwdFromCookie(HttpServletRequest request,
			HttpServletResponse response){
		//获取cookie
		Cookie cookieFromName = this.getCookieFromName(request, response, "keepUser");
		//如果不为空
		if(cookieFromName != null){
			//返回该cookie的值
						String nameAndPwd = cookieFromName.getValue();
						return nameAndPwd;						
		}
		return null;
	}
	
	/**
	 * 获取是否要自动登录
	 * @return
	 */
	public Boolean getAutoLogin(HttpServletRequest request,
			HttpServletResponse response){
		//获取cookie
		Cookie cookieFromName = this.getCookieFromName(request, response, "autoLogin");
			//cookie不为空
			if(cookieFromName != null){				
				String isAutoLogin = cookieFromName.getValue();
				if("true".equals(isAutoLogin)){
					return true;
				}
			}
		return false;
	}
	/**
	 * 去系统设置页
	 * @return
	 */
	@RequestMapping("/system/settings.do")
	public String toSystemSetting(){
		
		return "system/settings";
	}
}
