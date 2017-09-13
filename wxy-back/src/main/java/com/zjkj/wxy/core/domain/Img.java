package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Img entity. @author MyEclipse Persistence Tools
 */

public class Img implements java.io.Serializable {

	// Fields

	private int id;
	private ImgDetail imgDetail;
	private String title;
	private String url;
	private Integer state;
	private Long uptime;
	private Integer sort;
	private Integer isdown;
	private int detailid;

	// Constructors

	/** default constructor */
	public Img() {
	}

	/** minimal constructor */
	public Img(int id, String title, String url, Integer state,
			Long uptime, Integer isdown,int detailid) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.state = state;
		this.uptime = uptime;
		this.isdown = isdown;
		this.detailid = detailid;
	}

	/** full constructor */
	public Img(int id, ImgDetail imgDetail, String title, String url,
			Integer state, Long uptime, Integer sort,
			Integer isdown,int detailid) {
		this.id = id;
		this.imgDetail = imgDetail;
		this.title = title;
		this.url = url;
		this.state = state;
		this.uptime = uptime;
		this.sort = sort;
		this.isdown = isdown;
	}

	// Property accessors

	

	public ImgDetail getImgDetail() {
		return this.imgDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImgDetail(ImgDetail imgDetail) {
		this.imgDetail = imgDetail;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getUptime() {
		return this.uptime;
	}

	public void setUptime(Long uptime) {
		this.uptime = uptime;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsdown() {
		return this.isdown;
	}

	public void setIsdown(Integer isdown) {
		this.isdown = isdown;
	}

	public int getDetailid() {
		return detailid;
	}

	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}

	
}