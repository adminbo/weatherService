package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.ConfigWxmanagementService;
import com.zjkj.wxy.core.utils.PageBean;
/**
 * 用户管理实现
 * @author Lenovo
 *
 */
@Service("configWxmanagementService")
@Transactional
public class ConfigWxmanagementServiceImpl implements ConfigWxmanagementService {
	@Resource
	private CofigWxmanagementDao configWxmanagementDao;

	@Override
	public List<Wechat> wechatsliList() {
		// TODO Auto-generated method stub
		return configWxmanagementDao.wechatsliList();
	}

	@Override
	public void addWechats(Wechat wechat) {
		// TODO Auto-generated method stub
		configWxmanagementDao.addWechats(wechat);
	}

	@Override
	public Wechat getWechatid(int id) {
		// TODO Auto-generated method stub
		return configWxmanagementDao.getWechatid(id);
	}

	@Override
	public void updateWechat(Wechat wechat) {
		// TODO Auto-generated method stub
		wechat.setDeletestate(1);
		configWxmanagementDao.updateWechat(wechat);
	}

	

	public CofigWxmanagementDao getConfigWxmanagementDao() {
		return configWxmanagementDao;
	}

	public void setConfigWxmanagementDao(CofigWxmanagementDao configWxmanagementDao) {
		this.configWxmanagementDao = configWxmanagementDao;
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		configWxmanagementDao.pageQuery(pageBean);
	}

	@Override
	public List<Wechat> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return configWxmanagementDao.findByCriteria(criteria);
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Wechat wechat=configWxmanagementDao.findById(id);
		wechat.setDeletestate(0);
	}
	@Override
	public void deleteWechat(Wechat wechat) {
		// TODO Auto-generated method stub
		configWxmanagementDao.delete(wechat);
	}

	@Override
	public void showWechat(Wechat wechat) {
		// TODO Auto-generated method stub
		configWxmanagementDao.showWechat(wechat);
	}
	
	
}
