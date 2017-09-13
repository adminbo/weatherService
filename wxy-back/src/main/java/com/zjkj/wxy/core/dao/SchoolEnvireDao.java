package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.School;

public interface SchoolEnvireDao extends IBaseDao<Img>{
	/**
	 * 根据学校id查寻环境
	 * @param sid
	 * @return
	 */
	List<Img> getAllBySid(Integer sid);


	
	
}
