package com.zjkj.wxy.core.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.GradeDao;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.service.GradeService;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

	@Resource
	private GradeDao gradeDao;
	
	@Override
	public List<Grade> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return gradeDao.findByCriteria(criteria);
	}

	@Override
	public Grade findById(Serializable id) {
		// TODO Auto-generated method stub
		return gradeDao.findById(id);
	}

	@Override
	public void update(Grade grade) {
		// TODO Auto-generated method stub
		gradeDao.update(grade);
	}

	@Override
	public void delete(Grade grade) {
		// TODO Auto-generated method stub
		gradeDao.delete(grade);
	}

	@Override
	public void save(Grade grade) {
		// TODO Auto-generated method stub
		gradeDao.save(grade);
	}

	@Override
	public List<Grade> findBySid(Integer sid) {
		// TODO Auto-generated method stub
		return gradeDao.findBySid(sid);
	}

	@Override
	public List<Classes> getAllClazz(Integer gid) {
		// TODO Auto-generated method stub
		return gradeDao.getAllClazz(gid);
	}

	@Override
	public Grade findByNameAndSid(String grade, Integer id) {
		// TODO Auto-generated method stub
		return gradeDao.findByGnameAndSid(grade,id);
	}

	

}
