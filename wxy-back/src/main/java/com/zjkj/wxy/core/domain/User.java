package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields
	
	private Integer id;
	private School school;
	private String name;
	private Integer type;//用户类型，1 ：超级admin 2 ：一级代理 3： 二级代理 4： 学校管理   空：学校普通用户
	private String phoneNum;
	private String typeView;
	private String companyname;
	private String regemail;
	private String pwd;
	private String regtime;
	private Long edpwdtime;
	private String resttime;
	private Integer tid;
	private Integer aid;
	private Integer sid;
	private Agent agent;
	private String realName;
	private Integer isShow;//1 ：显示 0不显示
	private String code;//修改密码验证码
	private Set roles = new HashSet(0);//角色集合
	private Set systems = new HashSet(0);
	private Set communications = new HashSet(0);

	
	// Constructors

	
	public Integer getSid() {
		return sid;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getTypeView() {
		
		return typeView;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public User(Integer id, School school, String name, Integer type,
			String companyname, String regemail, String pwd,
			String regtime, Long edpwdtime, String resttime,
			Integer tid, Integer aid,  Set systems,
			Set communications) {
		this.id = id;
		this.school = school;
		this.name = name;
		this.type = type;
		this.companyname = companyname;
		this.regemail = regemail;
		this.pwd = pwd;
		this.regtime = regtime;
		this.edpwdtime = edpwdtime;
		this.resttime = resttime;
		this.tid = tid;
		this.aid = aid;
		
		this.systems = systems;
		this.communications = communications;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {		
		this.type = type;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getRegemail() {
		return this.regemail;
	}

	public void setRegemail(String regemail) {
		this.regemail = regemail;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegtime() {
		return this.regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public Long getEdpwdtime() {
		return this.edpwdtime;
	}

	public void setEdpwdtime(Long edpwdtime) {
		this.edpwdtime = edpwdtime;
	}

	

	public String getResttime() {
		return resttime;
	}

	public void setResttime(String resttime) {
		this.resttime = resttime;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
		StringBuffer sb = new StringBuffer();
		if(roles!=null){
			for (Role role : roles) {
				sb.append(role.getName()).append(",");
			}
			String s = sb.toString();
			if(s.endsWith(",")){
				s = s.substring(0, s.length()-1);
			}
			this.typeView=s;			
		}
	}

	public Set getSystems() {
		return this.systems;
	}

	public void setSystems(Set systems) {
		this.systems = systems;
	}

	public Set getCommunications() {
		return this.communications;
	}

	public void setCommunications(Set communications) {
		this.communications = communications;
	}

	public void setTypeView(String typeView) {
		this.typeView = typeView;
	}

	

}