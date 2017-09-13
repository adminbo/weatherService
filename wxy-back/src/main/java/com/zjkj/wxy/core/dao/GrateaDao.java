package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Gratea;

public interface GrateaDao extends IBaseDao<Gratea> {

	public List<Gratea> findByTea(Integer id);
}
