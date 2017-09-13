package com.zjkj.wxy.core.dao;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Parents;

public interface ParentDao extends IBaseDao<Parents> {
/**
 * 根据电话查询
 * @param phonenum
 * @return
 */
	Parents findByPhone(String phonenum,String name);

}
