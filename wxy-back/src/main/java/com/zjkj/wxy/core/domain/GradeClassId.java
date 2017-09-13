package com.zjkj.wxy.core.domain;

/**
 * GradeClassId entity. @author MyEclipse Persistence Tools
 */

public class GradeClassId implements java.io.Serializable {

	// Fields

	private Grade grade;
	private Classes classes;
	private Teacher teacher;

	// Constructors

	/** default constructor */
	public GradeClassId() {
	}

	/** full constructor */
	public GradeClassId(Grade grade, Classes classes, Teacher teacher) {
		this.grade = grade;
		this.classes = classes;
		this.teacher = teacher;
	}

	// Property accessors

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GradeClassId))
			return false;
		GradeClassId castOther = (GradeClassId) other;

		return ((this.getGrade() == castOther.getGrade()) || (this.getGrade() != null
				&& castOther.getGrade() != null && this.getGrade().equals(
				castOther.getGrade())))
				&& ((this.getClasses() == castOther.getClasses()) || (this
						.getClasses() != null && castOther.getClasses() != null && this
						.getClasses().equals(castOther.getClasses())))
				&& ((this.getTeacher() == castOther.getTeacher()) || (this
						.getTeacher() != null && castOther.getTeacher() != null && this
						.getTeacher().equals(castOther.getTeacher())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGrade() == null ? 0 : this.getGrade().hashCode());
		result = 37 * result
				+ (getClasses() == null ? 0 : this.getClasses().hashCode());
		result = 37 * result
				+ (getTeacher() == null ? 0 : this.getTeacher().hashCode());
		return result;
	}

}