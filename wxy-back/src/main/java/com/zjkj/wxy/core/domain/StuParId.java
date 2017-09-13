package com.zjkj.wxy.core.domain;

/**
 * StuParId entity. @author MyEclipse Persistence Tools
 */

public class StuParId implements java.io.Serializable {

	// Fields

	private Student student;
	private Parents parents;

	// Constructors

	/** default constructor */
	public StuParId() {
	}

	/** full constructor */
	public StuParId(Student student, Parents parents) {
		this.student = student;
		this.parents = parents;
	}

	// Property accessors

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Parents getParents() {
		return this.parents;
	}

	public void setParents(Parents parents) {
		this.parents = parents;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StuParId))
			return false;
		StuParId castOther = (StuParId) other;

		return ((this.getStudent() == castOther.getStudent()) || (this
				.getStudent() != null && castOther.getStudent() != null && this
				.getStudent().equals(castOther.getStudent())))
				&& ((this.getParents() == castOther.getParents()) || (this
						.getParents() != null && castOther.getParents() != null && this
						.getParents().equals(castOther.getParents())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudent() == null ? 0 : this.getStudent().hashCode());
		result = 37 * result
				+ (getParents() == null ? 0 : this.getParents().hashCode());
		return result;
	}

}