package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.School;

public interface PeitaosheshiDao extends IBaseDao<Img>{
/**
 * 查询配套设施
 * @param id 
 * @return
 */
	List<Img> findAllByType(Integer id);


	
	
}
