package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.UserDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.User;

/**
 * 用户管理dao实现
 * @author Lenovo
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao  {

	@Override
	public User getByUserNameAndPwd(String userName, String passWord) {
		String hql="from User where name = ? and pwd = ? and isShow =?";
		List<User> list = getHibernateTemplate().find(hql, userName,passWord,1);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User getByUsername(String username) {
		String hql="from User where name = ? and isShow =?";
		List<User> list = getHibernateTemplate().find(hql, username,1);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

}
