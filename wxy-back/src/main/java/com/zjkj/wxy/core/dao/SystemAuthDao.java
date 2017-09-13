package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Authority;

public interface SystemAuthDao extends IBaseDao<Authority>{
/**
 * 根据角色id查询权限4
 * @param id
 * @return
 */
	List<Authority> getByRoleId(Integer id);
/**
 * 根据关键字查询权限
 * @param keyWord
 * @return
 */

List<Authority> findByKeyWord(String[] auths);
/**
 * 根据登录用户查询所有权限
 * @param id
 * @return
 */
List<Authority> findAuthByUserId(Integer id);


}
