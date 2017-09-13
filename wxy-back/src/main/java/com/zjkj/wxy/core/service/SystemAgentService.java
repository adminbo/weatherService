package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Agent;

public interface SystemAgentService {
/**
 * 查询所有的代理商
 * @return
 */
	List<Agent> getAll();

}
