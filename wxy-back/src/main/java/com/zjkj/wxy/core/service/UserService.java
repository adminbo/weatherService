package com.zjkj.wxy.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.User;
/**
 * 用户管理service借口
 * @author Lenovo
 *
 */
public interface UserService {
/**
 * 登录
 * @param userName
 * @param passWord
 * @return
 */
	User login(String userName, String passWord);
/**
 * 更新用户信息
 * @param user
 */
void update(User user);
/**
 * 根据条件查询
 * @param criteria
 * @return
 */
List<User> findByCriteria(DetachedCriteria criteria);
 
}
