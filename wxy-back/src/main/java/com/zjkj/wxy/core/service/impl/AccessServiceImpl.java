package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AccessDao;
import com.zjkj.wxy.core.domain.Equipment;
import com.zjkj.wxy.core.service.AccessService;
import com.zjkj.wxy.core.utils.PageBean;
@Service
@Transactional
public class AccessServiceImpl implements AccessService{
@Resource
private AccessDao accessDao;

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		accessDao.pageQuery(pageBean);
	}
	
	@Override
	public void add(Equipment equipment) {
		// TODO Auto-generated method stub
		accessDao.save(equipment);
	}

	@Override
	public void delById(String id) {
		// TODO Auto-generated method stub
		Equipment findById = accessDao.findById(id);
		accessDao.delete(findById);
	}
}
