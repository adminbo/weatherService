package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.WechatDao;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.WechatService;

@Service
@Transactional
public class WechatServiceImpl implements WechatService {
	@Resource
	WechatDao wechatDao;

	@Override
	public void merge(Wechat wechat) {
		wechatDao.merge(wechat);
	}

	@Override
	public void save(Wechat w) {
		// TODO Auto-generated method stub
		wechatDao.save(w);
	}

	@Override
	public void update(Wechat w) {
		// TODO Auto-generated method stub
		wechatDao.update(w);
	}

}
