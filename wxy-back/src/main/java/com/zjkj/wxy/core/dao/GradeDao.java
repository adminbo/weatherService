package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;

public interface GradeDao extends IBaseDao<Grade> {
/**
 * 根据学校id查询学校所有年级
 * @param sid
 * @return
 */
	List<Grade> findBySid(Integer sid);
/**
 * 查询某个年级下的所有班级3
 * @param gid
 * @return
 */
List<Classes> getAllClazz(Integer gid);
/**
 * 通过学校id和年级名称查询年级
 * @param grade
 * @param id
 * @return
 */
Grade findByGnameAndSid(String grade, Integer id);
	
	

}
