package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Img;

@Repository
public class AligenedEnvironmenDaoImpl extends BaseDaoImpl<Img> implements AlignedEnvironmenDao{

	private SessionFactory sessionFactory; 
	@Resource
	public void setSF(SessionFactory sessionFactory){
		//调用父类的方法注入会话工厂对象
		super.setSessionFactory(sessionFactory);
	}
	
	
	@Override
	public List<Img> envireList() {
		// TODO Auto-generated method stub
		 String hql = "from t_img";  
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	        return query.list(); 
	}

	@Override
	public void addimgs(Img img) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(img);  
	}

	@Override
	public Img getWechatid(int id) {
		String hql = "from t_img w where w.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (Img)query.uniqueResult();
	}

	@Override
	public boolean updateEnvire(Img img) {
		String hql = "update t_img w set w.title = ?,w.url = ?,w.state = ?,w.uptime = ?,w.sort = ?,w.isdown = ? where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, img.getTitle());
        query.setString(1, img.getUrl());
        query.setInteger(2, img.getState());
        query.setLong(3, img.getUptime());
        query.setInteger(4, img.getSort());
        query.setInteger(5, img.getIsdown());
        query.setInteger(6, img.getId());
        return (query.executeUpdate() > 0); 
	}

	@Override
	public boolean updateschoolEnvire(Img img) {
		String hql = "update t_img w set w.title = ?,w.url = ?,w.state = ?,w.uptime = ?,w.sort = ?,w.isdown = ? where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, img.getTitle());
        query.setString(1, img.getUrl());
        query.setInteger(2, img.getState());
        query.setLong(3, img.getUptime());
        query.setInteger(4, img.getSort());
        query.setInteger(5, img.getIsdown());
        query.setInteger(6, img.getId());
        return (query.executeUpdate() > 0); 
	}

	@Override
	public boolean deletschoolEnvire(int id) {
		String hql = "delete t_img w where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (query.executeUpdate() > 0); 
	}

	
}
