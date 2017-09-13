package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Recipes entity. @author MyEclipse Persistence Tools
 */

public class Recipes implements java.io.Serializable {

	// Fields

	private int id;
	private School school;
	private String stuyear;
	private Integer term;
	private Integer weaks;
	private Integer day;
	private String mosnack;
	private String lunch;
	private String fruit;
	private String afsnack;

	// Constructors

	/** default constructor */
	public Recipes() {
	}

	/** minimal constructor */
	public Recipes(int id) {
		this.id = id;
	}

	/** full constructor */
	public Recipes(int id, School school, String stuyear,
			Integer term, Integer weaks, Integer day, String mosnack,
			String lunch, String fruit, String afsnack) {
		this.id = id;
		this.school = school;
		this.stuyear = stuyear;
		this.term = term;
		this.weaks = weaks;
		this.day = day;
		this.mosnack = mosnack;
		this.lunch = lunch;
		this.fruit = fruit;
		this.afsnack = afsnack;
	}

	// Property accessors

	

	public School getSchool() {
		return this.school;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getStuyear() {
		return this.stuyear;
	}

	public void setStuyear(String stuyear) {
		this.stuyear = stuyear;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Integer getWeaks() {
		return this.weaks;
	}

	public void setWeaks(Integer weaks) {
		this.weaks = weaks;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getMosnack() {
		return this.mosnack;
	}

	public void setMosnack(String mosnack) {
		this.mosnack = mosnack;
	}

	public String getLunch() {
		return this.lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getFruit() {
		return this.fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public String getAfsnack() {
		return this.afsnack;
	}

	public void setAfsnack(String afsnack) {
		this.afsnack = afsnack;
	}

}