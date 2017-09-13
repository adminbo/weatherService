package com.zjkj.wxy.core.dao;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.User;
/**
 * 用户管理dao接口
 * @author Lenovo
 *
 */
public interface UserDao extends IBaseDao<User>{
/**
 * 根据用户名和密码查询
 * @param userName
 * @param passWord
 * @return
 */
	User getByUserNameAndPwd(String userName, String passWord);
/**
 * 根据用户名查询
 * @param username
 * @return
 */
User getByUsername(String username);

}
