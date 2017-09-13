package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Gratea entity. @author MyEclipse Persistence Tools
 */

public class Gratea implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mark;
	private Integer grade;//年级
	private Integer clazz;//班级
	private Integer subject;//课程
	private Integer teacher;//任课老师
	private Integer agteacher;//代课教师
	private Integer schoolId;
	// Constructors

	/** default constructor */
	public Gratea() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getClazz() {
		return clazz;
	}

	public void setClazz(Integer clazz) {
		this.clazz = clazz;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public Integer getTeacher() {
		return teacher;
	}

	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}

	public Integer getAgteacher() {
		return agteacher;
	}

	public void setAgteacher(Integer agteacher) {
		this.agteacher = agteacher;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	
}