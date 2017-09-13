package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Recipes;
import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.service.CharacteristicService;
import com.zjkj.wxy.core.service.RecipesService;


@Controller
public class RecipesController {

	//spring 资源注入
			@Resource
			private RecipesService recipesService;

			public RecipesService getRecipesService() {
				return recipesService;
			}

			public void setRecipesService(RecipesService recipesService) {
				this.recipesService = recipesService;
			}

			@RequestMapping("/toAddRecipes")  
			    public String toRecipes(){  
			        return "/addRecipes";  
			    }  
			      
			    @RequestMapping("/addRecipes")// 请求url地址映射，类似Struts的action-mapping   
			    public String addRecipes(Recipes recipes){  
			    	recipesService.addrecipe(recipes);
			        return "redirect:/Recipes/getAllRecipes";  
			    }  
			      
			    @RequestMapping("/getAllRecipes")  
			    public String getAllRecipes(HttpServletRequest request){  
			        List<Recipes> recipes = recipesService.recipesList();
			          
			        request.setAttribute("recipes", recipes);  
			          
			        return "/getAllRecipes";  
			    }  
			      
			    
			    @RequestMapping("/getRecipes")  
			    public String getRecipes(int id,HttpServletRequest request){  
			    	Recipes recipes = recipesService.getRecipes(id);
			          
			        request.setAttribute("recipes", recipes);  
			        return "/editRecipes";  
			    }  
			      
			       
			        @RequestMapping("/updateRecipes")  
				    public String updateRecipes(Recipes recipes,HttpServletRequest request){  
				        if(recipesService.updateRecipes(recipes)){  
				        	recipes = recipesService.getRecipes(recipes.getId());
				            request.setAttribute("recipes", recipes);  
				            return "/editRecipes";  
				        }else{  
				            return "/error";  
				        } 
			    } 
	
}
