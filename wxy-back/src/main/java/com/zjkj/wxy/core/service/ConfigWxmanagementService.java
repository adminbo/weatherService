package com.zjkj.wxy.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.utils.PageBean;

public interface ConfigWxmanagementService {

	//展示公众号管理list
	public List<Wechat> wechatsliList();
	
	//增加公众号的实体
	public void addWechats(Wechat wechat);
	
	//修改公众号的实体（1，找寻它对应的id；2，修改）
	 public Wechat getWechatid(int id);  
     
	 //2修改
	 public void updateWechat(Wechat wechat);
	    
	 //3删除
	 public void deleteWechat(Wechat wechat);
	 
	//假删
	public void deleteById(Integer id);
	 
	//4查看
	 public void showWechat(Wechat wechat);
	 
	//分页查询
		void pageQuery(PageBean pageBean);
		
		//离线查询对象
		public List<Wechat> findByCriteria(DetachedCriteria criteria);   

		
}
