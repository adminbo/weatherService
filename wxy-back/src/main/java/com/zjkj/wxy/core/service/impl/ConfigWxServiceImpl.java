package com.zjkj.wxy.core.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.ConfigWxDao;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.ConfigWxService;

@Service("configWxService")
@Transactional
public class ConfigWxServiceImpl implements ConfigWxService{
	
	private ConfigWxDao configWxDao;
	
	@Override
	public void addWechatswe(Wechat wechat) {
		// TODO Auto-generated method stub
		configWxDao.addWechatswe(wechat);
	}
}
