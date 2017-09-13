package com.zjkj.wxy.core.utils.utilsImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjkj.wxy.core.utils.SessionProvider;
/**
 * 本地session提供类
 * @author Lenovo
 *
 */
public class HttpSessionProvider implements SessionProvider{
	
	@Override
	public void setAttributeForUserName(HttpServletRequest request, HttpServletResponse response, String name,
			String value) {
		request.getSession().setAttribute(name, value);
		
	}

	@Override
	public void setAttributeForCode(HttpServletRequest request, HttpServletResponse response, String name,
			String value) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute(name, value);
	}

	@Override
	public String getAttribute(HttpServletRequest request, HttpServletResponse response, String name) {
		// TODO Auto-generated method stub
		//获取之前存进去的session
		HttpSession session = request.getSession(false);
		//如果session不为空
		if(session!=null){
			return (String) session.getAttribute(name);
		}
		//否则返回null
		return null;
	}

	@Override
	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getSession().getId();
		return id;
	}

}
