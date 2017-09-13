package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Authentication entity. @author MyEclipse Persistence Tools
 */

public class Authentication implements java.io.Serializable {

	// Fields

	private Integer authid;
	private Wechat wechat;
	private Long authtime;
	private Integer type;
	private String orgname;
	private String orgaddr;
	private String orgdns;
	private String orgweb;
	private String orgintro;
	private String orgrep;
	private String orgphonenum;
	private Integer orgpeoplenum;
	private String orgcode;
	private String businessnum;
	private String busiscope;
	private String perscope;
	private String mediacompany;
	private Integer mediatype;
	private String medianame;
	private String medialicense;
	private String accountname;
	private String bank;
	private String accountid;
	private String accountaddr;
	private String orgcodeurl;
	private String ufctificurl;
	private String regcertificurl;
	private String repcertificurl;
	private String permitlicenseurl;
	private String appliletterurl;
	private String staffurl;
	private String branchstaffurl;
	private String partnerurl;
	private Long endtime;
	private String otherurl;
	private Integer id;

	// Constructors

	/** default constructor */
	public Authentication() {
	}

	/** minimal constructor */
	public Authentication(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Authentication(Integer authid, Wechat wechat, Long authtime, Integer type, String orgname,
			String orgaddr, String orgdns, String orgweb, String orgintro, String orgrep, String orgphonenum,
			Integer orgpeoplenum, String orgcode, String businessnum, String busiscope, String perscope,
			String mediacompany, Integer mediatype, String medianame, String medialicense, String accountname,
			String bank, String accountid, String accountaddr, String orgcodeurl, String ufctificurl,
			String regcertificurl, String repcertificurl, String permitlicenseurl, String appliletterurl,
			String staffurl, String branchstaffurl, String partnerurl, Long endtime, String otherurl,Integer id) {
		this.authid = authid;
		this.wechat = wechat;
		this.authtime = authtime;
		this.type = type;
		this.orgname = orgname;
		this.orgaddr = orgaddr;
		this.orgdns = orgdns;
		this.orgweb = orgweb;
		this.orgintro = orgintro;
		this.orgrep = orgrep;
		this.orgphonenum = orgphonenum;
		this.orgpeoplenum = orgpeoplenum;
		this.orgcode = orgcode;
		this.businessnum = businessnum;
		this.busiscope = busiscope;
		this.perscope = perscope;
		this.mediacompany = mediacompany;
		this.mediatype = mediatype;
		this.medianame = medianame;
		this.medialicense = medialicense;
		this.accountname = accountname;
		this.bank = bank;
		this.accountid = accountid;
		this.accountaddr = accountaddr;
		this.orgcodeurl = orgcodeurl;
		this.ufctificurl = ufctificurl;
		this.regcertificurl = regcertificurl;
		this.repcertificurl = repcertificurl;
		this.permitlicenseurl = permitlicenseurl;
		this.appliletterurl = appliletterurl;
		this.staffurl = staffurl;
		this.branchstaffurl = branchstaffurl;
		this.partnerurl = partnerurl;
		this.endtime = endtime;
		this.otherurl = otherurl;
		this.id=id;
	}


	public Integer getAuthid() {
		return authid;
	}

	public void setAuthid(Integer authid) {
		this.authid = authid;
	}

	public Wechat getWechat() {
		return this.wechat;
	}

	public void setWechat(Wechat wechat) {
		this.wechat = wechat;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getAuthtime() {
		return this.authtime;
	}

	public void setAuthtime(Long authtime) {
		this.authtime = authtime;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgaddr() {
		return this.orgaddr;
	}

	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	public String getOrgdns() {
		return this.orgdns;
	}

	public void setOrgdns(String orgdns) {
		this.orgdns = orgdns;
	}

	public String getOrgweb() {
		return this.orgweb;
	}

	public void setOrgweb(String orgweb) {
		this.orgweb = orgweb;
	}

	public String getOrgintro() {
		return this.orgintro;
	}

	public void setOrgintro(String orgintro) {
		this.orgintro = orgintro;
	}

	public String getOrgrep() {
		return this.orgrep;
	}

	public void setOrgrep(String orgrep) {
		this.orgrep = orgrep;
	}

	public String getOrgphonenum() {
		return this.orgphonenum;
	}

	public void setOrgphonenum(String orgphonenum) {
		this.orgphonenum = orgphonenum;
	}

	public Integer getOrgpeoplenum() {
		return this.orgpeoplenum;
	}

	public void setOrgpeoplenum(Integer orgpeoplenum) {
		this.orgpeoplenum = orgpeoplenum;
	}

	public String getOrgcode() {
		return this.orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getBusinessnum() {
		return this.businessnum;
	}

	public void setBusinessnum(String businessnum) {
		this.businessnum = businessnum;
	}

	public String getBusiscope() {
		return this.busiscope;
	}

	public void setBusiscope(String busiscope) {
		this.busiscope = busiscope;
	}

	public String getPerscope() {
		return this.perscope;
	}

	public void setPerscope(String perscope) {
		this.perscope = perscope;
	}

	public String getMediacompany() {
		return this.mediacompany;
	}

	public void setMediacompany(String mediacompany) {
		this.mediacompany = mediacompany;
	}

	public Integer getMediatype() {
		return this.mediatype;
	}

	public void setMediatype(Integer mediatype) {
		this.mediatype = mediatype;
	}

	public String getMedianame() {
		return this.medianame;
	}

	public void setMedianame(String medianame) {
		this.medianame = medianame;
	}

	public String getMedialicense() {
		return this.medialicense;
	}

	public void setMedialicense(String medialicense) {
		this.medialicense = medialicense;
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

	public String getOrgcodeurl() {
		return this.orgcodeurl;
	}

	public void setOrgcodeurl(String orgcodeurl) {
		this.orgcodeurl = orgcodeurl;
	}

	public String getUfctificurl() {
		return this.ufctificurl;
	}

	public void setUfctificurl(String ufctificurl) {
		this.ufctificurl = ufctificurl;
	}

	public String getRegcertificurl() {
		return this.regcertificurl;
	}

	public void setRegcertificurl(String regcertificurl) {
		this.regcertificurl = regcertificurl;
	}

	public String getRepcertificurl() {
		return this.repcertificurl;
	}

	public void setRepcertificurl(String repcertificurl) {
		this.repcertificurl = repcertificurl;
	}

	public String getPermitlicenseurl() {
		return this.permitlicenseurl;
	}

	public void setPermitlicenseurl(String permitlicenseurl) {
		this.permitlicenseurl = permitlicenseurl;
	}

	public String getAppliletterurl() {
		return this.appliletterurl;
	}

	public void setAppliletterurl(String appliletterurl) {
		this.appliletterurl = appliletterurl;
	}

	public String getStaffurl() {
		return this.staffurl;
	}

	public void setStaffurl(String staffurl) {
		this.staffurl = staffurl;
	}

	public String getBranchstaffurl() {
		return this.branchstaffurl;
	}

	public void setBranchstaffurl(String branchstaffurl) {
		this.branchstaffurl = branchstaffurl;
	}

	public String getPartnerurl() {
		return this.partnerurl;
	}

	public void setPartnerurl(String partnerurl) {
		this.partnerurl = partnerurl;
	}

	public Long getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Long endtime) {
		this.endtime = endtime;
	}

	public String getOtherurl() {
		return this.otherurl;
	}

	public void setOtherurl(String otherurl) {
		this.otherurl = otherurl;
	}

}