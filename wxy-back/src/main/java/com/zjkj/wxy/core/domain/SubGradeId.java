package com.zjkj.wxy.core.domain;

/**
 * SubGradeId entity. @author MyEclipse Persistence Tools
 */

public class SubGradeId implements java.io.Serializable {

	// Fields

	private Grade grade;
	private Subject subject;

	// Constructors

	/** default constructor */
	public SubGradeId() {
	}

	/** full constructor */
	public SubGradeId(Grade grade, Subject subject) {
		this.grade = grade;
		this.subject = subject;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubGradeId))
			return false;
		SubGradeId castOther = (SubGradeId) other;

		return ((this.getGrade() == castOther.getGrade()) || (this.getGrade() != null
				&& castOther.getGrade() != null && this.getGrade().equals(
				castOther.getGrade())))
				&& ((this.getSubject() == castOther.getSubject()) || (this
						.getSubject() != null && castOther.getSubject() != null && this
						.getSubject().equals(castOther.getSubject())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGrade() == null ? 0 : this.getGrade().hashCode());
		result = 37 * result
				+ (getSubject() == null ? 0 : this.getSubject().hashCode());
		return result;
	}

}