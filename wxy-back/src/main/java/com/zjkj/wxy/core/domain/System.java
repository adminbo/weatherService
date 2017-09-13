package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * System entity. @author MyEclipse Persistence Tools
 */

public class System implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String downpath;
	private Integer datestyle;
	private Integer isremind;
	private Integer remstyle;

	// Constructors

	/** default constructor */
	public System() {
	}

	/** minimal constructor */
	public System(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public System(Integer id, User user, String downpath,
			Integer datestyle, Integer isremind, Integer remstyle) {
		this.id = id;
		this.user = user;
		this.downpath = downpath;
		this.datestyle = datestyle;
		this.isremind = isremind;
		this.remstyle = remstyle;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDownpath() {
		return this.downpath;
	}

	public void setDownpath(String downpath) {
		this.downpath = downpath;
	}

	public Integer getDatestyle() {
		return this.datestyle;
	}

	public void setDatestyle(Integer datestyle) {
		this.datestyle = datestyle;
	}

	public Integer getIsremind() {
		return this.isremind;
	}

	public void setIsremind(Integer isremind) {
		this.isremind = isremind;
	}

	public Integer getRemstyle() {
		return this.remstyle;
	}

	public void setRemstyle(Integer remstyle) {
		this.remstyle = remstyle;
	}

}