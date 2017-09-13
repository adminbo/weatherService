package com.zjkj.wxy.core.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjkj.wxy.core.domain.User;

/**
 * 资源跳转控制器
 * @author smil
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {
	/**
	 * 后台入口index.jsp
	 * @return
	 */
	@RequestMapping("/index.do")
	public String index(){
		return "index";
	}
	/**
	 * 选择学校后跟新session的学校标识sid
	 * @param request
	 * @param sid
	 */
	@RequestMapping("/setSid.do")
	public void setSidInSession(HttpServletRequest request,Integer sid,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			if(sid!=null){
				session.setAttribute("SCHOOLID",sid);
			}
			response.getWriter().print(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 主页top资源跳转
	 * @return
	 */
	@RequestMapping("/top.do")
	public String top(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("loginUser");
		if(user.getSid()!=null){
			request.setAttribute("schoolid", user.getSid());
			session.setAttribute("SCHOOLID", user.getSid());
		}
		return "top";
	}
	/**
	 * 主页main资源跳转
	 * @return
	 */
	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
	/**
	 * 主页main部分left资源跳转
	 * @return
	 */
	@RequestMapping("/left.do")
	public String left(){
		return "wechatConfig/wctConfig";
	}
	/**
	 * 主页main部分right资源跳转
	 * @return
	 */
	@RequestMapping("/right.do")
	public String right(){
		return "right";
	}
}
