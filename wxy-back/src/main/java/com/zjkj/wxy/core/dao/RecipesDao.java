package com.zjkj.wxy.core.dao;

import java.util.List;

import com.zjkj.wxy.core.domain.Recipes;
import com.zjkj.wxy.core.domain.Trait;

public interface RecipesDao {
	
	//展示每週食譜list
			public List<Recipes> recipesList();
			
			//增加办学特色的事例
			public void addrecipe(Recipes recipes);
			
			//修改老師的事例（1，找寻它对应的id；2，修改；3，查看）
			 public Recipes getRecipes(int id);  
		     
			 //3修改
			 public boolean updateRecipes(Recipes recipes);
			 
}
