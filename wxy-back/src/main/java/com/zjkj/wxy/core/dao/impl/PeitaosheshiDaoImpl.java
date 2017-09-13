package com.zjkj.wxy.core.dao.impl;



import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.PeitaosheshiDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;

@Repository
public class PeitaosheshiDaoImpl extends BaseDaoImpl<Img> implements PeitaosheshiDao{

	@Override
	public List<Img> findAllByType(Integer id) {
		String sql="select i.* from t_img i,t_imgdetail d where i.id=d.imgid and d.schoolid = "+id+" and d.type =2";
		SQLQuery createSQLQuery = this.getSession().createSQLQuery(sql);
		createSQLQuery.addEntity(Img.class);
		List<Img> list = createSQLQuery.list();
//		String hql="select i from Img i ,ImgDetail d where d.schoolid = ? and i.id=d.imgid and d.type =1";
//		List<Img> find = getHibernateTemplate().find(hql, sid);
		return list;
	}

	
	
}
