package com.zjkj.wxy.core.service;

import java.math.BigDecimal;
import java.util.List;

import com.zjkj.wxy.core.domain.Agent;

public interface AgentService {
	/**
	 * 根据id查询代理商
	 * @param aid
	 * @return
	 */
	Agent findById(Integer aid);
/**
 * 查询所有
 * @return
 */
	List<Agent> getAll();

}
