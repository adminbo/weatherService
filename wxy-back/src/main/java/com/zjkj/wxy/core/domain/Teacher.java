package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields


	private Integer id;
	private String email;
	private School school;
	private Train train;
	private Integer age;
	private Integer sex;//0:女/1：男
	private String sexview;
	private String num;
	private String subjectname;
	private String station;
	private String entrytime;
	private String gradtime;
	private String gardschool;
	private String edu;
	private String phonenum;
	private Integer gradeid;
	private Integer classid;
	private String imgurl;
	private String introduce;
	private String wechatnum;
	private String wecahturl;
	private Integer isfllow;
	private Integer isshow;
	private String addtime;
	private String name;
	private String jobtime;
	private Set teaAcherattds = new HashSet(0);
	private Set gradeClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}


	public String getSexview() {
		return sexview;
	}

	public String getJobtime() {
		return jobtime;
	}

	public void setJobtime(String jobtime) {
		this.jobtime = jobtime;
	}

	
	public Teacher(Integer id, Train train) {
		this.id = id;
		this.train = train;
	}

	/** full constructor */
	public Teacher(Integer id, School school, Train train, Integer age,
			Integer sex, String num, String subjectname, String station,
			String entrytime, String gradtime, String gardschool,
			String edu, String phonenum, Integer gradeid,
			Integer classid, String imgurl, String introduce,
			String wechatnum, String wecahturl, Integer isfllow,
			Integer isshow, String addtime, String name,
			Set teaAcherattds, Set gradeClasses) {
		this.id = id;
		this.school = school;
		this.train = train;
		this.age = age;
		this.sex = sex;
		this.num = num;
		this.subjectname = subjectname;
		this.station = station;
		this.entrytime = entrytime;
		this.gradtime = gradtime;
		this.gardschool = gardschool;
		this.edu = edu;
		this.phonenum = phonenum;
		this.gradeid = gradeid;
		this.classid = classid;
		this.imgurl = imgurl;
		this.introduce = introduce;
		this.wechatnum = wechatnum;
		this.wecahturl = wecahturl;
		this.isfllow = isfllow;
		this.isshow = isshow;
		this.addtime = addtime;
		this.name = name;
		this.teaAcherattds = teaAcherattds;
		this.gradeClasses = gradeClasses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}
	public School getSchool() {
		return this.school;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSubjectname() {
		return this.subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getEntrytime() {
		return this.entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getGradtime() {
		return this.gradtime;
	}

	public void setGradtime(String gradtime) {
		this.gradtime = gradtime;
	}

	public String getGardschool() {
		return this.gardschool;
	}

	public void setGardschool(String gardschool) {
		this.gardschool = gardschool;
	}

	public String getEdu() {
		return this.edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Integer getGradeid() {
		return this.gradeid;
	}

	public void setGradeid(Integer gradeid) {
		this.gradeid = gradeid;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getWechatnum() {
		return this.wechatnum;
	}

	public void setWechatnum(String wechatnum) {
		this.wechatnum = wechatnum;
	}

	public String getWecahturl() {
		return this.wecahturl;
	}

	public void setWecahturl(String wecahturl) {
		this.wecahturl = wecahturl;
	}

	public Integer getIsfllow() {
		return this.isfllow;
	}

	public void setIsfllow(Integer isfllow) {
		this.isfllow = isfllow;
	}

	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTeaAcherattds() {
		return this.teaAcherattds;
	}

	public void setTeaAcherattds(Set teaAcherattds) {
		this.teaAcherattds = teaAcherattds;
	}

	public Set getGradeClasses() {
		return this.gradeClasses;
	}

	public void setGradeClasses(Set gradeClasses) {
		this.gradeClasses = gradeClasses;
	}

	public void setSexview(String sexview) {
		this.sexview = sexview;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", email=" + email + ", age=" + age + ", sex=" + sex + ", sexview=" + sexview
				+ ", num=" + num + ", subjectname=" + subjectname + ", station=" + station + ", entrytime=" + entrytime
				+ ", gradtime=" + gradtime + ", gardschool=" + gardschool + ", edu=" + edu + ", phonenum=" + phonenum
				+ ", gradeid=" + gradeid + ", classid=" + classid + ", imgurl=" + imgurl + ", introduce=" + introduce
				+ ", wechatnum=" + wechatnum + ", wecahturl=" + wecahturl + ", isfllow=" + isfllow + ", isshow="
				+ isshow + ", addtime=" + addtime + ", name=" + name + ", jobtime=" + jobtime + "]";
	}


	





	
}