package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * TakeAndSend entity. @author MyEclipse Persistence Tools
 */

public class TakeAndSend implements java.io.Serializable {

	// Fields

	private Integer id;
	private String schname;
	private Integer gid;
	private Integer claid;
	private String eid;
	private String cid;
	private Long time;
	private Integer sendstate;
	private Integer sendcontent;
	private Long sendtime;
	private Integer sendlong;
	private String imgurl;
	private Integer schid;
	private String stuname;
	
	

	// Constructors

	public Integer getSchid() {
		return schid;
	}

	public void setSchid(Integer schid) {
		this.schid = schid;
	}
	

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	/** default constructor */
	public TakeAndSend() {
	}

	/** minimal constructor */
	public TakeAndSend(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TakeAndSend(Integer id, String schname, Integer gid,
			Integer claid, String eid, String cid, Long time,
			Integer sendstate, Integer sendcontent, Long sendtime,
			Integer sendlong, String imgurl,Integer schid,String stuname) {
		this.id = id;
		this.schname = schname;
		this.gid = gid;
		this.claid = claid;
		this.eid = eid;
		this.cid = cid;
		this.time = time;
		this.sendstate = sendstate;
		this.sendcontent = sendcontent;
		this.sendtime = sendtime;
		this.sendlong = sendlong;
		this.imgurl = imgurl;
		this.schid = schid;
		this.stuname = stuname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchname() {
		return this.schname;
	}

	public void setSchname(String schname) {
		this.schname = schname;
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getClaid() {
		return this.claid;
	}

	public void setClaid(Integer claid) {
		this.claid = claid;
	}

	public String getEid() {
		return this.eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getSendstate() {
		return this.sendstate;
	}

	public void setSendstate(Integer sendstate) {
		this.sendstate = sendstate;
	}

	public Integer getSendcontent() {
		return this.sendcontent;
	}

	public void setSendcontent(Integer sendcontent) {
		this.sendcontent = sendcontent;
	}

	public Long getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Long sendtime) {
		this.sendtime = sendtime;
	}

	public Integer getSendlong() {
		return this.sendlong;
	}

	public void setSendlong(Integer sendlong) {
		this.sendlong = sendlong;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

}