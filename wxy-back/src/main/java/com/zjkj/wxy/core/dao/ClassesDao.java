package com.zjkj.wxy.core.dao;

import java.io.Serializable;
import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;

public interface ClassesDao extends IBaseDao<Classes> {
	
	public List<Classes> getClasses(Grade grade);
	
	public List<Classes> findByGrade(Integer id);

	public Serializable saves(Classes classes);
	
	public Classes findClassByName(String name);
	

}
