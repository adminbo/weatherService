package com.zjkj.wxy.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.TakeAndSend;

public interface JiazhangXTService {

	public List<TakeAndSend> findByCriteria(DetachedCriteria criteria);
}
