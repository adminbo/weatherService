package com.zjkj.wxy.core.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.json.JSONObject;

import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.utils.PageBean;

public interface SchoolService {
	//根据id查询
	public School findById(Integer id);
	
	public List<School> findAll();
	
	public void pageQuery(PageBean pageBean);
	
	
	/**
	 * 添加
	 */
	public void save(School school);
	
	/**
	 * 删除
	 */
	public void delete(School school);
	/**
	 * 修改
	 */
	public void update(School school);
/**
 * 根据名称查询
 * @param schoolname
 * @return
 */
	public School findByName(String schoolname);
/**
 * 根据id删除
 * @param id
 */
public void deleteById(Integer id);
/**
 * 根据校名和地址查询
 * @param name
 * @param address
 * @return
 */
public School findByNameAndAddr(String name, String address);
/**
 * 离线查询
 * @param detachedCriteria
 * @return
 */
public List<School> findByCri(DetachedCriteria detachedCriteria);
/**
 * 查询代理上旗下学校
 * @param id
 * @return
 */
public List<School> findForAgent(Integer id);

	
}
