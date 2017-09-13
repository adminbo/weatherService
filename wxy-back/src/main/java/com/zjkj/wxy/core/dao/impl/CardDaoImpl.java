package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.CardDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Card;
import com.zjkj.wxy.core.domain.CardApply;
/***
 * 卡片管理dao
 * @author 
 *
 */
@Repository
public class CardDaoImpl extends BaseDaoImpl<Card> implements CardDao{

	@Override
	public List<Card> listBySid(Integer sid) {
		// TODO Auto-generated method stub
		String hql="select c from Card c join c.student s join s.school sc where sc.id = ?";
		return this.getHibernateTemplate().find(hql, sid);
	}

	@Override
	public CardApply getBackById(String aid) {
		// TODO Auto-generated method stub
		String hql="from CardApply where id = ?";
		List<CardApply> find = this.getHibernateTemplate().find(hql, aid);
		return find.get(0);
	}

	@Override
	public CardApply getFillById(String aid) {
		// TODO Auto-generated method stub
		String hql="from CardApply where id = ?";
		List<CardApply> find = this.getHibernateTemplate().find(hql, aid);
		return find.get(0);
	}

	@Override
	public List<Card> getByApplyer(String applyer) {
		// TODO Auto-generated method stub
		String hql="from Card where invoicepeo=?";
		List<Card> find = this.getHibernateTemplate().find(hql, applyer);
		return find;
	}

	@Override
	public void updateCards(List<String> olds, List<String> news) {
		// TODO Auto-generated method stub
		for(int i=1;i<=olds.size();i++){
			String sql="update t_card set id = '"+news.get(i-1)+"' where id = '"+olds.get(i-1)+"'";
			SQLQuery createSQLQuery = this.getSession().createSQLQuery(sql);
			int executeUpdate = createSQLQuery.executeUpdate();
			//System.out.println(executeUpdate);
		}
	}

	@Override
	public void addByBatch(List<Card> cs) {
		// TODO Auto-generated method stub
		for(int i = 0;i<cs.size();i++){
			this.getHibernateTemplate().save(cs.get(i));
			if(i%100 ==0){
				this.getHibernateTemplate().flush(); //批量添加，每100条刷新写入数据库
				this.getHibernateTemplate().clear();
			}
		}
	}

	@Override
	public void deleteByBatch(List<String> news) {
		// TODO Auto-generated method stub
		for (int i =0;i<news.size();i++) {
			String sql="delete from t_card where id = '"+news.get(i)+"'";
			SQLQuery createSQLQuery = this.getSession().createSQLQuery(sql);
		}
	}



}
