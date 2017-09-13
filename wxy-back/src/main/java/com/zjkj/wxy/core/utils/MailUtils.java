package com.zjkj.wxy.core.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送的工具类:
 */
public class MailUtils {
	/**
	 * 发送邮件的方法:
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code){
		// 邮件发送三个步骤:
		// 创建一个Session对象:连接对象.
		Properties props = new Properties();
		Session session = Session.getInstance(props, new Authenticator() {
			//登录服务
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("Admin@zj.com", "admin");
			}
			
		});
		// 创建一个Message对象:邮件对象.
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("Admin@zj.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置主题:
			message.setSubject("微校园平台密码找回官方验证邮件，请勿回复");
			// 设置邮件的内容:
			message.setContent("<h5>【杭州卓教科技】 您的验证码是：<font color='blue'>"+code+"</font></h5>,请<a href='http://localhost/wxy-back/pwd/toEdit.do'>点击链接</a>输入该验证码进行验证！<br/><br/><br/><br/><br/><br/><br/><br/><br/>"
					+ "微校园运营中心<br> "+"Admin@zj.com","text/html;charset=UTF-8");
			// 使用Transport对象发送邮件.
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
}
