package com.zjkj.wxy.core.domain;

/**
 * SubGrade entity. @author MyEclipse Persistence Tools
 */

public class SubGrade implements java.io.Serializable {

	// Fields

	private SubGradeId id;
	private Grade grade;
	private Subject subject;

	// Constructors

	/** default constructor */
	public SubGrade() {
	}

	/** minimal constructor */
	public SubGrade(SubGradeId id) {
		this.id = id;
	}

	/** full constructor */
	public SubGrade(SubGradeId id, Grade grade, Subject subject) {
		this.id = id;
		this.grade = grade;
		this.subject = subject;
	}

	// Property accessors

	public SubGradeId getId() {
		return this.id;
	}

	public void setId(SubGradeId id) {
		this.id = id;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}