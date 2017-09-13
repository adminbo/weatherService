package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private String name;
	private String num;
	private Integer sex;
	private Integer grade;
	private Integer classid;
	private String birthday;
	private String intime;
	private String marks;
	private Integer isshow;
	private Integer status;
	private String changetime;
	private String uodtime;
	private Integer uod;
	private Integer cardnum;
	private String sexview;
	private String imgurl;
	private String studoview;
	private Integer studo;
	private Integer isInsured;//是否买保险
	private String idNum;//身份证号
	private Set cards = new HashSet(0);
	private Set leaves = new HashSet(0);
	private Set attendances = new HashSet(0);
	private Set scoreDetials = new HashSet(0);
	private Set stuPars = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}


	/** minimal constructor */
	public Student(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Student(Integer id, School school, String name, String num,
			Integer sex, Integer grade, 
			String birthday, String intime, String marks,
			Integer isshow, Integer status, String changetime,
			String uodtime, Integer uod, Integer cardnum, Set cards,
			Set leaves, Set attendances, Set scoreDetials, Set stuPars) {
		this.id = id;
		this.school = school;
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.grade = grade;

		this.birthday = birthday;
		this.intime = intime;
		this.marks = marks;
		this.isshow = isshow;
		this.status = status;
		this.changetime = changetime;
		this.uodtime = uodtime;
		this.uod = uod;
		this.cardnum = cardnum;
		this.cards = cards;
		this.leaves = leaves;
		this.attendances = attendances;
		this.scoreDetials = scoreDetials;
		this.stuPars = stuPars;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
		if(sex!=null){
			if(1==sex.intValue()){
				this.sexview="男";
			}
			if(0==sex.intValue()){
				this.sexview="女";
			}
		}
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}



	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIntime() {
		return this.intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getMarks() {
		return this.marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getChangetime() {
		return this.changetime;
	}

	public void setChangetime(String changetime) {
		this.changetime = changetime;
	}

	public String getUodtime() {
		return this.uodtime;
	}

	public void setUodtime(String uodtime) {
		this.uodtime = uodtime;
	}

	public Integer getUod() {
		return this.uod;
	}

	public void setUod(Integer uod) {
		this.uod = uod;
	}

	public Integer getCardnum() {
		return this.cardnum;
	}

	public void setCardnum(Integer cardnum) {
		this.cardnum = cardnum;
	}

	public Set getCards() {
		return this.cards;
	}

	public void setCards(Set cards) {
		this.cards = cards;
	}

	public Set getLeaves() {
		return this.leaves;
	}

	public void setLeaves(Set leaves) {
		this.leaves = leaves;
	}

	public Set getAttendances() {
		return this.attendances;
	}

	public void setAttendances(Set attendances) {
		this.attendances = attendances;
	}

	public Set getScoreDetials() {
		return this.scoreDetials;
	}

	public void setScoreDetials(Set scoreDetials) {
		this.scoreDetials = scoreDetials;
	}

	public Set getStuPars() {
		return this.stuPars;
	}

	public void setStuPars(Set stuPars) {
		this.stuPars = stuPars;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getSexview() {
		return sexview;
	}

	public String getStudoview() {
		return studoview;
	}

	public Integer getStudo() {
		return studo;
	}

	public void setStudo(Integer studo) {
		this.studo = studo;
		if(studo!=null){
			if(1==studo.intValue()){
				this.studoview="升级";
			}
			if(2==studo.intValue()){
				this.studoview="转学";
			}
			if(3==studo.intValue()){
				this.studoview="留级";
			}
			if(4==studo.intValue()){
				this.studoview="升学";
			}
			if(5==studo.intValue()){
				this.studoview="换班";
			}
			if(6==studo.intValue()){
				this.studoview="休学";
			}
		}
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public Integer getIsInsured() {
		return isInsured;
	}

	public void setIsInsured(Integer isInsured) {
		this.isInsured = isInsured;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", school=" + school + ", name=" + name + ", num=" + num + ", sex=" + sex
				+ ", grade=" + grade + ", classid=" + classid + ", birthday=" + birthday + ", intime=" + intime
				+ ", marks=" + marks + ", isshow=" + isshow + ", status=" + status + ", changetime=" + changetime
				+ ", uodtime=" + uodtime + ", uod=" + uod + ", cardnum=" + cardnum + ", sexview=" + sexview
				+ ", imgurl=" + imgurl + ", studoview=" + studoview + ", studo=" + studo + ", isInsured=" + isInsured
				+ ", idNum=" + idNum + ", cards=" + cards + ", leaves=" + leaves + ", attendances=" + attendances
				+ ", scoreDetials=" + scoreDetials + ", stuPars=" + stuPars + "]";
	}



}