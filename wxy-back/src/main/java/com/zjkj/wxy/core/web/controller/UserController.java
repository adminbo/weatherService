package com.zjkj.wxy.core.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.UserService;
import com.zjkj.wxy.core.utils.MD5Utils;



/**
 * 用户管理controller
 * @author Lenovo
 *
 */
@Controller
public class UserController {
	//spring 资源注入
	@Resource
	private UserService userService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private CommonController commonController;
	protected Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 用户登录方法
	 * @param session 回话
	 * @param userName 用户名
	 * @param passWord 密码
	 * @param validateCode 验证码
	 * @param model 
	 * @return
	 */
	@RequestMapping("/user/login.do")
	public String login(HttpServletResponse response,HttpServletRequest request,String userName,
			String passWord,String validateCode,Model model
			,Integer keepPwd ,Integer autoLogin){
		HttpSession session=request.getSession();
		//设置响应编码
		response.setCharacterEncoding("utf-8");
		//判定是否之前有用户信息的cookie
		Cookie keepUserCookie = commonController.getCookieFromName(request, response, "keepUser");
		//如果有
		if(keepUserCookie!=null){
			//获取验证码
			String key = (String) session.getAttribute("key");
			//首先校验验证码，不为空，并且输入正确
			if(validateCode !=null && validateCode.equalsIgnoreCase(key)){
				//验证码正确，验证用户名和密码
				if(userName != null && passWord != null){										
					logger.info( (new Date()).toString()+userName+"尝试登录///");
					//如果用户名和密码不为空，进行登录验证
//********************************华丽的分割线***************************************//
					String md5 = MD5Utils.md5(passWord);
					Subject subject = SecurityUtils.getSubject();					
					AuthenticationToken token = new UsernamePasswordToken(userName,md5 );
					try {
						//进行登录认证
						subject.login(token);
						
					} catch (IncorrectCredentialsException e ) {//密码错误
						// TODO: handle exception
						logger.info( (new Date()).toString()+userName+"尝试登录///,密码错误登录失败-------");
						e.printStackTrace();
						//查询不到用户，存入错误信息
						session.setAttribute("error", "密码错误！");
						session.setAttribute("userName", userName);
						return "redirect:/login.jsp";
					}catch (UnknownAccountException e ) { //用户名错误
						// TODO: handle exception
						logger.info( (new Date()).toString()+userName+"尝试登录///,用户名错误登录失败---");
						e.printStackTrace();
						//查询不到用户，存入错误信息
						session.setAttribute("error", "用户名错误！");
						session.setAttribute("userName", userName);
						return "redirect:/login.jsp";
					}catch(ExcessiveAttemptsException e){
						logger.info( (new Date()).toString()+userName+"尝试登录///，错误次数过多，锁定10分钟---");
						e.printStackTrace();
						session.setAttribute("error", "登录失败次数过多，10分钟后再试");
						return "redirect:/login.jsp";
						
					}catch (LockedAccountException e) {
						logger.info( (new Date()).toString()+userName+"尝试登录///，帐号被锁定，登录失败");
						e.printStackTrace();
						session.setAttribute("error", "账户已被锁定，稍后重试");
						return "redirect:/login.jsp";
					}catch (AuthenticationException e) {
						logger.info( (new Date()).toString()+userName+"尝试登录///，连接失效。。登录失败");
						e.printStackTrace();
						session.setAttribute("error", "连接失效，请重新登陆");
						return "redirect:/login.jsp";
					}
						//获取当前认证用户
						User  user= (User) subject.getPrincipal();										
//********************************华丽的分割线***************************************//		
				
					//如果查询到用户
					if(user != null){
						//自动登录标示
						if(autoLogin != null){
							if(1==keepPwd){
								Cookie cookie = new Cookie("autoLogin", "true");
								cookie.setMaxAge(7*24*60*60);
								cookie.setPath("/");
								response.addCookie(cookie);
							}
						}
						School school = user.getSchool();
						Integer type = user.getType();
						if(school!=null){
							Integer id = school.getId();
							user.setSid(id.intValue());
							List<School> schools = new ArrayList<>();
							schools.add(school);
							session.setAttribute("schools", schools);
							session.setAttribute("SCHOOLID", id);
							request.setAttribute("schoolid", schools.get(0).getId());
						}else{
							if(type==1){//超级admin登录
								List<School> findAll = schoolService.findAll();
								session.setAttribute("schools", findAll);
							}else if(type==2 || type==3){//代理商登录
								Agent agent = user.getAgent();
								Integer id = agent.getId();
								List<School> findAll = schoolService.findForAgent(id);
								if(findAll !=null&& findAll.size()>0){
									session.setAttribute("schools", findAll);
								}
							}
						}
						//放到session中，跳转页面
						session.setAttribute("loginUser", user);
//						return "wechatConfig/wctConfig";	
						return "index";	
					}
				}
				//查询不到用户，存入错误信息
				session.setAttribute("error", "用户名或密码错误！");
			}else{
				//存入验证码错误信息
				session.setAttribute("vmsg", "验证码错误！");
				//重定向回登录界面
			}
			return "redirect:/login.jsp";
		//如果没有
		}else{
			//获取验证码
			String key = (String) session.getAttribute("key");
			//首先校验验证码，不为空，并且输入正确
			if(validateCode !=null && validateCode.equalsIgnoreCase(key)){
				//验证码正确，验证用户名和密码
				if(userName != null && passWord != null){
					//如果用户名和密码不为空，进行登录验证
					
//********************************华丽的分割线***************************************//
					String md5 = MD5Utils.md5(passWord);
					Subject subject = SecurityUtils.getSubject();
					AuthenticationToken token = new UsernamePasswordToken(userName, md5);
					//进行登录认证
					try {
						//进行登录认证
						subject.login(token);
						
					} catch (UnknownAccountException e ) { //用户名错误
						// TODO: handle exception
						e.printStackTrace();
						//查询不到用户，存入错误信息
						session.setAttribute("error", "用户名错误！");
						session.setAttribute("userName", userName);
						return "redirect:/login.jsp";
					}catch (IncorrectCredentialsException e) {//密码错误
						// TODO: handle exception
						e.printStackTrace();
						//查询不到用户，存入错误信息
						session.setAttribute("error", "密码错误！");
						session.setAttribute("userName", userName);
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
						logger.info( (new Date()).toString()+userName+"尝试登录///，连接失效。。登录失败");
						e.printStackTrace();
						session.setAttribute("error", "连接失效，请重新登陆");
						return "redirect:/login.jsp";
					}
						//获取当前认证用户
						User  user= (User) subject.getPrincipal();					
					
//********************************华丽的分割线***************************************//			
					
					try {
						String usernamecode = URLEncoder.encode(userName, "utf-8");
						//如果查询到用户
						if(user != null){
							//保存用户7天
							if(keepPwd != null){
								if(1==keepPwd){
									
									//cookie中保存加密后的密码信息
									Cookie cookie = new Cookie("keepUser",usernamecode+"-"+ passWord);
									cookie.setMaxAge(7*24*60*60);
									cookie.setPath("/");
									response.addCookie(cookie);
								}						
							}
							//自动登录标示
							if(autoLogin != null){
								if(1==keepPwd){
									Cookie cookie = new Cookie("autoLogin", "true");
									cookie.setMaxAge(7*24*60*60);
									cookie.setPath("/");
									response.addCookie(cookie);
								}
							}
							School school = user.getSchool();
							Integer type = user.getType();
							if(school!=null){
								Integer id = school.getId();
								user.setSid(id.intValue());
								List<School> schools = new ArrayList<>();
								schools.add(school);
								session.setAttribute("schools", schools);
								session.setAttribute("SCHOOLID", id);
								request.setAttribute("schoolid", schools.get(0).getId());
							}else{
								if(type==1){//超级admin登录
									List<School> findAll = schoolService.findAll();
									session.setAttribute("schools", findAll);
								}else if(type==2 || type==3){//代理商登录
									Agent agent = user.getAgent();
									Integer id = agent.getId();
									List<School> findAll = schoolService.findForAgent(id);
									if(findAll !=null&& findAll.size()>0){
										session.setAttribute("schools", findAll);
									}
								}
							}
							//放到session中，跳转页面
							session.setAttribute("loginUser", user);
//							return "wechatConfig/wctConfig";				
							return "index";				
						}
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//查询不到用户，存入错误信息
				session.setAttribute("error", "用户名或密码错误！");
			}else{
				//存入验证码错误信息
				session.setAttribute("vmsg", "验证码错误！");
				//重定向回登录界面
			}
			return "redirect:/login.jsp";
		}
	}
	
    /** 
     * 用户登出 
     */  
    @RequestMapping("/user/logout.do")  
    public String logout(HttpServletRequest request){  
         Subject subject = SecurityUtils.getSubject(); 
       //获取当前认证用户
			User  user= (User) subject.getPrincipal();	
			String userName = user.getName();
			if (subject.isAuthenticated()) {  
		        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存   
		    }
         request.getSession().invalidate();
         logger.info( (new Date()).toString()+userName+"登出///");
         return "redirect:/login.jsp";  
    }  

}
