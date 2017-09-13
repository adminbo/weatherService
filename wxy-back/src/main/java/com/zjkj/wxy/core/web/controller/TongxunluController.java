package com.zjkj.wxy.core.web.controller;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.Parents;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.StuPar;
import com.zjkj.wxy.core.domain.StuParId;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.ParentService;
import com.zjkj.wxy.core.service.PeitaosheshiService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.StuParService;
import com.zjkj.wxy.core.service.StudentService;
import com.zjkj.wxy.core.utils.POIUtils;

@Controller
public class TongxunluController {
	//spring 资源注入
	@Resource
	private PeitaosheshiService peiaosdservice;
	@Resource
	private GradeService gradeService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private ClassesService classesService;
	@Resource
	private StudentService studentService;
	@Resource
	private ParentService parentService;
	@Resource
	private StuParService stuParService;
	public PeitaosheshiService getPeiaosdservice() {
		return peiaosdservice;
	}



	public void setPeiaosdservice(PeitaosheshiService peiaosdservice) {
		this.peiaosdservice = peiaosdservice;
	}

	  
	      
	    @RequestMapping("/getAllTongxunlu")  
	    public String getAllPeitaosheshi(HttpServletRequest request,Model model){  
//	        List<Img> img = peiaosdservice.findAll();
//	        request.setAttribute("img", img);  
//	        model.addAttribute("img", img);
	        return "/tongxunlu/contact";
	    } 
	    
	    @RequestMapping("/studentParent/import.do")
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
			    			Sheet sheet1 = workbook.getSheetAt(4);
			    			for (Row row : sheet1) {
//			******************************************************************  
			    				int rowNum = row.getRowNum();
			    				if (rowNum == 0||rowNum==1) {
			    					// 第1\2行为文件的标题行，忽略
			    					continue;
			    				}
			    				//导入学生
			    				Student sss = new Student();
			    				String sname = row.getCell(0).getStringCellValue();//名称		
			    				String sex = row.getCell(2).getStringCellValue();//性别	
			    				String grade = row.getCell(6).getStringCellValue();//nianji	
			    				String clazz = row.getCell(7).getStringCellValue();//banji
			    				Grade grad = gradeService.findByNameAndSid(grade,ss.getId());
			    				Classes findClassByName = classesService.findClassByName(clazz);
			    				if(row.getCell(3)!=null){
			    					 row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			    					 String dateCellValue = row.getCell(3).getStringCellValue();
			    					 sss.setBirthday(dateCellValue);
			    				}
			    						sss.setGrade(grad.getId());
			    						sss.setClassid(findClassByName.getId());
			    						sss.setSchool(ss);
			    					sss.setName(sname);
			    					sss.setIsshow(1);
			    				if("男".equals(sex)){
			    					sss.setSex(1);
			    				}else{
			    					sss.setSex(0);
			    				}
			    				studentService.save(sss);
								
							}
			    			Sheet sheet2 = workbook.getSheetAt(5);
			    			for (Row row : sheet2) {
			    				int rowNum = row.getRowNum();
			    				if (rowNum == 0||rowNum==1) {
			    					// 第1\2行为文件的标题行，忽略
			    					continue;
			    				}
			    				//导入家长
			    				StuParId sp = new StuParId();
			    				Set st = new HashSet<>();
			    				StuPar ps = new StuPar();
			    				Parents pp = new Parents();
			    				String pname = row.getCell(0).getStringCellValue();//名称		
			    				String stuname = row.getCell(2).getStringCellValue();//学生名称		
			    				DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Student.class);
			    				if(row.getCell(4)!=null){
			    					 row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			    					 String dateCellValue = row.getCell(4).getStringCellValue();
			    					 detachedCriteria.add(Restrictions.eq("birthday", dateCellValue));
			    				System.out.println("生日="+dateCellValue);
			    				}
			    				detachedCriteria.add(Restrictions.eq("name", stuname));
			    				Student sss =studentService.findByCri(detachedCriteria);
			    				String relation = null;//与学生关系	
			    				if(pname.endsWith("妈")){
			    					relation="母亲";
			    					pp.setSex(2);
			    				}else{
			    					relation="父亲";
			    					pp.setSex(1);
			    				}
			    				if(row.getCell(6)!=null){
			    					 row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			    					 String phone = row.getCell(6).getStringCellValue();
			    					 System.out.println(phone);
			    					 pp.setPhonenum(phone);
			    				}
			    				pp.setName(pname);
			    				pp.setRelation(relation);
			    				pp.setIsfllow(0);//未关注
			    				pp.setCretime(System.currentTimeMillis());
			    				pp.setStuPars(st);
			    				parentService.save(pp);
			    				//System.out.println("222222222=="+pp.getId());
			    				System.out.println("==========================1");
			    				Parents ppp =parentService.getByPhone(pp.getPhonenum(),pp.getName());
			    				System.out.println("==========================2");
			    				sp.setStudent(sss);
			    				sp.setParents(ppp);
			    				ps.setId(sp);
			    				ps.setParents(ppp);
			    				ps.setStudent(sss);
			    				
			    				stuParService.save(ps);
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
