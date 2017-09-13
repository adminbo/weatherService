package com.zjkj.wxy.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Role;

/**
 * 角色管理service接口
 * @author Lenovo
 *
 */
public interface SystemRoleService {
/**
 * 获取所有的角色
 * @param j 
 * @param i 
 * @return 角色集合
 */
	List<Role> getSameRole(int i, int j);
/**
 * 条件查询
 * @param criteria
 * @return
 */
List<Role> findByCriteria(DetachedCriteria criteria);
/**
 * 根据id查询角色
 * @param parid
 * @return
 */
Role findById(Integer parid);
/**
 * 添加角色4
 * @param role
 */
void add(Role role);
/**
 * 更新role
 * @param name 需要改为的名称
 * @param criteria 查询条件
 */
void updateRole(String name, DetachedCriteria criteria);
/**
 * 根据条件删除角色
 * @param criteria
 */
void deleteRole(DetachedCriteria criteria);
/**
 * 根据学校id查询该校的角色
 * @param sid
 */
List<Role> getBySid(Integer sid);

}
