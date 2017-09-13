package com.zjkj.wxy.core.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.GradeClass;

public interface ClassesService {
	//离线查询对象
	public List<Classes> findByCriteria(DetachedCriteria criteria);
	//根据id查
	public Classes findById(Serializable classid);
	//根据年级查班级
	public List<Classes> getClasses(Grade g);
	
	public List<Classes> findByGrade(Integer id); 
	
	//修改
	public void update(Classes classes);
	//删除
	public void delete(Classes classes);
	//新增
	public void save(Classes classes, GradeClass cl);
	
	public Classes findClassByName(String name);
	//所有
	public List<Classes> findAll();
	
	public void save(Classes cc);
	
}
