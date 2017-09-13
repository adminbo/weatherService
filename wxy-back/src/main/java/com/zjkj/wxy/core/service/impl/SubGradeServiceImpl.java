package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.SubGardeDao;
import com.zjkj.wxy.core.domain.SubGrade;
import com.zjkj.wxy.core.service.SubGradeService;
@Service
@Transactional
public class SubGradeServiceImpl implements SubGradeService {
	@Resource
	private SubGardeDao subGradeDao;
	
	@Override
	public void save(SubGrade gs) {
		// TODO Auto-generated method stub
		subGradeDao.save(gs);
	}
	
}
