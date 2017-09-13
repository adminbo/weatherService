package com.zjkj.wxy.core.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.ClassesDao;
import com.zjkj.wxy.core.dao.GradeClassDao;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.GradeClass;
import com.zjkj.wxy.core.service.ClassesService;
@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {

	@Resource
	private ClassesDao classesDao;
	@Resource
	private GradeClassDao gradeClassDao;
	@Override
	public List<Classes> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return classesDao.findByCriteria(criteria);
	}
	@Override
	public Classes findById(Serializable classid) {
		// TODO Auto-generated method stub
		return classesDao.findById(classid);
	}
	@Override
	public List<Classes> getClasses(Grade grade) {
		// TODO Auto-generated method stub
		
		return classesDao.getClasses(grade);
	}
	@Override
	public List<Classes> findByGrade(Integer id) {
		// TODO Auto-generated method stub
		return classesDao.findByGrade(id);
	}
	@Override
	public void update(Classes classes) {
		// TODO Auto-generated method stub
		classesDao.update(classes);
	}
	@Override
	public void delete(Classes classes) {
		// TODO Auto-generated method stub
		classesDao.delete(classes);
	}

	@Override
	public void save(Classes classes, GradeClass cl) {
		// TODO Auto-generated method stub
		Serializable id = classesDao.saves(classes);
		Classes findById = classesDao.findById(id);
		cl.setClasses(findById);
		gradeClassDao.save(cl);
	}
	@Override
	public Classes findClassByName(String name) {
		// TODO Auto-generated method stub
		return classesDao.findClassByName(name);
	}
	@Override
	public List<Classes> findAll() {
		// TODO Auto-generated method stub
		return classesDao.findAll();
	}
	@Override
	public void save(Classes cc) {
		
		classesDao.save(cc);
	}




}
