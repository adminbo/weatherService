package com.zjkj.wxy.core.dao;

import java.util.List;

import org.json.JSONObject;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Menu;
import com.zjkj.wxy.core.domain.Student;

public interface ApplicationCenterDao extends IBaseDao<Menu> {

	//展示配套環境list
	public List<Menu> applicationList();

	public List<Menu> applicationModuleList();

	public int updParentId(JSONObject json);
}