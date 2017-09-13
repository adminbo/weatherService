package com.zjkj.wxy.core.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EcodeingFilter implements Filter{

    private String charset = "UTF-8"; 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String charset = filterConfig.getServletContext().getInitParameter("charset");
		System.out.println("------------------------------"+charset);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;  
		//设置请求响应字符编码  
		req.setCharacterEncoding(charset);  
        //response.setCharacterEncoding(charset);   
        //执行下一个过滤器（如果有的话,否则执行目标servlet）  
        chain.doFilter(req, response);  		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
