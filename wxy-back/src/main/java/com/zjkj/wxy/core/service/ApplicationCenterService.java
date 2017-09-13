package com.zjkj.wxy.core.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.domain.Menu;

public interface ApplicationCenterService {

	//展示配套環境list
	public List<Menu> applicationList();

	public List<Menu> applicationModuleList();

	public void updParentId(JSONObject json);
}
