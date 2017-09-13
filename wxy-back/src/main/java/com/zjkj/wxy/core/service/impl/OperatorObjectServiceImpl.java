package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.OperatorDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.OperatorObejectService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service
@Transactional
public class OperatorObjectServiceImpl implements OperatorObejectService {

	@Resource
	private OperatorDao operatorDao;

	@Override
	public List<Operator> regliList() {
		// TODO Auto-generated method stub
		return operatorDao.findAll();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		 operatorDao.pageQuery(pageBean);
	}

	@Override
	public void addOperator(Operator reg) {
		// TODO Auto-generated method stub
		operatorDao.save(reg);
	}

	@Override
	public Operator getOperatorid(String id) {
		// TODO Auto-generated method stub
		return operatorDao.findById(id);
	}

	@Override
	public void updateReg(Operator reg) {
		// TODO Auto-generated method stub
		operatorDao.merge(reg);
	}

	@Override
	public void deletOperator(Operator reg) {
		// TODO Auto-generated method stub
		operatorDao.delete(reg);
	}

	@Override
	public void save(Operator gg) {
		// TODO Auto-generated method stub
		operatorDao.save(gg);
	}
	
}
