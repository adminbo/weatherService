package com.zjkj.wxy.core.web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zjkj.wxy.core.domain.User;
/**
 * springmvc拦截器，验证是否登录
 * @author Lenovo
 *
 */
public class AuthInterceptor implements HandlerInterceptor {
/**
 * 处理器执行前执行，验证是否登录，没登录返回登录页面，防止地址栏直接访问
 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		//如果请求的是登录方法或者忘记密码，放行
		StringBuffer url = request.getRequestURL();
		if(url.indexOf("/toLogin.do")>0 
				|| url.indexOf("/login.do")>0
				|| url.indexOf("/toBackPwd.do")>0
				|| url.indexOf("/sendMail.do")>0
				|| url.indexOf("/toEdit.do")>0
		     	|| url.indexOf("upPwd.do")>0){
			return true;
		}
		//如果访问其他方法，查看是否登录
		HttpSession session = request.getSession();
		if(session!=null){
			User user =(User)session.getAttribute("loginUser");
			if(user != null){
				return true;
			}
		}
		
		//如果访问路径不合法，跳转页面
		response.sendRedirect("/wxy-back/login.jsp");
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
