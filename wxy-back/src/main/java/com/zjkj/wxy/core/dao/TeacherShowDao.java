package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.User;

public interface TeacherShowDao extends IBaseDao<Teacher> {
/**
 * 根据学校id查询
 * @param id
 * @return
 */
	List<Teacher> findBySid(Integer id);
/**
 * 根据id查询，控制器返回json，不能用get
 * @param id
 * @return
 */
Teacher findByIdForJson(Integer id);

	
	
}
