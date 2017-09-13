package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Invoice entity. @author MyEclipse Persistence Tools
 */

public class Invoice implements java.io.Serializable {

	// Fields

	private Integer invoiceid;
	private Wechat wechat;
	private Integer itype;
	private String ititle;
	private String icontact;
	private String contactph0num;
	private String postaddr;
	private String postcode;
	private String province;
	private String city;
	private String districtAndCounty;
	private Integer id;

	// Constructors

	/** default constructor */
	public Invoice() {
	}

	/** minimal constructor */
	public Invoice(Integer id) {
		this.id = id;
	}

	 

	public Invoice(Integer invoiceid, Wechat wechat, Integer itype, String ititle, String icontact, String contactph0num,
			String postaddr, String postcode, String province, String city, String districtAndCounty,Integer id) {
		super();
		this.invoiceid = invoiceid;
		this.wechat = wechat;
		this.itype = itype;
		this.ititle = ititle;
		this.icontact = icontact;
		this.contactph0num = contactph0num;
		this.postaddr = postaddr;
		this.postcode = postcode;
		this.province = province;
		this.city = city;
		this.districtAndCounty = districtAndCounty;
		this.id=id;
	}

	// Property accessors

	public Wechat getWechat() {
		return this.wechat;
	}

	 

	public Integer getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}

	public void setWechat(Wechat wechat) {
		this.wechat = wechat;
	}

	public Integer getItype() {
		return this.itype;
	}

	public void setItype(Integer itype) {
		this.itype = itype;
	}

	public String getItitle() {
		return this.ititle;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setItitle(String ititle) {
		this.ititle = ititle;
	}

	public String getIcontact() {
		return this.icontact;
	}

	public void setIcontact(String icontact) {
		this.icontact = icontact;
	}

	public String getContactph0num() {
		return this.contactph0num;
	}

	public void setContactph0num(String contactph0num) {
		this.contactph0num = contactph0num;
	}

	public String getPostaddr() {
		return this.postaddr;
	}

	public void setPostaddr(String postaddr) {
		this.postaddr = postaddr;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrictAndCounty() {
		return districtAndCounty;
	}

	public void setDistrictAndCounty(String districtAndCounty) {
		this.districtAndCounty = districtAndCounty;
	}

}