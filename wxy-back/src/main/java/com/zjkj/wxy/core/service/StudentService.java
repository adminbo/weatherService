package com.zjkj.wxy.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.utils.PageBean;

public interface StudentService {
	//分页查询学生信息
	public void pageQuery(PageBean pageBean);
	
	//根据id查询
	public Student findById(Integer id);
	//新增学生信息
	public void save(Student student);
	//删除
	public void delete(Student student);
	//假删
	public void deleteById(Integer id);
	//修改
	public void update(Student student);
	//通过班级得到学生
	public List<Student> getStudent(Integer id,Integer gid);
	
	public List<Student> findStudentOne(Integer cid);
//离线查询
	public Student findByCri(DetachedCriteria detachedCriteria);
	
	public List<Student> getStudentBySchool(Integer sid);
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
public List<Student> findByNameAndGradeAndClazz(String stuname, Integer gra2, Integer cla);

}
