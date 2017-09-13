package com.zjkj.wxy.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.utils.PageBean;

public interface TeachershowService {
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
		/**
		 * 根据学校id查询
		 * @param id
		 * @return
		 */
		public List<Teacher> findBySid(Integer id);
		/**
		 * 查询代理商下的所有学校的所有教师
		 * @param pg 
		 * @param list
		 * @return
		 */
		public List<Teacher> findForAgent(PageBean pg, List<School> list);
		/***
		 * json查询根据id
		 * @param id
		 * @return
		 */
		public Teacher findByIdForJson(Integer id);
		/**
		 * 更新
		 * @param path 头像url
		 * @param tid id
		 * @param name 姓名
		 * @param introduce 简介
		 * @param station 职位
		 */
		public void updateTea(String path, Integer tid, String name, String introduce, String station);
		
}
