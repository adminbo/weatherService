package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.PresidentEmail;
import com.zjkj.wxy.core.domain.Recipes;
import com.zjkj.wxy.core.domain.Trait;

public interface PrincipalMailboxService {
	
	//展示校長信箱list
			public List<PresidentEmail> presidentEmaillList();
			
			//修改校長的事例（1，找寻它对应的id；2，修改）
			 public PresidentEmail getPresidentEmail(int id);  
		     
			 //2修改
			 public boolean updatePresidentEmail(PresidentEmail presidentEmail);
			 
}
