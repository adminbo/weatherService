package com.zjkj.wxy.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.SystemAuthDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Authority;
@Repository
public class SystemAuthDaoImpl extends BaseDaoImpl<Authority> implements SystemAuthDao {

	@Override
	public List<Authority> getByRoleId(Integer id) {
		// TODO Auto-generated method stub
		String hql="SELECT a FROM Authority a join a.roles r  where r.id = ? ";
		
		return this.getHibernateTemplate().find(hql, id);
	}

	@Override
	public List<Authority> findByKeyWord(String[] auths) {
		// TODO Auto-generated method stub
		String hql="from Authority where keyWord =?";
		List<Authority>list = new ArrayList<>();
		for (String keyWord : auths) {
			Authority auth =(Authority) this.getHibernateTemplate().find(hql, keyWord).get(0);	
			list.add(auth);
		}
		return list;
	}

	@Override
	public List<Authority> findAuthByUserId(Integer id) {
		// TODO Auto-generated method stub
		String hql="SELECT a FROM Authority a join a.roles r join r.users u where u.id = ? ";
		return this.getHibernateTemplate().find(hql, id);
	}

	
}
