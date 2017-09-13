package com.zjkj.wxy.core.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.utils.PageBean;

public interface TeacherService {

	//新增教师信息
	public void save(Teacher teacher);
	//删除教师信息
	public void delete(Teacher Teacher);
	//修改教师信息
	public void update(Teacher teacher);
	//修改教师信息（1，找寻它对应的id；2，修改）
	public Teacher findById(Integer id);
	//分页查询
	void pageQuery(PageBean pageBean);
	//假删
	public void deleteById(Integer id);
	//离线查询对象
	public List<Teacher> findByCriteria(DetachedCriteria criteria);
	//查询所有
	public List<Teacher> findAll();
	
}
