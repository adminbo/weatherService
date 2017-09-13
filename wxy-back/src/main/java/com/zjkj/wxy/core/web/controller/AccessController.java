package com.zjkj.wxy.core.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.domain.Equipment;
import com.zjkj.wxy.core.domain.School;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.service.AccessService;
import com.zjkj.wxy.core.service.SchoolService;
import com.zjkj.wxy.core.utils.PageBean;

/**
 * 门禁设备管理
 * @author smil
 *
 */
@Controller
@RequestMapping("/access")
public class AccessController {
	protected Logger  logger = Logger.getLogger(this.getClass());

	protected User user = null;
	
	@Resource
	private AccessService accessService;
	@Resource
	private SchoolService schoolService;
/**
 * 查询所有的设备
 * @return
 */
	@RequestMapping("/listEqu.do")
	public String listEqu(Integer currentPage,Integer pageSize,
			HttpServletRequest request,String id,Integer model2,Integer type,
			Model model,Integer schoolid,Integer runstate){
		//分页查询对象
		PageBean pageBean=new PageBean("form1",request);
		//离线查询对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Equipment.class);
		//获取当前用户
		if(user ==null){
			user=(User) request.getSession().getAttribute("loginUser");
		}
		//所属学校
		School school = user.getSchool();
		if(school!=null){
			model.addAttribute("isSchool", 1);
			detachedCriteria.add(Restrictions.eq("school", school));
		}else{
			//查询所有的学校
			List<School> findAll = schoolService.findAll();
			model.addAttribute("schools", findAll);
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
		//封装条件
		if(id!=null){
			detachedCriteria.add(Restrictions.eq("id", id));
			model.addAttribute("bh", id);
		}
		if(model2!=null){
			detachedCriteria.add(Restrictions.eq("model", model2));
			model.addAttribute("xh", model2);
		}
		if(runstate!=null){
			detachedCriteria.add(Restrictions.eq("runstate", runstate));
			model.addAttribute("yz", runstate);
		}
		if(type!=null){
			detachedCriteria.add(Restrictions.eq("type", type));
			model.addAttribute("lx", type);
		}
		if(schoolid!=null){
			School findById = schoolService.findById(schoolid);
			if(findById!=null){
				detachedCriteria.add(Restrictions.eq("school", findById));
				model.addAttribute("sname", findById.getName());
				model.addAttribute("sid", findById.getId());
			}
		}
			//detachedCriteria.add(Restrictions.eq("isshow", 1));
			pageBean.setDetachedCriteria(detachedCriteria);
			accessService.pageQuery(pageBean);
			model.addAttribute("pageBean", pageBean);
		return "access/equ";
	}
	/**
	 * 添加设备
	 * @return
	 */
	@RequestMapping("/addEqu.do")
	public String addEqu(String id,Integer model,Integer type,
			HttpServletRequest request,Integer sch){
		//封装数据
		Equipment equipment = new Equipment();
		equipment.setId(id);
		equipment.setModel(model);
		equipment.setType(type);
		equipment.setRunstate(1);//运行
		if(user ==null){
			user=(User) request.getSession().getAttribute("loginUser");
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d = format.format(date);
		equipment.setAddtime(d);
		//所属学校
		School school = user.getSchool();
		if(school==null){
			if(sch!=null){
				School findById = schoolService.findById(sch);
				equipment.setSchool(findById);
			}
		}else{
			equipment.setSchool(school);
		}
		accessService.add(equipment);
		return "redirect:/access/listEqu.do";
	}
	/**
	 * 删除设备
	 * @param id
	 * @return
	 */
	@RequestMapping("/delById.do")
	public String delById(String id){
		accessService.delById(id);
		return "redirect:/access/listEqu.do";
	}
	
}
