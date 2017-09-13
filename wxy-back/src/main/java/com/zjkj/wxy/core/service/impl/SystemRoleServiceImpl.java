package com.zjkj.wxy.core.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.SystemRoleDao;
import com.zjkj.wxy.core.dao.SystemUserDao;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.SystemRoleService;
/**
 * 角色管理service实现
 * @author Lenovo
 *
 */
@Service
@Transactional
public class SystemRoleServiceImpl implements SystemRoleService {
	@Resource
	private SystemRoleDao systemRoleDao;
	@Resource
	private SystemUserDao systemUserDao;


	@Override
	public List<Role> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return systemRoleDao.findByCriteria(criteria);
	}

	@Override
	public Role findById(Integer parid) {
		
		return systemRoleDao.findById(parid);
	}

	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		systemRoleDao.save(role);
	}

	@Override
	public void updateRole(String name, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		List<Role> roles = systemRoleDao.findByCriteria(criteria);
		if(roles!=null && roles.size()>0){
			Role role=roles.get(0);
			role.setName(name);
		}
	}

	@Override
	public void deleteRole(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		List<Role> roles = systemRoleDao.findByCriteria(criteria);//先根据条件查询出角色，实际只有一条
		if(roles!=null && roles.size()>0){
			Role role = roles.get(0);
			List<User> users =systemUserDao.findByRoles(role);//根据角色得到所有关联的用户
			for (User user : users) {
				user.getRoles().remove(role);//用户维护关系表
				systemUserDao.update(user);
			}
			role.setAuthoritys(null);//维护角色-权限关系
			//role.setIsshow(0);//删除角色，不可见
			systemRoleDao.delete(role);
		}
	}

	@Override
	public List<Role> getSameRole(int start, int end) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
		detachedCriteria.add(Restrictions.gt("id", new BigDecimal(start)));
		detachedCriteria.add(Restrictions.le("id", new BigDecimal(end)));
		return systemRoleDao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<Role> getBySid(Integer sid) {
		// TODO Auto-generated method stub
		
		return systemRoleDao.getBySidOfShow(sid);
	}

	
}
