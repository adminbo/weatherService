package com.zjkj.wxy.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.TeacherDao;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.service.TeacherService;
import com.zjkj.wxy.core.utils.PageBean;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherDao teacherDao;

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		teacherDao.pageQuery(pageBean);
	}

	@Override
	public void save(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.save(teacher);
	}

	@Override
	public void delete(Teacher Teacher) {
		// TODO Auto-generated method stub
		teacherDao.delete(Teacher);
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.update(teacher);
		teacher.setIsshow(1);
	}

	@Override
	public Teacher findById(Integer id) {
		// TODO Auto-generated method stub
		return teacherDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDao.findById(id);
		teacher.setIsshow(0);
	}

	@Override
	public List<Teacher> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return teacherDao.findByCriteria(criteria);
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherDao.findAll();
	}



	


}
