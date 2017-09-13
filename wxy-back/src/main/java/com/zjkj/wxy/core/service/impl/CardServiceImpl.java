package com.zjkj.wxy.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.CardApplyDao;
import com.zjkj.wxy.core.dao.CardDao;
import com.zjkj.wxy.core.domain.Card;
import com.zjkj.wxy.core.domain.CardApply;
import com.zjkj.wxy.core.service.CardApplyService;
import com.zjkj.wxy.core.service.CardService;
import com.zjkj.wxy.core.utils.PageBean;
/**
 * 卡片管理service
 * @author
 *
 */
@Service
@Transactional
public class CardServiceImpl implements CardService{
	@Resource
	private CardApplyService cardApplyService;
	@Resource
	private CardDao cardDao;
	@Resource
	private CardApplyService CardService;
	@Resource
	private CardApplyDao cardApplyDao;
	@Override
	public List<Card> listBySchoolId(Integer sid) {
		// TODO Auto-generated method stub
		return cardDao.listBySid(sid);
	}

	@Override
	public List<Card> list() {
		// TODO Auto-generated method stub
		return cardDao.findAll();
	}

	@Override
	public void pageList(PageBean pageBean) {
		// TODO Auto-generated method stub
		cardDao.pageQuery(pageBean);
	}

	@Override
	public void listByType(PageBean pageBean) {
		// TODO Auto-generated method stub
		cardDao.pageQuery(pageBean);
	}

	@Override
	public void add(Card card) {
		// TODO Auto-generated method stub
		cardDao.save(card);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		Card findById = cardDao.findById(id);
		findById.setIsshow(0);
	}

	@Override
	public CardApply getBackById(String aid) {
		// TODO Auto-generated method stub
		
		return cardDao.getBackById(aid);
	}

	@Override
	public void backCard(String apid, String card1, String card2, String card3, String card4) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String format = sd.format(d);
		//删除卡片，isshow=0
		if(card1!=null){
			Card c =cardDao.findById(card1);
			if(c!=null){
				c.setIsshow(0);
				c.setIsreturn(1);
				c.setReturntime(format);
			}
		}
		if(card2!=null){
			Card c =cardDao.findById(card2);
			if(c!=null){
				c.setIsshow(0);
				c.setIsreturn(1);
				c.setReturntime(format);
			}
		}
		if(card3!=null){
			Card c =cardDao.findById(card3);
			if(c!=null){
				c.setIsshow(0);
				c.setIsreturn(1);
				c.setReturntime(format);
			}
		}
		if(card4!=null){
			Card c =cardDao.findById(card4);
			if(c!=null){
				c.setIsshow(0);
				c.setIsreturn(1);
				c.setReturntime(format);
			}
		}
		
		CardApply backById = cardDao.getBackById(apid);
		backById.setIsdeal(1);//更改处理状态，已处理		
	}

	@Override
	public CardApply getFillById(String aid) {
		// TODO Auto-generated method stub
		
		return cardDao.getFillById(aid);
	}

	@Override
	public List<Card> getByApplyer(String applyer) {
		// TODO Auto-generated method stub
		return cardDao.getByApplyer(applyer);
	}

	@Override
	public void updateApplyState(List<String> olds, List<String> news, String applyid) {
		// TODO Auto-generated method stub
		CardApply fillById = cardDao.getFillById(applyid);
		fillById.setIsdeal(1);
//		for(int i=1;i<=olds.size();i++){
//			Card findById = cardDao.findById(olds.get(i-1));
//			findById.setId(news.get(i-1));
//		}
		cardDao.updateCards(olds, news);
		
	}

	@Override
	public void addByBatch(List<Card> cs) {
		// TODO Auto-generated method stub
		cardDao.addByBatch(cs);
	}

	@Override
	public Card findById(String cid) {
		// TODO Auto-generated method stub
		return cardDao.findById(cid);
	}

	@Override
	public void update(Card card) {
		// TODO Auto-generated method stub
		cardDao.update(card);
	}

	@Override
	public void delete(Card card) {
		// TODO Auto-generated method stub
		cardDao.delete(card);
	}

	@Override
	public void updateCardAndApply(Card card, CardApply ca) {
		// TODO Auto-generated method stub
		cardDao.update(card);
		ca.setIsdeal(1);
		cardApplyDao.update(ca);
	}


}
