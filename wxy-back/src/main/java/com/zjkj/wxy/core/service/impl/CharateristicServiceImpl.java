package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CharacteristicDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.CharacteristicService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service("characteristicService")
@Transactional
public class CharateristicServiceImpl implements CharacteristicService {

	
	@Resource
	private CharacteristicDao characteristicDao;

	@Override
	public List<Trait> traitsList() {
		// TODO Auto-generated method stub
		return characteristicDao.traitsList();
	}

	@Override
	public void addtrait(Trait trait) {
		// TODO Auto-generated method stub
		characteristicDao.addtrait(trait);
	}

	@Override
	public Trait getTrait(int id) {
		// TODO Auto-generated method stub
		return characteristicDao.findById(id);
	}

	@Override
	public boolean showTeacher(Trait trait) {
		// TODO Auto-generated method stub
		return characteristicDao.showTeacher(trait);
	}

	@Override
	public boolean updateTrait(Trait trait) {
		// TODO Auto-generated method stub
		return characteristicDao.updateTrait(trait);
	}

	@Override
	public boolean deletTrait(int id) {
		// TODO Auto-generated method stub
		return characteristicDao.deletTrait(id);
	}

	public CharacteristicDao getCharacteristicDao() {
		return characteristicDao;
	}

	public void setCharacteristicDao(CharacteristicDao characteristicDao) {
		this.characteristicDao = characteristicDao;
	}

	@Override
	public void pageQuery(PageBean<Trait> pg) {
		// TODO Auto-generated method stub
		 characteristicDao.pageQuery(pg);
	}

	@Override
	public void deletById(Integer id) {
		// TODO Auto-generated method stub
		Trait findById = characteristicDao.findById(id);
		characteristicDao.delete(findById);
	}

	@Override
	public void save(Trait t) {
		// TODO Auto-generated method stub
		characteristicDao.save(t);
	}



	
	 
	
}
