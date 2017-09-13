package com.zjkj.wxy.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjkj.wxy.core.dao.TeacherShowDao;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.service.TeachershowService;
import com.zjkj.wxy.core.utils.PageBean;

@Service
@Transactional
public  class TeachershowServiceImpl implements TeachershowService{

	@Resource
	private TeacherShowDao teacherDao;
	
	
	@Override
	public void save(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Teacher Teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teacher findById(Integer id) {
		// TODO Auto-generated method stub
		return teacherDao.findById(id);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		teacherDao.pageQuery(pageBean);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Teacher findById = teacherDao.findById(id);
		findById.setIsshow(0);//删除，不可见
	}

	@Override
	public List<Teacher> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return teacherDao.findByCriteria(criteria);
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> findBySid(Integer id) {
		// TODO Auto-generated method stub
		
		return teacherDao.findBySid(id);
	}

	@Override
	public List<Teacher> findForAgent(PageBean pg, List<School> list) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = new ArrayList<>();
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Teacher.class);	
		for (School school : list) {
			detachedCriteria.add(Restrictions.eq("school", school));
			List<Teacher> findByCriteria = teacherDao.findByCriteria(detachedCriteria);
			teachers.addAll(findByCriteria);
		}
		
		return teachers;
	}

	@Override
	public Teacher findByIdForJson(Integer id) {
		// TODO Auto-generated method stub
		return teacherDao.findByIdForJson(id);
	}

	@Override
	public void updateTea(String path, Integer tid, String name, String introduce, String station) {
		// TODO Auto-generated method stub
		Teacher findById = teacherDao.findById(tid);
		findById.setName(name);
		findById.setIntroduce(introduce);
		findById.setImgurl(path);
		findById.setStation(station);
	}



}
