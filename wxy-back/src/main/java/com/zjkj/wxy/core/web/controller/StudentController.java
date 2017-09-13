package com.zjkj.wxy.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.StudentService;
import com.zjkj.wxy.core.utils.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/student")
public class StudentController {
	//离线查询对象
	protected DetachedCriteria detachedCriteria=null;
	//分页查询对象
	protected PageBean pageBean=new PageBean();
	@Resource
	private StudentService studentService;
	@Resource
	private GradeService gradeService;
	@Resource
	private SchoolService schoolService; 
	@Resource
	private ClassesService classesService;
	//分页查询，模糊查询
		@RequestMapping("/listStudent.do")  
	    public String listStudent(Integer currentPage,Integer pageSize,Model model,
	    		String name,Integer sid,Integer show,HttpSession session){  
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
				return "/administration_management/student/student_info";	
	    }
		//进入展示页面
		@RequestMapping("/showStudent.do")
		public String getStudent(HttpSession session,HttpServletRequest request,Integer id,Model model){
			
			Student student = studentService.findById(id);
			Integer grade = student.getGrade();
			Grade gra = gradeService.findById(grade);
			Integer classid = student.getClassid();
			Classes cla = classesService.findById(classid);
			model.addAttribute("gra", gra);
			model.addAttribute("cla", cla);
			request.setAttribute("student", student);
			return "/administration_management/student/student_look";
		}

		//学生信息假删
		@RequestMapping(value="/deleteStudent.do")
		public String deleteStudent(Integer id){
			studentService.deleteById(id);
			return "redirect:/student/listStudent.do";
		}
		//跳转到要修改的页面
		@RequestMapping("/toUpdateStudent.do")  
		public String toUpdateStudent(Integer sid,HttpSession session,HttpServletRequest request,Integer id,Model model){
			User loginUser = (User) session.getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			 if(schoolid==null){
			    	Object schlid = session.getAttribute("SCHOOLID");
					schoolid = Integer.parseInt(String.valueOf(schlid));
					sid=schoolid;
					if(sid!=null){
						School findById = schoolService.findById(sid);
						DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
						criteria.add(Restrictions.eq("school",findById));
						List<Grade> grades = gradeService.findByCriteria(criteria);
						Student students = studentService.findById(id);
						Integer gradeid = students.getGrade();
						Grade findBygraId = gradeService.findById(gradeid);//现在所在年级
						Integer classid = students.getClassid();
						Classes findByclaId = classesService.findById(classid);//现在所在班级
						List<Classes> classes = classesService.findAll();
						model.addAttribute("classes", classes);
						request.setAttribute("student", students);
						model.addAttribute("grades", grades);
						model.addAttribute("student", students);
						model.addAttribute("gra", findBygraId);
						model.addAttribute("cla", findByclaId);
					}
				}else{
					sid=schoolid;
					School findById = schoolService.findById(sid);
					DetachedCriteria criteria = DetachedCriteria.forClass(Grade.class);
					criteria.add(Restrictions.eq("school",findById));
					List<Grade> grades = gradeService.findByCriteria(criteria);
					Student students = studentService.findById(id);
					Integer gradeid = students.getGrade();
					Grade findBygraId = gradeService.findById(gradeid);//现在所在年级
					Integer classid = students.getClassid();
					Classes findByclaId = classesService.findById(classid);//现在所在班级
					List<Classes> classes = classesService.findAll();
					model.addAttribute("classes", classes);
					request.setAttribute("student", students);
					model.addAttribute("grades", grades);
					model.addAttribute("student", students);
					model.addAttribute("gra", findBygraId);
					model.addAttribute("cla", findByclaId);
				}
			
			return "/administration_management/student/student_update";
		}
		//修改学生信息
		@RequestMapping("/updateStudent.do")  
		public String pdateStudent(Integer sid,MultipartFile fileName,HttpServletRequest request,HttpSession session,Student student){
			String imgurl = null;
			String path = null;
			try {
			if(fileName!=null){
				String filename=fileName.getOriginalFilename();
				String realPath = request.getSession().getServletContext().getRealPath("/");
				realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
				realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
				String trueFileName=String.valueOf(System.currentTimeMillis())+filename;
				path=realPath+File.separator+"uploadImg"+File.separator+"studentImg"+File.separator+trueFileName;
			    imgurl = File.separator+"uploadImg"+File.separator+"studentImg"+File.separator+trueFileName;
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
			//Grade grade = gradeService.findById(sid);
			User loginUser =(User) session.getAttribute("loginUser");
			//Integer sid = loginUser.getSid();//所属学校id
			//School school = schoolService.findById(sid);
			Integer schoolid = loginUser.getSid();
			if(schoolid==null){
		    	Object schlid = session.getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					School findById = schoolService.findById(sid);
					String cl = request.getParameter("classid");
					int classid = Integer.parseInt(cl);
					String gra = request.getParameter("grade");
					int graid = Integer.parseInt(gra);
					student.setImgurl(imgurl);
					student.setIsshow(1);
					student.setGrade(graid);
					//student.setClassid(cid);
					student.setSchool(findById);
					student.setClassid(classid);
					studentService.update(student);
				}
			}else{
				sid=schoolid;
				School findById = schoolService.findById(sid);
				String cl = request.getParameter("classid");
				int classid = Integer.parseInt(cl);
				String gra = request.getParameter("grade");
				int graid = Integer.parseInt(gra);
				student.setImgurl(imgurl);
				student.setIsshow(1);
				student.setGrade(graid);
				//student.setClassid(cid);
				student.setSchool(findById);
				student.setClassid(classid);
				studentService.update(student);
			}
			
			return "redirect:/student/listStudent.do";
		}
		//跳转到新增页面
		@RequestMapping("/toAddStudent.do")
		public String toAddStudent(HttpSession session,Model model,Integer sid){
			List<Grade> grades = null;
			User loginUser = (User) session.getAttribute("loginUser");
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
				    for (Grade grade : grades) {
				    	Integer gid = grade.getId();
				    	List<Classes> classes = classesService.findByGrade(gid);
					    model.addAttribute("classes", classes);
					}
					model.addAttribute("grades", grades);
				}
			}else{
				sid=schoolid;
				School findById = schoolService.findById(sid);
				DetachedCriteria criterias = DetachedCriteria.forClass(Grade.class);
				criterias.add(Restrictions.eq("school",findById));
			    grades = gradeService.findByCriteria(criterias);
			    for (Grade grade : grades) {
			    	Integer gid = grade.getId();
			    	List<Classes> classes = classesService.findByGrade(gid);
			    	model.addAttribute("classes", classes);
				}
				model.addAttribute("grades", grades);
			}
		    //通过学校查年级
		   
			return "/administration_management/student/student_add";
		}
		//新增学生信息
		@RequestMapping("/addStudent.do")
		public String AddStudent(MultipartFile fileName,Integer sid, HttpSession session,HttpServletRequest request,Student student){
			String imgurl = null;
			String path = null;
			try {
			if(fileName!=null){
				String filename=fileName.getOriginalFilename();
				String realPath = request.getSession().getServletContext().getRealPath("/");
				realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
				realPath =realPath.substring(0,realPath.lastIndexOf(File.separator));
				String trueFileName=String.valueOf(System.currentTimeMillis())+filename;
				path=realPath+File.separator+"uploadImg"+File.separator+"studentImg"+File.separator+trueFileName;
			    imgurl = File.separator+"uploadImg"+File.separator+"studentImg"+File.separator+trueFileName;
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
			 //获取当前登录用户
			User loginUser =(User) session.getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			if(schoolid==null){
		    	Object schlid = session.getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					School findById = schoolService.findById(sid);
					student.setIsshow(1);
					student.setSchool(findById);
					student.setImgurl(imgurl);
					studentService.save(student);
				}
			}else{
				sid=schoolid;
				School findById = schoolService.findById(sid);
				student.setIsshow(1);
				student.setSchool(findById);
				student.setImgurl(imgurl);
				studentService.save(student);
			}
			
			return "redirect:/student/listStudent.do";
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
			Classes cla = null;
			if(classes!=null){
				for (Classes classes2 : classes) {
					String sname= classes2.getName();
					if("一班".equals(sname)){
						cla=classes2;
					}
				}
			}
			if(cla!=null){
				Integer cid = cla.getId();
				List<Student> studentOne = studentService.findStudentOne(cid);
				cla.setStudents(studentOne);				
			}
			try {
				JSONArray jsonArray = JSONArray.fromObject(classes,jsonConfig);
				response.getWriter().print(jsonArray.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		@RequestMapping("/getStudent.do")
		public void getStudent(Integer gid,Integer id,HttpServletResponse response,HttpSession session,
				Integer currentPage,Integer pageSize,Model model,
	    		String name,Integer isshow){
			//设置编码
			response.setCharacterEncoding("utf-8");
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"school","cards","leaves","attendances","scoreDetials","stuPars"});
				//得到第一个班级的学生
				List<Student> students = studentService.getStudent(id,gid);
				
				if(currentPage==null){
					currentPage=1;//默认第一页
				}
				if(pageSize==null){
					pageSize=10;//默认每页显示10条
				}
				pageBean.setCurrentPage(currentPage);
				pageBean.setPageSize(pageSize);
				//pageBean.getRows().clear();
				//pageBean.setRows(students);
				DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
				if(name!=null){
					criteria.add(Restrictions.like("name", "%"+name+"%"));
				}
				if(isshow!=null){
					criteria.add(Restrictions.eq("isshow", 1));
				}
				pageBean.setDetachedCriteria(criteria);
				studentService.pageQuery(pageBean);
			try {
				JSONArray jsonArray = JSONArray.fromObject(students,jsonConfig);
				response.getWriter().print(jsonArray.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@RequestMapping("/getAllStudent.do")
		public void getAllStudent(HttpServletResponse response,HttpSession session,Integer currentPage,Integer pageSize,String name,Integer isshow,Integer sid){
			response.setCharacterEncoding("utf-8");
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"school","cards","leaves","attendances","scoreDetials","stuPars"});
			List<Student> studentBySchool =null;
			User loginUser = (User) session.getAttribute("loginUser");
			Integer schoolid = loginUser.getSid();
			if(schoolid==null){
		    	Object schlid = session.getAttribute("SCHOOLID");
				schoolid = Integer.parseInt(String.valueOf(schlid));
				sid=schoolid;
				if(sid!=null){
					 studentBySchool = studentService.getStudentBySchool(sid);
				}
			}else{
				sid=schoolid;
			    studentBySchool = studentService.getStudentBySchool(sid);
			}
			if(currentPage==null){
				currentPage=1;//默认第一页
			}
			if(pageSize==null){
				pageSize=10;//默认每页显示10条
			}
			DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
			if(name!=null){
				criteria.add(Restrictions.like("name", "%"+name+"%"));
			}
			if(isshow!=null){
				criteria.add(Restrictions.eq("isshow", 1));
			}
			pageBean.setDetachedCriteria(criteria);
			studentService.pageQuery(pageBean);
			try {
				JSONArray jsonArray = JSONArray.fromObject(studentBySchool,jsonConfig);
				response.getWriter().print(jsonArray.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
}
