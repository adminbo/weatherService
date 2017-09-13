package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.SystemRoleDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Role;
/**
 * 角色管理dao实现
 * @author Lenovo
 *
 */
@Repository
public class SystemRoleDaoImpl extends BaseDaoImpl<Role> implements SystemRoleDao{

	@Override
	public List<Role> getBySid(Integer sid) {
		// TODO Auto-generated method stub
		String hql="from Role where sid = ?";
		return this.getHibernateTemplate().find(hql, sid);
	}

	@Override
	public List<Role> getBySidOfShow(Integer sid) {
		String hql="from Role where sid = ? ";
		return this.getHibernateTemplate().find(hql, sid);
	}

}
