package com.zjkj.wxy.core.web.controller;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.zjkj.wxy.core.domain.Authentication;
import com.zjkj.wxy.core.domain.Invoice;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.User;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.service.AuthenticationObejectService;
import com.zjkj.wxy.core.service.InvoiceObejectService;
import com.zjkj.wxy.core.service.OperatorObejectService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.WechatService;

@Controller
public class WxManagController {

	@Resource
	WechatService wechatService;

	@Resource
	RegObejectService regObejectService;

	@Resource
	OperatorObejectService operatorObejectService;

	@Resource
	InvoiceObejectService invoiceObejectService;

	@Resource
	AuthenticationObejectService authenticationObejectService;

	/**
	 * 注册相关 保存基本信息 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/regbasicmsg", method = RequestMethod.POST)
	public String saveReviseRegbasicmsg(Wechat wechat, Reg reg,
			HttpServletRequest request) {
		this.setData("wechat", wechat);
		this.setData("reg", reg);
		return "1";
	}

	/**
	 * 注册相关 银行开户信息 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/bankopenmsg", method = RequestMethod.POST)
	public String saveReviseBankOpenMsg(Reg reg, HttpServletRequest request) {
		this.setData("reg", reg);
		return "1";
	}

	/**
	 * 注册相关 注册相关证件 -> 上传文件 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/regcredentials", method = RequestMethod.POST)
	public String saveReviseRegCredentials(
			@RequestParam(value = "bslisurl", required = false) MultipartFile bslisurl,
			@RequestParam(value = "authbookurl", required = false) MultipartFile authbookurl,
			@RequestParam(value = "orgcodeurl", required = false) MultipartFile orgcodeurl,
			@RequestParam(value = "expsbookurl", required = false) MultipartFile expsbookurl,
			HttpServletRequest request) {
		// 处理上传文件
		// 将上传文件结果url保存到Reg -> session
		try {
			Reg reg = new Reg();
			Object obj = this.getData("reg");
			if (obj != null) {
				BeanUtils.copyProperties(obj, reg);
			}
			Map<String, String> b1 = this.upload(request,
					bslisurl, "bslisurl");
			reg.setBslisurl(b1.size() > 0 ? b1.get("path") : "");
			Map<String, String> b2 = this.upload(request,
					authbookurl, "authbookurl");
			reg.setAuthbookurl(b2.size() > 0 ? b2.get("path") : "");
			Map<String, String> b3 = this.upload(request,
					orgcodeurl, "orgcodeurl");
			reg.setOrgcodeurl(b3.size() > 0 ? b3.get("path") : "");
			Map<String, String> b4 = this.upload(request,
					expsbookurl, "expsbookurl");
			reg.setExpsbookurl(b4.size() > 0 ? b4.get("path") : "");

			this.setData("reg", reg);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		return "1";
	}

	/**
	 * 认证相关 运营者信息 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/operationmsg", method = RequestMethod.POST)
	public String saveReviseOperationMsg(Operator operator,
			HttpServletRequest request) {
		this.setData("operator", operator);
		return "1";
	}

	/**
	 * 认证相关 发票信息 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/invoicemsg", method = RequestMethod.POST)
	public String saveReviseInvoiceMsg(Invoice invoice,
			HttpServletRequest request) {
		this.setData("invoice", invoice);
		return "1";
	}

	/**
	 * 认证相关 基本信息 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/certificationbasicmsg", method = RequestMethod.POST)
	public String saveReviseCertificationBasicMsg(
			Authentication authentication, HttpServletRequest request) {
		this.setData("authentication", authentication);
		return "1";
	}

	/**
	 * 认证相关 认证相关证件 -> 上传文件 临时保存到缓存里
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/save/revise/certificrelacerts", method = RequestMethod.POST)
	public String saveReviseCertificRelaCerts(
			@RequestParam(value = "orgcodeurl", required = false) MultipartFile orgcodeurl,
			@RequestParam(value = "regcertificurl", required = false) MultipartFile regcertificurl,
			@RequestParam(value = "appliletterurl", required = false) MultipartFile appliletterurl,
			@RequestParam(value = "branchstaffurl", required = false) MultipartFile branchstaffurl,
			@RequestParam(value = "frontidurl", required = false) MultipartFile frontidurl,
			@RequestParam(value = "backidurl", required = false) MultipartFile backidurl,
			@RequestParam(value = "repcertificurl", required = false) MultipartFile repcertificurl,
			@RequestParam(value = "ufctificurl", required = false) MultipartFile ufctificurl,
			@RequestParam(value = "permitlicenseurl", required = false) MultipartFile permitlicenseurl,
			@RequestParam(value = "staffurl", required = false) MultipartFile staffurl,
			@RequestParam(value = "partnerurl", required = false) MultipartFile partnerurl,
			@RequestParam(value = "otherurl", required = false) MultipartFile otherurl,
			HttpServletRequest request) {
		// 处理上传文件
		// 将文件结果保存到 Authentication 和 Operator-> session
		try {
			Authentication authentication = new Authentication();
			Object obj1 = this.getData("authentication");
			if (obj1 != null) {
				BeanUtils.copyProperties(obj1, authentication);
			}
			Map<String, String> b1 = this.upload(request,
					orgcodeurl, "orgcodeurl");
			Map<String, String> b2 = this.upload(request,
					regcertificurl, "regcertificurl");
			Map<String, String> b3 = this.upload(request,
					appliletterurl, "appliletterurl");
			Map<String, String> b4 = this.upload(request,
					branchstaffurl, "branchstaffurl");
			Map<String, String> b7 = this.upload(request,
					repcertificurl, "repcertificurl");
			Map<String, String> b8 = this.upload(request,
					ufctificurl, "ufctificurl");
			Map<String, String> b9 = this.upload(request,
					permitlicenseurl, "permitlicenseurl");
			Map<String, String> b10 = this.upload(request,
					staffurl, "staffurl");
			Map<String, String> b11 = this.upload(request,
					partnerurl, "partnerurl");
			Map<String, String> b12 = this.upload(request,
					otherurl, "otherurl");
			authentication.setOrgcodeurl(b1.get("path"));
			authentication.setRegcertificurl(b2.get("path"));
			authentication.setAppliletterurl(b3.get("path"));
			authentication.setBranchstaffurl(b4.get("path"));
			authentication.setRepcertificurl(b7.get("path"));
			authentication.setUfctificurl(b8.get("path"));
			authentication.setPermitlicenseurl(b9.get("path"));
			authentication.setStaffurl(b10.get("path"));
			authentication.setPartnerurl(b11.get("path"));
			authentication.setOtherurl(b12.get("path"));

			this.setData("authentication", authentication);

			Operator operator = new Operator();
			Object obj2 = this.getData("operator");
			if (obj2 != null) {
				BeanUtils.copyProperties(obj2, operator);
			}
			Map<String, String> b5 = this.upload(request,
					frontidurl, "frontidurl");
			Map<String, String> b6 = this.upload(request,
					backidurl, "backidurl");
			operator.setFrontidurl(b5.get("path"));
			operator.setBackidurl(b6.get("path"));
			this.setData("operator", operator);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		return "1";
	}

	/**
	 * 统一保存方法
	 * 
	 * @param request
	 * @return json
	 * @author hongyanyang1
	 * @version 2017-05-08
	 * @------------------------------------------------------ 
	 *                                                         ------------------
	 *                                                         ----------------
	 * @updated 修改描述.
	 * @updated by hongyanyang1
	 * @updated at 2017-05-08
	 */
	@ResponseBody
	@RequestMapping(value = "/saves/revises", method = RequestMethod.GET)
	public String saves(HttpServletRequest request) {
		if (!datas.isEmpty()) {
			Wechat wechat = (Wechat) datas.get("save_revise_wechat");
			wechatService.merge(wechat);
			Reg reg = (Reg) datas.get("save_revise_reg");
			reg.setWechat(wechat);
			Operator operator = (Operator) datas.get("save_revise_operator");
			User loginUser = (User) request.getAttribute(
					"loginUser");
//			operator.setWechat(wechat.getId());
			Invoice invoice = (Invoice) datas.get("save_revise_invoice");
			invoice.setWechat(wechat);
			Authentication authentication = (Authentication) datas
					.get("save_revise_authentication");
			authentication.setWechat(wechat);
			wechat.setDeletestate(1);
			reg.setWechat(wechat);
			regObejectService.updateReg(reg);
//			operator.setWechat(wechat.getId());
			operatorObejectService.updateReg(operator);
			invoice.setWechat(wechat);
			invoiceObejectService.updateInvoice(invoice);
			authentication.setWechat(wechat);
			authenticationObejectService.updateauthentication(authentication);
		}
		return "1";
	}

	private Map<String, Object> datas = new HashMap<String, Object>();

	private void setData(String key, Object value) {
		datas.put("save_revise_" + key, value);
	}

	private Object getData(String key) {
		return datas.get("save_revise_" + key);
	}

	private String fileupload = "upload/";

	public Map<String, String> upload(HttpServletRequest request, MultipartFile file,
			String path) throws IOException {
		// 返回上传文件信息
		Map<String, String> map = new HashMap<>();
		if (file == null) {
			if(!"".equals(request.getParameter(path+"FileName"))&&request.getParameter(path+"FileName")!=null){
				map.put("path", fileupload + path+"/"+request.getParameter(path+"FileName"));
			}else{
				map.put("path", fileupload + path+"/"+request.getParameter(path+"FileName"));
			}
			return map;
		}
		String realPath = request.getSession().getServletContext().getRealPath(fileupload);
		// 上传文件
		String fileName = file.getOriginalFilename();
		String filePath = path + "/" + fileName;
		path = realPath + "/" + filePath;
		File uploadFile = new File(path);
		try {
			Files.createParentDirs(uploadFile);
			FileCopyUtils.copy(file.getBytes(), uploadFile);
		} catch (IOException e) {
			throw new IOException(e);
		}
		map.put("path", fileupload + filePath);
		return map;
	}

	public String getFileExtension(String fullName) {
		String fileName = new File(fullName).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
}

class BeanUtils extends org.springframework.beans.BeanUtils {

	public static void copyProperties(Object source, Object target)
			throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(
						source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass()
								.getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						if (value != null && !"".equals(value)) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod
									.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
					} catch (Throwable ex) {
						throw new FatalBeanException(
								"Could not copy properties from source to target",
								ex);
					}
				}
			}
		}
	}
}
