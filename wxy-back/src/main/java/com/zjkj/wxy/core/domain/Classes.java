package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set gradeClasses = new HashSet(0);
	private List<Student> students;

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Classes(Integer id, String name, Set gradeClasses) {
		this.id = id;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", gradeClasses=" + gradeClasses + ", students=" + students
				+ "]";
	}

	

}