package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Img;

public interface AligendEnvireService {

	//展示校园管理list
	public List<Img> envireList();
	
	//增加校园环境的图片
	public void addimgs(Img img);
	
	//修改校园环境图片（1，找寻它对应的id；2，上架；3，下架）
	 public Img getWechatid(int id);  
     
	 //2上架
	 public boolean updateEnvire(Img img);
	    
	 //3下架
	 public boolean updateschoolEnvire(Img img);
	 
	 //删除校园环境
	 public boolean deletschoolEnvire(int id); 
}
