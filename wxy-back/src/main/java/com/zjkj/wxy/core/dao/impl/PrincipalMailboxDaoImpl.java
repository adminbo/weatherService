package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.CharacteristicDao;
import com.zjkj.wxy.core.dao.PrincipalMailboxDao;
import com.zjkj.wxy.core.dao.RecipesDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.PresidentEmail;
import com.zjkj.wxy.core.domain.Recipes;
import com.zjkj.wxy.core.domain.Trait;


@Repository
public class PrincipalMailboxDaoImpl extends BaseDaoImpl<PresidentEmail> implements PrincipalMailboxDao{

	private SessionFactory sessionFactory; 
	@Resource
	public void setSF(SessionFactory sessionFactory){
		//调用父类的方法注入会话工厂对象
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public List<PresidentEmail> presidentEmaillList() {
		String hql = "from t_PresidentEmail";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        return query.list(); 
	}
	@Override
	public PresidentEmail getPresidentEmail(int id) {
		String hql = "from t_PresidentEmail w where w.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (PresidentEmail)query.uniqueResult();
	}
	
	
	
	@Override
	public boolean updatePresidentEmail(PresidentEmail presidentEmail) {
		String hql = "update t_PresidentEmail w set w.SENDERID = ?,w.ISANON = ?,w.TITLE = ?,w.CONTENT = ?,w.RECTIME = ?,w.HANDSTATE = ? where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, presidentEmail.getSenderid());
        query.setInteger(1, presidentEmail.getIsanon());
        query.setString(2, presidentEmail.getTitle());
        query.setString(3, presidentEmail.getContent());
        query.setLong(4, presidentEmail.getRectime());
        query.setInteger(5, presidentEmail.getHandstate());
        query.setInteger(6, presidentEmail.getId());
        return (query.executeUpdate() > 0);
	}
	
	
	

}
