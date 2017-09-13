package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.JiazhangXTDao;
import com.zjkj.wxy.core.domain.TakeAndSend;
import com.zjkj.wxy.core.service.JiazhangXTService;
@Service
@Transactional
public class JiazhangXTServiceImpl implements JiazhangXTService {

	@Resource
	private JiazhangXTDao jiaZhangXTDao;

	@Override
	public List<TakeAndSend> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return jiaZhangXTDao.findByCriteria(criteria);
	}
}
