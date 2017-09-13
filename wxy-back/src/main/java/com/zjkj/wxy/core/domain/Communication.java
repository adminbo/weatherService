package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Communication entity. @author MyEclipse Persistence Tools
 */

public class Communication implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Long time;
	private String stuname;
	private String edunum;
	private String parname;
	private String parphnum;
	private Integer commtype;
	private String commcont;

	// Constructors

	/** default constructor */
	public Communication() {
	}

	/** minimal constructor */
	public Communication(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Communication(Integer id, User user, Long time,
			String stuname, String edunum, String parname, String parphnum,
			Integer commtype, String commcont) {
		this.id = id;
		this.user = user;
		this.time = time;
		this.stuname = stuname;
		this.edunum = edunum;
		this.parname = parname;
		this.parphnum = parphnum;
		this.commtype = commtype;
		this.commcont = commcont;
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

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getEdunum() {
		return this.edunum;
	}

	public void setEdunum(String edunum) {
		this.edunum = edunum;
	}

	public String getParname() {
		return this.parname;
	}

	public void setParname(String parname) {
		this.parname = parname;
	}

	public String getParphnum() {
		return this.parphnum;
	}

	public void setParphnum(String parphnum) {
		this.parphnum = parphnum;
	}

	public Integer getCommtype() {
		return this.commtype;
	}

	public void setCommtype(Integer commtype) {
		this.commtype = commtype;
	}

	public String getCommcont() {
		return this.commcont;
	}

	public void setCommcont(String commcont) {
		this.commcont = commcont;
	}

}