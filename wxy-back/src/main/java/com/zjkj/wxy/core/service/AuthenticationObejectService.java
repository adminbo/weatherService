package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Authentication;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.utils.PageBean;


public interface AuthenticationObejectService {

	//展示公众号管理list
	public List<Authentication> authenticationsList();
	
	//展示公众号管理list和分页查询
	public void pageQuery(PageBean pageBean);
	
	
	//增加公众号的实体
	public void addauthtication(Authentication reg);
	
	//修改公众号的实体（1，找寻它对应的id；2，修改 ；3，查看）
	 public Authentication getAuthenticationid(Integer id);  
    
	 //2修改
	 public void updateauthentication(Authentication  authentication);
	 
	    
	 //删除公众号实体
	 public void deletauthentication(Authentication authentication);

	    
}
