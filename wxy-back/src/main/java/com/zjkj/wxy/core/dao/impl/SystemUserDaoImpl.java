package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.SystemUserDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;
@Repository
public class SystemUserDaoImpl extends BaseDaoImpl<User> implements SystemUserDao{

	@Override
	public List<User> findByRoles(Role role) {
		// TODO Auto-generated method stub
		String hql="SELECT u FROM User u join u.roles r where r.id = ? ";
			Integer id = role.getId();
		return this.getHibernateTemplate().find(hql, id);	
	}

	@Override
	public Serializable saves(User user) {
	Serializable id = this.getHibernateTemplate().save(user);
		return id;
	}

}
