package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.CardApplyDao;
import com.zjkj.wxy.core.domain.CardApply;
import com.zjkj.wxy.core.service.CardApplyService;
@Service
@Transactional
public class CardApplyServiceImpl implements CardApplyService{
@Resource
private CardApplyDao cardApplyDao;

	@Override
	public CardApply getCardApplyById(String sid) {
		// TODO Auto-generated method stub
		return cardApplyDao.findById(sid);
	}
	
	@Override
	public void update(CardApply ca) {
		// TODO Auto-generated method stub
		cardApplyDao.update(ca);
	}

	@Override
	public void addBatch(List<CardApply> list) {
		// TODO Auto-generated method stub
		for (CardApply cardApply : list) {
			cardApplyDao.save(cardApply);
		}
	}
}
