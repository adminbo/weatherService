package com.zjkj.wxy.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Authority;
import com.zjkj.wxy.core.domain.Role;

public interface SystemAuthService {
/**
 * 条件查询
 * @param criteria
 * @return
 */
	List<Authority> findByCriteria(DetachedCriteria criteria);
/**
 * 根据角色id查询权限
 * @param id
 * @return
 */
List<Authority> getByRoleId(Integer id);
/**
 * 维护role和auth的关系
 * @param role
 * @param auths
 */
void updateRelation(Role role, String[] auths);

}
