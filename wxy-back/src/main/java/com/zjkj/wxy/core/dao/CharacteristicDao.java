package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Trait;

public interface CharacteristicDao extends IBaseDao<Trait>{

	//展示办學管理特色展示list
		public List<Trait> traitsList();
		
		//增加办学特色的事例
		public void addtrait(Trait trait);
		
		//修改老師的事例（1，找寻它对应的id；2，修改；3，查看）
		 public Trait getTrait(int id);  
	     
		 //2查看
		 public boolean showTeacher(Trait trait);
		    
		 //3修改
		 public boolean updateTrait(Trait trait);
		 
		 //删除老師在檔信息
		 public boolean deletTrait(int id); 
}
