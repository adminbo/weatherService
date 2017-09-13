package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private String name;
	private Integer levelstate;
	private Integer parentid;
	private Integer istea;
	private Integer ispar;
	private Integer edittime;
	private Integer synchrostate;
	private Integer type;
	private Integer oto;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Menu(Integer id, School school, String name, Integer levelstate,
			Integer parentid, Integer istea, Integer ispar,
			Integer edittime, Integer synchrostate,Integer type,Integer oto) {
		this.id = id;
		this.school = school;
		this.name = name;
		this.levelstate = levelstate;
		this.parentid = parentid;
		this.istea = istea;
		this.ispar = ispar;
		this.edittime = edittime;
		this.synchrostate = synchrostate;
		this.type = type;
		this.oto = oto;
	}

	// Property accessors

	

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	public Integer getId() {
		return id;
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

	

	public Integer getLevelstate() {
		return levelstate;
	}

	public void setLevelstate(Integer levelstate) {
		this.levelstate = levelstate;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getIstea() {
		return istea;
	}

	public void setIstea(Integer istea) {
		this.istea = istea;
	}

	public Integer getIspar() {
		return ispar;
	}

	public void setIspar(Integer ispar) {
		this.ispar = ispar;
	}

	public Integer getEdittime() {
		return edittime;
	}

	public void setEdittime(Integer edittime) {
		this.edittime = edittime;
	}

	public Integer getSynchrostate() {
		return synchrostate;
	}

	public void setSynchrostate(Integer synchrostate) {
		this.synchrostate = synchrostate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOto() {
		return oto;
	}

	public void setOto(Integer oto) {
		this.oto = oto;
	}

	
}