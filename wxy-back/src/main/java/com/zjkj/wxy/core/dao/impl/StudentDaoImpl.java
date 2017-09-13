package com.zjkj.wxy.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.StudentDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.utils.PageBean;
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

	@Override
	public List<Student> getstudent(Integer id,Integer gid) {
		String hql = "FROM Student  where classid = ? and grade = ? and isshow=1";
		List<Student> list = null;
		list = this.getHibernateTemplate().find(hql,id,gid);
		return list;
	}

	@Override
	public List<Student> findStudentOne(Integer cid) {
		String hql = "FROM Student where classid = ?";
		List<Student> list = null;
		list = this.getHibernateTemplate().find(hql,cid);
		return list;
	}

	@Override
	public List<Student> findByName(String sname) {
		// TODO Auto-generated method stub
		String hql="from Student where name = ?";
		List<Student> find = this.getHibernateTemplate().find(hql, sname);
		return find;
	}

	@Override
	public List<Student> findByContent(String stuname, Integer gra2, Integer cla) {
		String hql="from Student where name = ? and grade= ? and classid = ?";
		List<Student> find = this.getHibernateTemplate().find(hql, stuname,gra2,cla);
		return find;
	}

	@Override
	public List<Student> getStudentBySchool(Integer sid) {
		String hql="from Student where schoolid = ?";
		List find = this.getHibernateTemplate().find(hql, sid);
		return find;
	}

	

	

}
