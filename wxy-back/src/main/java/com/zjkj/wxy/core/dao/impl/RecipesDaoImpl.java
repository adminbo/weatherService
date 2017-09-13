package com.zjkj.wxy.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zjkj.wxy.core.dao.CharacteristicDao;
import com.zjkj.wxy.core.dao.RecipesDao;
import com.zjkj.wxy.core.dao.baseDao.BaseDaoImpl;
import com.zjkj.wxy.core.domain.Recipes;
import com.zjkj.wxy.core.domain.Trait;


@Repository
public class RecipesDaoImpl extends BaseDaoImpl<Recipes> implements RecipesDao{

	private SessionFactory sessionFactory; 
	@Resource
	public void setSF(SessionFactory sessionFactory){
		//调用父类的方法注入会话工厂对象
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Recipes> recipesList() {
		// TODO Auto-generated method stub
		 String hql = "from t_Recipes";  
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	        return query.list(); 
	}

	@Override
	public void addrecipe(Recipes recipes) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(recipes);  
	}

	@Override
	public Recipes getRecipes(int id) {
		String hql = "from t_Recipes w where w.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setInteger(0, id);
        return (Recipes)query.uniqueResult();
	}

	

	@Override
	public boolean updateRecipes(Recipes recipes) {
		String hql = "update t_recipes w set w.STUYEAR = ?,w.TERM = ?,w.WEAKS = ?,w.DAY = ?,w.MOSNACK = ?,w.LUNCH = ?,w.FRUIT = ?,w.AFSNACK = ? where w.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, recipes.getStuyear());
        query.setInteger(1, recipes.getTerm());
        query.setInteger(2, recipes.getWeaks());
        query.setInteger(3, recipes.getDay());
        query.setString(4, recipes.getMosnack());
        query.setString(5, recipes.getLunch());
        query.setString(6, recipes.getFruit());
        query.setString(7, recipes.getAfsnack());
        query.setInteger(8, recipes.getId());
        return (query.executeUpdate() > 0);
	}

	

}
