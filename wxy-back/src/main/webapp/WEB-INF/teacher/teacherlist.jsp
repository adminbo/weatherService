<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>教师风采</title>
    <script src="${pageContext.request.contextPath }/js/checksdetail.js"></script>
    <script src="${pageContext.request.contextPath }/js/address.js"></script>
</head>
<body>
<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
           <%-- <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage">学校信息管理</a></li> --%>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" class="env" target="leftFrame">校园环境</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllPeitaosheshi.do" class="fac" target="leftFrame">配套设施</a></li>
            <li><a href="${pageContext.request.contextPath }/teachers/listTeachershow.do" class="teacher" target="leftFrame">教师风采</a></li>
            <li><a href="${pageContext.request.contextPath }/banxue/banxuelist.do" class="feature" target="leftFrame">办学特色</a></li>
            <li><a href="${pageContext.request.contextPath }/foodweeks/foodweeklist.do" class="week" target="leftFrame">每周食谱</a></li>
            <li><a href="${pageContext.request.contextPath }/president.do" class="mailbox" target="leftFrame">校长信箱</a></li>
           <%--  <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </div>

    <div class="detail">
    
    	<form action="${pageContext.request.contextPath }/teachers/listTeachershow.do" method="post" id="fm"></form>
    
        <article class="teacher_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%>>校园管理 ></a>
                <a href="${pageContext.request.contextPath }/teachers/listTeachershow.do" target="leftFrame">教师风采</a>
            </section>
            <section class="s_add">
               <!--  <a href="javascript:void(0)" onclick="add()" class="add">新增</a> -->
               <!--  <a href="#" class="import">导入</a> -->
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="head">标题</th>
                        <th class="portrait">头像</th>
                        <th class="time">发布时间</th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                   
                    	<c:forEach items="${pageBean.rows }" var="teacher" varStatus="status">
		                    <tr>
		                        <td class="num">${status.count }</td>
		                        <td class="head" title="">${teacher.name }/${teacher.station }<em></em></td>
		                        <td class="portrait" title=""><input type="checkbox"  <c:if test="${not empty teacher.imgurl }">checked="checked"</c:if> disabled="disabled"/></td>
		                        <td class="time" title="">${teacher.addtime }</td>
		                        <td class="do">
		                            <a href="javascript:void(0)" onclick="show(${teacher.id})" class="look">查看</a>
		                            <a href="javascript:void(0)" onclick="edit(${teacher.id})" class="revise">修改</a>
		                            <a href="javascript:void(0)" onclick="delt(${teacher.id})" class="del">删除</a>
		                        </td>
		                    </tr>
	                    </c:forEach>
                 
                    </tbody>
                </table>
                <div class="bar">
                ${pageBean.pageHtml }
            <%--         <div class="barcon">
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
                    </div> --%>
                </div>
            </section>
        </article>
    </div>
</main>
<!--新增-->
<div id="teacher_add" class="easyui-window teacher_add">
    <h2>教师信息</h2>
    <form action="${pagaContext.request.contextPath }/teachers/addTea.do" method="post" enctype="multipart/form-data">
        <figure>
            <div id="localImag1"><img src="" id="timg1"></div>
            <figcaption>头像预览</figcaption>
        </figure>
        <p>更换头像照片
            <input id="doc1" type="file" name="pic" class="file" accept="image/png,image/gif,image/jpg" onchange="javascript:setImagePreview(1);">
        </p>
        <div>
            <label><span>*</span>教师姓名：</label>
            <input type="text" name="name" id="an" class="text" />
            <span></span>
        </div>
        <div>
            <label><span>*</span>教师职务：</label>
            <select name="station" id="as">
            </select>
            <span></span>
        </div>
        <div>
            <label>个人简介：</label>
            <textarea placeholder="请输入简介，不超过80个字..." name="introduce" id="ai"></textarea>
            <span></span>
        </div>
        <div class="btn">
            <button type="submit" class="save">保存</button>
            <button class="close" type="button" onclick="cloAdd()">取消</button>
        </div>
    </form>
</div>
<!--查看-->
<div class="easyui-window teacher_look" id="teacher_look">
    <h2>教师信息</h2>
    <form action="#" method="post">
        <figure>
            <img src="" id="img">
            <figcaption>头像预览</figcaption>
        </figure>
        <div>
            <label>教师姓名：</label>
            <input type="text" class="text" value="" id="name"/>
            <span></span>
        </div>
        <div>
            <label>教师职务：</label>
            <input type="text" class="text" value="" id="what"/>
            <span></span>
        </div>
        <div>
            <label>个人简介：</label>
            <textarea id="pi"></textarea>
            <span></span>
        </div>
        <div class="btn">
            <button class="close" type="button" onclick="cloShow()">取消</button>
        </div>
    </form>
</div>
<!--修改-->
<div class="easyui-window addcon" id="teacher_edit">
    <h2>教师信息</h2>
    <form action="${pageContext.request.contextPath }/teachers/updateTea.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="tid" id="tid">
        <figure>
            <div id="localImag2"><img src="" id="timg2"></div>
            <figcaption>头像预览</figcaption>
        </figure>
        <p>更换头像照片
            <input name="pic" id="doc2" type="file" class="file" accept="image/png,image/gif,image/jpg" onchange="javascript:setImagePreview(2);">
        </p>
        <div>
            <label><span>*</span>教师姓名：</label>
            <input type="text" name="name" class="text" id="tname" value=""/>
            <span></span>
        </div>
        <div>
            <label><span>*</span>教师职务：</label>
            <!-- <select name="station" id="tst">
            </select> -->
            <input type="text" name="station" class="text" id="tsta" value=""/>
            <span></span>
        </div>
        
        <div>
            <label>个人简介：</label>
            <textarea placeholder="请输入简介，不超过80个字..." name="introduce" id="itd"></textarea>
            <span></span>
        </div>
        <div class="btn">
            <button type="submit" class="save">保存</button>
            <button class="close" type="button" onclick="cloEdit()">取消</button>
        </div>
    </form>
</div>
<script type="text/javascript">
		//下面用于图片上传预览功能
		function setImagePreview(id) {
			var docObj=document.getElementById("doc"+id);
			var imgObjPreview=document.getElementById("timg"+id);
			if(docObj.files &&docObj.files[0]){
				//火狐下，直接设img属性
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = '150px';
				imgObjPreview.style.height = '180px'; 
				//imgObjPreview.src = docObj.files[0].getAsDataURL();
				 
				//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			}else{
				//IE下，使用滤镜
				docObj.select();
				var imgSrc = document.selection.createRange().text;
				var localImagId = document.getElementById("localImag"+id);
				//必须设置初始大小
				localImagId.style.width = "150px";
				localImagId.style.height = "180px";
					//图片异常的捕捉，防止用户修改后缀来伪造图片
				try{
					localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
					localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
				}catch(e){
					alert("您上传的图片格式不正确，请重新选择!");
					return false;
				}
					imgObjPreview.style.display = 'none';
					document.selection.empty();
			}
				return true;
		}
 
</script>
<script type="text/javascript">
function delt(id){
	var flag=confirm("确定删除？")
	if(flag){
		location.href="deleteById.do?id="+id;
	}
}
	function cloAdd(){
		$("#ai").val("");
		$("#an").val("");
		$("ag").attr("src","");
		$("#as").html("");
		 $("#teacher_add").window("close");
	}
	function cloEdit(){
		$("#timg").attr("src","");
		$("#doc").val("");
		$("tname").val("");
		$("tst").html("");
		$("#itd").val("");
		$("#tid").val("");
		$("#teacher_edit").window("close");
	}
	function cloShow(){
		 $("#teacher_look").window("close");
	}
	function add(id){
		$("#as").html("");
		$("#as").append("<option value=''>请选择</option>")
		$.ajax({
     	    type: "get",
     	    url: "${pageContext.request.contextPath}/teachers/getAllStation.do",
     	    data: {},
     	     success: function(d){
     	    	var roles=d.roles;
     	    	$.each(roles, function(i, role) { 
     	    		var tr="<option value='"+role.name+"'>"+role.name+"</option>"
     	    	    $("#as").append(tr)
     	    	}); 
          	 },
     	});	
		 $("#teacher_add").window("open");
	}

	function show(id){
		$.ajax({
	     	    type: "get",
	     	    url: "${pageContext.request.contextPath}/teachers/getById.do",
	     	    data: {"id":id},
	     	     success: function(d){
	     	    	 var imgurl=d.imgurl;
	          	     var name=d.name;
	          	     var introduce=d.introduce;
	          	     var station=d.station;
	          	     $("#img").attr("src",imgurl);
	          	     $("#name").val(name);
	          	     $("#pi").val(introduce);
	          	     $("#what").val(station); 
	          	 },
	     	});	
		 $("#teacher_look").window("open");
	}

	function edit(id){
		$("#timg2").attr("src","");
		$("#tid").val(id);
 	    var tr="";
 	    //$("#tst").html("");
 	    $("#tsta").val("");
 	    $("#tname").val("");
 	   // $("#tst").append("<option value=''>请选择</option>")
		$.ajax({
     	    type: "get",
     	    url: "${pageContext.request.contextPath}/teachers/getTea.do",
     	    data: {"id":id},
     	     success: function(d){
     	    	var tea=d.teacher;
     	    	$("#timg2").attr("src",tea.imgurl)
     	    	$("#tname").val(tea.name);
     	    	$("#itd").val(tea.introduce);
     	    	$("#tsta").val(tea.station);
					/*$.ajax({
			     	    type: "get",
			     	    url: "${pageContext.request.contextPath}/teachers/getAllStation.do",
			     	    data: {"id":id},
			     	     success: function(d){
			     	    	var roles=d.roles;
			     	    	$.each(roles, function(i, role) { 
			     	    		if(tea.station==role.name){
			     	    			tr="<option value='"+role.name+"' selected='true'>"+role.name+"</option>"
			     	    		}else{
			     	    			tr="<option value='"+role.name+"'>"+role.name+"</option>"
			     	    		}
			     	    	     $("#tst").append(tr)
			     	    	}); 
			          	 },
			     	});	*/
				 $("#teacher_edit").window("open");
          	 },
     	});	
	}
	
	$(function(){
	    $("#teacher_add").window({
	        title:'教师信息',
	        width:600,
	        modal:true,
	        shadow:true,
	        closed:true,
	        minimizable:false,
	        height:500,
	        resizable:false
	    });
	});


	$(function(){
	    $("#teacher_edit").window({
	        title:'教师信息',
	        width:600,
	        modal:true,
	        shadow:true,
	        closed:true,
	        minimizable:false,
	        height:500,
	        resizable:false
	    });
	});

	$(function(){
	    $("#teacher_look").window({
	        title:'教师信息',
	        width:600,
	        modal:true,
	        shadow:true,
	        closed:true,
	        minimizable:false,
	        height:500,
	        resizable:false
	    });
	});

</script>
</body>
</html>