package com.zjkj.wxy.core.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.StudentDao;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.service.StudentService;
import com.zjkj.wxy.core.utils.PageBean;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao studentDao;
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
        studentDao.pageQuery(pageBean);
	}
	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}
	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentDao.delete(student);
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Student student = studentDao.findById(id);
		student.setIsshow(0);
	}
	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
		student.setIsshow(1);
	}
	@Override
	public List<Student> getStudent(Integer id,Integer gid) {
		// TODO Auto-generated method stub
		return studentDao.getstudent(id,gid);
	}
	@Override
	public List<Student> findStudentOne(Integer cid) {
		// TODO Auto-generated method stub
		return studentDao.findStudentOne(cid);
	}
	@Override
	public Student findByCri(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		List<Student> findByCriteria = studentDao.findByCriteria(detachedCriteria);
		if(findByCriteria!=null && findByCriteria.size()>0){
			return  findByCriteria.get(0);
		}
		return  null;
	}
	@Override
	public List<Student> findByName(String sname) {
		// TODO Auto-generated method stub
		
		return studentDao.findByName(sname);
	}
	@Override
	public List<Student> findByNameAndGradeAndClazz(String stuname, Integer gra2, Integer cla) {
		// TODO Auto-generated method stub
		return studentDao.findByContent(stuname,gra2,cla);
	}
	@Override
	public List<Student> getStudentBySchool(Integer sid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentBySchool(sid);
	}

}
