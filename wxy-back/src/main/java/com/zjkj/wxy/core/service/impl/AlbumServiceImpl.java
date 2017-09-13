package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlbumDao;
import com.zjkj.wxy.core.domain.Album;
import com.zjkj.wxy.core.service.AlbumService;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

	@Resource
	private AlbumDao albumDao;

	@Override
	public List<Album> findBySGCid(Integer id, Integer sid, Integer gid) {
		// TODO Auto-generated method stub
		return albumDao.findBySGCid(id, sid, gid);
	}

	@Override
	public List<Album> getAllAlbum(Integer sid) {
		// TODO Auto-generated method stub
		return albumDao.getAllAlbum(sid);
	}
}
