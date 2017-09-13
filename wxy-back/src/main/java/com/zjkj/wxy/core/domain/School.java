package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer type;// 1： 幼教  2：普教
	private Integer nature;
	private String address;
	private String entertime;//入住时间
	private Integer firagentid;
	private Integer secagentid;
	private String wechatName;
	private Set monitors = new HashSet(0);
	private Set eduschedules = new HashSet(0);
	private Set imgDetails = new HashSet(0);
	private Set students = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set traits = new HashSet(0);
	private Set agents = new HashSet(0);
	private Set users = new HashSet(0);
	private Set presidentEmails = new HashSet(0);
	private Set grades = new HashSet(0);
	private Set courses = new HashSet(0);
	private Set trains = new HashSet(0);
	private Set menus = new HashSet(0);
	private Set recipeses = new HashSet(0);
	private Set equipments = new HashSet(0);
private String natureView;
private String typeView;
private String fname;//一级代理名
private String sname;//二级代理名
	// Constructors


	public String getNatureView() {
		return natureView;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getTypeView() {
		return typeView;
	}

	/** default constructor */
	public School() {
	}


	/** minimal constructor */
	public School(Integer id) {
		this.id = id;
	}

	

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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
		if(type!=null){
			if("1".equals(type.toString())){
				this.typeView="幼教";
			}else{
				this.typeView="普教";
			}
		}
	
	}

	public Integer getNature() {
		return this.nature;
	}

	public void setNature(Integer nature) {
		this.nature = nature;
		if(nature!=null){
			if("1".equals(nature.toString())){
				this.natureView="公办";
			}else{
				this.natureView="民办";
			}	
		}
		
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	



	public String getEntertime() {
		return entertime;
	}

	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}

	public Integer getFiragentid() {
		return this.firagentid;
	}

	public void setFiragentid(Integer firagentid) {
		this.firagentid = firagentid;
	}

	public Integer getSecagentid() {
		return this.secagentid;
	}

	public void setSecagentid(Integer secagentid) {
		this.secagentid = secagentid;
	}

	public Set getMonitors() {
		return this.monitors;
	}

	public void setMonitors(Set monitors) {
		this.monitors = monitors;
	}

	public Set getEduschedules() {
		return this.eduschedules;
	}

	public void setEduschedules(Set eduschedules) {
		this.eduschedules = eduschedules;
	}

	public Set getImgDetails() {
		return this.imgDetails;
	}

	public void setImgDetails(Set imgDetails) {
		this.imgDetails = imgDetails;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getTraits() {
		return this.traits;
	}

	public void setTraits(Set traits) {
		this.traits = traits;
	}

	public Set getAgents() {
		return this.agents;
	}

	public void setAgents(Set agents) {
		this.agents = agents;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getPresidentEmails() {
		return this.presidentEmails;
	}

	public void setPresidentEmails(Set presidentEmails) {
		this.presidentEmails = presidentEmails;
	}

	public Set getGrades() {
		return this.grades;
	}

	public void setGrades(Set grades) {
		this.grades = grades;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	public Set getTrains() {
		return this.trains;
	}

	public void setTrains(Set trains) {
		this.trains = trains;
	}

	public Set getMenus() {
		return this.menus;
	}

	public void setMenus(Set menus) {
		this.menus = menus;
	}

	public Set getRecipeses() {
		return this.recipeses;
	}

	public void setRecipeses(Set recipeses) {
		this.recipeses = recipeses;
	}

	public Set getEquipments() {
		return this.equipments;
	}

	public void setEquipments(Set equipments) {
		this.equipments = equipments;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", type=" + type + ", nature=" + nature + ", address=" + address
				+ ", entertime=" + entertime + ", wechatName=" + wechatName + "]";
	}

	



}