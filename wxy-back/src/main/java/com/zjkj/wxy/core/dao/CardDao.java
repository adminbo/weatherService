package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Card;
import com.zjkj.wxy.core.domain.CardApply;

public interface CardDao extends IBaseDao<Card>{
/**
 * 根据学校id查询卡片系
 * @param sid
 * @return
 */
	List<Card> listBySid(Integer sid);
/**
 * 根据id查询退卡申请
 * @param aid
 * @return
 */
CardApply getBackById(String aid);
/**
 * 查询申请补卡信息
 * @param aid
 * @return
 */
CardApply getFillById(String aid);
/**
 * 根据申请人差所有卡
 * @param applyer
 * @return
 */
List<Card> getByApplyer(String applyer);
/**
 * 更新
 * @param olds
 * @param news
 */
void updateCards(List<String> olds, List<String> news);
/**
 * 批量添加
 * @param cs
 */
void addByBatch(List<Card> cs);
/**
 * 批量删除
 * @param news
 */
void deleteByBatch(List<String> news);

}
