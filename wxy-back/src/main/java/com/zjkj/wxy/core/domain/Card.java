package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private String id;//卡编号
	private Student student;//持有人
	private Integer deposit;//押金
	private Integer haveinvoice;//是否开票
	private Integer invoicetype;//卡票类型
	private Long invoicetime;//开票时间
	private Integer isreturn;//是否退卡 0:否1：是
    private Integer isshow;//是否删除 1：没0：删
	private Integer sid;//学校id
	private String returntime;//退卡时间
	private String invoicepeo;//开卡人
	private String activeTime;//开卡时间
	private Grade grade;//年级
	private Classes clazz;//班级
	private String applyer;//申请人
	// Constructors

	/** default constructor */
	public Card() {
	}

	/** minimal constructor */
	public Card(String id) {
		this.id = id;
	}

	/** full constructor */


	// Property accessors

	public String getId() {
		return this.id;
	}

	

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}



	public Card(String id, Student student, Integer deposit, Integer haveinvoice, Integer invoicetype, Long invoicetime,
			Integer isreturn, Integer isshow, Integer sid, String returntime, String invoicepeo, String activeTime,
			Grade grade, Classes clazz, String applyer) {
		super();
		this.id = id;
		this.student = student;
		this.deposit = deposit;
		this.haveinvoice = haveinvoice;
		this.invoicetype = invoicetype;
		this.invoicetime = invoicetime;
		this.isreturn = isreturn;
		this.isshow = isshow;
		this.sid = sid;
		this.returntime = returntime;
		this.invoicepeo = invoicepeo;
		this.activeTime = activeTime;
		this.grade = grade;
		this.clazz = clazz;
		this.applyer = applyer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Integer getHaveinvoice() {
		return this.haveinvoice;
	}

	public void setHaveinvoice(Integer haveinvoice) {
		this.haveinvoice = haveinvoice;
	}

	public Integer getInvoicetype() {
		return this.invoicetype;
	}

	public void setInvoicetype(Integer invoicetype) {
		this.invoicetype = invoicetype;
	}

	public Long getInvoicetime() {
		return this.invoicetime;
	}

	public void setInvoicetime(Long invoicetime) {
		this.invoicetime = invoicetime;
	}

	public Integer getIsreturn() {
		return this.isreturn;
	}

	public void setIsreturn(Integer isreturn) {
		this.isreturn = isreturn;
	}



	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

	public String getInvoicepeo() {
		return this.invoicepeo;
	}

	public void setInvoicepeo(String invoicepeo) {
		this.invoicepeo = invoicepeo;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Classes getClazz() {
		return clazz;
	}

	public void setClazz(Classes clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", student=" + student + ", deposit=" + deposit + ", haveinvoice=" + haveinvoice
				+ ", invoicetype=" + invoicetype + ", invoicetime=" + invoicetime + ", isreturn=" + isreturn
				+ ", isshow=" + isshow + ", sid=" + sid + ", returntime=" + returntime + ", invoicepeo=" + invoicepeo
				+ ", activeTime=" + activeTime + ", grade=" + grade + ", clazz=" + clazz + "]";
	}
	
	

}