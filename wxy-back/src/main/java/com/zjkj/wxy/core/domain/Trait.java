package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Trait entity. @author MyEclipse Persistence Tools
 */

public class Trait implements java.io.Serializable {

	// Fields

	private int id;
	private School school;
	private String title;
	private String introduce;
	private String publishtime;
	private String imgurl;

	// Constructors

	/** default constructor */
	public Trait() {
	}

	/** minimal constructor */
	

	/** full constructor */
	public Trait(int id, School school, String title, String introduce,
			String publishtime, String imgurl) {
		this.id = id;
		this.school = school;
		this.title = title;
		this.introduce = introduce;
		this.publishtime = publishtime;
		this.imgurl = imgurl;
	}

	// Property accessors

	

	public School getSchool() {
		return this.school;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

}