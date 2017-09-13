package com.zjkj.wxy.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.ImgDetail;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.PeitaosheshiService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.utils.UUIDUtils;

@Controller
public class PeitaosheshiEnvireController {
private Logger logger = Logger.getLogger(PeitaosheshiEnvireController.class);
	//spring 资源注入
			@Resource
			private PeitaosheshiService peitaosheshiService;
			@Resource
			private SchoolService schoolService;

			  
			      /**
			       * 查询所有的配套设施
			       * @param request
			       * @param model
			       * @return
			       */
			    @RequestMapping("/getAllPeitaosheshi")  
			    public String getAllPeitaosheshi(HttpServletRequest request,Model model){  
			    	List<Img> img = new ArrayList<>();
			    	HttpSession session = request.getSession();
			    	User loginUser =(User) session.getAttribute("loginUser");
			    	Integer sid =(Integer) session.getAttribute("SCHOOLID");
			       if(sid!=null){
			    	  List<Img> findAll = peitaosheshiService.findAll(sid);  
			    	  img.addAll(findAll);
			       }
			        model.addAttribute("img", img);
			        return "/schoolEnvire/facility";
			    }  
			      /**
			       * 添加配套设施
			       * @param pic 上传的图片
			       * @param title 标题
			       * @param request 
			       * @return
			       */
			    @RequestMapping("/addSchoolEqu")
			    public String addEqu(MultipartFile pic,String title,HttpServletRequest request){
			    	HttpSession session = request.getSession();
			    	Integer id =(Integer) session.getAttribute("SCHOOLID");//所选的学校id
			    	if(id!=null){ //只有选择了学校才能上传添加
				    	try {
		    				if(!pic.isEmpty() && title!=null){
		    					Img img = new Img();
		    					img.setTitle(title);
		    					DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		    					String format = df.format(new Date());
		    					User user =(User) request.getSession().getAttribute("loginUser");
		    					School school = user.getSchool();
		    					if(school==null){
		    						school = schoolService.findById(id);
		    					}
		    					//Integer id = school.getId();
		    					String originalFilename = pic.getOriginalFilename();
		    					int lastIndexOf = originalFilename.lastIndexOf(".");
		    					String ex = originalFilename.substring(lastIndexOf+1);
		    					String random = UUIDUtils.getString(4);//4位随机字符串
		    					if(ex.equals("jpg") || ex.equals("png") || ex.equals("gif")){
		    						String realPath = request.getSession().getServletContext().getRealPath("/");
		    						String replace = realPath.replace(File.separator+"wxy-back", "");
		    						String path=File.separator+"uploadImg"+File.separator+"equ"+File.separator+id+File.separator+format+"_"+random+"_"+originalFilename;
		    						logger.info("上传配套设施图片-==="+originalFilename);
		    						File file = new File(replace+path);
		    						if(!file.exists()){
		    							file.mkdirs();
		    						}
		    						pic.transferTo(file);
		    						img.setUrl(path);
				    			}
		    					
		    					img.setUptime(System.currentTimeMillis());
		    					img.setState(1);
		    					img.setIsdown(0);
		    					ImgDetail imgDetail=new ImgDetail();
		    					imgDetail.setSchool(school);
		    					imgDetail.setType(2);
		    					peitaosheshiService.save(imgDetail,img);
				    		}
						} catch (IllegalStateException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							logger.error(e.getMessage());;
						}
			    	}
			    	return "redirect:/getAllPeitaosheshi.do";
			    }
			   
			    /**
			     * 根据id删除
			     * @param id
			     * @return
			     */
			    @RequestMapping("/equ/deleteById.do")
			    public String deleteById(Integer id){
			    	peitaosheshiService.deleteById(id);
			    	return "redirect:/getAllPeitaosheshi.do";
			    }
			    /***
			     * 上架显示图片
			     * @param id
			     * @return
			     */
			    @RequestMapping("/equ/showPicById.do")
			    public String showPic(Integer id){
			    	peitaosheshiService.updateToShow(id);
			    	return "redirect:/getAllPeitaosheshi.do";
			    }
			    /**
			     * 下架图片不显示
			     * @param id
			     * @return
			     */
			    @RequestMapping("/equ/noShowPicById.do")
			    public String downPic(Integer id){
			    	peitaosheshiService.updateToNoShow(id);
			    	return "redirect:/getAllPeitaosheshi.do";
			    }
	
}
