package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.CardApply;

public interface CardApplyService {
/***
 * 根据申请id查询
 * @param sid
 * @return
 */
	CardApply getCardApplyById(String sid);
/**
 * 处理更新处理状态
 * @param ca
 */
void update(CardApply ca);
/**
 * 批量导入申请信息
 * @param list
 */
void addBatch(List<CardApply> list);

}
