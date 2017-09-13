package com.zjkj.wxy.core.domain;

/**
 * StuPar entity. @author MyEclipse Persistence Tools
 */

public class StuPar implements java.io.Serializable {

	// Fields

	private StuParId id;
	private Parents parents;
	private Student student;

	// Constructors

	/** default constructor */
	public StuPar() {
	}

	/** minimal constructor */
	public StuPar(StuParId id) {
		this.id = id;
	}

	/** full constructor */
	public StuPar(StuParId id, Parents parents, Student student) {
		this.id = id;
		this.parents = parents;
		this.student = student;
	}

	// Property accessors

	public StuParId getId() {
		return this.id;
	}

	public void setId(StuParId id) {
		this.id = id;
	}

	public Parents getParents() {
		return this.parents;
	}

	public void setParents(Parents parents) {
		this.parents = parents;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}