<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>学校管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">

    

</head>
<body>

<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure" target="leftFrame">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage" target="leftFrame">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage" target="leftFrame">学校信息管理</a></li>
            <li><a href="${pageContext.request.contextPath }/safe/toSafeList.do" class="statistics" target="leftFrame">信息统计</a></li>
            <%-- <li><a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" class="env">校园环境</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllPeitaosheshi.do" class="fac">配套设施</a></li>
            <li><a href="${pageContext.request.contextPath }/teachers/listTeachershow.do" class="teacher">教师风采</a></li>
            <li><a href="${pageContext.request.contextPath }/banxue/banxuelist.do" class="feature">办学特色</a></li>
            <li><a href="${pageContext.request.contextPath }/foodweeks/foodweeklist.do" class="week">每周食谱</a></li>
            <li><a href="${pageContext.request.contextPath }/president.do" class="mailbox">校长信箱</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </div>
    <div class="detail">
        <article class="sdetail">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">技服中心 ></a>
                <a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" target="leftFrame">学校信息管理</a>
            </section>
            <form action="${pageContext.request.contextPath }/getAllSchoolMaster.do" method="post">
                <div class="search">
                    <div>
                        <label>学校名称：</label>
                        <input type="text" class="text" name="sname" value="${sname }"/>
                    </div>
                    <div>
                        <label>服务号名称：</label>
                        <input type="text" class="text" name="wname" value="${wname }"/>
                    </div>
                    <div class="belong">
                        <label>所属一级代理商：</label>
                        <select class="sbelong">
                            <option value="请选择代理商">请选择代理商</option>
                            <option value="杭州卓教">杭州卓教</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>学校类型：</label>
                        <select class="type" name="type">
                            <option value="">请选择类型</option>
                            <option value="1" <c:if test="${type==1 }">selected</c:if>>幼教</option>
                            <option value="2" <c:if test="${type==2 }">selected</c:if>>普教</option>

                        </select>
                    </div>
                    <div>
                        <label>学校地址：</label>
                        <select id="province" name="province">
                         <c:if test="${not empty province}"><option value="${province }">${province }</option></c:if>
                        <c:if test="${empty province  }"><option value="">省份</option></c:if>
                        </select>
                        <select name="city" id="city">
                         <c:if test="${not empty city}"><option value="${city }">${city }</option></c:if>
                        <c:if test="${empty city  }"><option value="">地级市</option></c:if>
                        </select>
                        <select name="districtAndCounty" id="districtAndCounty">
                        <c:if test="${not empty districtAndCounty }"><option value="${districtAndCounty }">${districtAndCounty }</option></c:if>
                        <c:if test="${empty districtAndCounty}"><option value="">市、县级市</option></c:if>
                        </select>
                    </div>
                    <!-- <div>

                        <label>学校地址：</label>
                        <select id="province" name="province">
                            <option value="省份">省份</option>
                            </select>
                        <select name="city" id="city">
                            <option value="地级市">地级市</option>
                        </select>
                        <select name="districtAndCounty" id="districtAndCounty">
                            <option value="市、县级市">市、县级市</option>
                        </select>
                        </div> -->
                        <div class="belong">
                        <label>所属二级代理商：</label>
                        <select class="sbelong" id="agent2" name="agentid2">
                        <c:if test="${not empty agentid2 }"><option value="${agentid2 }">${agentid2 }</option></c:if>
                        <c:if test="${empty agentid2}"><option value="">请选择代理商</option></c:if>
                           <%--  <option value="${agentid2 }">请选择代理商</option> --%>
                        </select>
                    </div>
                </div>
                <%-- <div class="search">
                    <div class="belong">
                        <label>所属一级代理商：</label>
                        <select class="sbelong" id="agent1" name="agentid1">
                        <c:if test="${not empty agentid1 }"><option value="${agentid1 }">${agentid1 }</option></c:if>
                        <c:if test="${empty agentid1}"><option value="">请选择代理商</option></c:if>
                            <option value="${agentid1 }">请选择代理商</option>
                        </select>
                    </div>
                    
                </div> --%>
                <div class="search">
                    <div>
                        <label>办学性质：</label>
                        <select>
                            <option value="请选择分类">请选择分类</option>
                            <option value="公办">公办</option>
                            <option value="民办">民办</option>
                        </select>
                    </div>
                    <div>
                        <label>入驻时间：</label>
                        <input class="Wdate" type="text" onClick="WdatePicker()">
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <input type="reset" class="clean" value="清除" />
                </div>
                <div class="clear"></div>
            </form>
            <section class="s_add">
                <a href="javascript:void(0)" onclick="add()" class="add">新增</a>
               <div id="import" class="import">导入</div>
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                    	<th class="num"></th>
                        <th class="sname">学校名称</th>
                        <th class="fname">服务号名称</th>
                        <th class="stype">学校类型</th>
                        <th class="nature">办学性质</th>
                        <th class="sadd">学校地址</th>
                        <!-- <th class="one">一级代理商</th>
                        <th class="two">二级代理商</th> -->
                        <th class="time">入驻时间
                            <button type="button"><img src="${pageContext.request.contextPath }/images/order.jpg"></button>
                        </th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                     <c:forEach items="${pageBean.rows }" var="data" varStatus="status"> 
                    <tr>
                        <td class="num">${status.index + 1}</td> 
                        <td class="sname">${data.name }</td>
                        <td class="fname">${data.wechatName}</td>
                        <td class="stype">${data.typeView }</td>
                        <td class="nature" title="">${data.natureView }</td>
                        <td class="sadd">${data.address }</td>
                        <%-- <td class="one">${data.firagentid }</td>
                        <td class="two">${data.secagentid }</td> 
                        <td class="time">${data.timeView }</td>
                        <td class="one">${data.fname }</td>
                        <td class="two">${data.sname }</td>--%>
                        <td class="time">${data.entertime}</td>
                        <td class="do">
                            <a href="javascript:void(0)" onclick="conlook(${data.id})" class="look">查看</a>
                            <a href="javascript:void(0)" onclick="conedit(${data.id})" class="revise">修改</a>
                            <a href="javascript:void(0)" onclick="del(${data.id})" class="del">删除</a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                ${pageBean.pageHtml }
  <%--               <div class="bar">
                    <div class="barcon">
                        <select>
                            <option value="显示10条">显示10条</option>
                            <option value="显示20条">显示20条</option>
                            <option value="显示30条">显示30条</option>
                        </select>
                        <div class="page">
                            <a href="#" class="first"><img src="${pageContext.request.contextPath }/images/first.jpg" /></a>
                            <a href="#" class="up"><img src="${pageContext.request.contextPath }/images/up.jpg" /></a>
                            <span>第<input value="1"/>页 共1页</span>
                            <a href="#" class="down"><img src="${pageContext.request.contextPath }/images/down.jpg" /></a>
                            <a href="#" class="last"><img src="${pageContext.request.contextPath }/images/last.jpg" /></a>
                        </div>
                        <a href="#" class="reload"><img src="${pageContext.request.contextPath }/images/reload.jpg"></a>
                        <p>共10条记录</p>
                    </div>
                </div> --%>
            </section>
        </article>
    </div>
</main>
<div id="conadd" class="easyui-window addcon">
    <h2>学校基本信息</h2>
    <form action="${pageContext.request.contextPath }/addSchool.do" method="post">
        <div>
            <label><span>*</span>学校名称：</label>
            <input id="school_name" type="text" class="text" name="name"/>
            <span id="school_name_input"></span>
        </div>
        <div>
            <label><span>*</span>服务号名称：</label>
            <input id="qiye_name" type="text" class="text" placeholder="请输入服务号名称">
     <!--        <select id="qiye_name">
                <option>请输入服务号名称</option>
                <option></option>
            </select> -->
            <input type="text" id="qiye_name" name="wechatName"/>

            <span id="qiye_name_input"></span>
        </div>
        <div>
            <label><span>*</span>学校类型：</label>
            <select id="school_type" class="type" name="type">
                <option value="" id="n1">请选择学校类型</option>
                <option value="1">幼教</option>
                <option value="2">普教</option>
            </select>
            <span id="school_type_input"></span>
        </div>
        <div>
            <label><span>*</span>办学性质：</label>
            <select>
                <option value="请选择分类">请选择分类</option>
                <option value="公办">公办</option>
                <option value="民办">民办</option>
            </select>
            <span></span>
        </div>
        <div>
            <label><span>*</span>学校地址：</label>
            <select name="province" id="province2">
                <option value="">省份</option>
            </select>
            <select name="city" id="city2">
                <option value="">地级市</option>
            </select>
            <select name="districtAndCounty" id="districtAndCounty2">
                <option value="">市、县级市</option>
            </select>
            <span id="address_input"></span>
        </div>
       <!--  <div>
            <label>入驻时间：</label>
            <input type="text" disabled="disabled" />
        </div> -->
        <div>
            <label><span>*</span>所属一级代理商：</label>
            <select id="frist_dl" class="sbelong" name="secagentid">
                <option value=''>请选择代理商</option>
            </select>
            <span id="frist_dl_input"></span>
        </div>
        <div>
            <label>所属二级代理商：</label>
            <select class="sbelong">
                <option value="请选择代理商">杭州卓教</option>
                <option value="杭州卓教">杭州卓教</option>
            </select>
        </div>
        <div class="btn">
            <button id="addbtn" type="submit"  class="save">保存</button>
           <button class="close" type="button" onclick="cos()">取消</button>
        </div>
    </form>
</div>
<div id="conlook" class="easyui-window school_look">
    <h2>学校基本信息</h2>
    <form action="#" method="post">
        <div>
            <label>学校名称：</label>
            <input type="text" id="i1" class="text" />
        </div>
        <div>
            <label>服务号名称：</label>
            <input type="text" id="i2" class="text" />
        </div>
        <div>
            <label>学校类型：</label>
            <input type="text" id="i3" class="text" />
        </div>
        <div>
            <label>办学性质：</label>
            <input type="text" id="i8" class="text" />
        </div>
        <div>
            <label>学校地址：</label>
            <input type="text" id="i4" class="text" />
        </div>
        <div>
            <label>入驻时间：</label>
            <input type="text" id="i5" class="text" />
        </div>
        <div>
            <label>所属一级代理商：</label>
            <input type="text" id="i6" class="text" />
        </div>
        <div>
            <label>所属二级代理商：</label>
            <input type="text" id="i7" class="text" />
        </div>
        <div class="btn">
            <button class="close" type="button" onclick="coe()">取消</button>
        </div>
    </form>
</div>
<div id="conedit" class="easyui-window addcon">
    <h2>学校基本信息</h2>
    <form action="${pageContext.request.contextPath }/school/update.do" method="post">
        <input type="hidden" id="sid" name="id"/>
        <div>
            <label><span>*</span>学校名称：</label>
            <input type="text" class="text" name="name" id="d1"/>
            <span></span>
        </div>
        <div>
            <label><span>*</span>服务号名称：</label>
            <input type="text" class="text" placeholder="请输入服务号名称" name="wachatName" id="d2"/>
            <span></span>
           <!--  <label>服务号名称：</label>
            <input type="text" class="text" name="wechatName" id="d2"/> -->
        </div>
        <div>
            <label><span>*</span>学校类型：</label>
            <select class="type" id="d3" name="type">
                <option value="1" id="d31">幼教</option>
                <option value="2" id="d32">普教</option>
            </select>
            <span></span>
        </div> 
        <div>
            <label><span>*</span>办学性质：</label>
            <select>
                <option value="请选择分类">请选择分类</option>
                <option value="公办">公办</option>
                <option value="民办">民办</option>
            </select>
            <span></span>
        </div>
        <div>
            <label><span>*</span>学校地址：</label>
                    <select id="province1" name="province">
                        <option value="" id="d41">省份</option>
                    </select>
                    <select name="city" id="city1">
                        <option value="" id="d42">地级市</option>
                    </select>
                    <select name="districtAndCounty" id="districtAndCounty1">
                        <option value="" id="d43">市、县级市</option>
                    </select>
            <span></span>
        </div>
        <div>
            <label>入驻时间：</label>
            <input type="text"  class="easyui-datebox" data-options="sharedCalendar:'#cc'" name="entertime" id="d5"/>
        </div>
        <div>
            <label><span>*</span>所属一级代理商：</label>
            <select class="sbelong" id="d6" name="secagentid">
                <option value="">请选择代理商</option>
            </select>
            <span></span>
        </div>
        <div>
            <label>所属二级代理商：</label>
            <select class="sbelong" name="agentid">
                <option value="">请选择代理商</option>
                <option value="杭州卓教">杭州卓教</option>
            </select>
        </div>
        <div class="btn">
            <button type="submit" class="save" >保存</button>
            <button class="close" type="button" onclick="cb()">取消</button>
        </div>
    </form>
</div>

</body>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/checksdetail.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/address.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>

<script type='application/javascript'>
$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
    //页面加载完成查询代理
    var a1='${agentid1}';
    var a2='${agentid2}';
	$.ajax({
		   type: "POST",
		   url: "agent/getAll.do",
		   //data: "name=John&location=Boston",
		   success: function(msg){
		     var l=msg.length;
		     var id="";
			   $("#agent1").html("");
			   $("#agent2").html("");
			   $("#agent1").append("<option value=''>请选择代理商</option>");
			   $("#agent2").append("<option value=''>请选择代理商</option>");
		     for(var i=0;i<l;i++){
		    	 id=msg[i].id;
		    	 if(a1==id){
			    		t ="<option value='"+id+"' selected='selected'>"+msg[i].name+"</option>";
			    	 }else{
			    		t ="<option value='"+id+"' >"+msg[i].name+"</option>";
			    	 }
		    	 if(a2==id){
			    		t2 ="<option value='"+id+"' selected='selected'>"+msg[i].name+"</option>";
			    	 }else{
			    		t2 ="<option value='"+id+"' >"+msg[i].name+"</option>";
			    	 }
		    	 /* var t="<option value='"+msg[i].id+"'>"+msg[i].name+"</option>";
		    	 var t2="<option value='"+msg[i].id+"'>"+msg[i].name+"</option>"; */
		    	 $("#agent1").append(t);
		    	 $("#agent2").append(t2);
		     }
		   }
		});
	
	$("#import").upload({  
		    action: '${pageContext.request.contextPath}/schoolImport/import.do',  
		    name:'upfile',
		    onComplete: function (data, self, element) {  
			     if(-1==data){
			    	 alert("要导入文件不是合格表格文件");
			     }else if(1==data){
			    	 alert("导入成功！");
			     }else if(2==data){
			    	 alert("请选择上传文件！");
			     }else{
			    	 alert("导入失败！");
			     }
		    }
	    }); 
	
});

	//打开查看弹窗
	function conlook(id){
		var url="${pageContext.request.contextPath}/school/findById.do";
		$.post(url,{"id":id},
			function(data) {
				$("#i1").val(data.name);
				$("#i2").val(data.wechatName);
				$("#i3").val(data.typeView);
				$("#i4").val(data.address);
				$("#i5").val(data.entertime);
				$("#i6").val(data.sname);
	    $("#conlook").window("open");
			});
	}
	
	//打开修改弹窗
	function conedit(id){
		$("#sid").val(id);
		var agentid="";
		$("#sid").val(id);
		var url="${pageContext.request.contextPath}/school/findById.do";
		$.post(url,{"id":id},
			function(data) {
			var types=data.type;
				$("#d1").val(data.name);
				$("#d2").val(data.wechatName);
				$("#d3").val(data.typeView);
				if(types==1){
					$("#d31").attr("selected","selected");
				}else{
					$("#d32").attr("selected","selected");
					
				}
				var addr = data.address;
				addr.substring();
				var strs= new Array()
				strs=addr.split("/"); //字符分割 
				var p=strs[0];
				var c=strs[1];
				var v=strs[2];
				$("#d41").text(p);
				$("#d41").val(p);
				$("#d42").text(c);
				$("#d42").val(c);
				$("#d43").text(v);
				$("#d43").val(v);
				$("#d5").val(data.entertime);
				agentid=data.secagentid;
			});
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/agent/getAll.do",
			   //data: "name=John&location=Boston",
			   success: function(msg){
			     var l=msg.length;
				   $("#d6").html("");
				   $("#d6").append("<option value=''>请选择代理商</option>");
				   var aid="";
				   var t="";
				   for(var i=0;i<l;i++){
			    	 aid=msg[i].id;
			    	 if(agentid==aid){
			    		t ="<option value='"+aid+"' selected='selected'>"+msg[i].name+"</option>";
			    	 }else{
			    		t ="<option value='"+aid+"' >"+msg[i].name+"</option>";
			    	 }
			    	 
			    	 $("#d6").append(t);
			     }
			   }
			});
		
	    $("#conedit").window("open");
	}
	//修改弹窗关闭
	function cb(){
		 $("#conedit").window("close");
	}
	//查看弹窗关闭
	function coe(){
		 $("#conlook").window("close");
	}
	//删除记录
	function del(id){
		var flag =confirm("确定要删除该学校么？")
		if(flag){
			location.href="${pageContext.request.contextPath}/school/deleteById?id="+id;
		}
	}

</script>
</html>