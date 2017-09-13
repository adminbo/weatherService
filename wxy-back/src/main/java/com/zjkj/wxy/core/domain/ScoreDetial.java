package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * ScoreDetial entity. @author MyEclipse Persistence Tools
 */

public class ScoreDetial implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private Scores scores;
	private Double score;
	private String subjectname;

	// Constructors

	/** default constructor */
	public ScoreDetial() {
	}

	/** minimal constructor */
	public ScoreDetial(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ScoreDetial(Integer id, Student student, Scores scores,
			Double score, String subjectname) {
		this.id = id;
		this.student = student;
		this.scores = scores;
		this.score = score;
		this.subjectname = subjectname;
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

	public Scores getScores() {
		return this.scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getSubjectname() {
		return this.subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

}