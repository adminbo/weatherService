package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Reg entity. @author MyEclipse Persistence Tools
 */

public class Reg implements java.io.Serializable {

	// Fields

	private Integer regid;
	private Wechat wechat;
	private String bslisurl;
	private String orgcode;
	private String authbookurl;
	private String functionintro;
	private String opcountry;
	private String opprovince;
	private String opcity;
	private String accountname;
	private String bank;
	private String accountid;
	private String accountaddr;
	private String wechatpwd;
	private String licensenum;
	private String orgcodeurl;
	private String expsbookurl;
	private Integer peoplenum;

	// Constructors

	/** default constructor */
	public Reg() {
	}

	/** minimal constructor */
	public Reg(Integer regid) {
		this.regid = regid;
	}

	/** full constructor */
	public Reg(Integer regid, Wechat wechat, String bslisurl, String orgcode, String authbookurl, String functionintro,
			String opcountry, String opprovince, String opcity, String accountname, String bank, String accountid,
			String accountaddr, String wechatpwd, String licensenum, String orgcodeurl, String expsbookurl,
			Integer peoplenum) {
		this.regid = regid;
		this.wechat = wechat;
		this.bslisurl = bslisurl;
		this.orgcode = orgcode;
		this.authbookurl = authbookurl;
		this.functionintro = functionintro;
		this.opcountry = opcountry;
		this.opprovince = opprovince;
		this.opcity = opcity;
		this.accountname = accountname;
		this.bank = bank;
		this.accountid = accountid;
		this.accountaddr = accountaddr;
		this.wechatpwd = wechatpwd;
		this.licensenum = licensenum;
		this.orgcodeurl = orgcodeurl;
		this.expsbookurl = expsbookurl;
		this.peoplenum = peoplenum;
	}

	public Integer getRegid() {
		return regid;
	}

	public void setRegid(Integer regid) {
		this.regid = regid;
	}

	public Wechat getWechat() {
		return this.wechat;
	}
	
	public void setWechat(Wechat wechat) {
		this.wechat = wechat;
	}

	public String getBslisurl() {
		return this.bslisurl;
	}

	public void setBslisurl(String bslisurl) {
		this.bslisurl = bslisurl;
	}

	public String getOrgcode() {
		return this.orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getAuthbookurl() {
		return this.authbookurl;
	}

	public void setAuthbookurl(String authbookurl) {
		this.authbookurl = authbookurl;
	}

	public String getFunctionintro() {
		return this.functionintro;
	}

	public void setFunctionintro(String functionintro) {
		this.functionintro = functionintro;
	}

	public String getOpcountry() {
		return this.opcountry;
	}

	public void setOpcountry(String opcountry) {
		this.opcountry = opcountry;
	}

	public String getOpprovince() {
		return this.opprovince;
	}

	public void setOpprovince(String opprovince) {
		this.opprovince = opprovince;
	}

	public String getOpcity() {
		return this.opcity;
	}

	public void setOpcity(String opcity) {
		this.opcity = opcity;
	}

	public String getAccountname() {
		return this.accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getAccountaddr() {
		return this.accountaddr;
	}

	public void setAccountaddr(String accountaddr) {
		this.accountaddr = accountaddr;
	}

	public String getWechatpwd() {
		return this.wechatpwd;
	}

	public void setWechatpwd(String wechatpwd) {
		this.wechatpwd = wechatpwd;
	}

	public String getLicensenum() {
		return this.licensenum;
	}

	public void setLicensenum(String licensenum) {
		this.licensenum = licensenum;
	}

	public String getOrgcodeurl() {
		return this.orgcodeurl;
	}

	public void setOrgcodeurl(String orgcodeurl) {
		this.orgcodeurl = orgcodeurl;
	}

	public String getExpsbookurl() {
		return this.expsbookurl;
	}

	public void setExpsbookurl(String expsbookurl) {
		this.expsbookurl = expsbookurl;
	}

	public Integer getPeoplenum() {
		return this.peoplenum;
	}

	public void setPeoplenum(Integer peoplenum) {
		this.peoplenum = peoplenum;
	}

}