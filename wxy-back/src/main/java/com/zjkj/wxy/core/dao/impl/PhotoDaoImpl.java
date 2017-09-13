package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.PhotoDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Photo;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class PhotoDaoImpl extends BaseDaoImpl<Photo> implements PhotoDao {

	@Override
	public List<Photo> getphotoByAbid(Integer abid) {
		String hql="from Photo where abid = ?";
		List find = this.getHibernateTemplate().find(hql,abid);
		return find;
	}

	

}
