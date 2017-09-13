package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Gratea;

public interface GrateaService {

	//新增关系
	public void save(Gratea gratea);
	//修改
	public void update(Gratea gratea);
	
	public Gratea findById(Integer id);
	
	public List<Gratea> findByTea(Integer id);
}
