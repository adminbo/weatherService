package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.ParentDao;
import com.zjkj.wxy.core.domain.Parents;
import com.zjkj.wxy.core.service.ParentService;
@Service
@Transactional
public class ParentServiceImpl implements ParentService{
@Resource
private ParentDao parentDao;
	

@Override
	public void save(Parents pp) {
		// TODO Auto-generated method stub
		parentDao.save(pp);
	}


@Override
public Parents getById(Integer id) {
	// TODO Auto-generated method stub
	return parentDao.findById(id);
}


@Override
public Parents getByPhone(String phonenum,String name) {
	// TODO Auto-generated method stub
	return parentDao.findByPhone(phonenum,name);
}

}
