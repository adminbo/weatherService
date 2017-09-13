package com.zjkj.wxy.core.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.PeitaosheshiDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDtialDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.PeitaosheshiService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service("peitaosheshiService")
@Transactional
public class PeitaosheshiServiceImpl implements PeitaosheshiService {
	
	@Resource
	private PeitaosheshiDao peitaosheshiDao;
	@Resource
	private SchoolEnvireDtialDao schoolEnvireDtialDao;
	public PeitaosheshiDao getPeitaosheshiDao() {
		return peitaosheshiDao;
	}

	public void setPeitaosheshiDao(PeitaosheshiDao peitaosheshiDao) {
		this.peitaosheshiDao = peitaosheshiDao;
	}

	@Override
	public List<Img> findAll(Integer id) {
		// TODO Auto-generated method stub
		return peitaosheshiDao.findAllByType(id);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(ImgDetail imgDetail, Img img) {
		// TODO Auto-generated method stub
		peitaosheshiDao.save(img);
		Set<Img> set=new HashSet<>();
		set.add(img);
		imgDetail.setImgs(set);
		img.setImgDetail(imgDetail);
		imgDetail.setImgid(img.getId());
		schoolEnvireDtialDao.save(imgDetail);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Img img = peitaosheshiDao.findById(id);
		peitaosheshiDao.delete(img);
		DetachedCriteria criteria =DetachedCriteria.forClass(ImgDetail.class);
		criteria.add(Restrictions.eq("imgid", id));
		List<ImgDetail> findByCriteria = schoolEnvireDtialDao.findByCriteria(criteria );
		ImgDetail detail = schoolEnvireDtialDao.findById(findByCriteria.get(0).getId());
		schoolEnvireDtialDao.delete(detail);
	}

	@Override
	public void updateToShow(Integer id) {
		// TODO Auto-generated method stub
		Img findById = peitaosheshiDao.findById(id);
		findById.setIsdown(0);
	}

	@Override
	public void updateToNoShow(Integer id) {
		// TODO Auto-generated method stub
		Img findById = peitaosheshiDao.findById(id);
		findById.setIsdown(1);
	}

	
	
	
	
}
