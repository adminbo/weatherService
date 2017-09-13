package com.zjkj.wxy.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Wechat entity. @author MyEclipse Persistence Tools
 */

public class Wechat implements java.io.Serializable {

	private Integer id;
	private String name;
	private String regemail;
	private String begintime;
	private String schoolname;
	private String operator_1;
	private Integer authentype;
	private Integer regtype;
	private Integer authenstate;
	private String secret;
	private String appId;
	private String pre;
	private String token;
	private String adminname;
	private String adminwechat;
	private String adminidnum;
	private String adminphonenum;
	private String opname;
	private Integer oid;
	private Integer sid;
	private Integer deletestate;
	private String serviceids;
	private Authentication authentication;
	private Invoice invoice;
	private Operator operator;
	private String sercret;
	private Reg reg;
	private String wechatId;
	// Constructors

	/** default constructor */
	public Wechat() {
	}

	/** minimal constructor */
	public Wechat(Integer id) {
		this.id = id;
	}




	public Wechat(Integer id, String name, String regemail, String begintime, String schoolname, String operator_1,
			Integer authentype, Integer regtype, Integer authenstate, String secret, String appId, String pre,
			String token, String adminname, String adminwechat, String adminidnum, String adminphonenum, String opname,
			Integer oid, Integer sid, Integer deletestate, String serviceids, Authentication authentication,
			Invoice invoice, Operator operator, String sercret, Reg reg, String wechatId) {
		super();
		this.id = id;
		this.name = name;
		this.regemail = regemail;
		this.begintime = begintime;
		this.schoolname = schoolname;
		this.operator_1 = operator_1;
		this.authentype = authentype;
		this.regtype = regtype;
		this.authenstate = authenstate;
		this.secret = secret;
		this.appId = appId;
		this.pre = pre;
		this.token = token;
		this.adminname = adminname;
		this.adminwechat = adminwechat;
		this.adminidnum = adminidnum;
		this.adminphonenum = adminphonenum;
		this.opname = opname;
		this.oid = oid;
		this.sid = sid;
		this.deletestate = deletestate;
		this.serviceids = serviceids;
		this.authentication = authentication;
		this.invoice = invoice;
		this.operator = operator;
		this.sercret = sercret;
		this.reg = reg;
		this.wechatId = wechatId;
	}

	// Property accessors

	
	
	public Integer getDeletestate() {
		return deletestate;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getOpname() {
		return opname;
	}

	public void setOpname(String opname) {
		this.opname = opname;
	}

	public Integer getOid() {
		return oid;
	}

	public String getServiceids() {
		return serviceids;
	}

	public void setServiceids(String serviceids) {
		this.serviceids = serviceids;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDeletestate(Integer deletestate) {
		this.deletestate = deletestate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegemail() {
		return this.regemail;
	}

	public void setRegemail(String regemail) {
		this.regemail = regemail;
	}



	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getSchoolname() {
		return this.schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getOperator_1() {
		return this.operator_1;
	}

	public void setOperator_1(String operator_1) {
		this.operator_1 = operator_1;
	}

	public Integer getAuthentype() {
		return this.authentype;
	}

	public void setAuthentype(Integer authentype) {
		this.authentype = authentype;
	}

	public Integer getRegtype() {
		return this.regtype;
	}

	public void setRegtype(Integer regtype) {
		this.regtype = regtype;
	}

	public Integer getAuthenstate() {
		return this.authenstate;
	}

	public void setAuthenstate(Integer authenstate) {
		this.authenstate = authenstate;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminwechat() {
		return this.adminwechat;
	}

	public void setAdminwechat(String adminwechat) {
		this.adminwechat = adminwechat;
	}

	public String getAdminidnum() {
		return this.adminidnum;
	}

	public void setAdminidnum(String adminidnum) {
		this.adminidnum = adminidnum;
	}

	public String getAdminphonenum() {
		return this.adminphonenum;
	}

	public void setAdminphonenum(String adminphonenum) {
		this.adminphonenum = adminphonenum;
	}

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Reg getReg() {
		return reg;
	}

	public void setReg(Reg reg) {
		this.reg = reg;
	}

	public String getSercret() {
		return sercret;
	}

	public void setSercret(String sercret) {
		this.sercret = sercret;
	}
	

}