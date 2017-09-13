package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Album;

public interface AlbumService {

	List<Album> findBySGCid(Integer id,Integer sid,Integer gid);
	List<Album> getAllAlbum(Integer sid);
}
