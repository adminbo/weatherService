package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.StuParDao;
import com.zjkj.wxy.core.domain.StuPar;
import com.zjkj.wxy.core.service.StuParService;
@Service
@Transactional
public class StuParServiceImpl implements StuParService{
@Resource
private StuParDao stuParDao;

	@Override
	public void save(StuPar ps) {
		// TODO Auto-generated method stub
		stuParDao.save(ps);
	}
}
