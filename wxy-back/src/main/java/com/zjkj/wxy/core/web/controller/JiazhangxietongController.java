package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.TakeAndSend;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.JiazhangXTService;
import com.zjkj.wxy.core.service.PeitaosheshiService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.utils.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/parent")
public class JiazhangxietongController {
	//spring 资源注入
	@Resource
	private JiazhangXTService jiaZhangXTService;
	@Resource
	private GradeService gradeService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private ClassesService classesService;
	      
	    @RequestMapping("/getAlljiazhangxietong")  
	    public String getAllPeitaosheshi(HttpServletRequest request,Model model,Integer sid){ 
	    	List<Grade> grades = null;
	    	User loginUser =(User)request.getSession().getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			if(schoolid==null){
		    	Object schlid = request.getSession().getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					School findById = schoolService.findById(sid);
					DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
					criteria.add(Restrictions.eq("school",findById));
					grades = gradeService.findByCriteria(criteria);
				}
			}else{
				sid=schoolid;	
				School findById = schoolService.findById(sid);
				DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
				criteria.add(Restrictions.eq("school",findById));
				grades = gradeService.findByCriteria(criteria);
			}
			model.addAttribute("grades",grades);
	        return "/jiazhangxietong/jiazhangxietong";
	    }  
	    
	    @RequestMapping("/getClass.do")
		public void getClasses(Integer id,HttpServletResponse response){
			//设置编码
			response.setCharacterEncoding("utf-8");
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"gradeClasses","school","cards","leaves","attendances","scoreDetials","stuPars"});
			Grade grade = gradeService.findById(id);
			//得到班级
			List<Classes> classes = classesService.findByGrade(id);
			
			try {
				JSONArray jsonArray = JSONArray.fromObject(classes,jsonConfig);
				response.getWriter().print(jsonArray.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    
	    @RequestMapping("/getJieSong.do")  
	    public void getJieSong(Integer id,Integer gid,Integer sid,HttpServletResponse response,HttpServletRequest request){
			//设置编码
			response.setCharacterEncoding("utf-8");
			JsonConfig jsonConfig = new JsonConfig();
			//jsonConfig.setExcludes(new String[]{""});
			List<TakeAndSend> findByCriteria = null;
			User loginUser =(User)request.getSession().getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			if(schoolid==null){
		    	Object schlid = request.getSession().getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					DetachedCriteria criteria = DetachedCriteria.forClass(TakeAndSend.class);
					criteria.add(Restrictions.eq("schid",sid));
					criteria.add(Restrictions.eq("gid",gid));
					criteria.add(Restrictions.eq("claid",id));
					findByCriteria =  jiaZhangXTService.findByCriteria(criteria);
				}
			}else{
				sid=schoolid;	
				DetachedCriteria criteria = DetachedCriteria.forClass(TakeAndSend.class);
				criteria.add(Restrictions.eq("schid",sid));
				criteria.add(Restrictions.eq("gid",gid));
				criteria.add(Restrictions.eq("claid",id));
				findByCriteria =  jiaZhangXTService.findByCriteria(criteria);
			}
			
			try {
				JSONArray jsonArray = JSONArray.fromObject(findByCriteria,jsonConfig);
				response.getWriter().print(jsonArray.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    
	    @RequestMapping("/toaddjiazhangxietong")  
	    public String toeditschoolmaster(){  
	        return "/tongxunlu/contact_add";  
	    } 
	    
	    @RequestMapping("/toshowjiazhangxietong")  
	    public String toshowjiazhangxietong(){  
	        return "/tongxunlu/contract_look";  
	    } 
	    
	    @RequestMapping("/toeditjiazhangxietong")  
	    public String toeditjiazhangxietong(){  
	        return "/tongxunlu/contract_revise";  
	    } 
}
