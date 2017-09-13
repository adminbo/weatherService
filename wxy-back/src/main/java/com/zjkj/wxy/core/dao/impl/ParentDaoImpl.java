package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.ParentDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Parents;
@Repository
public class ParentDaoImpl extends BaseDaoImpl<Parents> implements ParentDao {

	@Override
	public Parents findByPhone(String phonenum,String name) {
		String hql="from Parents where phonenum = ? and name = ?";
		List<Parents> find = this.getHibernateTemplate().find(hql, phonenum,name);
		if(find!=null&&find.size()>0){
			return find.get(0);
		}
		return null;
	}

}
