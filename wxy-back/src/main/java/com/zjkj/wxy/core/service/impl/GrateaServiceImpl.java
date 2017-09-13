package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.GrateaDao;
import com.zjkj.wxy.core.domain.Gratea;
import com.zjkj.wxy.core.service.GrateaService;
@Service
@Transactional
public class GrateaServiceImpl implements GrateaService {

	@Resource
	private GrateaDao grateaDao;

	@Override
	public void save(Gratea gratea) {
		// TODO Auto-generated method stub
		grateaDao.save(gratea);
	}

	@Override
	public void update(Gratea gratea) {
		// TODO Auto-generated method stub
		grateaDao.update(gratea);
	}

	@Override
	public Gratea findById(Integer id) {
		// TODO Auto-generated method stub
		return grateaDao.findById(id);
	}

	@Override
	public List<Gratea> findByTea(Integer id) {
		// TODO Auto-generated method stub
		return grateaDao.findByTea(id);
	}
}
