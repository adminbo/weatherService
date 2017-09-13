package com.zjkj.wxy.core.dao.impl;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.ConfigWxDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Wechat;


@Repository
public class ConfigWxDaoImpl extends BaseDaoImpl<Wechat> implements ConfigWxDao {

	private SessionFactory sessionFactory; 
	@Resource
	public void setSF(SessionFactory sessionFactory){
		//调用父类的方法注入会话工厂对象
		super.setSessionFactory(sessionFactory);
	}
	
	//增加公众号的配置
	public void addWechatswe(Wechat wechat) {
	sessionFactory.getCurrentSession().save(wechat);  
	}

	
	
	
}
