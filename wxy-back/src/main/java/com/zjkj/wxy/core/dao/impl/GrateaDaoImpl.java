package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.GrateaDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Gratea;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class GrateaDaoImpl extends BaseDaoImpl<Gratea> implements GrateaDao {

	@Override
	public List<Gratea> findByTea(Integer id) {
		String hql = "select t from Gratea t where t.teacher = ?";
		List<Gratea> list = null;
		list = this.getHibernateTemplate().find(hql,id);
		return list;
	}

	

}
