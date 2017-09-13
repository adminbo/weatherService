package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.TeacherDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {
    

//	@Override
//	public List<Teacher> getteachers() {
//		String hql = "from Teacher";  
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//        return query.list(); 
//	}
//	@Override
//	public void addTeacher(Teacher teacher) {
//		// TODO Auto-generated method stub
//		sessionFactory.getCurrentSession().save(teacher);
//	}
//	@Override
//	public boolean deleteTeacher(Integer id) {
//		String hql = "delete from Teacher t where t.id = ?";  
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//        query.setInteger(0, id);
//        return (query.executeUpdate() > 0); 
//	}
//	@Override
//	public boolean updateTeacher(Teacher teacher) {
//		String hql = "update Teacher t set t.IMGURL = ?,t.NAME=?,t.STATION = ?,t.INTRODUCE=?,t.SEX = ?,t.AGE=?,t.PHONENUM = ?,t.GARDSCHOOL=?,t.JOBTIME=?,t.ENTRYTIME = ?,t.NUM=?,t.SUBJECTNAME = ?,t.GRADEID=?,t.CLASSID = ? where t.id = ?";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		query.setString(0, teacher.getImgurl());
//		query.setString(1, teacher.getName());
//		query.setString(2, teacher.getStation());
//		query.setString(3, teacher.getIntroduce());
//		query.setBigDecimal(4, teacher.getSex());
//		query.setBigDecimal(5, teacher.getAge());
//		query.setString(6, teacher.getPhonenum());
//		query.setString(7, teacher.getGardschool());
//		query.setBigDecimal(8, teacher.getJobtime());
//		query.setBigDecimal(9, teacher.getEntrytime());
//		query.setString(10, teacher.getNum());
//		query.setString(11, teacher.getSubjectname());
//		query.setBigDecimal(12, teacher.getGradeid());
//		query.setBigDecimal(13, teacher.getClassid());
//		query.setInteger(14, teacher.getId());
//		return (query.executeUpdate() > 0);  
//	}
//	@Override
//	public Teacher getTeacherid(int id) {
//		String hql = "from Teacher where id=?";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		query.setInteger(0, id);
//		return (Teacher) query.uniqueResult();
//	}

}
