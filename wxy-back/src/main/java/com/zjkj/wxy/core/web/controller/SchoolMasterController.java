package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Agent;
import com.zjkj.wxy.core.domain.Authentication;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.Invoice;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Parents;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.StuPar;
import com.zjkj.wxy.core.domain.StuParId;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.Teacher;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AgentService;
import com.zjkj.wxy.core.service.AuthenticationObejectService;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.ConfigWxmanagementService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.InvoiceObejectService;
import com.zjkj.wxy.core.service.OperatorObejectService;
import com.zjkj.wxy.core.service.ParentService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.StuParService;
import com.zjkj.wxy.core.service.StudentService;
import com.zjkj.wxy.core.service.TeacherService;
import com.zjkj.wxy.core.service.WechatService;
import com.zjkj.wxy.core.utils.POIUtils;
import com.zjkj.wxy.core.utils.PageBean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
public class SchoolMasterController {

	//spring 资源注入
	@Resource
	private SchoolService schoolService;
	@Resource
	private GradeService gradeService;
	@Resource
	private ClassesService classesService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private StudentService studentService;
	@Resource
	private ParentService parentService;
	@Resource
	private StuParService stuParService;
	@Resource
	private WechatService wechatService;
	@Resource
	private OperatorObejectService operatorObejectService;
	@Resource
	private AuthenticationObejectService AuthenticationObejectService;
	@Resource
	private RegObejectService regObejectService;
	@Resource
	private InvoiceObejectService invoiceObejectService;
	@Resource
	private AgentService agentService;
	
	@Resource
	private ConfigWxmanagementService configWxmanagementService;

	public ConfigWxmanagementService getConfigWxmanagementService() {
		return configWxmanagementService;
	}

	public void setConfigWxmanagementService(
			ConfigWxmanagementService configWxmanagementService) {
		this.configWxmanagementService = configWxmanagementService;
	}

		// 离线查询对象
		protected DetachedCriteria detachedCriteria = null;
		// 分页查询对象
		protected PageBean pageBean ;

		public DetachedCriteria getDetachedCriteria() {
			return detachedCriteria;
		}

		public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
			this.detachedCriteria = detachedCriteria;
		}

		public PageBean getPageBean() {
			return pageBean;
		}

		public void setPageBean(PageBean pageBean) {
			this.pageBean = pageBean;
		}


	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
/**
 * 根据id查询学校信息
 * @param id
 * @param response
 * @return
 * @throws IOException 
 */

	@RequestMapping("/school/findById.do")
	public  void getSchoolById(String id,HttpServletResponse response) throws IOException{
		response.setContentType("text/json;charset=utf-8");
		School school = schoolService.findById(Integer.parseInt(id));
		Integer firagentid = school.getFiragentid();
		Integer secagentid = school.getSecagentid();
		if(firagentid!=null){
			Agent findById = agentService.findById(firagentid);
			if(findById!=null){
				school.setFname(findById.getName());
			}
		}
		if(secagentid!=null){
			Agent findById2 = agentService.findById(secagentid);
			if(findById2!=null){
				school.setSname(findById2.getName());
			}
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"eduschedules","monitors","imgDetails",
				"students","teachers","traits","agents","users","presidentEmails"
				,"grades","courses","trains","menus","recipeses","equipments"});
		JSONObject fromObject = JSONObject.fromObject(school,jsonConfig);
		String string = fromObject.toString();
		response.getWriter().print(string);
	}
	@RequestMapping("/toAddSchoolMaster")  
	    public String toAddSchoolMaster(){  
	        return "/toAddSchoolMaster";  
	    }  
	      /**
	       * 添加学校
	       * @param school
	       * @param province
	       * @param city
	       * @param districtAndCounty
	       * @return
	       */
	    @RequestMapping("/addSchool.do")// 请求url地址映射，类似Struts的action-mapping   
	    public String addWechar(School school,String province,String city,String districtAndCounty){  
//	    	System.out.println(school);
//	    	System.out.println(province);
//	    	System.out.println(city);
//	    	System.out.println(districtAndCounty);
	    	String address = province+"/"+city+"/"+districtAndCounty;
	    	school.setAddress(address);
	    	Date d = new Date();
	    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    	String format = df.format(d);
	    	school.setEntertime(format);
	    	schoolService.save(school);
	        return "redirect:/getAllSchoolMaster.do";  
	    }  
	    /**
	     * 更新
	     * @param s
	     * @param province
	     * @param city
	     * @param districtAndCounty
	     * @return
	     */
	    @RequestMapping("/school/update.do")
	    public String update(School s,String province,String city,String districtAndCounty){
	    	System.out.println(s);
	    	System.out.println(province);
	    	System.out.println(city);
	    	System.out.println(districtAndCounty);
	    	return "redirect:/getAllSchoolMaster.do";  
	    }
	    /**
	     * 根据id删除
	     * @param id
	     * @return
	     */
	    @RequestMapping("/school/deleteById.do")
	    public String delete(Integer id){
	    	schoolService.deleteById(id);
	    	 return "redirect:/getAllSchoolMaster.do";  
	    }
	    
	      /**
	       * 分页查询所有学校信息
	       * @return
	       */
	    @RequestMapping("/getAllSchoolMaster")  
	    public String getAllSchoolMaster(HttpServletRequest request,  
	    		Integer currentPage, Integer pageSize,HttpSession session,
				Model model,String sname,String wname,String province,String city,String districtAndCounty,
				Integer type,String time,Integer agentid1,Integer agentid2) {
	    	pageBean=new PageBean(request);
			// 获取当前登录用户
			User loginUser = (User) session.getAttribute("loginUser");
			if (currentPage == null) {
				currentPage = 1;// 默认第一页
			}
			if (pageSize == null) {
				pageSize = 10;// 默认每页显示10条
			}
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageSize(pageSize);
			// 设置离线查询条件
			detachedCriteria = DetachedCriteria.forClass(School.class);

			if(province!=null){
				detachedCriteria.add(Restrictions.like("address", "%"+province+"%"));
				model.addAttribute("province", province);
			}
			if(city!=null){
				detachedCriteria.add(Restrictions.like("address", "%"+city+"%"));
				model.addAttribute("city", city);
			}
			if(districtAndCounty!=null){
				detachedCriteria.add(Restrictions.like("address", "%"+districtAndCounty+"%"));
				model.addAttribute("districtAndCounty", districtAndCounty);
			}
			if(sname!=null){
				detachedCriteria.add(Restrictions.like("name", "%"+sname+"%"));
				model.addAttribute("sname", sname);
			}
			if(wname!=null){
				detachedCriteria.add(Restrictions.like("wechatName", "%"+wname+"%"));
				model.addAttribute("wname", wname);
			}
			if(time!=null){
				detachedCriteria.add(Restrictions.eq("entertime", time));
				model.addAttribute("time", time);
			}
			if(type!=null){
				detachedCriteria.add(Restrictions.eq("type", type));
				model.addAttribute("type", type);
			}
			if(agentid1!=null){
				detachedCriteria.add(Restrictions.eq("firagentid", agentid1));
				model.addAttribute("agentid1", agentid1);
			}
			if(agentid2!=null){
				detachedCriteria.add(Restrictions.eq("secagentid", agentid2));
				model.addAttribute("agentid2", agentid2);
			}
			
			pageBean.setDetachedCriteria(detachedCriteria);
			schoolService.pageQuery(pageBean);
			List<School> rows = pageBean.getRows();
			if(rows!=null && rows.size()>0){
				for (School s : rows) {
					Integer firagentid = s.getFiragentid();
					Integer secagentid = s.getSecagentid();
					if(firagentid!=null){
						Agent findById = agentService.findById(firagentid);
						if(findById!=null){
							s.setFname(findById.getName());
						}
					}
					if(secagentid!=null){
						Agent findById2 = agentService.findById(secagentid);
						if(findById2!=null){
							s.setSname(findById2.getName());
						}
					}
					
					
				}
			}
			model.addAttribute("pageBean", pageBean);
			return "/school/school_list";
	    }

//	    @RequestMapping("/delSchoolEnvire")  
//	    public void delUser(int id,HttpServletResponse response){  
//	        String result = "{\"result\":\"error\"}";  
//	        if(schoolEnvireService.deletschoolEnvire(id)){  
//	            result = "{\"result\":\"success\"}";  
//	        }  
//	        PrintWriter out = null;  
//	        response.setContentType("application/json");  
//	          
//	        try {  
//	            out = response.getWriter();  
//	            out.write(result);  
//	        } catch (IOException e) {  
//	            e.printStackTrace();  
//	        }  
//	          
//	    }  
//	      
//	    @RequestMapping("/getSchoolEnvireid")  
//	    public String getWechar(int id,HttpServletRequest request){  
//	    	Img img = schoolEnvireService.getWechatid(id);
//	          
//	        request.setAttribute("img", img);  
//	        return "/editSchoolEnvire";  
//	    }  
//	      
//	    @RequestMapping("/updateEnvireid")  
//	    public String updateEnvireid(Img img,HttpServletRequest request){  
//	        if(schoolEnvireService.updateEnvire(img)){  
//	            img = schoolEnvireService.getWechatid(img.getId());
//	            request.setAttribute("img", img);  
//	            return "/editEnvire";  
//	        }else{  
//	            return "/error";  
//	        }  
//	    }
	    
//	    @RequestMapping("/toeditschoolmaster")  
//	    public String toeditschoolmaster(){  
//	        return "/school/schooledit";  
//	    } 
//	    
//	    @RequestMapping("/toshowschoolmaster")  
//	    public String toshowschoolmaster(){  
//	        return "/school/schoolshow";  
//	    } 
	    
	    @RequestMapping("/school/import.do")
	    public void portSchool(MultipartFile upfile,Model model,HttpServletResponse response) {
	    	response.setCharacterEncoding("utf-8");
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
		    			for (Row row : sheet) {
		    				int rowNum = row.getRowNum();
		    				if (rowNum == 0||rowNum==1) {
		    					// 第1\2行为文件的标题行，忽略
		    					continue;
		    				}
	//***********************************************************************	    				
		    				//导入学校
//		    				School s = new School();
//		    				// 获得当前行的某一列
//		    				String name = row.getCell(0).getStringCellValue();//名称
//		    				String type = row.getCell(1).getStringCellValue();//类型 1幼教 2普教
//		    				String nature = row.getCell(2).getStringCellValue();//性质 1公办 2民办
//		    				String s1 = row.getCell(3).getStringCellValue();//省
//		    				String s2 = row.getCell(4).getStringCellValue();//市
//		    				String s3 = row.getCell(5).getStringCellValue();//区
//			    			String address = s1+"/"+s2+"/"+s3;
//			    			
//			    			s.setName(name);
//			    			s.setAddress(address);
//			    			if("幼教".equals(type)){
//			    				s.setType(1);
//			    			}else{
//			    				s.setType(2);
//			    			}
//			    			if("公办".equals(nature)){
//			    				s.setNature(1);
//			    			}else{
//			    				s.setNature(2);
//			    			}
////			    			s.setEntertime(System.currentTimeMillis());
//			    			System.out.println(s);
//			    			schoolService.save(s);
		    				
	//******************************************************************	    				
		    				//导入运营人
		    				Operator gg = new Operator();
		    				String op = row.getCell(21).getStringCellValue();//运营人
		    				String zw = row.getCell(22).getStringCellValue();//运营人职位
		    				String bm = row.getCell(23).getStringCellValue();//运营人部门
		    				row.getCell(25).setCellType(Cell.CELL_TYPE_STRING);
		    				String pn = row.getCell(25).getStringCellValue();//运营人手机号
		    				row.getCell(26).setCellType(Cell.CELL_TYPE_STRING);
		    				String wx= row.getCell(26).getStringCellValue();//运营人微信
		    				String oemail= row.getCell(27).getStringCellValue();//运营人微信
		    				String noid= row.getCell(28).getStringCellValue();//运营人shenfenz
		    				gg.setName(op);
		    				gg.setPosition(zw);
		    				gg.setDep(bm);
		    				gg.setPhonenum(pn);
		    				gg.setWechat(wx);
		    				gg.setCardnum(noid);
		    				gg.setEmail(oemail);
		    				operatorObejectService.save(gg);
	//******************************************************************	    				
		    				//导入微信公众号
//		    				Wechat w = new Wechat();
//			    			String wname = row.getCell(20).getStringCellValue();//公众号名称
//			    			String z= row.getCell(18).getStringCellValue();//注册类型
//			    			row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
//			    			String r= row.getCell(17).getStringCellValue();//认证类型
//			    			String regemail= row.getCell(14).getStringCellValue();//注册邮箱
//			    			if(row.getCell(15)!=null){
//		    					 row.getCell(15).setCellType(Cell.CELL_TYPE_NUMERIC);
//		    					 Date dateCellValue = row.getCell(15).getDateCellValue();
//		    					 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//		    					 String begin = sd.format(dateCellValue);
//		    					 w.setBegintime(begin);
//		    				}
//			    			if(row.getCell(16)!=null){
//			    				row.getCell(16).setCellType(Cell.CELL_TYPE_NUMERIC);
//			    				Date dateCellValue = row.getCell(16).getDateCellValue();
//			    				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//			    				String end = sd.format(dateCellValue);//到期时间
//			    			}
//			    			w.setAuthenstate(1);//已认证
//			    			w.setSchoolname(name);
//			    			w.setAdminname(op);
//			    			w.setSid(24);
//			    			w.setDeletestate(1);
//			    			w.setName(wname);
//			    			w.setOpname(op);
//			    			w.setAdminphonenum(pn);
//			    			w.setAdminwechat(wx);
//			    			w.setAdminidnum(noid);
//			    			if("企业".equals(z)){
//			    				w.setRegtype(1);
//			    			}else if("媒体".equals(z)){
//			    				w.setRegtype(2);
//			    			}else if("政府".equals(z)){
//			    				w.setRegtype(3);
//			    			}else{
//			    				w.setRegtype(4);
//			    			}
//			    			if("企业".equals(r)){
//			    				w.setAuthentype(1);
//			    			}else if("媒体".equals(r)){
//			    				w.setAuthentype(2);
//			    			}else if("政府".equals(r)){
//			    				w.setAuthentype(3);
//			    			}else{
//			    				w.setAuthentype(4);
//			    			}
//			    			w.setRegemail(regemail);
//			    			wechatService.save(w);
		//******************************************************************    				
		    				//导入注册认证发票信息
//		    				Reg reg = new Reg();//注册
//		    				Authentication au = new Authentication();//认证
//		    				Invoice i = new Invoice();
//		    				au.setOrgaddr(address);
//		    				String web = row.getCell(8).getStringCellValue();//官网
//		    				String dns = row.getCell(9).getStringCellValue();//域名
//		    				String info = row.getCell(10).getStringCellValue();//简介
//		    				String rep = row.getCell(11).getStringCellValue();//法人
//		    				row.getCell(24).setCellType(Cell.CELL_TYPE_STRING);
//		    				String pho = row.getCell(24).getStringCellValue();//座机
//		    				String regadd = row.getCell(29).getStringCellValue();//注册运营地区
//		    				String gns = row.getCell(29).getStringCellValue();//功能
//		    				String scope = row.getCell(31).getStringCellValue();//经营范围
//		    				String perscope = row.getCell(32).getStringCellValue();//2经营范围
//		    				row.getCell(33).setCellType(Cell.CELL_TYPE_STRING);
//		    				String bankId = row.getCell(33).getStringCellValue();//银行开户帐号
//		    				String uname = row.getCell(34).getStringCellValue();//开户名
//		    				String bankname = row.getCell(35).getStringCellValue();//开户银行
//		    				String add = row.getCell(36).getStringCellValue();//开户地点
//		    				//发票
//		    				String itype = row.getCell(37).getStringCellValue();//
//		    				String ititle = row.getCell(38).getStringCellValue();//
//		    				String icat = row.getCell(39).getStringCellValue();//
//		    				row.getCell(40).setCellType(Cell.CELL_TYPE_STRING);
//		    				String icatnum = row.getCell(40).getStringCellValue();//
//		    				String add1 = row.getCell(41).getStringCellValue();//
//		    				String add2 = row.getCell(42).getStringCellValue();//
//		    				row.getCell(43).setCellType(Cell.CELL_TYPE_STRING);
//		    				String ipcode = row.getCell(43).getStringCellValue();//
//		    				au.setOrgweb(web);
//		    				au.setOrgdns(dns);
//		    				au.setOrgintro(info);
//		    				au.setOrgrep(rep);
//		    				au.setOrgphonenum(pho);
//		    				au.setBusiscope(scope);
//		    				au.setPerscope(perscope);
//		    				au.setAccountid(bankId);
//		    				au.setAccountname(uname);
//		    				au.setBank(bankname);
//		    				au.setAccountaddr(add);
//		    				if("企业".equals(r)){
//			    				au.setType(1);
//			    			}else if("媒体".equals(r)){
//			    				au.setType(2);
//			    			}else if("政府".equals(r)){
//			    				au.setType(3);
//			    			}else{
//			    				au.setType(4);
//			    			}
//		    				String[] split = regadd.split("、");
//		    				reg.setOpcountry(split[0]);
//		    				reg.setOpprovince(split[0]);
//		    				reg.setOpcity(split[0]);
//		    				reg.setAccountid(bankId);
//		    				reg.setAccountname(uname);
//		    				reg.setAccountaddr(add);
//		    				reg.setBank(bankname);
//		    				if(itype!=null){
//		    					if("普通发票".equals(itype)){
//		    						i.setItype(1);
//		    					}else{
//		    						i.setItype(2);
//		    					}
//		    				}
//		    				i.setItitle(ititle);
//		    				i.setIcontact(icat);
//		    				i.setContactph0num(icatnum);
//		    				i.setPostaddr(add1+add2);
//		    				i.setPostcode(ipcode);
		    				
		    				
//		    				regObejectService.addregs(reg);
//		    				invoiceObejectService.addInvoice(i);
//		    				AuthenticationObejectService.addauthtication(au);
		//******************************************************************    				
		    				//导入年级结构
		    				String gname = row.getCell(0).getStringCellValue();//nianji名称
		    				String cname = row.getCell(1).getStringCellValue();//banji名称
		    				if(!grades.contains(gname)){
		    					grades.add(gname);
		    				}
		    				if(!clazzs.contains(cname)){
		    					clazzs.add(cname);
		    				}
		    				
	//******************************************************************
		    				//导入教师
//		    				Teacher tt = new Teacher();
//		    				String name = row.getCell(0).getStringCellValue();//名称
//		    				String phone = row.getCell(4).getStringCellValue();//电话
//		    				String sex = row.getCell(10).getStringCellValue();//性别
//		    				tt.setIsshow(1);
//		    				tt.setName(name);
//		    				tt.setPhonenum(phone);
//		    				if("女".equals(sex)){
//		    					tt.setSex(2);
//		    				}else{
//		    					tt.setSex(1);
//		    				}
//		    				teacherService.save(tt);
		    				
	//****************************************************************************************
		    				//导入学生
		    				Student sss = new Student();
//		    				String name = row.getCell(0).getStringCellValue();//名称		
//		    				String sex = row.getCell(2).getStringCellValue();//性别	
//		    				if(row.getCell(3)!=null){
//		    					 row.getCell(3).setCellType(Cell.CELL_TYPE_NUMERIC);
//		    					 Date dateCellValue = row.getCell(3).getDateCellValue();
//		    					 SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//		    					 sss.setBirthday(s.format(dateCellValue) );//生日
//		    				}
//		    						
//		    					sss.setName(name);
//		    					sss.setIsshow(1);
//		    				if("男".equals(sex)){
//		    					sss.setSex(1);
//		    				}else{
//		    					sss.setSex(0);
//		    				}
//		    				studentService.save(sss);
	//****************************************************************************************	    				
		    				//导入家长
//		    				StuParId sp = new StuParId();
//		    				Set st = new HashSet<>();
//		    				StuPar ps = new StuPar();
//		    				Parents pp = new Parents();
//		    				String name = row.getCell(0).getStringCellValue();//名称		
//		    				String stuname = row.getCell(1).getStringCellValue();//学生名称		
//		    				DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Student.class);
//		    				if(row.getCell(3)!=null){
//		    					 row.getCell(3).setCellType(Cell.CELL_TYPE_NUMERIC);
//		    					 Date dateCellValue = row.getCell(3).getDateCellValue();
//		    					 SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//		    					 String format = s.format(dateCellValue);
//		    					 detachedCriteria.add(Restrictions.eq("birthday", format));
//		    				}
//		    				detachedCriteria.add(Restrictions.eq("name", stuname));
//		    				Student sss =studentService.findByCri(detachedCriteria);
//		    				String relation = row.getCell(4).getStringCellValue();//与学生关系	
//		    				if("父亲".equals(relation)){
//		    					pp.setSex(1);
//		    				}else{
//		    					pp.setSex(2);
//		    				}
//		    				if(row.getCell(5)!=null){
//		    					 row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
//		    					 String phone = row.getCell(5).getStringCellValue();
//		    					 System.out.println(phone);
//		    					 pp.setPhonenum(phone);
//		    				}
//		    				pp.setName(name);
//		    				pp.setRelation(relation);
//		    				pp.setIsfllow(0);//未关注
//		    				pp.setCretime(System.currentTimeMillis());
//		    				pp.setStuPars(st);
//		    				parentService.save(pp);
//		    				//System.out.println("222222222=="+pp.getId());
//		    				System.out.println("==========================1");
//		    				Parents ppp =parentService.getByPhone(pp.getPhonenum(),pp.getName());
//		    				System.out.println("==========================2");
//		    				sp.setStudent(sss);
//		    				sp.setParents(ppp);
//		    				ps.setId(sp);
//		    				ps.setParents(ppp);
//		    				ps.setStudent(sss);
//		    				
//		    				stuParService.save(ps);
		   }
		    			
	//****************************************************************************************
		    			//导入年级结构
//		    			School ss =schoolService.findById(24);
//		    			for (String string : clazzs) {
//							Classes cc = new Classes();
//							cc.setName(string);
//							classesService.save(cc);
//						}
//		    			for (String string : grades) {
//		    				Grade g = new Grade();
//							g.setName(string);
//							g.setSchool(ss);
//							gradeService.save(g);
//						}
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
