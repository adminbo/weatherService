package com.zjkj.wxy.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Subject;

public interface SubjectService {

	public List<Subject> findByCriteria(DetachedCriteria criteria);
	
	public Subject findById(Integer id);
	//年级所有学科
	public List<Subject> getSubject(Grade grade);
	//新增学科
	public void save(Subject subject);
	//删除学科
	public void delete(Subject subject);
	
	public List<Subject> findAll();
/**
 * 根据名字查询学科
 * @param string
 * @return
 */
	public Subject findByName(String string);
}
