package com.zjkj.wxy.core.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.GradeDao;
import com.zjkj.wxy.core.dao.SubjectDao;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Subject;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.service.SubjectService;
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Resource
	private SubjectDao subjectDao;
	@Resource
	private GradeDao gradeDao;
	@Override
	public List<Subject> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return subjectDao.findByCriteria(criteria);
     }
	@Override
	public Subject findById(Integer id) {
		// TODO Auto-generated method stub
		return subjectDao.findById(id);
	}
	@Override
	public List<Subject> getSubject(Grade grade) {
		// TODO Auto-generated method stub
		return subjectDao.getSubject(grade);
	}
	@Override
	public void save(Subject subject) {
		// TODO Auto-generated method stub
	//	grade.getSubjects().add(subject);
		subjectDao.save(subject);
	}
	@Override
	public void delete(Subject subject) {
		// TODO Auto-generated method stub
		subjectDao.delete(subject);
	}
	@Override
	public List<Subject> findAll() {
		// TODO Auto-generated method stub
		return subjectDao.findAll();
	}
	@Override
	public Subject findByName(String sub) {
		// TODO Auto-generated method stub
		return subjectDao.findByName(sub);
	}
	
	
	
}
	
	
