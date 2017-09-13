package com.zjkj.wxy.core.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Wechat;

public interface SchoolDao extends IBaseDao<School> {
/**
 * 根据学校名称查询
 * @param schoolname
 * @return
 */
	School findByName(String schoolname);
/**
 * 根据校名和地址查询学校
 * @param name
 * @param address
 * @return
 */
School findByNameAndAddr(String name, String address);
/**
 * 查询代理商的学校
 * @param id
 * @return
 */
List<School> findForAgent(Integer id);

}
