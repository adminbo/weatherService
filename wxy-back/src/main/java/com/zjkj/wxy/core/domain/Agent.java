package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 代理商
 * Agent entity. @author MyEclipse Persistence Tools
 */

public class Agent implements java.io.Serializable {

	// Fields

	private Integer id;
	private Set schools = new HashSet(0);
	private String name;
	private Integer levels;
	private Integer schooid;

	// Constructors

	/** default constructor */
	public Agent() {
	}

	/** minimal constructor */
	public Agent(Integer id, Set schools) {
		this.id = id;
		this.schools = schools;
	}

	/** full constructor */
	public Agent(Integer id, Set schools, String name, Integer level,
			Integer schooid) {
		this.id = id;
		this.schools = schools;
		this.name = name;
		this.levels = levels;
		this.schooid = schooid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	

	public Set getSchools() {
		return schools;
	}

	public void setSchools(Set schools) {
		this.schools = schools;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevels() {
		return this.levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public Integer getSchooid() {
		return this.schooid;
	}

	public void setSchooid(Integer schooid) {
		this.schooid = schooid;
	}

}