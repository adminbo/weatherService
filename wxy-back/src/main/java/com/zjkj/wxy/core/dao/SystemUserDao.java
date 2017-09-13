package com.zjkj.wxy.core.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;

public interface SystemUserDao extends IBaseDao<User>{
/**
 * 根据角色查询用户
 * @param roles
 * @return
 */
	List<User> findByRoles(Role roles);
	
	Serializable saves(User user);
}
