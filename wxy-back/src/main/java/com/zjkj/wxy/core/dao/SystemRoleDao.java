package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Role;
/**
 * 角色管理dao接口
 * @author Lenovo
 *
 */
public interface SystemRoleDao extends IBaseDao<Role>{
/**
 * 根据学校id查询角色
 * @param sid
 * @return
 */
	List<Role> getBySid(Integer sid);
/**
 * 查询可有角色
 * @param sid
 * @return
 */
List<Role> getBySidOfShow(Integer sid);

}
