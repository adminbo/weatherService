package com.zjkj.wxy.core.service;

import java.math.BigDecimal;
import java.util.Set;

import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.utils.PageBean;

public interface SystemUserService {
/**
 * 分页查询
 * @param pageBean
 */
	void pageQuery(PageBean pageBean);
/**
 * 添加用户
 * @param user
 * @param roles 
 */
void saveUser(User user, Set<Role> roles);
/**
 * 根据用户id查询
 * @param id
 * @return
 */
User findById(Integer id);
/**
 * 修改
 * @param user
 */
void updateUser(User user);
/**
 * 根据id删除
 * @param id
 */
void deleteById(Integer id);

}
