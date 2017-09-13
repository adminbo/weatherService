package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ImgDetail entity. @author MyEclipse Persistence Tools
 */

public class ImgDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private Integer type;
	private Integer imgid;
	private Set imgs = new HashSet(0);

	// Constructors

	/** default constructor */
	public ImgDetail() {
	}

	/** minimal constructor */
	public ImgDetail(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ImgDetail(Integer id, School school, Integer type,
			Integer imgid, Set imgs) {
		this.id = id;
		this.school = school;
		this.type = type;
		this.imgid = imgid;
		this.imgs = imgs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getImgid() {
		return this.imgid;
	}

	public void setImgid(Integer imgid) {
		this.imgid = imgid;
	}

	public Set getImgs() {
		return this.imgs;
	}

	public void setImgs(Set imgs) {
		this.imgs = imgs;
	}

}