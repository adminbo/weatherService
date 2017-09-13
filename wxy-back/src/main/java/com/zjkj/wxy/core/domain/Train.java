package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Train entity. @author MyEclipse Persistence Tools
 */

public class Train implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private String title;
	private Long time;
	private Integer score;
	private String content;
	private Integer ispush;
	private Integer isshow;
	private Integer techid;
	private Set teachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Train() {
	}

	/** minimal constructor */
	public Train(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Train(Integer id, School school, String title, Long time,
			Integer score, String content, Integer ispush,
			Integer isshow, Integer techid, Set teachers) {
		this.id = id;
		this.school = school;
		this.title = title;
		this.time = time;
		this.score = score;
		this.content = content;
		this.ispush = ispush;
		this.isshow = isshow;
		this.techid = techid;
		this.teachers = teachers;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIspush() {
		return this.ispush;
	}

	public void setIspush(Integer ispush) {
		this.ispush = ispush;
	}

	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Integer getTechid() {
		return this.techid;
	}

	public void setTechid(Integer techid) {
		this.techid = techid;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}