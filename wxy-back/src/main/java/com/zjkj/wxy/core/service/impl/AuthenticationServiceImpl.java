package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.AuthenticationDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Authentication;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.AuthenticationObejectService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationObejectService {

	@Resource
	private AuthenticationDao Authenticationdao;

	@Override
	public List<Authentication> authenticationsList() {
		// TODO Auto-generated method stub
		return Authenticationdao.findAll();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		Authenticationdao.pageQuery(pageBean);
	}

	@Override
	public void addauthtication(Authentication reg) {
		// TODO Auto-generated method stub
		Authenticationdao.save(reg);
	}

	@Override
	public Authentication getAuthenticationid(Integer id) {
		// TODO Auto-generated method stub
		return Authenticationdao.findById(id);
	}

	@Override
	public void updateauthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		Authenticationdao.merge(authentication);
	}

	@Override
	public void deletauthentication(Authentication authentication) {
		// TODO Auto-generated method stub
		Authenticationdao.delete(authentication);
	}
	
}
