package com.zjkj.wxy.core.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.PresidentEmail;
import com.zjkj.wxy.core.service.PrincipalMailboxService;


@Controller
public class PrincipalMailboxController {

	//spring 资源注入
			@Resource
			private PrincipalMailboxService principalMailboxService;

			
			public PrincipalMailboxService getPrincipalMailboxService() {
				return principalMailboxService;
			}

			public void setPrincipalMailboxService(
					PrincipalMailboxService principalMailboxService) {
				this.principalMailboxService = principalMailboxService;
			}

			
			      
			    @RequestMapping("/getAllPrincipalMailbox")  
			    public String getPrincipalMailbox(HttpServletRequest request){  
			        List<PresidentEmail> presidentEmails = principalMailboxService.presidentEmaillList();
			          
			        request.setAttribute("presidentEmails", presidentEmails);  
			          
			        return "/getAllPrincipalMailbox";  
			    }  
			      
			    
			    @RequestMapping("/getPrincipalMailbox")  
			    public String getRecipes(int id,HttpServletRequest request){  
			    	PresidentEmail presidentEmail = principalMailboxService.getPresidentEmail(id);
			          
			        request.setAttribute("presidentEmail", presidentEmail);  
			        return "/editpresidentEmail";  
			    }  
			      
			       
			        @RequestMapping("/updatePrincipalMailbox")  
				    public String updatePrincipalMailbox(PresidentEmail presidentEmail,HttpServletRequest request){  
				        if(principalMailboxService.updatePresidentEmail(presidentEmail)){  
				        	presidentEmail = principalMailboxService.getPresidentEmail(presidentEmail.getId());
				            request.setAttribute("presidentEmail", presidentEmail);  
				            return "/editPresidentEmail";  
				        }else{  
				            return "/error";  
				        } 
			    } 
	
}
