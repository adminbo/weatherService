package com.zjkj.wxy.core.web.controller;


import java.awt.GradientPaint;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Gratea;
import com.zjkj.wxy.core.domain.Parents;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.StuPar;
import com.zjkj.wxy.core.domain.StuParId;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.Subject;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.GrateaService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.SubjectService;
import com.zjkj.wxy.core.service.SystemRoleService;
import com.zjkj.wxy.core.service.TeacherService;
import com.zjkj.wxy.core.utils.POIUtils;
import com.zjkj.wxy.core.utils.PageBean;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	private Logger logger = Logger.getLogger(TeacherController.class);
	//离线查询对象
	protected DetachedCriteria detachedCriteria=null;
	
	@Resource
	private TeacherService teacherService;
	@Resource
	private GradeService gradeService;
	@Resource
	private SystemRoleService systemRoleService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private ClassesService classesService;
	@Resource
	private GrateaService grateaService;
	
	//分页查询，模糊查询
	@RequestMapping("/listTeacher.do")  
    public String listTeacher(Integer sid,Integer currentPage,Integer pageSize,Model model,
    		String num,String name,String entrytime,String subjectname,
    		String station,Integer isshow,Integer sex,HttpServletRequest request){  
		  //  PageBean pageBean=new PageBean("form1",request);
		 //   School school =null;
		    //获取当前登录用户
		//分页查询对象
		 PageBean pageBean=new PageBean(request);
			User loginUser =(User)request.getSession().getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			//默认展示学校
			if(schoolid==null){
				Object schlid = request.getSession().getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					School school = schoolService.findById(sid);
					//School school = loginUser.getSchool();//所属学校id
					if(currentPage==null){
						currentPage=1;//默认第一页
					}
					if(pageSize==null){
						pageSize=10;//默认每页显示10条
					}
					pageBean.setCurrentPage(currentPage);
					pageBean.setPageSize(pageSize);
					//设置离线查询条件
					detachedCriteria=DetachedCriteria.forClass(Teacher.class);
					if(num!=null){
						detachedCriteria.add(Restrictions.like("num", "%"+num+"%"));
						model.addAttribute("num", num);
					}
					if(sex!=null){
						detachedCriteria.add(Restrictions.eq("sex", sex));
						model.addAttribute("sex", sex);
					}if(name!=null){
						detachedCriteria.add(Restrictions.like("name", "%"+name+"%"));
						model.addAttribute("name", name);
					}if(entrytime!=null){
						detachedCriteria.add(Restrictions.like("entrytime", "%"+entrytime+"%"));
						model.addAttribute("entrytime", entrytime);
					}if(subjectname!=null){
						detachedCriteria.add(Restrictions.like("subjectname", "%"+subjectname+"%"));
						model.addAttribute("subjectname", subjectname);
					}if(station!=null){
						detachedCriteria.add(Restrictions.like("station", "%"+station+"%"));
						model.addAttribute("station", station);
					}if(school!=null){
						detachedCriteria.add(Restrictions.eq("school", school));	
						model.addAttribute("school", school);
					}
						detachedCriteria.add(Restrictions.eq("isshow",1));
						//角色(教师职务)
						//获取sid
					  //  User users = (User) request.getSession().getAttribute("loginUser");
					   // Integer shid = loginUser.getSid();
						DetachedCriteria criterias = DetachedCriteria.forClass(Role.class);
						criterias.add(Restrictions.eq("sid", sid));
						List<Role> role = systemRoleService.findByCriteria(criterias);
						//学科
						List<Subject> subjects = subjectService.findAll();
						//得到学校id
					   //通过学校查年级
					   
					pageBean.setDetachedCriteria(detachedCriteria);
					teacherService.pageQuery(pageBean);
					request.setAttribute("schoolid", sid);
					model.addAttribute("subject", subjects);
					model.addAttribute("role", role);
					model.addAttribute("pageBean", pageBean);
				}
			}else{
				sid=schoolid;
				School school = schoolService.findById(sid);
				//School school = loginUser.getSchool();//所属学校id
				if(currentPage==null){
					currentPage=1;//默认第一页
				}
				if(pageSize==null){
					pageSize=10;//默认每页显示10条
				}
				pageBean.setCurrentPage(currentPage);
				pageBean.setPageSize(pageSize);
				//设置离线查询条件
				detachedCriteria=DetachedCriteria.forClass(Teacher.class);
				if(num!=null){
					detachedCriteria.add(Restrictions.like("num", "%"+num+"%"));
					model.addAttribute("num", num);
				}
				if(sex!=null){
					detachedCriteria.add(Restrictions.eq("sex", sex));
					model.addAttribute("sex", sex);
				}if(name!=null){
					detachedCriteria.add(Restrictions.like("name", "%"+name+"%"));
					model.addAttribute("name", name);
				}if(entrytime!=null){
					detachedCriteria.add(Restrictions.like("entrytime", "%"+entrytime+"%"));
					model.addAttribute("entrytime", entrytime);
				}if(subjectname!=null){
					detachedCriteria.add(Restrictions.like("subjectname", "%"+subjectname+"%"));
					model.addAttribute("subjectname", subjectname);
				}if(station!=null){
					detachedCriteria.add(Restrictions.like("station", "%"+station+"%"));
					model.addAttribute("station", station);
				}if(school!=null){
					detachedCriteria.add(Restrictions.eq("school", school));	
					model.addAttribute("school", school);
				}
					detachedCriteria.add(Restrictions.eq("isshow",1));
					//角色(教师职务)
					//获取sid
				  //  User users = (User) request.getSession().getAttribute("loginUser");
				   // Integer shid = loginUser.getSid();
					DetachedCriteria criterias = DetachedCriteria.forClass(Role.class);
					criterias.add(Restrictions.eq("sid", sid));
					List<Role> role = systemRoleService.findByCriteria(criterias);
					//学科
					List<Subject> subjects = subjectService.findAll();
					//得到学校id
				   //通过学校查年级
				   
				pageBean.setDetachedCriteria(detachedCriteria);
				teacherService.pageQuery(pageBean);
				request.setAttribute("schoolid", sid);
				model.addAttribute("subject", subjects);
				model.addAttribute("role", role);
				model.addAttribute("pageBean", pageBean);
			}
			
			return "/administration_management/teacher/teacher_info";	
    }
	//跳转到添加页面
	@RequestMapping("/toAddteacher.do")  
    public String toAddTeacher(Integer sid,HttpSession session,Model model,Integer id,HttpServletRequest request){  
		List<Grade> grades = null;
		List<Role> roles = null;
		Set<Subject> subject = null;
		List<Classes> classes = null;
	    //获取sid
	    User user = (User) session.getAttribute("loginUser");
	 //   School school = user.getSchool();
	    Integer schoolid = user.getSid();
	    if(schoolid==null){
	    	Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School findById = schoolService.findById(sid);
				DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
				criteria.add(Restrictions.eq("school",findById));
				grades = gradeService.findByCriteria(criteria);
				DetachedCriteria criterias = DetachedCriteria.forClass(Role.class);
				criterias.add(Restrictions.eq("sid", sid));
				roles = systemRoleService.findByCriteria(criterias);
				for (Grade gra : grades) {
					List<Classes> list =classesService.getClasses(gra);
					gra.setClasses(list);
					subject = gra.getSubjects();
				    classes = gra.getClasses();
				}
			}
		}else{
			sid=schoolid;	
			School findById = schoolService.findById(sid);
			DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
			criteria.add(Restrictions.eq("school",findById));
			grades = gradeService.findByCriteria(criteria);
			DetachedCriteria criterias = DetachedCriteria.forClass(Role.class);
			criterias.add(Restrictions.eq("sid", sid));
			roles = systemRoleService.findByCriteria(criterias);
			for (Grade gra : grades) {
				List<Classes> list =classesService.getClasses(gra);
				gra.setClasses(list);
				subject = gra.getSubjects();
			    classes = gra.getClasses();
			}
		}
		model.addAttribute("subject", subject);
		model.addAttribute("classes", classes);
		model.addAttribute("roles", roles);
		model.addAttribute("grades",grades);
		request.setAttribute("schoolid", sid);
        return "/administration_management/teacher/teacher_add";  
    }
	//教师信息添加
	@RequestMapping("/addTeacher.do")   
    public String addTeacher(Integer sid,MultipartFile fileName,HttpSession session,Teacher teacher,HttpServletRequest request){ 
		String imgurl = null;
		String path = null;
		try {
		if(fileName!=null){
			String filename=fileName.getOriginalFilename();
			String realPath = request.getSession().getServletContext().getRealPath("/");
			realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
			realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
			String trueFileName=String.valueOf(System.currentTimeMillis())+filename;
			path=realPath+File.separator+"uploadImg"+File.separator+"teacherImg"+File.separator+trueFileName;
		    imgurl = File.separator+"uploadImg"+File.separator+"teacherImg"+File.separator+trueFileName;
		//构造文件
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			//上传
			fileName.transferTo(file);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		User loginUser =(User) session.getAttribute("loginUser");
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School school = schoolService.findById(sid);
				teacher.setIsshow(1);	
				teacher.setImgurl(imgurl);
				teacher.setSchool(school);
				teacherService.save(teacher);
				Gratea gratea = new Gratea();
				gratea.setGrade(teacher.getGradeid());
				gratea.setClazz(teacher.getClassid());
				gratea.setTeacher(teacher.getId());
				gratea.setSchoolId(teacher.getSchool().getId());
				Subject subjectname = subjectService.findByName(teacher.getSubjectname());
				Integer subid = subjectname.getId();
				gratea.setSubject(subid);
				grateaService.save(gratea);
			}
		}else{
			sid=schoolid;	
			School school = schoolService.findById(sid);
			teacher.setIsshow(1);	
			teacher.setImgurl(imgurl);
			teacher.setSchool(school);
			teacherService.save(teacher);
			Gratea gratea = new Gratea();
			gratea.setGrade(teacher.getGradeid());
			gratea.setClazz(teacher.getClassid());
			gratea.setTeacher(teacher.getId());
			gratea.setSchoolId(teacher.getSchool().getId());
			Subject subjectname = subjectService.findByName(teacher.getSubjectname());
			Integer subid = subjectname.getId();
			gratea.setSubject(subid);
			grateaService.save(gratea);
		}
		
		return "redirect:/teacher/listTeacher.do"; 
    } 
	
	//删除教师信息
	@RequestMapping(value="/deleteTeacher.do")
	public String deleteTeacher(Integer id){
		//teacher.setIsshow(0);
		//System.out.println(teacher.getIsshow());
	     teacherService.deleteById(id);
		return "redirect:/teacher/listTeacher.do";
	}
	
	//根据id查询展现要修改的页面
	@RequestMapping("/toUpdateTeacher.do")  
    public String toupdateTeacher(Integer sid,HttpSession session,HttpServletRequest request,Integer id,Model model,
    		HttpServletResponse response){  
		List classes =null;
		Set subjects =null;
		List<Role> role = null;
		List<Grade> grades = null;
		Teacher teacher = teacherService.findById(id);
	    //获取sid
	    User user = (User) session.getAttribute("loginUser");
	   // School school = user.getSchool();
	    Integer schoolid = user.getSid();
	    if(schoolid==null){
	    	Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School findById = schoolService.findById(sid);
				DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
				criteria.add(Restrictions.eq("school",findById));
				grades = gradeService.findByCriteria(criteria);
				for (Grade gra : grades) {
					List<Classes> list =classesService.getClasses(gra);
					gra.setClasses(list);
					subjects = gra.getSubjects();
				    classes = gra.getClasses();
				}
				DetachedCriteria criterias = DetachedCriteria.forClass(Role.class);
				criterias.add(Restrictions.eq("sid", sid));
				role = systemRoleService.findByCriteria(criterias);
			}
		}else{
			sid=schoolid;	
			School findById = schoolService.findById(sid);
			DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
			criteria.add(Restrictions.eq("school",findById));
			grades = gradeService.findByCriteria(criteria);
			for (Grade gra : grades) {
				List<Classes> list =classesService.getClasses(gra);
				gra.setClasses(list);
				subjects = gra.getSubjects();
			    classes = gra.getClasses();
			}
			DetachedCriteria criterias = DetachedCriteria.forClass(Role.class);
			criterias.add(Restrictions.eq("sid", sid));
			role = systemRoleService.findByCriteria(criterias);
		}
//	    DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
//	    criteria.add(Restrictions.eq("school", school));
//		List<Grade> grade = gradeService.findByCriteria(criteria);
//		for (Grade gra : grade) {
//			List<Classes> list =classesService.getClasses(gra);
//			gra.setClasses(list);
//			subjects = gra.getSubjects();
//		    classes = gra.getClasses();
//		}
		//角色(教师职务)
	 //   Integer shid = user.getSid();
		
	    //学科
	 // 	List<Subject> subject = subjectService.findAll();
	  	//班级
	 // 	List<Classes> classes = classesService.findAll();
	  	model.addAttribute("subject", subjects);
	  	model.addAttribute("classes", classes);
		model.addAttribute("role", role);
		model.addAttribute("grade",grades);
		request.setAttribute("teacher", teacher);
		request.setAttribute("schoolid", sid);
        return "/administration_management/teacher/teacher_update";  
    }
	
	//教师信息修改保存
	@RequestMapping("/updateTeacher")
	public String updateTeacher(Integer sid,MultipartFile fileName,HttpServletRequest request,HttpSession session,Teacher teacher){	
		String imgurl = null;
		String path = null;
		try {
		if(fileName!=null){
			String filename=fileName.getOriginalFilename();
			String realPath = request.getSession().getServletContext().getRealPath("/");
			realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
			realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
			String trueFileName=String.valueOf(System.currentTimeMillis())+filename;
			path=realPath+File.separator+"uploadImg"+File.separator+"teacherImg"+File.separator+trueFileName;
		    imgurl = File.separator+"uploadImg"+File.separator+"teacherImg"+File.separator+trueFileName;
		//构造文件
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			//上传
			fileName.transferTo(file);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		teacher.setImgurl(imgurl);
		teacher.setIsshow(1);
		User loginUser =(User) session.getAttribute("loginUser");
		Integer schoolid = loginUser.getSid();
		if(schoolid==null){
			Object schlid = session.getAttribute("SCHOOLID");
			schoolid = Integer.parseInt(String.valueOf(schlid));
			sid=schoolid;
			if(sid!=null){
				School school = schoolService.findById(sid);
				teacher.setSchool(school);
				System.out.println(teacher);
				teacherService.update(teacher);
				List<Gratea> grateas = grateaService.findByTea(teacher.getId());
				for (Gratea gratea : grateas) {
					gratea.setSchoolId(sid);
					gratea.setGrade(teacher.getGradeid());
					gratea.setClazz(teacher.getClassid());
					Subject subjectname = subjectService.findByName(teacher.getSubjectname());
					Integer subid = subjectname.getId();
					gratea.setSubject(subid);
					grateaService.update(gratea);
				}
			}
		}else{
			sid=schoolid;	
			School school = schoolService.findById(sid);
			teacher.setSchool(school);
			System.out.println(teacher);
			teacherService.update(teacher);
			List<Gratea> grateas = grateaService.findByTea(teacher.getId());
			for (Gratea gratea : grateas) {
				gratea.setSchoolId(sid);
				gratea.setGrade(teacher.getGradeid());
				gratea.setClazz(teacher.getClassid());
				Subject subjectname = subjectService.findByName(teacher.getSubjectname());
				Integer subid = subjectname.getId();
				gratea.setSubject(subid);
				grateaService.update(gratea);
			}
			
		}
		//BigDecimal scid = new BigDecimal(sid);
		
		return "redirect:/teacher/listTeacher.do";
	}
	//根据id查询教师具体信息
	@RequestMapping("/showTeacher.do")  
    public String showTeacher(HttpSession session,HttpServletRequest request,Integer id,Model model){  
		Teacher teachers = teacherService.findById(id);
		Integer classid = teachers.getClassid();
		Classes clas = classesService.findById(classid);
		Integer gradeid = teachers.getGradeid();
		Grade grade = gradeService.findById(gradeid);
		request.setAttribute("cla", clas);
		request.setAttribute("grade", grade);
		request.setAttribute("teacher", teachers);
        return "/administration_management/teacher/teacher_look";  
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
	    			
	    			School ss =schoolService.findByNameAndAddr(name,address);
	    			Sheet sheet1 = workbook.getSheetAt(3);
	    			for (Row row : sheet1) {
//	******************************************************************  
	    				int rowNum = row.getRowNum();
	    				if (rowNum == 0||rowNum==1) {
	    					// 第1\2行为文件的标题行，忽略
	    					continue;
	    				}
	    				logger.info("行号==="+row.getRowNum());
	    				//任课
	    				Gratea gt = new Gratea();
	    				//导入教师
	    				Teacher tt = new Teacher();
	    				String tname = row.getCell(0).getStringCellValue();//教师名称
	    				String subject = row.getCell(3).getStringCellValue();//学科名称
	    				Subject sub = subjectService.findByName(subject);//查询学科
	    				if(sub!=null){
	    					gt.setSubject(sub.getId()); //任课学科
	    				}
	    				if(row.getCell(4)!=null){
	    					row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
	    					String phone = row.getCell(4).getStringCellValue();//电话
	    					tt.setPhonenum(phone);
	    				}
	    				String gradename = row.getCell(7).getStringCellValue();//nianji
	    				String clazzname = row.getCell(8).getStringCellValue();//banji
	    				String sex = row.getCell(10).getStringCellValue();//性别
	    				Grade grad = gradeService.findByNameAndSid(gradename,ss.getId());
	    				Classes findClassByName = classesService.findClassByName(clazzname);
	    				gt.setGrade(grad.getId()); //任课年级
	    				gt.setClazz(findClassByName.getId()); //任课班级
	    				gt.setSchoolId(ss.getId()); //任课学校
	    				tt.setIsshow(1);
	    				tt.setName(tname);
	    				if(grad!=null){
	    					tt.setGradeid(grad.getId());
	    				}
	    				if(findClassByName!=null){
	    					tt.setClassid(findClassByName.getId());
	    				}
	    				tt.setSchool(ss);
	    				if("女".equals(sex)){
	    					tt.setSex(2);
	    				}else{
	    					tt.setSex(1);
	    				}
	    				teacherService.save(tt);
	    				gt.setTeacher(tt.getId());
	    				grateaService.save(gt);
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
