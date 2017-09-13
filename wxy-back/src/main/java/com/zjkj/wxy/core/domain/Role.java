package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer pId;
	private Role parRole;
	private Integer sid;

	private String open="true";
	private Set authoritys = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}



	public Role getParRole() {
		return parRole;
	}

	public void setParRole(Role parRole) {
		this.parRole = parRole;
	}

	
	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/** minimal constructor */
	public Role(Integer id) {
		this.id = id;
	}

	/** full constructor */


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

	

	public Set getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(Set authoritys) {
		this.authoritys = authoritys;
	}

	public Set getUsers() {
		return users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}



}