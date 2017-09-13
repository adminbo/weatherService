package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.AlbumDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Album;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class AlbumDaoImpl extends BaseDaoImpl<Album> implements AlbumDao {

	@Override
	public List<Album> findBySGCid(Integer id, Integer sid, Integer gid) {
		String hql="from Album where cid = ? and sid = ? and gid = ? and fid=0";
		List find = this.getHibernateTemplate().find(hql,id, sid,gid);
		return find;
	}

	@Override
	public List<Album> getAllAlbum(Integer sid) {
		String hql="from Album where sid = ? and fid=0";
		List find = this.getHibernateTemplate().find(hql,sid);
		return find;
	}

}
