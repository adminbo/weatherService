package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Photo;

public interface PhotoDao extends IBaseDao<Photo> {

	List<Photo> getphotoByAbid(Integer abid);
}
