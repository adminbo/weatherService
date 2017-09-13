package com.zjkj.wxy.core.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.SchoolDao;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.utils.PageBean;
@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

	@Resource
	private SchoolDao schoolDao;
	@Override
	public School findById(Integer id) {
		// TODO Auto-generated method stub
		return schoolDao.findById(id);
	}
	@Override
	public List<School> findAll() {
		// TODO Auto-generated method stub
		return schoolDao.findAll();
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		schoolDao.pageQuery(pageBean);
	}
	@Override
	public void save(School school) {
		// TODO Auto-generated method stub
		schoolDao.save(school);
	}
	@Override
	public void delete(School school) {
		// TODO Auto-generated method stub
		schoolDao.delete(school);
	}
	@Override
	public void update(School school) {
		// TODO Auto-generated method stub
		schoolDao.update(school);
	}
	@Override
	public School findByName(String schoolname) {
		// TODO Auto-generated method stub
		return schoolDao.findByName(schoolname);
	}
	@Override
	public void deleteById(	Integer id) {
		// TODO Auto-generated method stub
		School findById = schoolDao.findById(id);
		schoolDao.delete(findById);
	}
	@Override
	public School findByNameAndAddr(String name, String address) {
		// TODO Auto-generated method stub
		
		return schoolDao.findByNameAndAddr(name,address);
	}
	@Override
	public List<School> findByCri(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		
		return schoolDao.findByCriteria(detachedCriteria);
	}
	@Override
	public List<School> findForAgent(Integer id) {
		// TODO Auto-generated method stub
		return schoolDao.findForAgent(id);
	}

	
}
