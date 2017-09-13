package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.SchoolEnvireService;

@Service("aligendEnvireService")
@Transactional
public class AligenmendEnvireServiceImpl implements AligendEnvireService {

	
	@Resource
	private AlignedEnvironmenDao alignedEnvironmenDao;

	@Override
	public List<Img> envireList() {
		// TODO Auto-generated method stub
		return alignedEnvironmenDao.envireList();
	}

	@Override
	public void addimgs(Img img) {
		// TODO Auto-generated method stub
		alignedEnvironmenDao.addimgs(img);
	}

	@Override
	public Img getWechatid(int id) {
		// TODO Auto-generated method stub
		return	alignedEnvironmenDao.getWechatid(id);
	}

	@Override
	public boolean updateEnvire(Img img) {
		// TODO Auto-generated method stub
		return alignedEnvironmenDao.updateEnvire(img);
	}

	@Override
	public boolean updateschoolEnvire(Img img) {
		// TODO Auto-generated method stub
		return alignedEnvironmenDao.updateschoolEnvire(img);
	}

	@Override
	public boolean deletschoolEnvire(int id) {
		// TODO Auto-generated method stub
		return alignedEnvironmenDao.deletschoolEnvire(id);
	}

	public AlignedEnvironmenDao getAlignedEnvironmenDao() {
		return alignedEnvironmenDao;
	}

	public void setAlignedEnvironmenDao(AlignedEnvironmenDao alignedEnvironmenDao) {
		this.alignedEnvironmenDao = alignedEnvironmenDao;
	}

	
	 
	
}
