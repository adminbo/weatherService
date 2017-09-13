package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Student;

public interface StudentDao extends IBaseDao<Student> {
	
	public List<Student> getstudent(Integer id,Integer gid);
	//默认显示一班的
	public List<Student> findStudentOne(Integer cid);
	/**
	 * 根据名字查询
	 * @param sname
	 * @return
	 */
	public List<Student> findByName(String sname);
	/**
	 * 根据姓名，年级，班级查询学生
	 * @param stuname
	 * @param gra2
	 * @param cla
	 * @return
	 */
	public List<Student> findByContent(String stuname, Integer gra2, Integer cla);
	
	public List<Student> getStudentBySchool(Integer sid);
	

}
