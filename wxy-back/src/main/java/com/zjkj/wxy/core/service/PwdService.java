package com.zjkj.wxy.core.service;

import com.zjkj.wxy.core.domain.User;

/**
 * 密码管理
 * @author Lenovo
 *
 */
public interface PwdService {
	/**
	 * 发送邮件，保存验证码
	 * @param user
	 */
	void sendMail(User user,String mail);

}
