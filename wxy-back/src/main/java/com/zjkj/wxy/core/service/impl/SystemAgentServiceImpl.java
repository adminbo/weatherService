package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.SystemAgentDao;
import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.service.SystemAgentService;
@Service
@Transactional
public class SystemAgentServiceImpl implements SystemAgentService {

	@Resource
	private SystemAgentDao systemAgentDao;

	@Override
	public List<Agent> getAll() {
		// TODO Auto-generated method stub
		return systemAgentDao.findAll();
	}
}
