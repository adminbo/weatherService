package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Parents entity. @author MyEclipse Persistence Tools
 */

public class Parents implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String phonenum;
	private String relation;
	private Integer isfllow;
	private String wechat;
	private Long cretime;
	private Long edtime;
	private Integer sex;
	private String homeaddr;
	private Set stuPars = new HashSet(0);

	// Constructors

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/** default constructor */
	public Parents() {
	}

	/** minimal constructor */
	public Parents(Integer id) {
		this.id = id;
	}


	// Property accessors

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	
	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsfllow() {
		return isfllow;
	}

	public void setIsfllow(Integer isfllow) {
		this.isfllow = isfllow;
	}



	public Long getCretime() {
		return cretime;
	}

	public void setCretime(Long cretime) {
		this.cretime = cretime;
	}

	public Long getEdtime() {
		return edtime;
	}

	public void setEdtime(Long edtime) {
		this.edtime = edtime;
	}

	public String getHomeaddr() {
		return this.homeaddr;
	}

	public void setHomeaddr(String homeaddr) {
		this.homeaddr = homeaddr;
	}

	public Set getStuPars() {
		return this.stuPars;
	}

	public void setStuPars(Set stuPars) {
		this.stuPars = stuPars;
	}

}