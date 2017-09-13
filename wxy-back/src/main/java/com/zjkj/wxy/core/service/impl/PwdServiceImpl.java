package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.UserDao;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.PwdService;
import com.zjkj.wxy.core.utils.MailUtils;
@Service
@Transactional
public class PwdServiceImpl implements PwdService {
	protected Logger  logger = Logger.getLogger(this.getClass());
	@Resource
	private UserDao userDao;

	@Override
	public void sendMail(User user,String mail) {
		//获取验证码
		String validateCode = user.getCode();
		//发送邮件
		try {
			MailUtils.sendMail(mail, validateCode);
//		保存
			userDao.save(user);
			logger.info("邮件发送成功 ^  _  ^");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("发送邮件失败！！！！！！！！！！！1");
		}
	}

}
