package com.zjkj.wxy.core.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session获取工具接口，为单点登录做准备
 * @author Lenovo
 *
 */
public interface SessionProvider {
		//四个方法
	/**
	 * 用户的信息（用户名放到Session域中）
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 */
		   
		public void setAttributeForUserName(HttpServletRequest request,HttpServletResponse response,String name,String value);
		/**
		 * 验证码放到Session域中
		 * @param request
		 * @param response
		 * @param name
		 * @param value
		 */
		
		public void setAttributeForCode(HttpServletRequest request,HttpServletResponse response,String name,String value);
		/**
		 * 从Session域中获取验证码或用户名
		 * @param request
		 * @param response
		 * @param name
		 * @return
		 */
	
		public String getAttribute(HttpServletRequest request,HttpServletResponse response,String name);
		/**
		 * 获取SessionID
		 * @param request
		 * @param response
		 * @return
		 */
		
		public String getSessionId(HttpServletRequest request,HttpServletResponse response);
	}

