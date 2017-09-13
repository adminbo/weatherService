package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.utils.PageBean;

public interface SchoolEnvireService {

	public List<Img> findAll();
	
	public void pageQuery(PageBean pageBean);
	
	
	/**
	 * 添加
	 */
	public void save(Img school);
	
	/**
	 * 删除
	 */
	public void delete(Img school);
	/**
	 * 修改
	 */
	public void update(Img school);
/**
 * 查询该校校园环境
 * @param sid
 * @return
 */
	public List<Img> findOfSchool(Integer sid);
/**
 * 添加校园环境和详情
 * @param imgDetail
 * @param img
 */
public void save(ImgDetail imgDetail, Img img);

public void deleteById(Integer id);
/***
 * 上架图片
 * @param id
 */
public void updateToShow(Integer id);
/**
 * 下架图片
 * @param id
 */
public void updateToNoShow(Integer id);
}
