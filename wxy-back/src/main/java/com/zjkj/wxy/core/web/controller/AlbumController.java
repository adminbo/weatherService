package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Album;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Photo;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.AlbumService;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.PhotoService;
import com.zjkj.wxy.core.service.SchoolService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Resource
	private GradeService gradeService;
	@Resource
	private SchoolService schoolService; 
	@Resource
	private ClassesService classesService;
	@Resource
	private AlbumService albumService;
	@Resource
	private PhotoService photoService;
	
	@RequestMapping("/toAlbum.do")
	public String toAlbum(Model model,HttpSession session,Integer sid){
		 List<Grade> grades = null;
		    //获取当前登录用户
			User loginUser =(User) session.getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			if(schoolid==null){
				Object schlid = session.getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					School findById = schoolService.findById(sid);
					DetachedCriteria criterias = DetachedCriteria.forClass(Grade.class);
					criterias.add(Restrictions.eq("school",findById));
				    grades = gradeService.findByCriteria(criterias);
				}
			}else{
				sid=schoolid;	
				School findById = schoolService.findById(sid);
				DetachedCriteria criterias = DetachedCriteria.forClass(Grade.class);
				criterias.add(Restrictions.eq("school",findById));
			    grades = gradeService.findByCriteria(criterias);
			}
			model.addAttribute("grades", grades);
		return "administration_management/album/album";
	}
	@RequestMapping("/getClasses.do")
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
	
	@RequestMapping("/getAlbum.do")
	public void getAlbum(Integer id,Integer gid,HttpServletResponse response,HttpSession session,Integer sid){
		response.setCharacterEncoding("utf-8");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"cla","grade","school","photos"});
		//获取当前登录用户
		List<Album> findBySGCid = null;
		User loginUser =(User) session.getAttribute("loginUser");
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				findBySGCid = albumService.findBySGCid(id, sid, gid);
			}
		}else{
			sid=schoolid;	
			findBySGCid = albumService.findBySGCid(id, sid, gid);
		}
		
		try {
			JSONArray jsonArray = JSONArray.fromObject(findBySGCid,jsonConfig);
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getAllAlbum.do")
	public void getAllAlbum(HttpServletResponse response,HttpSession session,Integer sid){
		response.setCharacterEncoding("utf-8");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"cla","grade","school","photos"});
		List<Album> allAlbum = null;
		User loginUser =(User) session.getAttribute("loginUser");
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				allAlbum = albumService.getAllAlbum(sid);
			}
		}else{
			sid=schoolid;	
			allAlbum = albumService.getAllAlbum(sid);
		}
		try {
			JSONArray jsonArray = JSONArray.fromObject(allAlbum,jsonConfig);
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getphotoByAbid.do")
	public String getphotoByAbid(HttpSession session,Integer abid,Model model,String albumname,HttpServletRequest request){
		List<Photo> getphotoByAbid = photoService.getphotoByAbid(abid);
		model.addAttribute("photos", getphotoByAbid);
		model.addAttribute("album", albumname);
		return "administration_management/album/photoshow";
	}
	
	
}
