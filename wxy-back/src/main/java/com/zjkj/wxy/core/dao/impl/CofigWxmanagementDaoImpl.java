package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Wechat;


@Repository
public class CofigWxmanagementDaoImpl extends BaseDaoImpl<Wechat> implements CofigWxmanagementDao{

	
	
	@Override
	public List<Wechat> wechatsliList() {
		// TODO Auto-generated method stub
		 String hql = "from t_Wechat";  
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	        return query.list(); 
	}

	@Override
	public void addWechats(Wechat wechat) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(wechat);  
	}

	@Override
	public Wechat getWechatid(int id) {
		String hql = "from Wechat w where w.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (Wechat)query.uniqueResult();
	}

	

	@Override
	public void deleteWechat(Wechat wechat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWechat(Wechat wechat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showWechat(Wechat wechat) {
		// TODO Auto-generated method stub
		
	}

	
}
