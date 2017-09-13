package com.zjkj.wxy.core.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Card;
import com.zjkj.wxy.core.domain.CardApply;
import com.zjkj.wxy.core.domain.Classes;
import com.zjkj.wxy.core.domain.Equipment;
import com.zjkj.wxy.core.domain.Grade;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Student;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.CardApplyService;
import com.zjkj.wxy.core.service.CardService;
import com.zjkj.wxy.core.service.ClassesService;
import com.zjkj.wxy.core.service.GradeService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.StudentService;
import com.zjkj.wxy.core.utils.POIUtils;
import com.zjkj.wxy.core.utils.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 卡片管理
 * @author 
 *
 */
@Controller
@RequestMapping("/card")
public class CardController {
	
	protected Logger  logger = Logger.getLogger(this.getClass());
	
	
	@Resource
	private CardService cardService;
	@Resource
	private CardApplyService cardApplyService;
	@Resource
	private GradeService gradeService;
	@Resource
	private ClassesService classesService;
	@Resource
	private StudentService studentService;
	@Resource
	private SchoolService schoolService;
	
	
	public static String getFixLenthString(int strLength) {  
	      
	    Random rm = new Random();  
	      
	    // 获得随机数  
	    double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
	  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	  
	    // 返回固定的长度的随机数  
	    return fixLenthString.substring(1, strLength + 1);  
	}
	/**
	 * 查看所有的卡片
	 * @return
	 */
	@RequestMapping("/listCard.do")
	public String listCard(HttpServletRequest request,Integer currentPage,
			Integer pageSize,Model model,String id,String activeTime ,
			String sname,Integer grade,	Integer clazz,String schoolname){
		//离线查询对象
		 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Card.class);

		
		//分页查询对象
		PageBean<Card> pageBean=new PageBean<Card>(request);
		 
		//获取当前用户

		User user=(User) request.getSession().getAttribute("loginUser");

		//所属学校
		Integer sid =null;
			School school = user.getSchool();
			if(school!=null){
				model.addAttribute("isschool", 1);
				model.addAttribute("school",school);
				sid = school.getId();
			}else{
				List<School> findAll = schoolService.findAll();
				model.addAttribute("schools", findAll);
			} 
			
	//查询该学校所有的年级

	
		if(currentPage==null){
			currentPage=1;//默认第一页
		}
		if(pageSize==null){
			pageSize=10;//默认每页显示10条
		}
		//封装pageBean
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		detachedCriteria.add(Restrictions.eq("isshow", 1));
		if(sid!=null){
			//List<Card> cards=cardService.listBySchoolId(sid);
			detachedCriteria.add(Restrictions.eq("sid", sid));
			model.addAttribute("sid", sid);
			
		}else{
			if(schoolname!=null){
				School s =schoolService.findByName(schoolname);
				if(s!=null){
					model.addAttribute("schname", s.getName());
					sid=s.getId();
				}
			}
		}
		if(sid!=null){
			List<Grade> grades = gradeService.findBySid(sid);
			model.addAttribute("grades", grades);
			detachedCriteria.add(Restrictions.eq("sid", sid));
			model.addAttribute("sid", sid);
		}
		if(activeTime!=null){
			detachedCriteria.add(Restrictions.eq("activeTime", activeTime));
			model.addAttribute("activeTime", activeTime);
		}
		if(id!=null){
			detachedCriteria.add(Restrictions.eq("id", id));
			model.addAttribute("id", id);
		}
		if(sname!=null){
			List<Student> students = studentService.findByName(sname);
			if(students!=null&&students.size()>0){
				detachedCriteria.add(Restrictions.eq("student", students.get(0)));
				model.addAttribute("sname", sname);
			}
		}
		if(grade!=null){
			Grade findById = gradeService.findById(grade);
			detachedCriteria.add(Restrictions.eq("grade", findById));
			model.addAttribute("grade", grade);
		}
		if(clazz!=null){
			Classes findById = classesService.findById(clazz);
			detachedCriteria.add(Restrictions.eq("clazz", findById));
			model.addAttribute("clazz", clazz);
		}
		pageBean.setDetachedCriteria(detachedCriteria);
		cardService.pageList(pageBean);
		model.addAttribute("pageBean", pageBean);
		return "access/card";
	}
	/**
	 * 根据申请类型查询
	 */
	@RequestMapping("/listByType.do")
	public void listByType(Integer currentPage,Integer pageSize,Integer type,
			Model model,HttpServletRequest request,HttpServletResponse response,
			String id,String stuname,String applyer,Integer isdeal,Integer gra,Integer cla,
			String applytime,String schoolname){
		response.setContentType("text/html; charset=utf-8");
		DetachedCriteria detachedCriteria=detachedCriteria=DetachedCriteria.forClass(CardApply.class);
		//分页查询对象
		PageBean pageBean=new PageBean("from3",request);

		
		//获取当前用户
			User user=(User) request.getSession().getAttribute("loginUser");
		//所属学校
		School school = user.getSchool();

		if(school!=null){			
			detachedCriteria.add(Restrictions.eq("school", school));
			model.addAttribute("school",school);
		}else{
			if(schoolname!=null){
				School s = schoolService.findByName(schoolname);
				if(s!=null){
					detachedCriteria.add(Restrictions.eq("school", s));
					model.addAttribute("schname",s.getName());
				}
			}
		}
		if(currentPage==null){
			currentPage=1;//默认第一页
		}
		if(pageSize==null){
			pageSize=10;//默认每页显示10条
		}
		//封装pageBean
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		//封装查询条件

		if(type!=null){
			detachedCriteria.add(Restrictions.eq("type", type));
		}
		if(id!=null){
			detachedCriteria.add(Restrictions.eq("id", id));
			model.addAttribute("aid", id);
		}
		if(stuname!=null&&gra!=null&&cla!=null){
			List<Student> list =studentService.findByNameAndGradeAndClazz(stuname,gra,cla);
			if(list!=null&&list.size()>0){
				detachedCriteria.add(Restrictions.eq("student", list.get(0)));
			}
		}else{
			if(stuname!=null){
				List<Student> findByName = studentService.findByName(stuname);
				if(findByName!=null&&findByName.size()>0){
					detachedCriteria.add(Restrictions.eq("student", findByName.get(0)));
					model.addAttribute("stuname", stuname);
				}
			}
			if(gra!=null){
				Grade findById = gradeService.findById(gra);
				detachedCriteria.add(Restrictions.eq("grade", findById));
				model.addAttribute("gra", gra);
			}
			if(cla!=null){
				Classes findById = classesService.findById(cla);
				detachedCriteria.add(Restrictions.eq("classes", findById));
				model.addAttribute("cla", cla);
			}
		}
		if(applyer!=null){
			detachedCriteria.add(Restrictions.like("applyer", applyer));
			model.addAttribute("applyer", applyer);
		}
		if(isdeal!=null){
			detachedCriteria.add(Restrictions.eq("isdeal", isdeal));
			model.addAttribute("isdeal", isdeal);
		}
		if(applytime!=null){
			detachedCriteria.add(Restrictions.eq("applytime", applytime));
			model.addAttribute("applytime", applytime);
		}
		pageBean.setDetachedCriteria(detachedCriteria);
		cardService.listByType(pageBean);
		int total = pageBean.getTotal();
		List<CardApply> rows = pageBean.getRows();
		for (CardApply cardApply : rows) {
			cardApply.setSchoolName(cardApply.getSchool().getName());
			cardApply.setGradeName(cardApply.getGrade().getName());
			cardApply.setClassName(cardApply.getClasses().getName());
		}
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows);
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"classes","grade","cards","leaves","attendances","scoreDetials","stuPars","school"});
			JSONObject jo = JSONObject.fromObject(map,jsonConfig);
			//JSONArray js = JSONArray.fromObject(rows,jsonConfig);
			response.getWriter().print(jo.toString());
			logger.info("成功会写数据。。。。。。。。。。。。。。。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("数据回传失败-----------------------");
		}
	}
	/**
	 * 根据id查询卡片，ajax请求，用于验证要开的卡是否在数据库中，防止
	 * @param cid
	 */
	@RequestMapping("/findById.do")
	public void findById(String cid,HttpServletResponse response){
			try {
				response.setContentType("text/json; charset=utf-8");
				if(cid!=null){ //输入了卡号
					Card card =cardService.findById(cid);
					if(card !=null){
						response.getWriter().print(1); //查询到，返回1
					}else{
						response.getWriter().print(0); //查询到，返回0
					}
				}else{
					response.getWriter().print(1); //没有输入，返回1
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * g根据多个id查询
	 * @param cid
	 * @param response
	 */
	@RequestMapping("/findByIds.do")
	public void findByIds(String cid,HttpServletResponse response){
		response.setContentType("text/json; charset=utf-8");
		try {
			String renum="";
			Integer re = -1;
			if(cid!=null){
				String[] split = cid.split("/");
				for(int i=0;i<split.length;i++){
					if(!"".equals(split[i])){
						Card card =cardService.findById(split[i]);
						if(card==null){
							if("".equals(renum)){
								renum=renum+i;
							}else{
								renum=renum+"/"+i;
							}
							re=0;
						}
					}
				}
			}
			String returns = re+"_"+renum;
			response.getWriter().print(returns);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加卡片
	 * @return
	 */
	@RequestMapping("/add.do")
	public String addCards(String[]nec,Model model,String sid,HttpServletRequest request){
//		if(sid.length()<14){
//			int i = 14-sid.length();
//			for(int j=0;j<i;j++){
//				sid=0+sid;
//			}
//		}
		//读取属性文件
		InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("wxy.properties"); 
		Properties prop = new Properties();    
		try {
			prop.load(inStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//属性文件读取失败
		}    
		//押金
		String deposit = prop.getProperty("deposit");
		//根据申请id查询
		CardApply ca =cardApplyService.getCardApplyById(sid);
		Grade grade = ca.getGrade();
		//从年级获取学校id
		School school2 = ca.getSchool();
		Integer id2 = school2.getId();
		Classes classes = ca.getClasses();
		String applyer = ca.getApplyer();//申请者，下边的开卡人
		Student student = ca.getStudent();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d = format.format(date);
		for (String string : nec) {
			if(string!=null){				
				Card card = cardService.findById(string);
				card.setGrade(grade);
				card.setClazz(classes);
				card.setSid(id2);//学校id
//				card.setId(string);//id
				card.setStudent(student);//持有人
				card.setActiveTime(d);//开卡时间
				card.setDeposit(Integer.parseInt(deposit));//默认押金
				card.setIsreturn(0);//默认没有退卡
				//card.setInvoicepeo(applyer);
				card.setApplyer(applyer);//开卡者，即申请人
				card.setIsshow(1);
				try {
					cardService.updateCardAndApply(card,ca);
					//cardApplyService.update(ca);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return "redirect:/card/listCard.do";
	}
	/**
	 * 根据年级查询该年级下的所有班级
	 * @param gid
	 */
	@RequestMapping("/listClazzByGid.do")
	public void getAllClazzOfSchoolByGradeId(Integer gid,HttpServletResponse response){
		response.setContentType("text/json;charset=utf-8");
		try {
			List<Classes> list=gradeService.getAllClazz(gid);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"gradeClasses","students"});
			JSONArray js = JSONArray.fromObject(list,jsonConfig);
			response.getWriter().print(js);
			logger.info("获取年级下的所有班级======yes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("获取年级下的所有班级======异常");
		}
	}
	/**
	 * 根据卡片标号删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById.do")
	public String deleteById(String id){
		cardService.deleteById(id);
		return "redirect:/card/listCard.do";
	}
	/**
	 * 根据申请id查询退卡申请
	 * @param aid
	 * @param response
	 */
	@RequestMapping("/getBackById.do")
	public void getBackById(String aid ,HttpServletResponse response){
		response.setContentType("text/json;charset=utf-8");
		try {
			CardApply ac =   cardService.getBackById(aid);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"classes","grade","student","school"});
			JSONObject jo=JSONObject.fromObject(ac,jsonConfig);
			response.getWriter().print(jo.toString());
			logger.info("获取退卡申请======yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("获取退卡申请======no");
		}
	}
	/**
	 * 处理退卡申请
	 * @param apid 申请id
	 * @param card1 要退调的卡
	 * @param card2
	 * @param card3
	 * @param card4
	 * @param bnum 退卡数量
	 * @return
	 */
	@RequestMapping("/back.do")
	public String backCard(String apid,String card1,String card2,String card3,String card4,Integer bnum){
		cardService.backCard(apid,card1,card2,card3,card4);
		return "redirect:/card/listCard.do";
	}
	/**
	 * 根据申请id查询补卡信息
	 * @param aid
	 * @param response
	 */
	@RequestMapping("/getFillById.do")
	public void getFillById(String aid,HttpServletResponse response){
		response.setContentType("text/json;charset=utf-8");
		List<String> list = new ArrayList<>();
		List<String> cardnos = new ArrayList<>();
		try { 
			CardApply ca =cardService.getFillById(aid);
			String applyer = ca.getApplyer();//申请人，也就是开卡时的申请人
			//根据申请人查询该人所申请的所有卡片
			List<Card> cards =cardService.getByApplyer(applyer);
			for (Card card : cards) {
				cardnos.add(card.getId());
			}
			String card1no = ca.getCard1no();
			String card2no = ca.getCard2no();
			String card3no = ca.getCard3no();
			String card4no = ca.getCard4no();
			if(card1no!=null){
				list.add(card1no);
			}
			if(card2no!=null){
				list.add(card2no);
			}
			if(card3no!=null){
				list.add(card3no);
			}
			if(card4no!=null){
				list.add(card4no);
			}
			 for (String cardno : list) {
				if(cardnos.contains(cardno)){
					cardnos.remove(cardno);
				}
			}
			
			JSONArray ja = JSONArray.fromObject(cardnos);
			response.getWriter().print(ja.toString());
			logger.info("获取退卡申请======yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("获取退卡申请======no");
		}
	}
	/**
	 * 更换卡片，更改申请状态1
	 * @param cad1
	 * @param cad2
	 * @param cad3
	 * @param cad4
	 * @param newcard1
	 * @param newcard2
	 * @param newcard3
	 * @param newcard4
	 * @param applyid
	 * @return
	 */
	@RequestMapping("/changeCards.do")
	public String changeCards(String cad1,String cad2,String cad3,String cad4,String newcard1,String newcard2,String newcard3,String newcard4,String applyid){
		List<String> olds=new ArrayList<>();
		List<String> news=new ArrayList<>();
		if(cad1!=null){
			olds.add(cad1);
		}
		if(cad2!=null){
			olds.add(cad2);
		}
		if(cad3!=null){
			olds.add(cad3);
		}
		if(cad4!=null){
			olds.add(cad4);
		}
		if(newcard1!=null){
			news.add(newcard1);
		}
		if(newcard2!=null){
			news.add(newcard2);
		}
		if(newcard3!=null){
			news.add(newcard3);
		}
		if(newcard4!=null){
			news.add(newcard4);
		}
		for (String string : news) {
			Card card = new Card();
			card.setId(string);
			cardService.delete(card);
		}
		cardService.updateApplyState(olds,news,applyid);
		return "redirect:/card/listCard.do";
	}
	/**
	 * 提前添加卡片
	 * @return
	 */
	@RequestMapping("/addBefore.do")
	public String addBefore(String cardNo,String cardNo1 ,String cardNo2 ){
		if(cardNo !=null){
			Card c = new Card();
			c.setId(cardNo);
			cardService.add(c);
		}
		if(cardNo1 !=null && cardNo2 !=null){
			Integer begin = Integer.parseInt(cardNo1);
			Integer end = Integer.parseInt(cardNo2);
			List<Card> cs = new ArrayList<>();
			for(int i=begin;i<=end;i++){
				Card c = new Card();
				c.setId(i+"");
				cs.add(c);
			}
			cardService.addByBatch(cs);;
		}
		return "redirect:/card/listCard.do";
	}
	/**
	 * 导入卡片申请
	 * @return
	 */
	@RequestMapping("/importApply.do")
	public void importApply(MultipartFile upfile,Model model,HttpServletResponse response){
		logger.info("导入开卡申请------------");
		List<CardApply> list=new ArrayList<>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
					response.setCharacterEncoding("utf-8");
					if(!upfile.isEmpty()){
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
			    			for (Row row : sheet) {
			    				int rowNum = row.getRowNum();
			    				if (rowNum == 0||rowNum==1) {
			    					// 第1\2行为文件的标题行，忽略
			    					continue;
			    				}
	//***********************************************************************	
			    				// 获得当前行的某一列
			    				logger.info("行号===="+row.getRowNum());
			    				String schoolName = row.getCell(0).getStringCellValue();//学校名称
			    				String studentName = row.getCell(1).getStringCellValue();//学生名称
			    				String gradeName = row.getCell(2).getStringCellValue();//年级名称
			    				String clazzName = row.getCell(3).getStringCellValue();//班级名称
			    				String applyerName = row.getCell(4).getStringCellValue();//支付，申请人名称
			    				School school = schoolService.findByName(schoolName);
			    				Integer sid = school.getId();
			    				Grade grade = gradeService.findByNameAndSid(gradeName, sid);
			    				Integer gid = grade.getId();
			    				Classes clazz = classesService.findClassByName(clazzName);
			    				Integer cid = clazz.getId();
			    				DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Student.class);
			    				detachedCriteria.add(Restrictions.eq("grade", gid));
			    				detachedCriteria.add(Restrictions.eq("classid", cid));
			    				detachedCriteria.add(Restrictions.eq("school", school));
			    				detachedCriteria.add(Restrictions.eq("name", studentName));
			    				Student student = studentService.findByCri(detachedCriteria);
			    				Integer stuid = student.getId();
			    				CardApply ca = new CardApply();
			    				ca.setId(getFixLenthString(12).replace(".", ""));
			    				ca.setApplyer(applyerName);
			    				ca.setSchool(school);
			    				ca.setSchoolName(schoolName);
			    				ca.setGrade(grade);
			    				ca.setGradeName(gradeName);
			    				ca.setStudent(student);
			    				ca.setClasses(clazz);
			    				ca.setClassName(clazzName);
			    				ca.setApplytime(df.format(new Date()).substring(0, 16));
			    				ca.setType(2);//申请类型  开卡
			    				ca.setNum(1);//申请数量
			    				ca.setIsdeal(0);//默认没有处理
			    				list.add(ca);
			    			}   
			    			inputStream.close();//关
			    			cardApplyService.addBatch(list);
			    			response.getWriter().print(1);//success
						}
					}else{
						response.getWriter().print(2);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error(e.fillInStackTrace());
				}
	}
	
	public static void main(String[] args) {
		DateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String substring = fd.format(new Date()).substring(0, 16);
		System.out.println(substring);
	}
}
