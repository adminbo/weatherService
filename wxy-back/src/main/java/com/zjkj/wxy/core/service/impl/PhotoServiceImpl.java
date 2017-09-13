package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.PhotoDao;
import com.zjkj.wxy.core.domain.Photo;
import com.zjkj.wxy.core.service.PhotoService;
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

	@Resource
	private PhotoDao photoDao;

	@Override
	public List<Photo> getphotoByAbid(Integer abid) {
		// TODO Auto-generated method stub
		return photoDao.getphotoByAbid(abid);
	}
}
