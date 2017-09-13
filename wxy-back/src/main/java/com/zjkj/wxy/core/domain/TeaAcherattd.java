package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * TeaAcherattd entity. @author MyEclipse Persistence Tools
 */

public class TeaAcherattd implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private Integer grade;
	private Integer class_;
	private Long mouth;
	private String teachname;
	private Integer type;
	private Long date;

	// Constructors

	/** default constructor */
	public TeaAcherattd() {
	}

	/** minimal constructor */
	public TeaAcherattd(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TeaAcherattd(Integer id, Teacher teacher, Integer grade,
			Integer class_, Long mouth, String teachname,
			Integer type, Long date) {
		this.id = id;
		this.teacher = teacher;
		this.grade = grade;
		this.class_ = class_;
		this.mouth = mouth;
		this.teachname = teachname;
		this.type = type;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getClass_() {
		return this.class_;
	}

	public void setClass_(Integer class_) {
		this.class_ = class_;
	}

	public Long getMouth() {
		return this.mouth;
	}

	public void setMouth(Long mouth) {
		this.mouth = mouth;
	}

	public String getTeachname() {
		return this.teachname;
	}

	public void setTeachname(String teachname) {
		this.teachname = teachname;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getDate() {
		return this.date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

}