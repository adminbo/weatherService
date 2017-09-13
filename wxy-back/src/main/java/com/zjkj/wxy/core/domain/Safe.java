package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;


/**
 * Safe entity. @author MyEclipse Persistence Tools
 */

public class Safe  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Classes cla;
     private Grade grade;
     private School school;
     private Student student;
     private String sname;
     private String sidno;
     private String applicantname;
     private String applicantidno;
     private String applicantmobile;
     private Integer insuretype;
     private Integer insurefee;
     private Integer insureterm;
     private String paymentno;
     private Integer paymentfee;
     private String paytime;


    // Constructors

    /** default constructor */
    public Safe() {
    }

	/** minimal constructor */
    public Safe(Integer id) {
        this.id = id;
    }
    
    /** full constructor */


   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
	public Safe(Integer id, Classes cla, Grade grade, School school, Student student, String sname, String sidno,
			String applicantname, String applicantidno, String applicantmobile, Integer insuretype,
			Integer insurefee, Integer insureterm, String paymentno, Integer paymentfee, String paytime) {
		super();
		this.id = id;
		this.cla = cla;
		this.grade = grade;
		this.school = school;
		this.student = student;
		this.sname = sname;
		this.sidno = sidno;
		this.applicantname = applicantname;
		this.applicantidno = applicantidno;
		this.applicantmobile = applicantmobile;
		this.insuretype = insuretype;
		this.insurefee = insurefee;
		this.insureterm = insureterm;
		this.paymentno = paymentno;
		this.paymentfee = paymentfee;
		this.paytime = paytime;
	}

	public void setId(Integer id) {
        this.id = id;
    }

	public Classes getCla() {
		return cla;
	}

	public void setCla(Classes cla) {
		this.cla = cla;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSidno() {
        return this.sidno;
    }
    
    public void setSidno(String sidno) {
        this.sidno = sidno;
    }

    public String getApplicantname() {
        return this.applicantname;
    }
    
    public void setApplicantname(String applicantname) {
        this.applicantname = applicantname;
    }

    public String getApplicantidno() {
        return this.applicantidno;
    }
    
    public void setApplicantidno(String applicantidno) {
        this.applicantidno = applicantidno;
    }

    public String getApplicantmobile() {
        return this.applicantmobile;
    }
    
    public void setApplicantmobile(String applicantmobile) {
        this.applicantmobile = applicantmobile;
    }

    public Integer getInsuretype() {
        return this.insuretype;
    }
    
    public void setInsuretype(Integer insuretype) {
        this.insuretype = insuretype;
    }

    public Integer getInsurefee() {
        return this.insurefee;
    }
    
    public void setInsurefee(Integer insurefee) {
        this.insurefee = insurefee;
    }

    public Integer getInsureterm() {
        return this.insureterm;
    }
    
    public void setInsureterm(Integer insureterm) {
        this.insureterm = insureterm;
    }

    public String getPaymentno() {
        return this.paymentno;
    }
    
    public void setPaymentno(String paymentno) {
        this.paymentno = paymentno;
    }

    public Integer getPaymentfee() {
        return this.paymentfee;
    }
    
    public void setPaymentfee(Integer paymentfee) {
        this.paymentfee = paymentfee;
    }

    public String getPaytime() {
        return this.paytime;
    }
    
    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }
   








}