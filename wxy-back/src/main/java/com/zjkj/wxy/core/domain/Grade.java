package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private List<Classes> classes;
	private String name;
	private Set gradeClasses = new HashSet(0);
	private Set subjects;

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Grade(Integer id, School school, String name, Set gradeClasses) {
		this.id = id;
		this.school = school;
		this.name = name;
		this.gradeClasses = gradeClasses;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getGradeClasses() {
		return this.gradeClasses;
	}

	public void setGradeClasses(Set gradeClasses) {
		this.gradeClasses = gradeClasses;
	}


	public List getClasses() {
		return classes;
	}

	public void setClasses(List classes) {
		this.classes = classes;
	}

	public Set getSubjects() {
		return subjects;
	}

	public void setSubjects(Set subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", school=" + school + ", classes=" + classes + ", name=" + name + ", gradeClasses="
				+ gradeClasses + ", subjects=" + subjects + "]";
	}



	



}