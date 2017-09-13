package com.zjkj.wxy.core.dao.impl;

import java.lang.Integer;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.ApplicationCenterDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Menu;

@Repository
public class ApplicationCenterDaoImpl extends BaseDaoImpl<Menu> implements ApplicationCenterDao {

	@Override
	public List<Menu> applicationList() {
		String hql = "from Menu m where m.type < 10000";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Menu> list = query.list();
		return list;
	}

	@Override
	public List<Menu> applicationModuleList() {
		String hql = "from Menu m where m.type > 10000";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Menu> list = query.list();
		return list;
	}

	public int updParentId(JSONObject json) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "update Menu m set m.parentid=?, m.istea = ?, m.ispar = ? where m.type < 10000";
			Query query = session.createQuery(hql);
			query.setBigInteger(0, null);
			query.setBigInteger(1, null);
			query.setBigInteger(2, null);
			int r = query.executeUpdate();
			String updateTHql = "update Menu m set m.parentid=?, m.istea = ? where m.id = ? and m.type < 10000";
			String updateFHql = "update Menu m set m.parentid=?, m.ispar = ? where m.id = ? and m.type < 10000";
			JSONObject teacher = json.getJSONObject("teacher");
			Iterator teacherIt = teacher.keys();
			while (teacherIt.hasNext()) {//教师
				String key = String.valueOf(teacherIt.next());
				JSONObject value = teacher.getJSONObject(key);
				String pid = value.getString("pid");
				JSONArray chis = value.getJSONArray("chi");
				for (int i = 0; i < chis.length(); i++) {
					query = session.createQuery(updateTHql);
					query.setInteger(0, Integer.valueOf(pid));
					query.setInteger(1, Integer.valueOf(1));
					query.setInteger(2, chis.getInt(i));
					r = query.executeUpdate();
				}
			}
			JSONObject family = json.getJSONObject("family");
			Iterator familyIt = family.keys();
			while (familyIt.hasNext()) {//家长
				String key = String.valueOf(familyIt.next());
				JSONObject value = family.getJSONObject(key);
				String pid = value.getString("pid");
				JSONArray chis = value.getJSONArray("chi");
				for (int i = 0; i < chis.length(); i++) {
					query = session.createQuery(updateFHql);
					query.setInteger(0, Integer.valueOf(pid));
					query.setInteger(1, Integer.valueOf(1));
					query.setInteger(2, chis.getInt(i));
					r = query.executeUpdate();
				}
			}
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return 0;
	}
}
