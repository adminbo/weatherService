<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>办学特色</title>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">

    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/checksdetail.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/address.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
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
        <article class="teacher_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">校园管理 ></a>
                <a href="${pageContext.request.contextPath }/banxue/banxuelist.do" target="leftFrame">办学特色</a>
            </section>
            <section class="s_add">
                <a href="javascript:void(0)" onclick="add()" class="add">新增</a>
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="head">标题</th>
                        <th class="portrait">图片</th>
                        <th class="time">发布时间</th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                    <c:forEach items="${pageBean.rows }" var="trait" varStatus="status">
	                    <tr>
	                        <td class="num">${status.count }</td>
	                        <td class="head" title="${trait.title }">${trait.title }<em></em></td>
	                        <td class="portrait" title=""><input type="checkbox" <c:if test="${not empty trait.imgurl }">checked="checked"</c:if> disabled="disabled"/></td>
	                        <td class="time" title="${trait.publishtime }">${trait.publishtime }</td>
	                        <td class="do">
	                            <a href="javascript:void(0)" onclick="look(${trait.id})" class="look">查看</a>
	                            <a href="javascript:void(0)" onclick="revise(${trait.id})" class="revise">修改</a>
	                            <a href="javascript:void(0)" onclick="dele(${trait.id})" class="del">删除</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="bar">
                 ${pageBean.pageHtml }
                 <%--    <div class="barcon">
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
<div class="easyui-window teacher_add" id="teacher_adds" >
    <h2>特色信息</h2>
    <form action="${pageContext.request.contextPath }/banxue/addNew.do" method="post" id="ad" enctype="multipart/form-data">
        <figure>
            <div id="localImag1"><img src="" id="timg1"></div>
            <figcaption>特色预览</figcaption>
        </figure>
        <p>更换特色照片
            <input type="file" id="doc1" name="imgurl" class="file" accept="image/png,image/gif,image/jpg" onchange="javascript:setImagePreview(1);">
        </p>
        <div>
            <label><span>*</span>简介标题：</label>
            <input type="text" class="text" name="title" id="ititle"/>
            <span></span>
        </div>
        <div>
            <label>特色简介：</label>
            <textarea placeholder="请输入简介，不超过80个字..." id="ival" name="introduce"></textarea>
            <span></span>
        </div>
        <div class="btn">
            <button type="button" onclick="subadd()" class="save">保存</button>
            <button class="close" onclick="cloAdd()" type="button">取消</button>
        </div>
    </form>
</div>
<!--查看-->
<div id="teacher_looks" class="easyui-window teacher_look" >
    <h2>特色信息</h2>
    <form action="#" method="post">
        <figure>
           <div id=""><img src="" id="timg"></div> 
            <figcaption>特色预览</figcaption>
        </figure>
        <div>
            <label>简介标题：</label>
            <input type="text" class="text" value="" id="title"/>
            <span></span>
        </div>
        <div>
            <label>特色简介：</label>
            <textarea placeholder="请输入简介，不超过80个字..." id="titd"></textarea>
            <span></span>
        </div>
        <div class="btn">
            <button class="close" onclick="cloLook()" type="button">取消</button>
        </div>
    </form>
</div>
<!--修改-->
<div class="easyui-window teacher_add" id="teacher_resever">
    <h2>特色信息</h2>
    <form action="#" method="post">
        <figure>
            <img src="${pageContext.request.contextPath }/images/portrait.jpg">
            <figcaption>特色预览</figcaption>
        </figure>
        <p>更换特色照片
            <input type="file" class="file" accept="image/png,image/gif,image/jpg">
        </p>
        <div>
            <label><span>*</span>简介标题：</label>
            <input type="text" class="text" value="标题风采"/>
            <span></span>
        </div>
        <div>
            <label>特色简介：</label>
            <textarea placeholder="请输入简介，不超过80个字...">特色的风采，在不一样的国度</textarea>
            <span></span>
        </div>
        <div class="btn">
            <button type="submit" class="save">保存</button>
            <button class="close" onclick="cloEdit()" type="button">取消</button>
        </div>
    </form>
</div>


<script type="text/javascript">
//添加
function subadd(){
	var imgs=$("#doc1").val();
	var t=$("#ititle").val().trim();
	var v=$("#ival").val().trim();
	if(imgs==""){
		alert("请选择图片");
		return;
	}
	if(t==""){
		alert("请填写标题");
		return;
	}
	if(v==""){
		alert("请填写简介");
		return;
	}
	if(imgs!="" && t!=""){
		$("#ad").submit();
	}
}

function cloAdd(){
	 $("#teacher_adds").window("close");
}
function cloEdit(){
	$("#teacher_resever").window("close");
}
function cloLook(){
	 
	 $("#teacher_looks").window("close");
}
function dele(id){
	var flag=confirm("确定要删除？");
	if(flag){
		location.href="deleteById.do?id="+id;
	}
}
function look(id){
	$("#title").val("");
	 $("#timg").attr("src","");
	 $("#titd").val("");
	$.ajax({
 	    type: "get",
 	    url: "${pageContext.request.contextPath}/banxue/getById.do",
 	    data: {"id":id},
 	     success: function(d){
 	    	 $("#title").val(d.title);
 	    	 $("#timg").attr("src",d.imgurl);
 	    	 $("#titd").val(d.introduce);
      	 },
 	});	
			 $("#teacher_looks").window("open");
}
function add(){
	 $("#teacher_adds").window("open");
}
function revise(id){
	 $("#teacher_resever").window("open");
}
	
	$(function(){
	    $("#teacher_adds").window({
	        title:'学校信息',
	        width:600,
	        modal:true,
	        shadow:true,
	        closed:true,
	        height:490,
	        resizable:false
	    });
	    $("#teacher_looks").window({
	        title:'学校信息',
	        width:600,
	        modal:true,
	        shadow:true,
	        closed:true,
	        height:490,
	        resizable:false
	    });
	    $("#teacher_resever").window({
	        title:'学校信息',
	        width:600,
	        modal:true,
	        shadow:true,
	        closed:true,
	        height:490,
	        resizable:false
	    });
	});


</script>
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
</body>
</html>