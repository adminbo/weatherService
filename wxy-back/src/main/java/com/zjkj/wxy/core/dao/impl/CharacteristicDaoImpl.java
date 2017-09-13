package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.CharacteristicDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Trait;


@Repository
public class CharacteristicDaoImpl extends BaseDaoImpl<Trait> implements CharacteristicDao{

	private SessionFactory sessionFactory; 
	@Resource
	public void setSF(SessionFactory sessionFactory){
		//调用父类的方法注入会话工厂对象
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Trait> traitsList() {
		// TODO Auto-generated method stub
		 String hql = "from t_trait";  
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	        return query.list(); 
	}

	@Override
	public void addtrait(Trait trait) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(trait);  
	}

	@Override
	public Trait getTrait(int id) {
		String hql = "from t_trait w where w.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (Trait)query.uniqueResult();
	}

	@Override
	public boolean showTeacher(Trait trait) {
		String hql = "update t_trait w set w.TITLE = ?,w.INTRODUCE = ?,w.PUBLISHTIME = ?,w.IMGURL = ?,w.SCHOLID = ? where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, trait.getTitle());
        query.setString(1, trait.getIntroduce());
        query.setString(2, trait.getPublishtime());
        query.setString(3, trait.getImgurl());
        query.setInteger(4, trait.getId());
        return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateTrait(Trait trait) {
		String hql = "update t_trait w set w.TITLE = ?,w.INTRODUCE = ?,w.PUBLISHTIME = ?,w.IMGURL = ?,w.SCHOLID = ? where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, trait.getTitle());
        query.setString(1, trait.getIntroduce());
        query.setString(2, trait.getPublishtime());
        query.setString(3, trait.getImgurl());
        query.setInteger(4, trait.getId());
        return (query.executeUpdate() > 0);
	}

	@Override
	public boolean deletTrait(int id) {
		String hql = "delete t_trait w where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (query.executeUpdate() > 0); 
	}

}
