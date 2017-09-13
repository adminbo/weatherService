package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Album;

public interface AlbumDao extends IBaseDao<Album> {

	List<Album> findBySGCid(Integer id,Integer sid,Integer gid);
	List<Album> getAllAlbum(Integer sid);
}
