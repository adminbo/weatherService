package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.RecipesDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Recipes;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.RecipesService;
import com.zjkj.wxy.core.service.SchoolEnvireService;

@Service("recipesService")
@Transactional
public class RecipesServiceImpl implements RecipesService {

	
	@Resource
	private RecipesDao recipesDao;

	@Override
	public List<Recipes> recipesList() {
		// TODO Auto-generated method stub
		return recipesDao.recipesList();
	}

	@Override
	public void addrecipe(Recipes recipes) {
		// TODO Auto-generated method stub
		recipesDao.addrecipe(recipes);
	}

	@Override
	public Recipes getRecipes(int id) {
		// TODO Auto-generated method stub
		return recipesDao.getRecipes(id);
	}

	@Override
	public boolean updateRecipes(Recipes recipes) {
		// TODO Auto-generated method stub
		return recipesDao.updateRecipes(recipes);
	}

	public RecipesDao getRecipesDao() {
		return recipesDao;
	}

	public void setRecipesDao(RecipesDao recipesDao) {
		this.recipesDao = recipesDao;
	}

	
}
