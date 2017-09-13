package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.UserDao;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.UserService;
/**
 * 用户管理实现
 * @author Lenovo
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public User login(String userName, String passWord) {
		
		return userDao.getByUserNameAndPwd(userName,passWord);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public List<User> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return userDao.findByCriteria(criteria);
	}
}
