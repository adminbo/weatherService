package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Trait;
import com.zjkj.wxy.core.service.CharacteristicService;


@Controller
public class CharateristicController {

	//spring 资源注入
			@Resource
			private CharacteristicService characteristicService;

			

			public CharacteristicService getCharacteristicService() {
				return characteristicService;
			}

			public void setCharacteristicService(CharacteristicService characteristicService) {
				this.characteristicService = characteristicService;
			}

			@RequestMapping("/toAddCharacteristic")  
			    public String toCharacteristic(){  
			        return "/addCharacteristic";  
			    }  
			      
			    @RequestMapping("/addCharacteristic")// 请求url地址映射，类似Struts的action-mapping   
			    public String addCharacteristic(Trait trait){  
			    	characteristicService.addtrait(trait);
			        return "redirect:/characteristic/getAllcharacteristicService";  
			    }  
			      
			    @RequestMapping("/getAllcharacteristicService")  
			    public String getAllCharacteristic(HttpServletRequest request){  
			        List<Trait> trait = characteristicService.traitsList();
			          
			        request.setAttribute("trait", trait);  
			          
			        return "/getAllCharacteristic";  
			    }  
			      
			    @RequestMapping("/delCharacteristic")  
			    public void delCharacteristic(int id,HttpServletResponse response){  
			        String result = "{\"result\":\"error\"}";  
			        if(characteristicService.deletTrait(id)){  
			            result = "{\"result\":\"success\"}";  
			        }  
			        PrintWriter out = null;  
			        response.setContentType("application/json");  
			          
			        try {  
			            out = response.getWriter();  
			            out.write(result);  
			        } catch (IOException e) {  
			            e.printStackTrace();  
			        }  
			          
			    }  
			      
			    @RequestMapping("/getCharacteristic")  
			    public String getCharacteristic(int id,HttpServletRequest request){  
			    	Trait trait = characteristicService.getTrait(id);
			          
			        request.setAttribute("trait", trait);  
			        return "/editCharacteristic";  
			    }  
			      
			    @RequestMapping("/showCharacteristic")  
			    public String showCharacteristic(Trait trait,HttpServletRequest request){  
			        if(characteristicService.showTeacher(trait)){  
			        	trait = characteristicService.getTrait(trait.getId());
			            request.setAttribute("trait", trait);  
			            return "/editCharacteristic";  
			        }else{  
			            return "/error";  
			        }  
			    }
			    
			        @RequestMapping("/updateCharacteristic")  
				    public String updateCharacteristic(Trait trait,HttpServletRequest request){  
				        if(characteristicService.updateTrait(trait)){  
				        	trait = characteristicService.getTrait(trait.getId());
				            request.setAttribute("trait", trait);  
				            return "/editCharacteristices";  
				        }else{  
				            return "/error";  
				        } 
			    } 
	
}
