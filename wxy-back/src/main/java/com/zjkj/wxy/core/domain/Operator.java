package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Operator entity. @author MyEclipse Persistence Tools
 */

public class Operator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String phonenum;
	private Integer type;
	private String dep;
	private String position;
	private String email;
	private String frontidurl;
	private String backidurl;
	private String telnum;
	private String cardnum;
	private Integer operatorid;
	private String wechat;

	// Constructors

	/** default constructor */
	public Operator() {
	}

	/** minimal constructor */
	public Operator(Integer id) {
		this.id = id;
	}

	public Integer getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}

	/** full constructor */
	public Operator(Integer id, String name, String wechat, String phonenum,
			Integer type, String dep, String position, String email,
			String frontidurl, String backidurl, String telnum, String cardnum) {
		this.id = id;
		this.name = name;
		this.wechat = wechat;
		this.phonenum = phonenum;
		this.type = type;
		this.dep = dep;
		this.position = position;
		this.email = email;
		this.frontidurl = frontidurl;
		this.backidurl = backidurl;
		this.telnum = telnum;
		this.cardnum = cardnum;
	}

	// Property accessors



	public String getName() {
		return this.name;
	}




	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDep() {
		return this.dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFrontidurl() {
		return this.frontidurl;
	}

	public void setFrontidurl(String frontidurl) {
		this.frontidurl = frontidurl;
	}

	public String getBackidurl() {
		return this.backidurl;
	}

	public void setBackidurl(String backidurl) {
		this.backidurl = backidurl;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}