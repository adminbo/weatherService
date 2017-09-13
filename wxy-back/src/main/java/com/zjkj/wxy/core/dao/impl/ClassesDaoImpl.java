package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.ClassesDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
@Repository
public class ClassesDaoImpl extends BaseDaoImpl<Classes> implements ClassesDao {
	@Override
	public List<Classes> getClasses(Grade grade) {
		String hql = "SELECT c FROM Classes c join c.gradeClasses g join g.grade gra where gra.id = ? ";	
		// TODO Auto-generated method stub
		List<Classes> list =null;		
			Integer id = grade.getId();
			list= this.getHibernateTemplate().find(hql, id);
		return list;
	}

	@Override
	public List<Classes> findByGrade(Integer id) {
		String hql = "SELECT c FROM Classes c join c.gradeClasses g join g.grade gra where gra.id = ? ";
		List<Classes> list = null;
		list = this.getHibernateTemplate().find(hql,id);
		return list;
	}

	@Override
	public Serializable saves(Classes classes) {
		// TODO Auto-generated method stub
		Serializable id = this.getHibernateTemplate().save(classes);
		return id;
	}

	@Override
	public Classes findClassByName(String name) {
		String hql = "from Classes where name = ? ";
		 List<Classes> find = this.getHibernateTemplate().find(hql,name);
		 if(find!=null && find.size()>0){
			 return find.get(0);
		 }
		return null;
	}


	

}
