package com.zjkj.wxy.core.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.SystemRoleDao;
import com.zjkj.wxy.core.dao.SystemUserDao;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.SystemUserService;
import com.zjkj.wxy.core.utils.PageBean;
/**
 * 系统设置，用户管理
 * @author Lenovo
 *
 */
@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {
	@Resource
	private SystemUserDao systemUserDao;
	@Resource
	private SystemRoleDao systemRoleDao;

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		systemUserDao.pageQuery(pageBean);
	}

	@Override
	public void saveUser(User user,Set<Role> roles) {
		// TODO Auto-generated method stub
//		user.setRoles(null);
		user.setRoles(roles);
		Serializable saves = systemUserDao.saves(user);
//		User findById = systemUserDao.findById(saves);
//		findById.setRoles(roles);
//		systemUserDao.update(findById);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return systemUserDao.findById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		systemUserDao.update(user);
	}

	@Override
	public void deleteById(Integer id) {
		User user = systemUserDao.findById(id);
		user.setIsShow(0);
		user.setRoles(null);
	}
}
