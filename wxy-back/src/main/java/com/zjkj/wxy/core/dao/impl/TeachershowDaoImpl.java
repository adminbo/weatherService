package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.TeacherDao;
import com.zjkj.wxy.core.dao.TeacherShowDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class TeachershowDaoImpl extends BaseDaoImpl<Teacher> implements TeacherShowDao {

	@Override
	public List<Teacher> findBySid(Integer id) {
		// TODO Auto-generated method stub
		String hql="from Teacher where schoolid = ? and isshow = 1";
		return getHibernateTemplate().find(hql, id);
	}

	@Override
	public Teacher findByIdForJson(Integer id) {
		// TODO Auto-generated method stub
		String hql="from Teacher where id = ?";
		List<Teacher> find = getHibernateTemplate().find(hql, id);
		return find.get(0);
	}
    



}
