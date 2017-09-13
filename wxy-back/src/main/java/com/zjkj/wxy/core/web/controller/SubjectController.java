package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.SubGrade;
import com.zjkj.wxy.core.domain.Subject;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.SubGradeService;
import com.zjkj.wxy.core.service.SubjectService;
import com.zjkj.wxy.core.utils.POIUtils;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Resource
	private SubjectService subjectService;
	@Resource
	private GradeService gradeService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private SubGradeService subGradeService;
	
	@RequestMapping("/toSubject.do") 
	public String toSubject(Integer sid,HttpSession session,Model model,HttpServletRequest request){
		User loginUser = (User) session.getAttribute("loginUser");
		List<Grade> grades = null;
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
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
		//School school = loginUser.getSchool();
		model.addAttribute("grades", grades);	
		request.setAttribute("schoolid", sid);
		return "/administration_management/subject/subject";
	}
	
	//或得每个年级的学科
	@RequestMapping("/getSubject.do")
	public void getSubject(Integer id,HttpServletResponse response,HttpSession session){
		//设置编码
		response.setCharacterEncoding("utf-8");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"school","grades"});
		Grade grade = gradeService.findById(id);
		List<Subject> subject = subjectService.getSubject(grade);
		try {
			JSONArray jsonArray = JSONArray.fromObject(subject,jsonConfig);
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("saveSubject.do")
	public String saveSubject(HttpSession session,Integer sid,String sname,Integer id){
//		try {
//			if(sname!=null){
//				sname = new String(sname.getBytes("iso8859-1"),"utf-8");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		Subject sub = new Subject();
        sub.setName(sname);
        subjectService.save(sub);
        
		User loginUser  = (User) session.getAttribute("loginUser");
	//	School school = loginUser.getSchool();
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School findById = schoolService.findById(sid);
				Grade grade = gradeService.findById(id);
				grade.setSchool(findById);
				grade.getSubjects().add(sub);
				try {
					gradeService.save(grade);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}else{
			sid=schoolid;	
			School findById = schoolService.findById(sid);
			Grade grade = gradeService.findById(id);
			grade.setSchool(findById);
			grade.getSubjects().add(sub);
			try {
				gradeService.save(grade);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "redirect:/subject/toSubject.do";
	}
	
	@RequestMapping("/deleteSubject")
	public String deleteSub(HttpSession session,Integer sid,Integer id,Integer gid){
		//得到学校
		User loginUser = (User) session.getAttribute("loginUser");
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School findById = schoolService.findById(sid);
				Subject subject = subjectService.findById(id);
				Grade grade = gradeService.findById(gid);
				grade.setSchool(findById);
				grade.getSubjects().remove(subject);
				try {
					subjectService.delete(subject);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}else{
			sid=schoolid;
			School findById = schoolService.findById(sid);
			Subject subject = subjectService.findById(id);
			Grade grade = gradeService.findById(gid);
			grade.setSchool(findById);
			grade.getSubjects().remove(subject);
			try {
				subjectService.delete(subject);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "redirect:/subject/toSubject.do";
	}
	/**
	 * 导入学科
	 * @param upfile
	 * @param model
	 * @param response
	 */
	@RequestMapping("/import.do")
	public void portSchool(MultipartFile upfile,Model model,HttpServletResponse response) {
    	response.setCharacterEncoding("utf-8");
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	try {
	    	if(upfile!=null){
	    		String filename = upfile.getOriginalFilename();//上传文件名称
	    		
	    		if(!filename.endsWith("xls") && !filename.endsWith("xlsx")){
						response.getWriter().print(-1);//上传文件不是表格文件
	    		}else{
	    			//获取上传文件输入流
	    			InputStream inputStream = upfile.getInputStream();
	    			//获得工作空间
	    			Workbook workbook = POIUtils.getImportWorkbook(inputStream, filename);
	    			// 加载第一个sheet页
	    			Sheet sheet = workbook.getSheetAt(0);
	    			List<String> grades = new ArrayList<>();
	    			List<String> clazzs = new ArrayList<>();
	    			String name=null;
	    			String address=null;
	    			for (Row row : sheet) {
	    				int rowNum = row.getRowNum();
	    				if (rowNum == 0||rowNum==1) {
	    					// 第1\2行为文件的标题行，忽略
	    					continue;
	    				}
//***********************************************************************	
	    				// 获得当前行的某一列
	    				name = row.getCell(0).getStringCellValue();//名称
	    				String s1 = row.getCell(3).getStringCellValue();//省
	    				String s2 = row.getCell(4).getStringCellValue();//市
	    				String s3 = row.getCell(5).getStringCellValue();//区
	    				address = s1+"/"+s2+"/"+s3;
	    			}    
	    			
	    			School ss =schoolService.findByNameAndAddr(name,address);
	    			Sheet sheet1 = workbook.getSheetAt(2);
	    			List<String> sus=new ArrayList<>();
	    			Map<String,String> sg = new HashMap<>();
	    			for (Row row : sheet1) {
//	******************************************************************  
	    				int rowNum = row.getRowNum();
	    				if (rowNum == 0||rowNum==1) {
	    					// 第1\2行为文件的标题行，忽略
	    					continue;
	    				}
		    				String gradename = row.getCell(0).getStringCellValue();//nianji
		    				String subjectname = row.getCell(1).getStringCellValue();//xueke
		    				sg.put(gradename, subjectname);
		    				String[] subjectnames = subjectname.split("、");
		    				for (String string : subjectnames) {
		    					if(!sus.contains(string)){
		    						sus.add(string);
		    					}
							}
	    			}
	    			for (String string : sus) {
	    				Subject s = new Subject();
						s.setName(string);
						Subject findByName = subjectService.findByName(string);
						if(findByName==null){
							subjectService.save(s);
						}
					}
	    			Set<Entry<String, String>> entrySet = sg.entrySet();
	    			for (Entry<String, String> entry : entrySet) {
						String gradename =entry.getKey();
						String value = entry.getValue();
						String[] split = value.split("、");
						Grade grad = gradeService.findByNameAndSid(gradename,ss.getId());
						for(int i =0;i<split.length;i++){
							Subject s =subjectService.findByName(split[i]);
							SubGrade gs = new SubGrade();
							gs.setGrade(grad);
							gs.setSubject(s);
							subGradeService.save(gs);
						}
					}
	    			inputStream.close();//关
	    			response.getWriter().print(1);//success
	    		}
	    	}else{
	    		response.getWriter().print(2);//success
	    	}
	    	
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

}
