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
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDtialDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service("szchoolEnvireService")
@Transactional
public class SchoolEnvireServiceImpl implements SchoolEnvireService {

	
	@Resource
	private SchoolEnvireDao schoolEnvireDao;
	@Resource
	private SchoolEnvireDtialDao schoolEnvireDtialDao;

	

	public SchoolEnvireDao getSchoolEnvireDao() {
		return schoolEnvireDao;
	}

	public void setSchoolEnvireDao(SchoolEnvireDao schoolEnvireDao) {
		this.schoolEnvireDao = schoolEnvireDao;
	}

	@Override
	public List<Img> findAll() {
		// TODO Auto-generated method stub
		return schoolEnvireDao.findAll();
	}

	

	@Override
	public void save(Img school) {
		// TODO Auto-generated method stub
		schoolEnvireDao.save(school);
	}

	@Override
	public void delete(Img school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Img school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Img> findOfSchool(Integer sid) {
		// TODO Auto-generated method stub
		
		return schoolEnvireDao.getAllBySid(sid);
	}

	@Override
	public void save(ImgDetail imgDetail, Img img) {
		// TODO Auto-generated method stub
		schoolEnvireDao.save(img);
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
		Img img = schoolEnvireDao.findById(id);
		schoolEnvireDao.delete(img);
		DetachedCriteria criteria =DetachedCriteria.forClass(ImgDetail.class);
		criteria.add(Restrictions.eq("imgid", id));
		List<ImgDetail> findByCriteria = schoolEnvireDtialDao.findByCriteria(criteria );
		ImgDetail detail = schoolEnvireDtialDao.findById(findByCriteria.get(0).getId());
		schoolEnvireDtialDao.delete(detail);
	}

	@Override
	public void updateToShow(Integer id) {
		// TODO Auto-generated method stub
		Img findById = schoolEnvireDao.findById(id);
		findById.setIsdown(0);
	}

	@Override
	public void updateToNoShow(Integer id) {
		// TODO Auto-generated method stub
		Img findById = schoolEnvireDao.findById(id);
		findById.setIsdown(1);
	}

	
	
}
