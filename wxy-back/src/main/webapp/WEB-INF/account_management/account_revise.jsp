<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>公众号管理</title>
<%@include file="/WEB-INF/include/static.jsp"%>
<script src="${ctx }/js/updaterevise.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type='text/javascript'>
$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
});
</script>
</head>
<body>
	<main> <%@include file="/WEB-INF/include/left_menu.jsp"%>
	<div class="detail">
		<article> 
		<section class="top"> 
		<a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a> 
		<a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">技服中心 ></a> 
		<a href="${pageContext.request.contextPath }/getAllWechateslist.do" target="leftFrame">公众号管理</a> 
		</section>
		<div class="revisecon">
			<h2>注册相关</h2>
			<h3>基本信息</h3>
			<form id="reg_basic_msg" class="basic" action="#" method="post">
				<input type="hidden" name="id" value="${wechat.id }" />
				<div class="info">
					<div>
						<label><span>*</span>服务号ID：</label>
						<input type="text" readonly="readonly" name="serviceids" value="${wechat.serviceids }" />
					</div>
					<div>
						<label><span>*</span>服务号名称：</label>
						<input type="text" readonly="readonly" name="name" value="${wechat.name }"  />
					</div>
					<div>
						<label>
							<span>*</span>
							注册邮箱：
						</label>
						<input id="email" type="email" name="regemail" value="${wechat.regemail}" placeholder="请填写微信服务号注册时提交的邮箱" />
						<p id="email_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							认证时间：
						</label>
						<input id="rz_time1" class="Wdate" name="authtime" value="${wechat.authentication.authtime}" type="text" onClick="WdatePicker({dateFmt:'yyyyMMdd'})">
						至
						<input id="rz_time2" class="Wdate" name="endtime" value="${wechat.authentication.endtime}" type="text" onClick="WdatePicker({dateFmt:'yyyyMMdd'})">
						<p id="rz_time_input"></p>
					</div>
					<div>
                        <label>功能介绍：</label>
                        <input type="text" />
                    </div>
					<%-- <div>
						<label>
							<span>*</span>
							管理员姓名：
						</label>
						<input id="glname" type="text" name="adminname" value="${wechat.adminname }" placeholder="服务号管理员或运营者的姓名，包含分隔号“.”" />
						<p id="glname_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							管理员身份证：
						</label>
						<input id="nameid" type="text" name="adminidnum" value="${wechat.adminidnum }" />
						<p id="nameid_input"></p>
					</div>
					<div>
						<label>营业执照注册号：</label>
						<input type="text" name="licensenum" value="${wechat.reg.licensenum }" />
					</div>
					<div>
						<label>企业号人数：</label>
						<input type="text" name="peoplenum" value="${wechat.reg.peoplenum }" />
					</div> --%>
				</div>
				<div class="info">
					<%-- <div>
						<label>注册时间：</label>
						<input type="text" readonly="readonly" name="begintime" value="${wechat.begintime }" />
					</div> --%>
					<div>
						<label>
							<span>*</span>
							服务号密码：
						</label>
						<input id="password" type="password" name="sercret" value="${wechat.sercret}" placeholder="字母、数字或者英文符号，最短8位，区分大小写" />
						<p id="password_input"></p>
					</div>
					<div>
				    	<label>服务号状态：</label>
				    	<select>
				    		<option value="1" <c:if test="${wechat.regtype==1}">selected="selected" </c:if>>已认证</option>
				    		<option value="0" <c:if test="${wechat.regtype==0}">selected="selected" </c:if>>未认证</option>
				    		<option value="2" <c:if test="${wechat.regtype==2}">selected="selected" </c:if>>认证中</option>
				    	</select>
				    </div>
					<div>
						<label>
							<span>*</span>
							注册类型：
						</label>
						<select id="regtype" name="regtype">
							<option value="0" <c:if test="${wechat.regtype==0||wechat.regtype==null}">selected="selected" </c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.regtype==1}">selected="selected" </c:if>>企业</option>
							<option value="2" <c:if test="${wechat.regtype==2}">selected="selected" </c:if>>媒体</option>
							<option value="3" <c:if test="${wechat.regtype==3}">selected="selected" </c:if>>政府</option>
							<option value="4" <c:if test="${wechat.regtype==4}">selected="selected" </c:if>>其他组织</option>
						</select>
						<p id="zc_type_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							认证类型：
						</label>
						<select id="rz_type" name="type">
							<option value="" >请选择分类</option>
							<option value="1" <c:if test="${wechat.authentication.type==1}">selected="selected"</c:if>>企业</option>
							<option value="2" <c:if test="${wechat.authentication.type==2}">selected="selected"</c:if>>媒体</option>
							<option value="3" <c:if test="${wechat.authentication.type==3}">selected="selected"</c:if>>政府</option>
							<option value="4" <c:if test="${wechat.authentication.type==4}">selected="selected"</c:if>>其他组织</option>
						</select>
						<p id="rz_type_input"></p>
					</div>
					<%-- <div>
						<label>
							<span>*</span>
							管理员手机：
						</label>
						<input id="phone" type="tel" name="adminphonenum" value="${wechat.adminphonenum}" />
						<p id="phone_input"></p>
					</div>
					<div>
						<label>组织机构代码：</label>
						<input id="admin_wx" type="text" name="orgcode" value="${wechat.reg.orgcode }" />
						<p id="org_code_input"></p>
					</div> --%>
					<div>
                            <label>运营地区：</label>
                            <select id="s1">
                                <option value="国家">国家</option>
                            </select>
                            <select id="s2">
                                <option value="省份、州">省份、州</option>
                            </select>
                            <select id="s3">
                                <option value="地级市、县">地级市、县</option>
                            </select>
                            <p></p>
                        </div>
				</div>
				<div class="clear"></div>
			</form>
			<h3>机构信息</h3>
			<form id="certification_basic_msg" class="basic" action="#" method="post">
			<input type="hidden" name="id" value="${wechat.authentication.id}" />
			<input type="hidden" name="authentication.wechat.id" value="${wechat.id}" />
				<div class="info">
					<div>
						<label>
							<span>*</span>
							机构名称：
						</label>
						<input id="jg_name" type="text" name="orgname" value="${wechat.authentication.orgname}" />
						<p id="jg_name_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							法定代表人：
						</label>
						<input id="fr_name" type="text" name="orgrep" value="${wechat.authentication.orgrep}" placeholder="分支机构请填写执照上明确的负责人，否则是法人" />
						<p id="fr_name_input"></p>
					</div>
					<div>
						<label>机构官网：</label>
						<input type="text" name="orgweb" value="${wechat.authentication.orgweb}" placeholder="如果有官网，最好填写" />
					</div>
					<div>
						<label>经营范围（一般经营范围）：</label>
						<input type="text" name="busiscope" value="${wechat.authentication.busiscope}" placeholder="与企业工商营业执照上一致" />
					</div>
					<div>
						<label>工商执照注册号：</label>
						<input type="text" name="businessnum" value="${wechat.authentication.businessnum}" />
					</div>
					<div>
						<label>
							机构人数：
						</label>
						<input id="num" type="text" placeholder="学校请填写教师数和学生数总和" name="orgpeoplenum" value="${wechat.authentication.orgpeoplenum}" />
						<!-- <p id="num_input"></p> -->
					</div>
					<%-- <div>
						<label>媒体单位名称：</label>
						<input type="text" name="mediacompany" value="${wechat.authentication.mediacompany}" placeholder="请填写组织机构代码证上的名称" />
					</div>
					<div>
						<label>媒体名称：</label>
						<input type="text" name="medianame" value="${wechat.authentication.medianame}" placeholder="请填写频道/节目/报纸/期刊的名称" />
					</div> --%>
				</div>
				<div class="info">
					<div>
						<label>
							<span>*</span>
							机构地址：
						</label>
						<input id="address" type="text" name="orgaddr" value="${wechat.authentication.orgaddr}" />
						<p id="address_input"></p>
					</div>
					<div>
						<label>机构简介：</label>
						<input type="text" name="orgintro" value="${wechat.authentication.orgintro}" />
					</div>
					<div>
					<label>
						<span>*</span>
						机构域名：</label>
						<input id="jg_ym" type="text" name="orgdns" value="${wechat.authentication.orgdns}" />
						<p id="jg_ym_input"></p>
					</div>
					<div>
						<label>经营范围（前置许可经营范围）：</label>
						<input type="text" name="perscope" value="${wechat.authentication.perscope}" placeholder="没有则填“无”" />
					</div>
					<%-- <div>
						<label>
							<span>*</span>
							办公电话：
						</label>
						<input id="tel" type="tel" name="orgphonenum" value="${wechat.authentication.orgphonenum}" placeholder="包括区号、电话、分机号，以“-”隔开" />
						<p id="tel_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							组织机构代码/统一社会信用代码：
						</label>
						<input id="daima" type="text" name="orgcode" value="${wechat.authentication.orgcode}" />
						<p id="daima_input"></p>
					</div>
					<div>
						<label>媒体类型：</label>
						<select name="mediatype">
							<option value="0" <c:if test="${wechat.authentication.mediatype==0||wechat.authentication.mediatype==null}">selected="selected"</c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.authentication.mediatype==1}">selected="selected"</c:if>>频道</option>
							<option value="2" <c:if test="${wechat.authentication.mediatype==2}">selected="selected"</c:if>>节目</option>
							<option value="3" <c:if test="${wechat.authentication.mediatype==3}">selected="selected"</c:if>>报纸</option>
							<option value="4" <c:if test="${wechat.authentication.mediatype==4}">selected="selected"</c:if>>期刊</option>
						</select>
					</div>
					<div>
						<label>媒体单位工商登记号：</label>
						<input type="text" name="medialicense" value="${wechat.authentication.medialicense}" />
					</div> --%>
				</div>
				<div class="clear"></div>
			</form>
			<h3>运营者信息</h3>
			<form id="operation_msg" class="basic" action="#" method="post">
			<input type="hidden" name="id" value="${wechat.operator.id}" />
			<input type="hidden" name="operator.wechat.id" value="${wechat.id}" />
				<div class="info">
					<%-- <div>
						<label>
							<span>*</span>
							运营者类型：
						</label>
						<select id="yy_type" name="type"/>
							<option value="0" <c:if test="${wechat.operator.type==0||wechat.operator.type==null}">selected="selected"</c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.operator.type==1}">selected="selected"</c:if>>企业内部员工</option>
							<option value="2" <c:if test="${wechat.operator.type==2}">selected="selected"</c:if>>第三方代办服务商</option>
						</select>
						<p id="yy_type_input"></p>
					</div> --%>
					<div>
						<label>
							<span>*</span>
							运营者姓名：
						</label>
						<input id="yy_name" type="text" name="name" value="${wechat.operator.name }" placeholder="与申请公函上的运营者一致" />
						<p id="yy_name_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者部门：
						</label>
						<input id="bumen" type="text" name="dep" value="${wechat.operator.dep }" />
						<p id="bumen_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者手机：
						</label>
						<input id="yy_phone" type="tel" name="phonenum" value="${wechat.operator.phonenum }" />
						<p id="yy_phone_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者微信：
						</label>
						<input id="admin_wx" type="text" name="adminwechat" value="${wechat.adminwechat}" />
						<p id="admin_wx_input"></p>
					</div>
				</div>
				<div class="info">
					<div>
						<label>
							<span>*</span>
							运营者身份证：
						</label>
						<input id="yy_nameid" type="text" name="cardnum" value="${wechat.operator.cardnum }" />
						<p id="yy_nameid_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者职位：
						</label>
						<input id="yy_zw" type="text" name="position" value="${wechat.operator.position }" />
						<p id="yy_zw_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者座机：
						</label>
						<input id="yy_tel" type="tel" name="telnum" value="${wechat.operator.telnum }" placeholder="包括区号、电话、分机号，以“-”隔开" />
						<p id="yy_tel_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者邮箱：
						</label>
						<input id="yy_email" type="text" name="email" value="${wechat.operator.email }" />
						<p id="yy_email_input"></p>
					</div>
				</div>
				<div class="clear"></div>
			</form>
			<h3>银行开户信息</h3>
			<form id="bank_open_msg" class="basic" action="#" method="post">
			<input type="hidden" name="regid" value="${wechat.reg.regid}" />
			<input type="hidden" name="reg.wechat.id" value="${wechat.id}" />
				<div class="info">
					<div>
						<label>
							<span>*</span>
							开户名称：
						</label>
						<input id="kh_name" type="text" name="accountname" value="${wechat.reg.accountname }" />
						<p id="kh_name_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							对公账户：
						</label>
						<input id="dg_zh" type="text" name="accountid" value="${wechat.reg.accountid}" placeholder="和组织机构代码证上的机构名称一致" />
						<p id="dg_zh_input"></p>
					</div>
				</div>
				<div class="info">
					<div>
						<label>
							<span>*</span>
							开户银行：
						</label>
						<input id="kh_yh" type="text" name="bank" value="${wechat.reg.bank}" />
						<p id="kh_yh_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							开户地点：
						</label>
						<input id="kh_address" type="text" name="accountaddr" value="${wechat.reg.accountaddr}" />
						<p id="kh_address_input"></p>
					</div>
				</div>
				<div class="clear"></div>
			</form>
			<%-- <h3>注册相关证件</h3>
			<form id="reg_credentials" class="basic" enctype="multipart/form-data" action="#" method="post">
				<div class="info">
					<div>
						<label>企业营业执照：</label>
						<input type="text" class="text" readonly="readonly" name="bslisurlFileName" filename="${wechat.reg.bslisurl }" />
                        <em>浏览<input type="file" name="bslisurl" value="" class="file" /></em>
					</div>
					<div>
						<label>授权运营书：</label>
						<input type="text" class="text" readonly="readonly" name="authbookurlFileName" filename="${wechat.reg.authbookurl }" />
                        <em>浏览<input type="file" name="authbookurl" value="" class="file" /></em>
					</div>
				</div>
				<div class="info">
					<div>
						<label>组织机构代码证：</label>
						<input type="text" class="text" readonly="readonly" name="orgcodeurlFileName" filename="${wechat.reg.orgcodeurl }" />
                        <em>浏览<input type="file" name="orgcodeurl" value="" class="file" /></em>
					</div>
					<div>
						<label>扩容承诺书：</label>
						<input type="text" class="text" readonly="readonly" name="expsbookurlFileName" filename="${wechat.reg.expsbookurl }" />
                        <em>浏览<input type="file" name="expsbookurl" value="" class="file" /></em>
					</div>
				</div>
				<div class="clear"></div>
			</form>
			<div class="service"></div>
			<h2>认证相关</h2> --%>
			<h3>发票信息</h3>
			<form id="invoice_msg" class="basic" action="#" method="post">
			<input type="hidden" name="id" value="${wechat.invoice.id}" />
			<input type="hidden" name="invoice.wechat.id" value="${wechat.id}" />
				<div class="info">
					<div>
						<label>
							<span>*</span>
							发票类型：
						</label>
						<select id="fp_type" name="itype">
							<option value="0" <c:if test="${wechat.invoice.itype==0||wechat.invoice.itype==null}">selected="selected"</c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.invoice.itype==1}">selected="selected"</c:if>>普通发票</option>
							<option value="2" <c:if test="${wechat.invoice.itype==2}">selected="selected"</c:if>>增值税发票</option>
						</select>
						<p id="fp_type_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							联系人：
						</label>
						<input id="lxr" type="text" name="icontact" value="${wechat.invoice.icontact }" />
						<p id="lxr_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							邮寄地址：
						</label>
						<select name="province" id="province" class="province">
							<option value="0" <c:if test="${wechat.invoice.province==null||wechat.invoice.province==0}">selected="selected"</c:if> >省份</option>
							<option value="1" <c:if test="${wechat.invoice.province==1}">selected="selected"</c:if>>测试省份</option>
						</select>
							<p id="province_input"></p>
						<select name="city" id="city" class="city">
							<option value="0" <c:if test="${wechat.invoice.city==null||wechat.invoice.city==0}">selected="selected"</c:if>>地级市</option>
							<option value="1" <c:if test="${wechat.invoice.city==1}">selected="selected"</c:if>>测试地级市</option>
						</select>
							<p id="city_input"></p>
						<select name="districtAndCounty" id="districtAndCounty" class="districtAndCounty">
							<option value="0" <c:if test="${wechat.invoice.districtAndCounty==null||wechat.invoice.districtAndCounty==0}">selected="selected"</c:if>>市、县级市</option>
							<option value="1" <c:if test="${wechat.invoice.districtAndCounty==1}">selected="selected"</c:if>>测试市、县级市</option>
						</select>
						<p id="districtAndCounty_input"></p>
						<p></p>
					</div>
					<div>
						<label>
							<span>*</span>
							详细街道地址：
						</label>
						<input id="xxdz" type="text" name="postaddr" value="${wechat.invoice.postaddr }" />
						<p id="xxdz_input"></p>
					</div>
				</div>
				<div class="info">
					<div>
						<label>
							<span>*</span>
							发票抬头：
						</label>
						<input id="fp_head" type="text" name="ititle" value="${wechat.invoice.ititle }" />
						<p id="fp_head_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							联系人手机：
						</label>
						<input id="lxr_phone" type="tel" name="contactph0num" value="${wechat.invoice.contactph0num }" />
						<p id="lxr_phone_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							邮政编码：
						</label>
						<input id="yzbm" type="text" name="postcode" value="${wechat.invoice.postcode }" />
						<p id="yzbm_input"></p>
					</div>
				</div>
				<div class="clear"></div> 
			</form>
			<h3>认证相关证件</h3>
			<form id="certific_rela_certs" class="basic" enctype="multipart/form-data" action="#" method="post">
			<input type="hidden" name="wechatId" value="${wechat.id}" />
				<div class="info">
					<div>
						<label>
							<span>*</span>
							统一社会信用代码证：
						</label>
						<input type="text" class="text" readonly="readonly" name="ufctificurlFileName" filename="${wechat.authentication.ufctificurl }" />
                        <em>浏览<input id="xydm" type="file" name="ufctificurl" value="" class="file" /></em>
						<p id="xydm_input"></p>
					</div>
					<div>
						<label>民办非企业登记证书：</label>
						<input type="text" class="text" readonly="readonly" name="regcertificurlFileName" filename="${wechat.authentication.regcertificurl }" />
                        <em>浏览<input type="file" name="regcertificurl" value="" class="file" /></em>
					</div>
					<div>
						<label>事业单位法人证书：</label>
						<input type="text" class="text" readonly="readonly" name="repcertificurlFileName" filename="${wechat.authentication.repcertificurl }" />
                        <em>浏览<input type="file" name="repcertificurl" value="" class="file" /></em>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者身份证（正面）：
						</label>
						<input type="text" readonly="readonly" name="frontidurlFileName" filename="${wechat.operator.frontidurl }" />
                        <em>浏览<input id="yy_nameid_z" type="file" name="frontidurl" value="" class="file" /></em>
						<%-- 反面
						<input type="text" class="infoid" readonly="readonly" name="backidurlFileName" filename="${wechat.operator.backidurl }" />
                        <em>浏览<input id="yy_nameid_f" type="file" name="backidurl" value="" class="file" /></em>
						<p id="yy_id_input"></p> --%>
					</div>
					<div>
						<label>
							<span>*</span>
							申请公函：
						</label>
						<input type="text" class="text" readonly="readonly" name="appliletterurlFileName" filename="${wechat.authentication.appliletterurl }" />
                        <em>浏览<input id="sq_gh" type="file" name="appliletterurl" value="" class="file" /></em>
						<p id="sq_gh_input"></p>
					</div>
					<div>
						<label>分公司人员证明：</label>
						<input type="text" class="text" readonly="readonly" name="branchstaffurlFileName" filename="${wechat.authentication.branchstaffurl }" />
                        <em>浏览<input type="file" name="branchstaffurl" value="" class="file" /></em>
					</div>
				</div>
				<div class="info">
					<div>
						<label>组织机构代码证：</label>
						<input type="text" class="text" readonly="readonly" name="orgcodeurlFileName" filename="${wechat.authentication.orgcodeurl }" />
                        <em>浏览<input type="file" name="orgcodeurl" value="" class="file" /></em>
					</div>
					<div>
						<label>企业营业执照：</label>
						<input type="text" class="text" readonly="readonly" name="bslisurlFileName" filename="${wechat.reg.bslisurl }" />
                        <em>浏览<input type="file" name="bslisurl" value="" class="file" /></em>
					</div>
					<div>
						<label>
							<span>*</span>
							相关许可证：
						</label>
						<input type="text" class="text" readonly="readonly" name="permitlicenseurlFileName" filename="${wechat.authentication.permitlicenseurl }" />
                        <em>浏览<input id="xkz" type="file" name="permitlicenseurl" value="" class="file" /></em>
						<p id="xkz_input"></p>
					</div>
					<div>
						<label>
							<span>*</span>
							运营者身份证（反面）：
						</label>
						<input type="text" readonly="readonly" name="backidurlFileName" filename="${wechat.operator.backidurl }" />
                        <em>浏览<input type="file" name="backidurl" value="" class="file" /></em>
					</div>
					<%-- <div>
						<label>内部人员证明：</label>
						<input type="text" class="text" readonly="readonly" name="staffurlFileName" filename="${wechat.authentication.staffurl }" />
                        <em>浏览<input type="file" name="staffurl" value="" class="file" /></em>
					</div>
					<div>
						<label>上下游合作伙伴证明：</label>
						<input type="text" class="text" readonly="readonly" name="partnerurlFileName" filename="${wechat.authentication.partnerurl }" />
                        <em>浏览<input type="file" name="partnerurl" value="" class="file" /></em>
					</div> --%>
					<div>
						<label>其他证明材料：</label>
					 		<input type="text" class="text" readonly="readonly" name="otherurlFileName" filename="${wechat.authentication.otherurl }" />
                            <em>浏览<input type="file" name="otherurl" value="" class="file" /></em>
					</div>
				</div>
				<div class="clear"></div>
			</form>
		</div>
		<div class="shut">
			<button id="update_btn" type="submit" class="save">保存</button>
			<a href="${pageContext.request.contextPath }/getAllWechateslist.do">
				<button type="button" class="close">关闭</button>
			</a>
		</div>
		</article>
	</div>
	</main>
</body>
</html>