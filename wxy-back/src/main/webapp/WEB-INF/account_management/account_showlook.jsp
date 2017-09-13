<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>公众号管理</title>
    <script src="/wxy-back/js/updaterevise.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/address.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<main> <%@include file="/WEB-INF/include/left_menu.jsp"%> 
    <div class="detail">
        <article>
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a<%--  href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">技服中心 ></a>
                <a href="${pageContext.request.contextPath }/getAllWechateslist.do" target="leftFrame">公众号管理</a>
            </section>
            <div class="lookcon">
                <h2>公众号详细信息</h2>
                <h3>服务号信息</h3>
                <form class="basic" action="${pageContext.request.contextPath }/updaterevise.do" method="post">
                    <div class="info">
                         <%-- <div>
                            <label>注册类型：</label>
                           <!--  <input type="text" value="其他组织"  disabled="disabled" /> -->
                            <select id="zc_type" disabled="disabled">
                            <option value="" >请选择分类</option>
							<option value="1" <c:if test="${wechat.regtype==1}">selected="selected" </c:if>>企业</option>
							<option value="2" <c:if test="${wechat.regtype==2}">selected="selected" </c:if>>媒体</option>
							<option value="3" <c:if test="${wechat.regtype==3}">selected="selected" </c:if>>政府</option>
							<option value="4" <c:if test="${wechat.regtype==4}">selected="selected" </c:if>>其他组织</option>
                            </select> 
                            <p id="zc_type_input" ></p>
                        </div>  --%>
                        <%-- <div>
                            <label>注册类型：</label>
                            <input type="text" value="${}"  disabled="disabled" />
                        </div> --%>
                        <div>
                            <label>服务号ID：</label>
                            <input type="text" value="${wechat.serviceids}" disabled="disabled" />
                        </div>
                        <div>
                            <label>服务号名称：</label>
                            <input type="text" value="${wechat.name}" disabled="disabled" />
                        </div>
                        <div>
                            <label>注册邮箱：</label>
                            <input type="text" value="${wechat.regemail}" disabled="disabled" />
                        </div>
                        <div>
                            <label>认证时间：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                        <%-- <div>
                            <label>注册邮箱：</label>
                            <input id="email" type="email" value="${wechat.regemail}" />
                            <p id="email_input"></p>
                        </div>
                        <div>
                            <label>认证时间：</label>
                            <input type="text" class="infotime" disabled="disabled" value="${wechat.authentication.authtime}"/>
                            至
                            <input type="text" class="infotime" disabled="disabled" value="${wechat.authentication.endtime}"/>
                        </div>
                        <div>
                            <label>管理员姓名：</label>
                            <input id="glname" type="text" value="${wechat.adminname}" placeholder="服务号管理员或运营者的姓名，包含分隔号“.”" />
                            <p id="glname_input"></p>
                        </div>
                        <div>
                            <label>管理员身份证：</label>
                            <input id="nameid" type="text" value="${wechat.adminidnum}" />
                            <p id="nameid_input"></p>
                        </div> --%>
                        <div>
                            <label>功能介绍：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                        <%-- <div>
                            <label>企业人数：</label>
                            <input type="text" value="${wechat.reg.peoplenum }"/>
                        </div> --%>
                    </div>
                    <div class="info">
                        <%-- <div>
                            <label>注册时间：</label>
                            <input type="text" disabled="disabled" value="${wechat.begintime }"/>
                        </div>
                        <div>
                            <label>服务号密码：</label>
                            <input id="password" type="text" value="${wechat.sercret}" placeholder="字母、数字或者英文符号，最短8位，区分大小写" />
                            <p id="password_input"></p>
                        </div>
                        <div>
                            <label>管理员手机：</label>
                            <input id="phone" type="tel" value="${wechat.adminphonenum}" />
                            <p id="phone_input"></p>
                        </div>
                        <div>
                            <label>管理员微信：</label>
                            <input id="admin_wx" type="text" value="${wechat.adminwechat}"/>
                            <p id="admin_wx_input"></p>
                        </div> --%>
                        <div>
                            <label>服务号密码：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                        <div>
                            <label>服务号状态：</label>
                            <input type="text" disabled="disabled"/>
                        </div>
                        <div>
                            <label>注册类型：</label>
                            <input type="text" value=""  disabled="disabled" />
                        </div>
                        <div>
                            <label>认证类型：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                        <%-- <div>
                            <label>认证类型：</label>
                            <select id="rz_type" name="type">
							<option value="0" <c:if test="${wechat.authentication.type==0||wechat.authentication.type==null}">selected="selected" </c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.authentication.type==1}">selected="selected"</c:if>>企业法人</option>
							<option value="2" <c:if test="${wechat.authentication.type==2}">selected="selected"</c:if>>民办非企业</option>
							<option value="3" <c:if test="${wechat.authentication.type==3}">selected="selected"</c:if>>事业单位</option>
							<option value="4" <c:if test="${wechat.authentication.type==4}">selected="selected"</c:if>>其他组织</option>
						</select>
                        </div> --%>
                        <div>
                            <label>运营地区：</label>
                            <input type="text" class="infoadd" disabled="disabled" />国
                            <input type="text" class="infoadd" disabled="disabled" />省
                            <input type="text" class="infoadd" disabled="disabled" />市
                        </div>
                    </div>
                    <div class="clear"></div>
                </form>
                <h3>机构信息</h3>
                <form class="basic">
                    <div class="info">
                        <div>
                            <label>机构名称：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgname}"/>
                        </div>
                        <div>
                            <label>法定代表人：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgrep}"/>
                        </div>
                        <div>
                            <label>机构官网：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgweb}"/>
                        </div>
                        <div>
                            <label>经营范围（一般经营范围）：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.busiscope}"/>
                        </div>
                        <div>
                            <label>机构人数：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgpeoplenum}" />
                        </div>
                        <%-- <div>
                            <label>工商执照注册号：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.businessnum}"/>
                        </div>
                        <div>
                            <label>媒体单位名称：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.mediacompany}"/>
                        </div>
                        <div>
                            <label>媒体名称：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.medianame}"/>
                        </div> --%>
                    </div>
                    <div class="info">
                        <div>
                            <label>机构地址：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgaddr}"/>
                        </div>
                        <div>
                            <label>机构简介：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgintro}"/>
                        </div>
                        <div>
                            <label>机构域名：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgdns}" />
                        </div>
                        <%-- <div>
                            <label>办公电话：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgphonenum}"/>
                        </div>
                        <div>
                            <label>组织机构代码/统一社会信用代码：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.orgcode}"/>
                        </div> --%>
                        <div>
                            <label>经营范围（前置许可经营范围）：</label>
                            <input type="text" disabled="disabled" value="${wechat.authentication.perscope}"/>
                        </div>
                        <%-- <div>
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
                            <input type="text" disabled="disabled" value="${wechat.authentication.medialicense}"/>
                        </div> --%>
                    </div>
                    <div class="clear"></div>
                </form>
                <h3>运营者信息</h3>
                <form class="basic">
                    <div class="info">
                        <%-- <div>
                            <label>运营者类型：</label>
                           <select id="yy_type" id="type" name="type">
							<option value="0" <c:if test="${wechat.operator.type==0||wechat.operator.type==null}">selected="selected"</c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.operator.type==1}">selected="selected"</c:if>>企业内部员工</option>
							<option value="2" <c:if test="${wechat.operator.type==2}">selected="selected"</c:if>>第三方代办服务商</option>
							</select>
                        </div> --%>
                        <div>
                            <label>运营者姓名：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.name }"/>
                        </div>
                        <div>
                            <label>运营者部门：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.dep }"/>
                        </div>
                        <div>
                            <label>运营者手机：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.phonenum }" />
                        </div>
                        <div>
                            <label>运营者微信：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                    </div>
                    <div class="info">
                        <div>
                            <label>运营者身份证：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.cardnum }"/>
                        </div>
                        <div>
                            <label>运营者职位：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.position }"/>
                        </div>
                        <div>
                            <label>运营者座机：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.telnum }"/>
                        </div>
                        <div>
                            <label>运营者邮箱：</label>
                            <input type="text" disabled="disabled" value="${wechat.operator.email }"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </form>
                <h3>银行开户信息</h3>
                <form class="basic">
                    <div class="info">
                        <div><label>开户名称：</label>
                            <input type="text" disabled="disabled" value="${wechat.reg.accountname }"/>
                        </div>
                        <div><label>对公账户：</label>
                            <input type="text" disabled="disabled" value="${wechat.reg.accountid}" />
                        </div>
                    </div>
                    <div class="info">
                        <div><label>开户银行：</label>
                            <input type="text" disabled="disabled" value="${wechat.reg.bank}"/>
                        </div>
                        <div><label>开户地点：</label>
                            <input type="text" disabled="disabled" value="${wechat.reg.accountaddr}"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </form>
                <h3>发票信息</h3>
                <form class="basic">
                    <div class="info">
                        <div>
                            <label>发票类型：</label>
                            <select id="fp_type" name="itype">
							<option value="0" <c:if test="${wechat.invoice.itype==0||wechat.invoice.itype==null}">selected="selected"</c:if>>请选择分类</option>
							<option value="1" <c:if test="${wechat.invoice.itype==1}">selected="selected"</c:if>>普通发票</option>
							<option value="2" <c:if test="${wechat.invoice.itype==2}">selected="selected"</c:if>>增值税发票</option>
						</select>
                        </div>
                        <div>
                            <label>联系人：</label>
                            <input type="text" disabled="disabled" value="${wechat.invoice.icontact }"/>
                        </div>
                        <div>
                            <label>邮寄地址：</label>
                            <select name="province" class="province">
							<option value="0" <c:if test="${wechat.invoice.province==null||wechat.invoice.province==0}">selected="selected"</c:if> >省份</option>
							<option value="1" <c:if test="${wechat.invoice.province==1}">selected="selected"</c:if>>测试省份</option>
						</select>省
                            <select name="city" class="city">
							<option value="0" <c:if test="${wechat.invoice.city==null||wechat.invoice.city==0}">selected="selected"</c:if>>地级市</option>
							<option value="1" <c:if test="${wechat.invoice.city==1}">selected="selected"</c:if>>测试地级市</option>
						</select>市
                            <select name="districtAndCounty" class="districtAndCounty">
							<option value="0" <c:if test="${wechat.invoice.districtAndCounty==null||wechat.invoice.districtAndCounty==0}">selected="selected"</c:if>>市、县级市</option>
							<option value="1" <c:if test="${wechat.invoice.districtAndCounty==1}">selected="selected"</c:if>>测试市、县级市</option>
						</select>县
                        </div>
                        <div>
                            <label>详细街道地址：</label>
                            <input type="text" disabled="disabled" value="${wechat.invoice.postaddr }"/>
                        </div>
                    </div>
                    <div class="info">
                        <div>
                            <label>发票抬头：</label>
                            <input type="text" disabled="disabled" value="${wechat.invoice.ititle }"/>
                        </div>
                        <div>
                            <label>联系人手机：</label>
                            <input type="text" disabled="disabled" value="${wechat.invoice.contactph0num }"/>
                        </div>
                        <div>
                            <label>邮政编码：</label>
                            <input type="text" disabled="disabled" value="${wechat.invoice.postcode }"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </form>
                <%-- <h3>注册相关证件</h3>
                <form class="basic">
                    <div class="info">
                        <div>
                            <label>企业营业执照：</label>
                            <input type="text" class="text" disabled="disabled" name="bslisurlFileName" value="${wechat.reg.bslisurl }" />
                        </div>
                        <div>
                            <label>授权运营书：</label>
                            <input type="text" class="text" disabled="disabled" name="authbookurlFileName" value="${wechat.reg.authbookurl }" />
                        </div>
                    </div>
                    <div class="info">
                        <div>
                            <label>组织机构代码证：</label>
                            <input type="text" class="text" disabled="disabled" name="orgcodeurlFileName" value="${wechat.reg.orgcodeurl }" />
                        </div>
                        <div>
                            <label>扩容承诺书：</label>
                            <input type="text" class="text" readonly="readonly" name="expsbookurlFileName" value="${wechat.reg.expsbookurl }" />
                        </div>
                    </div>
                    <div class="clear"></div>
                </form>
                <div class="service">
                    <div>
                        <label>服务号状态：</label>
                        <input type="text" disabled="disabled"/>
                    </div>
                </div>
                <h2>认证相关</h2> --%>
                <h3>认证相关证件</h3>
                <form id="certific_rela_certs" class="basic" enctype="multipart/form-data" action="#" method="post">
			<input type="hidden" name="wechatId" value="${wechat.id}" />
				<div class="info">
					<div>
						<label>
							统一社会信用代码证：
						</label>
						<input type="text" class="text" readonly="readonly" name="ufctificurlFileName" value="${wechat.authentication.ufctificurl }" />
						<p id="xydm_input"></p>
					</div>
					<div>
						<label>民办非企业登记证书：</label>
						<input type="text" class="text" readonly="readonly" name="regcertificurlFileName" value="${wechat.authentication.regcertificurl }" />
					</div>
					<div>
						<label>事业单位法人证书：</label>
						<input type="text" class="text" readonly="readonly" name="repcertificurlFileName" value="${wechat.authentication.repcertificurl }" />
					</div>
					<div>
						<label>
							运营者身份证（正面）：
						</label>
						<input type="text" readonly="readonly" name="frontidurlFileName" value="${wechat.operator.frontidurl }" />
						<%-- 反面
						<input type="text" class="infoid" readonly="readonly" name="backidurlFileName" value="${wechat.operator.backidurl }" />
						<p id="yy_id_input"></p> --%>
					</div>
					<div>
						<label>
							申请公函：
						</label>
						<input type="text" class="text" readonly="readonly" name="appliletterurlFileName" value="${wechat.authentication.appliletterurl }" />
						<p id="sq_gh_input"></p>
					</div>
					<%-- <div>
						<label>分公司人员证明：</label>
						<input type="text" class="text" readonly="readonly" name="branchstaffurlFileName" value="${wechat.authentication.branchstaffurl }" />
					</div> --%>
				</div>
				<div class="info">
					<div>
						<label>组织机构代码证：</label>
						<input type="text" class="text" readonly="readonly" name="orgcodeurlFileName" value="${wechat.authentication.appliletterurl }" />
					</div>
					<div>
                        <label>企业营业执照：</label>
                        <input type="text" class="text" disabled="disabled" name="bslisurlFileName" value="${wechat.reg.bslisurl }" />
                    </div>
					<div>
						<label>
							相关许可证：
						</label>
						<input type="text" class="text" readonly="readonly" name="permitlicenseurlFileName" value="${wechat.authentication.permitlicenseurl }" />
						<p id="xkz_input"></p>
					</div>
					<div>
						<label>
							运营者身份证（反面）：
						</label>
						<input type="text" readonly="readonly" name="backidurlFileName" value="${wechat.operator.backidurl }" />
					</div>
					<%-- <div>
						<label>内部人员证明：</label>
						<input type="text" class="text" readonly="readonly" name="staffurlFileName" value="${wechat.authentication.staffurl }" />
					</div>
					<div>
						<label>上下游合作伙伴证明：</label>
						<input type="text" class="text" readonly="readonly" name="partnerurlFileName" value="${wechat.authentication.partnerurl }" />
					</div> --%>
					<div>
						<label>其他证明材料：</label>
					 		<input type="text" class="text" readonly="readonly" name="otherurlFileName" value="${wechat.authentication.otherurl }" />
					</div>
				</div>
				<div class="clear"></div>
			</form>
            </div>
            <div class="shut">
                <a href="${pageContext.request.contextPath }/getAllWechateslist.do"><button type="button" class="close">关闭</button></a>
            </div>
        </article>
    </div>
</main>
<input  name="id" id="" type="hidden" value="${wechat.id}" />
</body>
</html>