package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private Integer grade;
	private Integer class_;
	private Integer weaks;
	private Integer day;
	private Integer section;
	private String stuyear;
	private Integer term;
	private String subject;
	private String teacher;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Course(Integer id, School school, Integer grade,
			Integer class_, Integer weaks, Integer day,
			Integer section, String stuyear, Integer term,
			String subject, String teacher) {
		this.id = id;
		this.school = school;
		this.grade = grade;
		this.class_ = class_;
		this.weaks = weaks;
		this.day = day;
		this.section = section;
		this.stuyear = stuyear;
		this.term = term;
		this.subject = subject;
		this.teacher = teacher;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
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

	public Integer getWeaks() {
		return this.weaks;
	}

	public void setWeaks(Integer weaks) {
		this.weaks = weaks;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getSection() {
		return this.section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public String getStuyear() {
		return this.stuyear;
	}

	public void setStuyear(String stuyear) {
		this.stuyear = stuyear;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}