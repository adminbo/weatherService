package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.utils.PageBean;

public interface CharacteristicService {

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
		/**
		 * 分页
		 * @param pg
		 * @return
		 */
		public void pageQuery(PageBean<Trait> pg);
/**
 * 根据id删除
 * @param id
 */
		public void deletById(Integer id);
/**
 * 添加办学特色
 * @param t
 */
public void save(Trait t); 
}
