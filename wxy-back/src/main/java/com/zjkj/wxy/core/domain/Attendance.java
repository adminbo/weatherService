package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * 
 * Attendance entity. @author MyEclipse Persistence Tools
 */

public class Attendance implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private String grade;
	private String class_;
	private Long mouth;
	private String stuname;
	private Integer type;
	private Long date;

	// Constructors

	/** default constructor */
	public Attendance() {
	}

	/** minimal constructor */
	public Attendance(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Attendance(Integer id, Student student, String grade,
			String class_, Long mouth, String stuname, Integer type,
			Long date) {
		this.id = id;
		this.student = student;
		this.grade = grade;
		this.class_ = class_;
		this.mouth = mouth;
		this.stuname = stuname;
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

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Long getMouth() {
		return this.mouth;
	}

	public void setMouth(Long mouth) {
		this.mouth = mouth;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
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