package com.zjkj.wxy.core.service;

import com.zjkj.wxy.core.domain.Equipment;
import com.zjkj.wxy.core.utils.PageBean;

public interface AccessService {
/**
 * 条件分页查询
 * @param pageBean
 */
	void pageQuery(PageBean pageBean);
/**
 * 添加设备
 * @param equipment
 */
void add(Equipment equipment);
/**
 * 根据id删除设备
 * @param id
 */
void delById(String id);

}
