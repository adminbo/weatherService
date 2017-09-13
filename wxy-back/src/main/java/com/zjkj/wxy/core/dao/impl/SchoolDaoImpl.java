package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.SchoolDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class SchoolDaoImpl extends BaseDaoImpl<School> implements SchoolDao {

	@Override
	public School findByName(String schoolname) {
		String hql="from School where name = ?";
		List<School> find = this.getHibernateTemplate().find(hql, schoolname);
		if(find!=null&& find.size()>0){
			return find.get(0);
		}
		return null;
	}

	@Override
	public School findByNameAndAddr(String name, String address) {
		String hql="from School where name = ? and address=?";
		List<School> find = this.getHibernateTemplate().find(hql, name,address);
		if(find!=null&& find.size()>0){
			return find.get(0);
		}
		return null;
	}

	@Override
	public List<School> findForAgent(Integer id) {
		// TODO Auto-generated method stub
		String hql="from School where firagentid = ? ";
		List<School> find = this.getHibernateTemplate().find(hql, id);
		return find;
	}



}
