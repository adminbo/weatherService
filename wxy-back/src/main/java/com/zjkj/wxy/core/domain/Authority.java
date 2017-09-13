package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable {

	// Fields
	private Authority authority;
	private Integer id;//权限id
	private String name;//权限名称
	private String keyWord; //关键字
	private Integer pId; //父级id
	private Integer isModel;//是否是模块权限 1:yes 0:no
	private Integer lve;//权限等级
	private String open ="true";
	private Set authoritys = new HashSet(0);
	private Set roles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Authority() {
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	/** minimal constructor */
	public Authority(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Authority(Integer id, String keyWord, String name) {
		this.id = id;
		this.name = name;
		this.keyWord = keyWord;


	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}



	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsModel() {
		return isModel;
	}

	public void setIsModel(Integer isModel) {
		this.isModel = isModel;
	}



	public Integer getLve() {
		return lve;
	}

	public void setLve(Integer lve) {
		this.lve = lve;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	

	public Set getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(Set authoritys) {
		this.authoritys = authoritys;
	}

	public Set getRoles() {
		return roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

}