<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学生管理</title>
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
<script src="${pageContext.request.contextPath }/js/student_info.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type='text/javascript'>
$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
    $("#tab1").click(function(){
        $(this).children().slideToggle(0,function(){
            //TODO
        });
        document.getElementById("mr").style.display = "block";
    });
});
</script>
</head>
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
		<article class="sinfo_main">
			<section class="top">
				<a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a> 
				<a href="${pageContext.request.contextPath }/grade/toGrade.do" target="leftFrame">教务管理 ></a> 
				<a href="${pageContext.request.contextPath }/student/listStudent.do" target="leftFrame">学生管理</a>
			</section>
			<%-- <div class="info_top">
				<label>学校名称：</label> <span> <select name="schoolid" onchange="this.parentNode.nextSibling.value=this.value">
						    
					        <c:forEach items="${schools }" var="sch">
					        <option value="${sch.id }">${sch.name}</option>
					        </c:forEach>
					        
				</select>
				</span><input type="text" name="schoolid" value="${school.name }"/>
			</div> --%>
			<form action="${pageContext.request.contextPath }/student/listStudent.do" method="post">
				<%-- <div class="search">
					<div>
						<label>年级：</label> <select onchange="getclass()"  id="grade_id" name="grade">
						 <option  value="">请选择年级</option>
							<c:forEach items="${grades }" var="grade">
					        <option id="opt${grade.id }" value="${grade.id }">${grade.name}</option>
					        </c:forEach>
						</select>
					</div>
				</div> --%>
				<div class="search">
					<div>
						<label>学生姓名：</label> <input name="name" type="text" />
					</div>
				</div>
				<div class="btn">
					<button class="lookup" type="submit" value="查找">查找</button>
					<input type="reset" class="clean" value="清空" />
				</div>
				<div class="clear"></div>
			</form>
			<div class="grade_con">
				<div id="tab_bar">
					<ul id="class_input">
					 <li id="tab1" class="tab" style="background-color: #fff">
					 <span id="mr">年级</span>
					 <div style="display: none;position:absolute;z-index:2;top:38px;left:5px;width:inherit;"> 
                     <span onclick="getAllStudent()">全年级</span>  
					 <c:forEach items="${grades }" var="grade">
                        <span onclick="getclass('${grade.id }','${grade.name }')"><input type="hidden" id="grade_id" value="${grade.id }"/>${grade.name }</span>  
                     </c:forEach>    
                     </div>              
                    </li>
                    <div id="banji">
                    <li id="tab2" class="tab">
                        班级1
                    </li>
                    <li id="tab3" class="tab">
                        班级2
                    </li>
                    </div>
					</ul>
				</div>
				<div class="tab_con">
					
					<div class="tab_css" id="tab1_content" style="display: block">
					<div class="s_add">
						<a href="${pageContext.request.contextPath }/student/toAddStudent.do" class="add">新增</a> <a href="javascript:void(0)" onclick="add()"
							class="batch">批量处理</a>
							<a href="javascript:void(0)" onclick="add()" class="import">导入</a>
					</div>
						<div class="content">
							<table>
								<thead>
									<tr>
										<th class="num"></th>
										<th class="sname">学生姓名</th>
										<th class="snum">学号</th>
										<th class="portrait">年级</th>
										<th class="time">班级</th>
										<th class="sex">性别</th>
										<th class="birthday">生日</th>
										<th class="do">操作</th>
									</tr>
								</thead>
								 <tbody id="yankai" class="con_tbody">								
										
									
								</tbody>
								
							</table>
							<!-- <div id="jy" class="choice">请先选择学校，年级，班级！</div> -->

							<div class="bar">
							
								<div class="barcon" id="page">
									<%-- <select>
										<option value="显示10条">显示10条</option>
										<option value="显示20条">显示20条</option>
										<option value="显示30条">显示30条</option>
									</select>
									<div class="page">
										<a href="#" class="first"><img src="${pageContext.request.contextPath }/images/first.jpg" /></a>
										<a href="#" class="up"><img src="${pageContext.request.contextPath }/images/up.jpg" /></a> <span>第<input
											value="1" />页 共1页
										</span> <a href="#" class="down"><img src="${pageContext.request.contextPath }/images/down.jpg" /></a>
										<a href="#" class="last"><img src="${pageContext.request.contextPath }/images/last.jpg" /></a>
									</div>
									<a href="#" class="reload"><img src="${pageContext.request.contextPath }/images/reload.jpg"></a>
									<p>共10条记录</p> --%>
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</article>
	</div>
	</main>
	<div id="Dao" class="import_con" class="easyui-window uadd">
		<h2>导入</h2>
		<div class="mould">
			<button type="button">升年级</button>
			<button type="button">导出</button>
		</div>
		<div class="mould">
			<label>从模板导入：</label>
			<div class="upload">
				<input type="text" class="text" disabled="disabled" /> <span>浏览...<input
					type="file" class="file" /></span>
				<div class="clear"></div>
			</div>
			<a href="#">模板下载</a>
			<div class="clear"></div>
		</div>
		<div class="btn">
			<button type="submit" class="save">保存</button>
			<a href="${pageContext.request.contextPath }/student/listStudent.do"><button class="close" type="button">取消</button></a>
		</div>
	</div>

</body>
</html>