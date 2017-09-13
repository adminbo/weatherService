package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.PrincipalMailboxDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.PresidentEmail;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.PrincipalMailboxService;
import com.zjkj.wxy.core.service.SchoolEnvireService;

@Service("principalMailboxService")
@Transactional
public class PrincipalMailboxServiceImpl implements PrincipalMailboxService {

	
	@Resource
	private PrincipalMailboxDao principalMailboxDao;

	@Override
	public List<PresidentEmail> presidentEmaillList() {
		// TODO Auto-generated method stub
		return principalMailboxDao.presidentEmaillList();
	}

	@Override
	public PresidentEmail getPresidentEmail(int id) {
		// TODO Auto-generated method stub
		return principalMailboxDao.getPresidentEmail(id);
	}

	@Override
	public boolean updatePresidentEmail(PresidentEmail presidentEmail) {
		// TODO Auto-generated method stub
		return principalMailboxDao.updatePresidentEmail(presidentEmail);
	}

	
	 
	
}
