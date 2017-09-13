package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.ApplicationCenterDao;
import com.zjkj.wxy.core.domain.Menu;
import com.zjkj.wxy.core.service.ApplicationCenterService;

@Service("applicationCenterService")
@Transactional
public class ApplicationCenterServiceImpl implements ApplicationCenterService {

	@Resource
	private ApplicationCenterDao applicationcedao;

	@Override
	public List<Menu> applicationList() {
		return applicationcedao.applicationList();
	}

	@Override
	public List<Menu> applicationModuleList() {
		return applicationcedao.applicationModuleList();
	}

	public ApplicationCenterDao getApplicationcedao() {
		return applicationcedao;
	}

	public void setApplicationcedao(ApplicationCenterDao applicationcedao) {
		this.applicationcedao = applicationcedao;
	}

	public void updParentId(JSONObject json) {
		applicationcedao.updParentId(json);
	}
}
