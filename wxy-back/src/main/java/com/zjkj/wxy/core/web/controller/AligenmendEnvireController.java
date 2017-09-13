package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.SchoolEnvireService;

@Controller
public class AligenmendEnvireController {

	//spring 资源注入
			@Resource
			private AligendEnvireService aligendEnvireService;

			public AligendEnvireService getAligendEnvireService() {
				return aligendEnvireService;
			}

			public void setAligendEnvireService(AligendEnvireService aligendEnvireService) {
				this.aligendEnvireService = aligendEnvireService;
			}

			@RequestMapping("/toAddAligendEnvire")  
			    public String toAddAligendEnvire(){  
			        return "/addAligendEnvire";  
			    }  
			      
			    @RequestMapping("/addAligendEnvire")// 请求url地址映射，类似Struts的action-mapping   
			    public String addAligendEnvire(Img img){  
			    	aligendEnvireService.addimgs(img);
			        return "redirect:/aligend/getAllAligendEnvire";  
			    }  
			      
			    @RequestMapping("/getAllAligendEnvire")  
			    public String AligendEnvire(HttpServletRequest request){  
			        List<Img> img = aligendEnvireService.envireList();
			          
			        request.setAttribute("img", img);  
			          
			        return "/getAllAligendEnvire";  
			    }  
			      
			    @RequestMapping("/delAligendEnvire")  
			    public void delAligendEnvire(int id,HttpServletResponse response){  
			        String result = "{\"result\":\"error\"}";  
			        if(aligendEnvireService.deletschoolEnvire(id)){  
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
			      
			    @RequestMapping("/getAligendEnvire")  
			    public String getAligendEnvire(int id,HttpServletRequest request){  
			    	Img img = aligendEnvireService.getWechatid(id);
			          
			        request.setAttribute("img", img);  
			        return "/editAligendEnvire";  
			    }  
			      
			    @RequestMapping("/updateAligendEnvire")  
			    public String updateAligendEnvire(Img img,HttpServletRequest request){  
			        if(aligendEnvireService.updateEnvire(img)){  
			            img = aligendEnvireService.getWechatid(img.getId());
			            request.setAttribute("img", img);  
			            return "/editEnvire";  
			        }else{  
			            return "/error";  
			        }  
			    }
			    
			        @RequestMapping("/updateAligendEnvires")  
				    public String updateSchoolEnvireid(Img img,HttpServletRequest request){  
				        if(aligendEnvireService.updateschoolEnvire(img)){  
				            img = aligendEnvireService.getWechatid(img.getId());
				            request.setAttribute("img", img);  
				            return "/editEnvire";  
				        }else{  
				            return "/error";  
				        } 
			    } 
	
}
