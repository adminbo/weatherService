package com.zjkj.wxy.core.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AgentDao;
import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.service.AgentService;
@Service
@Transactional
public class AgentServiceImpl implements AgentService {
@Resource
private AgentDao agentDao;

@Override
public Agent findById(Integer aid) {
	// TODO Auto-generated method stub
	return agentDao.findById(aid);
}

@Override
public List<Agent> getAll() {
	// TODO Auto-generated method stub
	List<Agent> findAll = agentDao.findAll();
	return findAll;
}
}
