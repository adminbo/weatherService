package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Authentication;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.GradeClass;
import com.zjkj.wxy.core.domain.GradeClassId;
import com.zjkj.wxy.core.domain.Invoice;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.Subject;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeClassService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.StudentService;
import com.zjkj.wxy.core.service.SubjectService;
import com.zjkj.wxy.core.utils.POIUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



@Controller
@RequestMapping("/grade")
public class GradeController {
	@Resource
	private GradeService gradeService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private ClassesService classesService;
	@Resource
	private StudentService studentService;
	@Resource
	private GradeClassService gradeClassService;
	@Resource
	private SubjectService subjectService;
	
	//点击教务管理显示默认页
	
	@RequestMapping("/toGrade.do") 
	public String getGrade(Integer id,Integer sid,HttpServletRequest request,HttpSession session,Model model){
		User loginUser = (User) session.getAttribute("loginUser");
		List<Grade> findBySid = null;
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
			    findBySid = gradeService.findBySid(sid);
			    for (Grade g : findBySid) {
					List<Classes> list =classesService.getClasses(g);
					g.setClasses(list);
				}
			}
		}else{
			sid=schoolid;	
			findBySid = gradeService.findBySid(sid);
			for (Grade g : findBySid) {
				List<Classes> list =classesService.getClasses(g);
				g.setClasses(list);
			}
		}
		request.setAttribute("schoolid", sid);
		model.addAttribute("grades", findBySid);
		return "/administration_management/grade/grade";
		
	}
	//修改年级
//	@RequestMapping("/updateGrade.do")
//	public String updateGrade(BigDecimal id,String rname,HttpServletResponse response,Grade grade){
//		response.setCharacterEncoding("utf-8");
//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.setExcludes(new String[]{"gradeClasses","subGrades","school"});
//		//得到要修改的年级
//	    Grade grades = gradeService.findById(id);
//	    grades.setName(rname);
//	    //修改
//	    gradeService.update(grades);
//	    try {
//			JSONObject jsonObject = JSONObject.fromObject(grade,jsonConfig);
//			response.getWriter().print(jsonObject.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    return "redirect:/grade/toGrade.do";
//	}
	//新增年级
	@RequestMapping("/saveGrade.do")
	public String saveGrade(HttpSession session,Integer sid,String rname,HttpServletResponse response){
	    User user = (User) session.getAttribute("loginUser");
	 //   School school = user.getSchool();
	    Integer schoolid = user.getSid();
	    if(schoolid==null){
	    	Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School findById = schoolService.findById(sid);
				Grade grade = new Grade();
				//新增年级
				grade.setSchool(findById);
				grade.setName(rname);
			    gradeService.save(grade);
			}
		}else{
			sid=schoolid;	
			School findById = schoolService.findById(sid);
			Grade grade = new Grade();
			//新增年级
			grade.setSchool(findById);
			grade.setName(rname);
		    gradeService.save(grade);
		}  
	    return "redirect:/grade/toGrade.do";
	}
	//是否删除年级
	@RequestMapping("/isdelete.do")
	public void isdelete(Integer id,Integer sid,HttpServletResponse response,HttpSession session,Grade grade){
		response.setCharacterEncoding("utf-8");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"gradeClasses","subGrades","school"});
		//得到学校
		User loginUser = (User) session.getAttribute("loginUser");
	    Grade grades = gradeService.findById(id);
//	    Integer schoolid = loginUser.getSid();
//	    if(schoolid==null){
//			if(sid!=null){
//				School findById = schoolService.findById(sid);
//				grades.setSchool(findById);
//			}
//		}else{
//			sid=schoolid;	
//			School findById = schoolService.findById(sid);
//			grades.setSchool(findById);
//		}  
	    
	    List<Subject> sub = subjectService.getSubject(grades);
	    if(sub.size()>0){
	    	try {
				response.getWriter().print(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //查询是否有班级
	    List<Classes> c = classesService.findByGrade(id);
	    if(c.size()>0){
	    	try {
				response.getWriter().print(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else{
	    	try {
	 			response.getWriter().print(0);
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	    }   
	   
	}
	
	//删除年级
	@RequestMapping("/deleteGrade.do")
	public String deleteGrade(HttpSession session,Integer id,Integer sid,HttpServletResponse response,Grade grade){
		User loginUser = (User) session.getAttribute("loginUser");
	//	School school =  loginUser.getSchool();
		Integer schoolid = loginUser.getSid();
	    if(schoolid==null){
	    	Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School findById = schoolService.findById(sid);
				Grade grades = gradeService.findById(id);
			    grades.setSchool(findById);
			    Set<GradeClass> classes = grades.getGradeClasses();
			    for (GradeClass gradeClass : classes) {
			    	gradeClass.setClasses(null);
				}
			    gradeService.delete(grades);
			}
		}else{
			sid=schoolid;	
			School findById = schoolService.findById(sid);
			Grade grades = gradeService.findById(id);
		    grades.setSchool(findById);
		    Set<GradeClass> classes = grades.getGradeClasses();
		    for (GradeClass gradeClass : classes) {
		    	gradeClass.setClasses(null);
			}
		    gradeService.delete(grades);
		}  
	    
	    return "redirect:/grade/toGrade.do";
	}
	
	
	//是否删除班级
	@RequestMapping("/isdeleteCl.do")
	public void deleteClasses(HttpServletResponse response,HttpSession session,Integer id,Integer gid) throws IOException{
//		User loginUser = (User) session.getAttribute("loginUser");
//		School school =  loginUser.getSchool();
//		DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
//	    criteria.add(Restrictions.eq("school", school));
//	    List<Grade> grades = gradeService.findByCriteria(criteria);
//	   // Integer gid = grades.getId();
		List<Student> student = studentService.getStudent(id,gid);//有学生不能删
		Classes classes = classesService.findById(id);
		Set<GradeClass> gradeClasses = classes.getGradeClasses();//有关系不能删
		if(student.size()>0 || gradeClasses.size()>0 ){
				response.getWriter().print(0);
		}else{
			response.getWriter().print(1);
		}
		
	}
	
	@RequestMapping("/deleteClasses.do")
	public String deleteClass(HttpSession session,Integer id){
		//得到学校
	//	User loginUser = (User) session.getAttribute("loginUser");
	//	School school =  loginUser.getSchool();
		Classes classes = classesService.findById(id);
//		Set<GradeClass> gradeClasses = classes.getGradeClasses();
//		for (GradeClass gradeClass : gradeClasses) {
//			Grade grade = gradeClass.getGrade();
//			grade.setSchool(school);	
//			gradeClassService.delete(gradeClass);
//		}
//		classes.setGradeClasses(gradeClasses);
		classesService.delete(classes);
		return "redirect:/grade/toGrade.do";
	}
	
	//新增班级
	@RequestMapping("/saveClasses.do")
	public String saveClasses(Integer id,HttpSession session,String cname){
		User user = (User) session.getAttribute("loginUser");
	    Grade grade = gradeService.findById(id);   	
//    	Integer schoolid = user.getSid();
// 	    if(schoolid==null){
// 			if(sid!=null){
// 				School findById = schoolService.findById(sid);
// 				grade.setSchool(findById);
// 			}
// 		}else{
// 			sid=schoolid;	
// 			School findById = schoolService.findById(sid);
// 			grade.setSchool(findById);
// 		}  
	    Classes classes = new Classes();
	    classes.setName(cname);
	    GradeClass cl = new GradeClass();
	    GradeClassId gci = new GradeClassId();
	    
	    gci.setGrade(grade);
	    gci.setClasses(classes);
	    cl.setGrade(grade);
	    cl.setClasses(classes);
	    cl.setId(gci);
	    classesService.save(classes, cl);
	    return "redirect:/grade/toGrade.do";
	}
	
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
		    			
		    			Sheet sheet1 = workbook.getSheetAt(1);
		    			School ss =schoolService.findByNameAndAddr(name,address);
		    			Map<String ,String> gc = new HashMap<>();
		    			for (Row row : sheet1) {
//		******************************************************************  
		    				int rowNum = row.getRowNum();
		    				if (rowNum == 0||rowNum==1) {
		    					// 第1\2行为文件的标题行，忽略
		    					continue;
		    				}
		    				//导入年级结构
		    				String cname = row.getCell(1).getStringCellValue();//banji名称
		    				String gname = row.getCell(0).getStringCellValue();//nianji名称
		    				gc.put(gname+"/"+rowNum, cname);
		    				if(!grades.contains(gname)){
		    					grades.add(gname);
		    				}
		    				if(!clazzs.contains(cname)){
		    					clazzs.add(cname);
		    				}
							
						}
		    			for (String string : clazzs) {
		    				Classes cc = new Classes();
		    				cc.setName(string);
		    				classesService.save(cc);
		    			}
		    			for (String string : grades) {
		    				Grade g = new Grade();
		    				g.setName(string);
		    				g.setSchool(ss);
		    				gradeService.save(g);
		    			}
		    			Set<Entry<String, String>> entrySet = gc.entrySet();
		    			for (Entry<String, String> entry : entrySet) {
							String key = entry.getKey();
							String value = entry.getValue();
							String grade=key.split("/")[0];
							Grade g = gradeService.findByNameAndSid(grade, ss.getId());
							Classes clazz = classesService.findClassByName(value);
							GradeClass gradeclass = new GradeClass();
							gradeclass.setGrade(g);
							gradeclass.setClasses(clazz);
							gradeClassService.save(gradeclass );
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
