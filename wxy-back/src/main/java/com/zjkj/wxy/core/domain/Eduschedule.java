package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Eduschedule entity. @author MyEclipse Persistence Tools
 */

public class Eduschedule implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private String grade;
	private String subject;
	private Long mouth;
	private String content;
	private Integer periods;
	private Integer isshow;

	// Constructors

	/** default constructor */
	public Eduschedule() {
	}

	/** minimal constructor */
	public Eduschedule(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Eduschedule(Integer id, School school, String grade,
			String subject, Long mouth, String content,
			Integer periods, Integer isshow) {
		this.id = id;
		this.school = school;
		this.grade = grade;
		this.subject = subject;
		this.mouth = mouth;
		this.content = content;
		this.periods = periods;
		this.isshow = isshow;
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

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getMouth() {
		return this.mouth;
	}

	public void setMouth(Long mouth) {
		this.mouth = mouth;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPeriods() {
		return this.periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

}