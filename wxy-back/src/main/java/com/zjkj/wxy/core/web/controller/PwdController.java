package com.zjkj.wxy.core.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.PwdService;
import com.zjkj.wxy.core.service.UserService;
import com.zjkj.wxy.core.utils.MD5Utils;
import com.zjkj.wxy.core.utils.UUIDUtils;
/**
 * 密码管理
 * @author Lenovo
 *
 */
@Controller
public class PwdController {
	protected Logger  logger = Logger.getLogger(this.getClass());
	
	@Resource
	private UserService userService;
	@Resource
	private PwdService pwdService;
	/**
	 * 发送邮件
	 * @param mail
	 * @param session
	 * @return
	 */
	@RequestMapping("/user/sendMail.do")
	public String sendMail(String mail,String validateCode,HttpSession session,Model model){
		logger.info("邮箱地址为"+mail+"；进行修改密码操作");
		//获取验证码
		String code = (String) session.getAttribute("key");
		//验证码正确
		if(validateCode !=null && code.equalsIgnoreCase(validateCode)){
			//离线查询
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			criteria.add(Restrictions.eq("regemail", mail));
			//根据注册邮箱查询用户
			List<User> users = userService.findByCriteria(criteria );
			if(users == null || users.size()<=0){
				logger.info("根据邮箱"+mail+"没有找到用户，邮箱输入有误**********");
				model.addAttribute("mailError", "请输入注册邮箱地址的正确格式！");
				return "pwd/backPwd";
			}
			User user = users.get(0);
			//获取6wei验证码
			String valCode = UUIDUtils.getValCode();
			//设置user的验证码
			user.setCode(valCode);
			try {
				
				pwdService.sendMail(user,mail);
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("senderror", "邮件发送失败，请检查网络环境并重新发送！");
				return "pwd/backPwd";
			}
			model.addAttribute("mail", mail);
			return "pwd/sendSuc";
		}
		model.addAttribute("vError", "验证输入错误，请重新输入！");
		return "pwd/backPwd";
	}
	/**
	 * 去修改页面
	 * @return
	 */
	@RequestMapping("/pwd/toEdit.do")
	public String toEdit(){
		return "pwd/edit";
	}
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping("/pwd/upPwd.do")
	public String editPwd(String code,String password,Model model){
		User user=null;
		String ucode=null;
		if(code!=null){
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			criteria.add(Restrictions.eq("code", code));
			//根据注册邮箱查询用户
			List<User> users = userService.findByCriteria(criteria );
			if(users!=null &&users.size()>0){
				user = users.get(0);
				//获取数据库验证码
				ucode =user.getCode();
			}			
		}else{
			model.addAttribute("codeError", "验证码输入有误！");
			return "pwd/edit";
		}
		//比较验证码是否正确
		if(!code.equals(ucode)){
			model.addAttribute("codeError", "验证码输入有误！");
			return "pwd/edit";
		}
		//判断密码准确性，修改密码，同时把验证码置为空
		if(password!=null && (password.length()>=6 && password.length()<=16)){
			password =MD5Utils.md5(password);
			user.setPwd(password);
			user.setCode(null);
			userService.update(user);
			return "redirect:/login.jsp";
		}else{
			model.addAttribute("pwdError", "新密码输入有误！");
			return "pwd/edit";
		}
	}
}
