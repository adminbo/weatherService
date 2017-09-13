<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>公众号管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/address.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
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
<main>
    <aside class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure" class="configure" target="leftFrame">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage" target="leftFrame">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage" target="leftFrame">学校信息管理</a></li>
            <li><a href="${pageContext.request.contextPath }/safe/toSafeList.do" class="statistics" target="leftFrame">信息统计</a></li>
            <%-- <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </aside>
    <div class="detail">
        <article class="guanli">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">技服中心 ></a>
                <a href="${pageContext.request.contextPath }/getAllWechateslist.do" target="leftFrame">公众号管理</a>
            </section>
            <form id="form1" action="${pageContext.request.contextPath }/getAllWechateslist.do" method="post">
                <div class="search">
                    <div>
                        <label>服务号ID：</label>
                        <input type="text" name="serviceids" class="text" value="${serviceids }"/>
                    </div>
                    <div>
                        <label>服务号状态：</label>
                        <select>
                            <option value="">请选择分类</option>
                            <option value="0">未认证</option>
							<option value="2">认证中</option>
							<option value="1">已认证</option>
                        </select>
                    </div>
                    <div>
                        <label>注册类型：</label>
                        <select id="regtype">
                            <option value="" >请选择分类</option>
							<option value="1" <c:if test="${data.regtype==1}">selected="selected" </c:if>>企业</option>
							<option value="2" <c:if test="${data.regtype==2}">selected="selected" </c:if>>媒体</option>
							<option value="3" <c:if test="${data.regtype==3}">selected="selected" </c:if>>政府</option>
							<option value="4" <c:if test="${data.regtype==4}">selected="selected" </c:if>>其他组织</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>服务号名称：</label>
                        <input type="text" name="name"   class="text"  value="${name }"/>
                    </div>
                    <div>
                        <label>运营者姓名：</label>
                        <input type="text" name="operator_1" class="text" value="${operator_1 }"/>
                    </div>
                    <div>
                        <label>认证类型：</label>
                        <select>
                            <option value="">请选择分类</option>
							<option value="1" <c:if test="${data.authentype==1}">selected="selected" </c:if>>企业</option>
							<option value="2" <c:if test="${data.authentype==2}">selected="selected" </c:if>>媒体</option>
							<option value="3" <c:if test="${data.authentype==3}">selected="selected" </c:if>>政府</option>
							<option value="4" <c:if test="${data.authentype==4}">selected="selected" </c:if>>其他组织</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>注册邮箱：</label>
                        <input type="email"  name="regemail" class="email" value="${regemail }"/>
                    </div>
                    <div>
                        <label>认证到期时间：</label>
                        <input class="Wdate" name="begintime"  value="${begintime }"  type="text" onClick="WdatePicker()">
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <button class="clean" type="reset" value="清空">清空</button>
                </div>
                <div class="clear"></div>
            </form>
            <section class="s_add">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" class="add">新增</a>
                <a href="#" class="import">导入</a>
            </section>
            <section class="content">
       <table>  
       <thead>
        <tr>  
            <th class="num"></th>  
            <th class="qid">服务号ID</th>  
            <th class="qname">服务号名称</th>
            <th class="ztype">注册邮箱</th>
            <th class="rtype">服务号状态</th>
            <th class="zemail">运营者姓名</th>
            <th class="yname">认证到期时间</th>
            <th class="time">注册类型</th>
            <th class="status">认证类型</th>
            <th class="do">操作</th>  
        </tr>  
        </thead>
        <tbody class="con_tbody">
        <c:forEach items="${pageBean.rows }" var="data" varStatus="status">  
            <tr>  
            	<td class="num">${status.index + 1}</td>  	 	 	 	 	
                <td class="qid">${data.serviceids }</td>  
                <td class="qname">${data.name }</td>
                <td class="ztype">${data.regemail }</td> 
                <td class="rtype">
                    <c:if test="${data.authenstate==0}">未认证</c:if>
					<c:if test="${data.authenstate==2}">认证中</c:if>
					<c:if test="${data.authenstate==1}">已认证</c:if>
                </td> 
                <td class="zemail">${data.operator_1 }</td> 
                <td class="yname">${data.begintime }</td> 
                <td class="time">
					<c:if test="${data.regtype==1}">企业</c:if>
					<c:if test="${data.regtype==2}">媒体</c:if>
					<c:if test="${data.regtype==3}">政府</c:if>
					<c:if test="${data.regtype==4}">其他组织</c:if>
                </td> 
                <td class="status">
                	<c:if test="${data.authentype==1}">企业法人</c:if>
					<c:if test="${data.authentype==2}">民办非企业</c:if>
					<c:if test="${data.authentype==3}">事业单位</c:if>
					<c:if test="${data.authentype==4}">其他组织</c:if>
                <td class="do">   
                  <a href="${pageContext.request.contextPath }/showWechat.do?id=${data.id}" class="look">查看</a>
                  <a href="${pageContext.request.contextPath }/getWechat.do?id=${data.id}" class="revise">修改</a>
                  <a href="${pageContext.request.contextPath }/deleteWechat.do?id=${data.id}" class="del">删除</a> 
 				  </td>  
            </tr>  
        </c:forEach>  
         </tbody>
    </table>  
            ${pageBean.pageHtml }
            </section>
        </article>
    </div>
</main>

<script>
    $(function(){
        var pro=$(".province");
        var city=$(".city");
        var dAC=$(".districtAndCounty");
        var num1=null;
        var num2=null;
        init();
        pro.change(function(){
            num1=pro.prop("selectedIndex");
            city.find("option").eq(0).siblings().remove();
            dAC.find("option").eq(0).siblings().remove();
            if(num1!==0){
                for(var i=0;i<province[num1-1].city.length;i++){
                    var $temp=$("<option value=\"\">"+province[num1-1].city[i].name+"</option>");
                    city.append($temp);
                }
            }
        });
        city.change(function(){
            num2=city.prop("selectedIndex");
            dAC.find("option").eq(0).siblings().remove();
            if(num2!==0){
                for(var i=0;i<province[num1-1].city[num2-1].districtAndCounty.length;i++){
                    var $temp=$("<option value=\"\">"+province[num1-1].city[num2-1].districtAndCounty[i]+"</option>");
                    dAC.append($temp);
                }
            }
        })
    });

    function init(){
        var pro=$(".province");
        for(var i=0;i<province.length;i++){
            var $temp=$("<option value=\"\">"+province[i].name+"</option>");
            pro.append($temp);
        }
    }
</script>
</body>
</html>