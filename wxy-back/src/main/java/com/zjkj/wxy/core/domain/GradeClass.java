package com.zjkj.wxy.core.domain;

/**
 * GradeClass entity. @author MyEclipse Persistence Tools
 */

public class GradeClass implements java.io.Serializable {

	// Fields

	private GradeClassId id;
	private Classes classes;
	private Teacher teacher;
	private Grade grade;

	// Constructors

	/** default constructor */
	public GradeClass() {
	}

	/** minimal constructor */
	public GradeClass(GradeClassId id) {
		this.id = id;
	}

	/** full constructor */
	public GradeClass(GradeClassId id, Classes classes, Teacher teacher,
			Grade grade) {
		this.id = id;
		this.classes = classes;
		this.teacher = teacher;
		this.grade = grade;
	}

	// Property accessors

	public GradeClassId getId() {
		return this.id;
	}

	public void setId(GradeClassId id) {
		this.id = id;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}