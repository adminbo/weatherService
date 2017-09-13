package com.zjkj.wxy.core.dao;


import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Wechat;

public interface ConfigWxDao extends IBaseDao<Wechat>{

	//增加公众号的配置
	public void addWechatswe(Wechat wechat);
	
}
