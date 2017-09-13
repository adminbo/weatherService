package com.zjkj.wxy.core.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;


public interface GradeService {
	
	public Grade findById(Serializable id);
	 
	 public List<Grade> findByCriteria(DetachedCriteria criteria);
	 //修改年级
	 public void update(Grade grade);
	 //删除年级
	 public void delete(Grade grade);
	 //新增
	 public void save(Grade grade);
/**
 * 根据学校id查询年级
 * @param sid
 */
	public List<Grade> findBySid(Integer sid);
/**
 * 查询某个年级下的班级
 * @param gid
 * @return
 */
public List<Classes> getAllClazz(Integer gid);
/**
 * 通过年级名称,学校id查询
 * @param grade
 * @return
 */
public Grade findByNameAndSid(String grade, Integer id);

}
