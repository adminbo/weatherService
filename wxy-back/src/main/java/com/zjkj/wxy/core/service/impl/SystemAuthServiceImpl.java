package com.zjkj.wxy.core.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.SystemAuthDao;
import com.zjkj.wxy.core.dao.SystemRoleDao;
import com.zjkj.wxy.core.domain.Authority;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.service.SystemAuthService;
@Service
@Transactional
public class SystemAuthServiceImpl implements SystemAuthService {
	@Resource
	private SystemAuthDao systemAuthDao;
	@Resource
	private SystemRoleDao systemRoleDao;
	@Override
	public List<Authority> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return systemAuthDao.findByCriteria(criteria);
	}

	@Override
	public List<Authority> getByRoleId(Integer id) {
		
		return systemAuthDao.getByRoleId(id);
	}

	@Override
	public void updateRelation(Role role, String[] auths) {
		//根据关键字查询权限
	Set authoritys = role.getAuthoritys();
		authoritys.clear();
		List<Authority>list =systemAuthDao.findByKeyWord(auths);	
		for (Authority authority : list) {
			authoritys.add(authority);
		}
		role.setAuthoritys(authoritys);
		systemRoleDao.update(role);
		
	}
}
