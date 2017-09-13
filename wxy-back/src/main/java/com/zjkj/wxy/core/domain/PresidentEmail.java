package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * PresidentEmail entity. @author MyEclipse Persistence Tools
 */

public class PresidentEmail implements java.io.Serializable {

	// Fields

	private int id;
	private School school;
	private Integer senderid;
	private Integer isanon;
	private String title;
	private String content;
	private String reply;//回复内容
	private Long rectime;
	private Integer handstate;

	// Constructors

	/** default constructor */
	public PresidentEmail() {
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	/** minimal constructor */
	public PresidentEmail(int id) {
		this.id = id;
	}

	/** full constructor */
	public PresidentEmail(int id, School school, Integer senderid,
			Integer isanon, String title, String content,
			Long rectime, Integer handstate) {
		this.id = id;
		this.school = school;
		this.senderid = senderid;
		this.isanon = isanon;
		this.title = title;
		this.content = content;
		this.rectime = rectime;
		this.handstate = handstate;
	}

	// Property accessors

	

	public School getSchool() {
		return this.school;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getSenderid() {
		return this.senderid;
	}

	public void setSenderid(Integer senderid) {
		this.senderid = senderid;
	}

	public Integer getIsanon() {
		return this.isanon;
	}

	public void setIsanon(Integer isanon) {
		this.isanon = isanon;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getRectime() {
		return this.rectime;
	}

	public void setRectime(Long rectime) {
		this.rectime = rectime;
	}

	public Integer getHandstate() {
		return this.handstate;
	}

	public void setHandstate(Integer handstate) {
		this.handstate = handstate;
	}

}