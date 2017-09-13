package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.RegDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service
@Transactional
public class RegObjectServiceImpl implements RegObejectService {

	@Resource
	private RegDao regDao;
	
	@Override
	public List<Reg> regliList() {
		// TODO Auto-generated method stub
		return regDao.findAll();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regDao.pageQuery(pageBean);
	}

	@Override
	public void addregs(Reg reg) {
		// TODO Auto-generated method stub
		regDao.save(reg);
	}

	@Override
	public Reg getRegid(Integer id) {
		// TODO Auto-generated method stub
		return regDao.findById(id);
	}

	@Override
	public void updateReg(Reg reg) {
		// TODO Auto-generated method stub
		regDao.merge(reg);
	}

	@Override
	public void deletWechat(Reg reg) {
		// TODO Auto-generated method stub
		regDao.delete(reg);
	}

	
	
	 
	
}
