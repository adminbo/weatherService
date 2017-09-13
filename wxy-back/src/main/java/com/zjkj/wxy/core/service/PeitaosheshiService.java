package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.utils.PageBean;

public interface PeitaosheshiService {

	public List<Img> findAll(Integer id);
	
	public void pageQuery(PageBean pageBean);
	/**
	 * 添加配套设施，上传图片的啦
	 * @param imgDetail
	 * @param img
	 */
	public void save(ImgDetail imgDetail, Img img);
	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteById(Integer id);
	/**
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
