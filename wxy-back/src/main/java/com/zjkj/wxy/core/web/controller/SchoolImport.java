package com.zjkj.wxy.core.web.controller;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Authentication;
import com.zjkj.wxy.core.domain.Invoice;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AgentService;
import com.zjkj.wxy.core.service.AuthenticationObejectService;
import com.zjkj.wxy.core.service.InvoiceObejectService;
import com.zjkj.wxy.core.service.OperatorObejectService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.service.WechatService;
import com.zjkj.wxy.core.utils.POIUtils;

@Controller
@RequestMapping("/schoolImport")
public class SchoolImport {
		//spring 资源注入
		@Resource
		private SchoolService schoolService;
		@Resource
		private OperatorObejectService operatorObejectService;
		@Resource
		private WechatService wechatService;
		@Resource
		private RegObejectService regObejectService;
		@Resource
		private InvoiceObejectService invoiceObejectService;
		@Resource
		private AgentService agentService;
		@Resource
		private AuthenticationObejectService AuthenticationObejectService;
	
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
		    			for (Row row : sheet) {
		    				int rowNum = row.getRowNum();
		    				if (rowNum == 0||rowNum==1) {
		    					// 第1\2行为文件的标题行，忽略
		    					continue;
		    				}
//***********************************************************************	
		    				String wname = row.getCell(20).getStringCellValue();//公众号名称
		    				//导入学校		    					    				
		    				School s = new School();
		    				// 获得当前行的某一列
		    				String name = row.getCell(0).getStringCellValue();//名称
		    				String type = row.getCell(1).getStringCellValue();//类型 1幼教 2普教
		    				String nature = row.getCell(2).getStringCellValue();//性质 1公办 2民办
		    				String s1 = row.getCell(3).getStringCellValue();//省
		    				String s2 = row.getCell(4).getStringCellValue();//市
		    				String s3 = row.getCell(5).getStringCellValue();//区
		    				String address = s1+"/"+s2+"/"+s3;
		    				s.setName(name);
		    				s.setAddress(address);
		    				if("幼教".equals(type)){
		    					s.setType(1);
		    				}else{
		    					s.setType(2);
		    				}
		    				if("公办".equals(nature)){
		    					s.setNature(1);
		    				}else{
		    					s.setNature(2);
		    				}
			    			s.setEntertime(df.format(new Date()));
			    			s.setWechatName(wname);
		    				System.out.println(s);
		    				schoolService.save(s);
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
		    				String oemail= row.getCell(27).getStringCellValue();//运营人邮箱
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
		    				Wechat w = new Wechat();
			    			
		    				String appid= row.getCell(44).getStringCellValue();//appid
		    				String secret= row.getCell(45).getStringCellValue();//secret
		    				String WID= row.getCell(46).getStringCellValue();//原始id
			    			String z= row.getCell(18).getStringCellValue();//注册类型
			    			row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
			    			String r= row.getCell(17).getStringCellValue();//认证类型
			    			String regemail= row.getCell(14).getStringCellValue();//注册邮箱
			    			if(row.getCell(15)!=null){
		    					 //row.getCell(15).setCellType(Cell.CELL_TYPE_NUMERIC);
			    				 String begin = row.getCell(15).getStringCellValue();
		    					// SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		    					
		    					 w.setBegintime(begin);
		    				}
			    			if(row.getCell(16)!=null){
			    				//row.getCell(16).setCellType(Cell.CELL_TYPE_NUMERIC);
			    				String end = row.getCell(16).getStringCellValue();
			    				//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			    				//String end = sd.format(dateCellValue);//到期时间
			    			}
			    			w.setAppId(appid);//appid
			    			w.setSecret(secret);//secret
			    			w.setWechatId(WID);//、原始id
			    			w.setAuthenstate(1);//已认证
			    			w.setSchoolname(name);
			    			w.setAdminname(op);
			    			w.setSid(s.getId());
			    			w.setDeletestate(1);
			    			w.setName(wname);
			    			w.setOpname(op);
			    			w.setAdminphonenum(pn);
			    			w.setAdminwechat(wx);
			    			w.setAdminidnum(noid);
			    			if("企业".equals(z)){
			    				w.setRegtype(1);
			    			}else if("媒体".equals(z)){
			    				w.setRegtype(2);
			    			}else if("政府".equals(z)){
			    				w.setRegtype(3);
			    			}else{
			    				w.setRegtype(4);
			    			}
			    			if("企业".equals(r)){
			    				w.setAuthentype(1);
			    			}else if("媒体".equals(r)){
			    				w.setAuthentype(2);
			    			}else if("政府".equals(r)){
			    				w.setAuthentype(3);
			    			}else{
			    				w.setAuthentype(4);
			    			}
			    			w.setRegemail(regemail);
			    			w.setOperator(gg);
			    			w.setOperator_1(op);
			    			wechatService.save(w);
		//******************************************************************    				
		    				//导入注册认证发票信息
		    				Reg reg = new Reg();//注册
		    				Authentication au = new Authentication();//认证
		    				Invoice i = new Invoice();
		    				au.setOrgaddr(address);
		    				String web = row.getCell(8).getStringCellValue();//官网
		    				String dns = row.getCell(9).getStringCellValue();//域名
		    				String info = row.getCell(10).getStringCellValue();//简介
		    				String rep = row.getCell(11).getStringCellValue();//法人
		    				row.getCell(24).setCellType(Cell.CELL_TYPE_STRING);
		    				String pho = row.getCell(24).getStringCellValue();//座机
		    				String regadd = row.getCell(29).getStringCellValue();//注册运营地区
		    				String gns = row.getCell(29).getStringCellValue();//功能
		    				String scope = row.getCell(31).getStringCellValue();//经营范围
		    				String perscope = row.getCell(32).getStringCellValue();//2经营范围
		    				row.getCell(33).setCellType(Cell.CELL_TYPE_STRING);
		    				String bankId = row.getCell(33).getStringCellValue();//银行开户帐号
		    				String uname = row.getCell(34).getStringCellValue();//开户名
		    				String bankname = row.getCell(35).getStringCellValue();//开户银行
		    				String add = row.getCell(36).getStringCellValue();//开户地点
		    				//发票
		    				String itype = row.getCell(37).getStringCellValue();//
		    				String ititle = row.getCell(38).getStringCellValue();//
		    				String icat = row.getCell(39).getStringCellValue();//
		    				row.getCell(40).setCellType(Cell.CELL_TYPE_STRING);
		    				String icatnum = row.getCell(40).getStringCellValue();//
		    				String add1 = row.getCell(41).getStringCellValue();//
		    				String add2 = row.getCell(42).getStringCellValue();//
		    				row.getCell(43).setCellType(Cell.CELL_TYPE_STRING);
		    				String ipcode = row.getCell(43).getStringCellValue();//
		    				au.setOrgweb(web);
		    				au.setOrgdns(dns);
		    				au.setOrgintro(info);
		    				au.setOrgrep(rep);
		    				au.setOrgphonenum(pho);
		    				au.setBusiscope(scope);
		    				au.setPerscope(perscope);
		    				au.setAccountid(bankId);
		    				au.setAccountname(uname);
		    				au.setBank(bankname);
		    				au.setAccountaddr(add);
		    				if("企业".equals(r)){
			    				au.setType(1);
			    			}else if("媒体".equals(r)){
			    				au.setType(2);
			    			}else if("政府".equals(r)){
			    				au.setType(3);
			    			}else{
			    				au.setType(4);
			    			}
		    				String[] split = regadd.split("、");
		    				reg.setOpcountry(split[0]);
		    				reg.setOpprovince(split[0]);
		    				reg.setOpcity(split[0]);
		    				reg.setAccountid(bankId);
		    				reg.setAccountname(uname);
		    				reg.setAccountaddr(add);
		    				reg.setBank(bankname);
		    				if(itype!=null){
		    					if("普通发票".equals(itype)){
		    						i.setItype(1);
		    					}else{
		    						i.setItype(2);
		    					}
		    				}
		    				i.setItitle(ititle);
		    				i.setIcontact(icat);
		    				i.setContactph0num(icatnum);
		    				i.setPostaddr(add1+add2);
		    				i.setPostcode(ipcode);
		    				i.setWechat(w);
		    				reg.setWechat(w);
		    				au.setWechat(w);
		    				regObejectService.addregs(reg);
		    				invoiceObejectService.addInvoice(i);
		    				AuthenticationObejectService.addauthtication(au);
		    				w.setReg(reg);
		    				w.setAuthentication(au);
		    				w.setInvoice(i);
		    				wechatService.update(w);

		    				
//		******************************************************************    
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
