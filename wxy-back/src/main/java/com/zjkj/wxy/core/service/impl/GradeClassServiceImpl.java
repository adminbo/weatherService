package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.GradeClassDao;
import com.zjkj.wxy.core.domain.GradeClass;
import com.zjkj.wxy.core.service.GradeClassService;
@Service
@Transactional
public class GradeClassServiceImpl implements GradeClassService {

	@Resource
	private GradeClassDao gradeClassDao;
	@Override
	public void delete(GradeClass gradeclass) {
		// TODO Auto-generated method stub
		gradeClassDao.delete(gradeclass);
	}
	@Override
	public void save(GradeClass gradeclass) {
		// TODO Auto-generated method stub
		gradeClassDao.save(gradeclass);
	}

}
