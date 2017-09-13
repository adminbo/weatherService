package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Grade> grades;
	//private Integer sid;
	//private BigDecimal gradeid;

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Subject(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getGrades() {
		return grades;
	}

	public void setGrades(Set grades) {
		this.grades = grades;
	}

	



//	public Integer getSid() {
//		return sid;
//	}
//
//	public void setSid(Integer sid) {
//		this.sid = sid;
//	}

//	public BigDecimal getGradeid() {
//		return gradeid;
//	}
//
//	public void setGradeid(BigDecimal gradeid) {
//		this.gradeid = gradeid;
//	}
//	
	

}