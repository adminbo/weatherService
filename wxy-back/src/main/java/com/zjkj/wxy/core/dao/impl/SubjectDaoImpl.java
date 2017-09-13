package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.SubjectDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Subject;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class SubjectDaoImpl extends BaseDaoImpl<Subject> implements SubjectDao {

	@Override
	public List<Subject> getSubject(Grade grade) {
		String hql = "SELECT s FROM Subject s join s.grades gra where gra.id = ?";
		List<Subject> list = null;
		Integer id = grade.getId();
		list = this.getHibernateTemplate().find(hql,id);
		return list;
	}

	@Override
	public Subject findByName(String sub) {
		String hql = "FROM Subject where name = ?";
		List<Subject> find = this.getHibernateTemplate().find(hql,sub);
		if(find!=null && find.size()>0){
			return find.get(0);
		}
		return null;
	}


}
