package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Monitor entity. @author MyEclipse Persistence Tools
 */

public class Monitor implements java.io.Serializable {

	// Fields

	private String id;
	private School school;
	private Integer runstate;
	private Long date;
	private Long vediotime;
	private Integer vedioformat;

	// Constructors

	/** default constructor */
	public Monitor() {
	}

	/** minimal constructor */
	public Monitor(String id) {
		this.id = id;
	}

	/** full constructor */
	public Monitor(String id, School school, Integer runstate,
			Long date, Long vediotime, Integer vedioformat) {
		this.id = id;
		this.school = school;
		this.runstate = runstate;
		this.date = date;
		this.vediotime = vediotime;
		this.vedioformat = vedioformat;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getRunstate() {
		return this.runstate;
	}

	public void setRunstate(Integer runstate) {
		this.runstate = runstate;
	}

	public Long getDate() {
		return this.date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getVediotime() {
		return this.vediotime;
	}

	public void setVediotime(Long vediotime) {
		this.vediotime = vediotime;
	}

	public Integer getVedioformat() {
		return this.vedioformat;
	}

	public void setVedioformat(Integer vedioformat) {
		this.vedioformat = vedioformat;
	}

}