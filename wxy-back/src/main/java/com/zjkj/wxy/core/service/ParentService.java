package com.zjkj.wxy.core.service;

import com.zjkj.wxy.core.domain.Parents;

public interface ParentService {
/**
 * 保存
 * @param pp
 */
	void save(Parents pp);
/**
 * 根据id查询
 * @param id
 * @return
 */
Parents getById(Integer id);
/**
 * 根据电话查询
 * @param phonenum
 * @return
 */
Parents getByPhone(String phonenum,String name);

}
