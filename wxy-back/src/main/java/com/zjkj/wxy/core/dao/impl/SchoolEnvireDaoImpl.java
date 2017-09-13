package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Img;

@Repository
public class SchoolEnvireDaoImpl extends BaseDaoImpl<Img> implements SchoolEnvireDao{

	@Override
	public List<Img> getAllBySid(Integer sid) {
		// TODO Auto-generated method stub
		String sql="select i.* from t_img i,t_imgdetail d where i.id=d.imgid and d.schoolid = "+sid+" and d.type =1";
		SQLQuery createSQLQuery = this.getSession().createSQLQuery(sql);
		createSQLQuery.addEntity(Img.class);
		List<Img> list = createSQLQuery.list();
//		String hql="select i from Img i ,ImgDetail d where d.schoolid = ? and i.id=d.imgid and d.type =1";
//		List<Img> find = getHibernateTemplate().find(hql, sid);
		return list;
	}

	
	
}
