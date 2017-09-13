<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>教师信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css" />
	<link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath }/js/qunit-1.11.0.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrapv3.js"></script>
<script src="${pageContext.request.contextPath }/js/checkTeacherinfo.js"></script>
<script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	 src="${pageContext.request.contextPath}/js/ocupload/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript">
function getEnv(sid){
	location.href="listTeacher.do?sid="+sid;
}
	$(function(){
		$("#import").upload({  
		    action: '${pageContext.request.contextPath}/teacher/import.do',  
		    name:'upfile',
		    onComplete: function (data, self, element) {  
			     if(-1==data){
			    	 alert("要导入文件不是合格表格文件");
			     }else if(1==data){
			    	 alert("导入成功！");
			    	 location.reload();
			     }else if(2==data){
			    	 alert("请选择上传文件！");
			     }else{
			    	 alert("导入失败！");
			     }
		    }
	    }); 
		
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
		<h2>
			用户名<span>${loginUser.name }</span>
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath }/grade/toGrade.do" class="grade" target="leftFrame">年级结构</a></li>
            <li><a href="${pageContext.request.contextPath }/subject/toSubject.do" class="subject" target="leftFrame">学科管理</a></li>
            <li><a href="${pageContext.request.contextPath }/teacher/listTeacher.do" class="teachers" target="leftFrame">教师信息</a></li>
            <li><a href="${pageContext.request.contextPath }/student/listStudent.do" class="students" target="leftFrame">学生管理</a></li>
            <li><a href="${pageContext.request.contextPath }/album/toAlbum.do" class="album" target="leftFrame">班级相册</a></li>
		</ul>
	</div>
	<div class="detail">
		<article class="tinfo_main">
			<section class="top">
				 <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/grade/toGrade.do" target="leftFrame">教务管理 ></a>
                <a href="${pageContext.request.contextPath }/teacher/listTeacher.do" target="leftFrame">教师信息</a>
			</section>
			<%-- <div class="info_top">
				<label>学校名称：</label> <span> <select name="schoolid" onchange="this.parentNode.nextSibling.value=this.value">
						    
					        <c:forEach items="${schools }" var="sch">
					        <option value="${sch.id }">${sch.name}</option>
					        </c:forEach>
					        
				</select>
				</span><input type="text" name="schoolid" value="${school.name }"/>
			</div> --%>
			<form action="${pageContext.request.contextPath }/teacher/listTeacher.do">
				<div class="search">
					<div>
						<label>姓名：</label> <input name="name" type="text" value="${name }" />
					</div>
					<div>
						<label>学科：</label> <select name="subjectname">
						<option value="">请选择学科</option>
						<c:forEach items="${subject}" var="sub">
							<option value="${sub.name }">${sub.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="search">
					<div>
						<label>工号：</label> <input name="num" type="text" class="text" value="${num }" />
					</div>
					<div>
						<label>职务：</label> <select name="station">
						<option value="">请选择职务</option>
							<c:forEach items="${role }" var="role">
							<option value="${role.name }">${role.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="search">
					<div>
						<label>性别：</label>
                        <select name=sex>
                            <option value="">请选择性别</option>
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
					</div>
				</div>
				<div class="btn">
					<button class="lookup" type="submit" value="查找">查找</button>
					<input type="reset" class="clean" value="清除" />
				</div>
				<div class="clear"></div>
			</form>
			<section class="s_add">
				<a href="${pageContext.request.contextPath }/teacher/toAddteacher.do?sid=${school.id}"
					class="add">新增</a> 
					<!-- <a href="javascript:void(0)" onclick="add()" class="import">导入</a> -->
					<p id="import" class="import">导入</p>
			</section>
			<!--<div class="choice">请先选择学校！</div>-->
			<section class="content">
				<table>
					<thead>
						<tr>
							<th class="num"></th>
							<th class="tname">姓名</th>
							<th class="tnum">工号</th>
							<th class="sex">性别</th>
							<th class="sub">学科</th>
							<th class="job">职务</th>
							<th class="do">操作</th>
						</tr>
					</thead>
					<tbody class="con_tbody">
						<c:forEach items="${pageBean.rows }" var="teacher"
							varStatus="status">
							<tr>
								<td class="num">${status.count }</td>
								<td class="tname" name="name" title="${teacher.name}">${teacher.name}</td>
								<td class="tnum" name="num" title="${teacher.num}">${teacher.num}</td>
								<td class="sex" name="sex" title="${teacher.sexview}">${teacher.sexview}</td>
								<td class="sub" name="subjectname" title="${teacher.subjectname}">${teacher.subjectname}</td>
								<td class="job" name="edu" title="${teacher.station}">${teacher.station}</td>
								<td class="do">
								<a href="${pageContext.request.contextPath }/teacher/showTeacher.do?id=${teacher.id}" class="look">查看</a>
								 <a href="${pageContext.request.contextPath }/teacher/toUpdateTeacher.do?id=${teacher.id}&sid=${school.id}" class="revise">修改</a>
								  <a href="${pageContext.request.contextPath }/teacher/deleteTeacher.do?id=${teacher.id}" class="del">删除</a>
								  </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="bar">
					<div class="barcon">
					${pageBean.pageHtml }
						<%-- <select>
							<option value="显示10条">显示10条</option>
							<option value="显示20条">显示20条</option>
							<option value="显示30条">显示30条</option>
						</select>
						<div class="page">
							<a href="#" class="first"><img
								src="${pageContext.request.contextPath }/images/first.jpg" /></a> <a
								href="#" class="up"><img
								src="${pageContext.request.contextPath }/images/up.jpg" /></a> <span>第<input
								value="1" />页 共1页
							</span> <a href="#" class="down"><img
								src="${pageContext.request.contextPath }/images/down.jpg" /></a> <a
								href="#" class="last"><img
								src="${pageContext.request.contextPath }/images/last.jpg" /></a>
						</div>
						<a href="#" class="reload"><img
							src="${pageContext.request.contextPath }/images/reload.jpg"></a>
						<p>共10条记录</p> --%>
					</div>
				</div>
			</section>
		</article>
	</div>
	</main>
	<div id="Dao" class="easyui-window import_con">
		<h2>导入</h2>
		<div class="mould">
			<label>从模板导入：</label>
			<div class="upload">
				<input type="text" class="text" disabled="disabled" /> <span>浏览...<input id="upfile"
					type="file" class="file" name="file" /></span>
				<div class="clear"></div>
			</div>
			<a href="#">模板下载</a>
			<div class="clear"></div>
		</div>
		<div class="btn">
			<button type="submit" class="save">保存</button>
			<a href="${pageContext.request.contextPath }/teacher/listTeacher.do"><button class="close" type="button">取消</button></a>
		</div>
	</div>
</body>
</html>