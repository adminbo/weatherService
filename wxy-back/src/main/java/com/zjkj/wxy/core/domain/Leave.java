package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Leave entity. @author MyEclipse Persistence Tools
 */

public class Leave implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private String leavepeo;
	private String leavereason;
	private Long starttime;
	private Long leavetime;
	private String approval;
	private Integer isdestroy;
	private Long destime;

	// Constructors

	/** default constructor */
	public Leave() {
	}

	/** minimal constructor */
	public Leave(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Leave(Integer id, Student student, String leavepeo,
			String leavereason, Long starttime, Long leavetime,
			String approval, Integer isdestroy, Long destime) {
		this.id = id;
		this.student = student;
		this.leavepeo = leavepeo;
		this.leavereason = leavereason;
		this.starttime = starttime;
		this.leavetime = leavetime;
		this.approval = approval;
		this.isdestroy = isdestroy;
		this.destime = destime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getLeavepeo() {
		return this.leavepeo;
	}

	public void setLeavepeo(String leavepeo) {
		this.leavepeo = leavepeo;
	}

	public String getLeavereason() {
		return this.leavereason;
	}

	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}

	public Long getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Long starttime) {
		this.starttime = starttime;
	}

	public Long getLeavetime() {
		return this.leavetime;
	}

	public void setLeavetime(Long leavetime) {
		this.leavetime = leavetime;
	}

	public String getApproval() {
		return this.approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public Integer getIsdestroy() {
		return this.isdestroy;
	}

	public void setIsdestroy(Integer isdestroy) {
		this.isdestroy = isdestroy;
	}

	public Long getDestime() {
		return this.destime;
	}

	public void setDestime(Long destime) {
		this.destime = destime;
	}

}