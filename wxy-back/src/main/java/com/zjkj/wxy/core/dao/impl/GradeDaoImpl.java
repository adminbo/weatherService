package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.GradeDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class GradeDaoImpl extends BaseDaoImpl<Grade> implements GradeDao {

	@Override
	public List<Grade> findBySid(Integer sid) {
		// TODO Auto-generated method stub
		String hql="from Grade where schoolid = ?";
		List find = this.getHibernateTemplate().find(hql, sid);
		return find;
	}

	@Override
	public List<Classes> getAllClazz(Integer gid) {
		// TODO Auto-generated method stub
		String sql="select distinct c.* from t_class c left join grade_class gc on  c.id = gc.cid where gc.gid ="+gid;
		SQLQuery query = this.getSession().createSQLQuery(sql);
		query.addEntity(Classes.class);
		List list = query.list();
		return list;
	}

	@Override
	public Grade findByGnameAndSid(String grade, Integer id) {
		String hql="from Grade where schoolid = ? and name = ?";
		List find = this.getHibernateTemplate().find(hql, id,grade);
		if(find!=null && find.size()>0){
			return (Grade) find.get(0);
		}
		return null;
	}


}
