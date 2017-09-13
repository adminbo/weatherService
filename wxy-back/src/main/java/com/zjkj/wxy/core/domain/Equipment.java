package com.zjkj.wxy.core.domain;

import java.math.BigDecimal;

/**
 * Equipment entity. @author MyEclipse Persistence Tools
 */

public class Equipment implements java.io.Serializable {

	// Fields

	private String id;
	private School school;
	private Integer type;//1:门禁机2:闸机3:摄像头
	private Integer model; //1落地机  2支架机 3 壁挂机
	private Integer runstate;//1：运行2：故障3：
	private String addtime;
//视图值
private String modelView; 
private String typeView;
private String stateView;
	// Constructors

	/** default constructor */
	public Equipment() {
	}

	public String getTypeView() {
		return typeView;
	}

	public String getStateView() {
		return stateView;
	}

	public String getModelView() {
		return modelView;
	}

	/** minimal constructor */
	public Equipment(String id) {
		this.id = id;
	}

	/** full constructor */


	// Property accessors

	public String getId() {
		return this.id;
	}

	public Equipment(String id, School school, Integer type, Integer model, Integer runstate, String addtime,
			String modelView, String typeView, String stateView) {
		super();
		this.id = id;
		this.school = school;
		this.type = type;
		this.model = model;
		this.runstate = runstate;
		this.addtime = addtime;
		this.modelView = modelView;
		this.typeView = typeView;
		this.stateView = stateView;
	}

	public void setId(String id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
		if(type!=null){
			if(1==type.intValue()){
				this.typeView="门禁机";
			}
			if(2==type.intValue()){
				this.typeView="闸机";
			}
			if(3==type.intValue()){
				this.typeView="摄像头";
			}
			
		}
	}

	public void setModel(Integer model) {
		this.model = model;
		if(model==1){
			this.modelView="落地机";
		}
		if(model==2){
			this.modelView="支架机";
		}
		if(model==3){
			this.modelView="壁挂机";
		}
	}

	public Integer getRunstate() {
		return this.runstate;
	}

	public void setRunstate(Integer runstate) {
		this.runstate = runstate;
		if(runstate!=null){
			if(0==runstate.intValue()){
				this.stateView="运行正常";
			}
			if(1==runstate.intValue()){
				this.stateView="摄像头故障";
			}
			if(2==runstate.intValue()){
				this.stateView="刷卡器故障";
			}
			if(3==runstate.intValue()){
				this.stateView="拆机报警";
			}
			if(4==runstate.intValue()){
				this.stateView="其他";
			}
			if(4==runstate.intValue()){
				this.stateView="设备离线";
			}
		}
	}
	public Integer getModel() {
		return model;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

}