package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Subject;

public interface SubjectDao extends IBaseDao<Subject> {

	//所有学科
	public List<Subject> getSubject(Grade grade);
/**
 * 根据名称查询
 * @param sub
 * @return
 */
	public Subject findByName(String sub);
}
