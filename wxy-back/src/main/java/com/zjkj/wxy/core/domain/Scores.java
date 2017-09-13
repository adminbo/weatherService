package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Scores entity. @author MyEclipse Persistence Tools
 */

public class Scores implements java.io.Serializable {

	// Fields

	private Integer id;
	private String gname;
	private String cname;
	private String sname;
	private Long testtime;
	private Integer joinnum;
	private Set scoreDetials = new HashSet(0);

	// Constructors

	/** default constructor */
	public Scores() {
	}

	/** minimal constructor */
	public Scores(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Scores(Integer id, String gname, String cname, String sname,
			Long testtime, Integer joinnum, Set scoreDetials) {
		this.id = id;
		this.gname = gname;
		this.cname = cname;
		this.sname = sname;
		this.testtime = testtime;
		this.joinnum = joinnum;
		this.scoreDetials = scoreDetials;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Long getTesttime() {
		return this.testtime;
	}

	public void setTesttime(Long testtime) {
		this.testtime = testtime;
	}

	public Integer getJoinnum() {
		return this.joinnum;
	}

	public void setJoinnum(Integer joinnum) {
		this.joinnum = joinnum;
	}

	public Set getScoreDetials() {
		return this.scoreDetials;
	}

	public void setScoreDetials(Set scoreDetials) {
		this.scoreDetials = scoreDetials;
	}

}