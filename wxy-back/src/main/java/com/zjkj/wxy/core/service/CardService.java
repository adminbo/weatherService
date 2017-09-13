package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Card;
import com.zjkj.wxy.core.domain.CardApply;
import com.zjkj.wxy.core.utils.PageBean;

public interface CardService {
/**
 * 根据用户所属学校查询该校的卡片
 * @param sid
 * @return 
 */
	List<Card> listBySchoolId(Integer sid);
/**
 * 查询所有卡片
 * @return
 */
List<Card> list();
/**
 * 分页
 * @param pageBean
 */
void pageList(PageBean pageBean);
/**
 * 根据申请类型查询
 * @param pageBean
 */
void listByType(PageBean pageBean);
/**
 * 添加卡
 * @param card
 */
void add(Card card);
/**
 * 根据id删除
 * @param id
 */
void deleteById(String id);
/**
 * 根据id查询退卡
 * @param aid
 * @return
 */
CardApply getBackById(String aid);
/**
 * 处理退卡申请，更改处理状态，删除卡片
 * @param apid
 * @param card1
 * @param card2
 * @param card3
 * @param card4
 */
void backCard(String apid, String card1, String card2, String card3, String card4);
/**
 * 根据申请id查询补卡
 * @param aid
 * @return
 */
CardApply getFillById(String aid);
/**
 * 根据申请人查该人所有的卡片
 * @param applyer
 * @return
 */
List<Card> getByApplyer(String applyer);
/**
 * 更换卡片
 * @param olds
 * @param news
 * @param applyid
 */
void updateApplyState(List<String> olds, List<String> news, String applyid);
/**
 * 批量添加
 * @param cs
 */
void addByBatch(List<Card> cs);
/**
 * 根据id查询卡片
 * @param cid
 * @return
 */
Card findById(String cid);
/**
 * 跟新状态
 * @param card
 */
void update(Card card);
/**
 * 删除
 * @param card
 */
void delete(Card card);
/**
 * 更新卡片和申请
 * @param card
 * @param ca
 */
void updateCardAndApply(Card card, CardApply ca);

}
