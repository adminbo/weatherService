<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath }/js/teacher_update.js"></script>
</head>
<body>
<div id="teacheradd" class="easyui-window teacheradd">
		<h2>教师基本信息</h2>
		<form action="${pageContext.request.contextPath }/teacher/updateTeacher.do?id=${teacher.id}" method="post">
		    <div>
				<label><span>*</span>头像：</label> <input name="imgurl" id="" type="text"
					class="text" value="${requestScope.teacher.imgurl }" /> <span id="user_name_input"></span>
			</div>
			<div>
				<label><span>*</span>教师姓名：</label> <input name="name" id="" type="text"
					class="text" value="${teacher.name}" /> <span id="user_name_input"></span>
			</div>
			<div>
				<label><span>*</span>教师职务：</label><select name="station" id="user_type"> <%-- <input name="station" id="" type="text"
					class="text" value="${teacher.station}" />  --%>
					<c:forEach items="${role }" var="role">
					<option value="${teacher.station}">${role.name}</option>
					</c:forEach><span id="user_dw_input"></span>
					</select>
			</div>
			<div>
				<label><span></span>个人简介：</label> <input name="introduce" id="" type="text"
					class="text" value="${teacher.introduce}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>性别：</label> <select id="user_type" name="sex" title="${teacher.sexview }">	
			        <option value="1">男</option>
			        <option value="0">女</option>
				</select> <span id="user_type_input"></span>
			</div>
			<div>
				<label><span></span>年龄：</label> <input name="age" id="user_dw" type="text"
					class="text" value="${teacher.age}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>手机号码：</label> <input name="phonenum" id="user_dw" type="text"
					class="text"  value="${teacher.phonenum}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>毕业院校：</label> <input name="gardschool" id="user_dw" type="text"
					class="text"  value="${teacher.gardschool}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>工龄：</label> <input name="jobtime" id="user_dw" type="text"
					class="text" value="${teacher.jobtime}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>入职时间：</label> <input name="entrytime" id="user_dw" type="text"
					class="text" value="${teacher.entrytime}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>工号：</label> <input name="num" id="user_dw" type="text"
					class="text" value="${teacher.num}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>学科：</label> <select name="subjectname" id="user_type">
				<c:forEach items="${subject }" var="subject">
					<option value="${teacher.subjectname }">${subject.name }</option>
					</c:forEach>
					
				</select> <span id="user_type_input"></span>
			</div>
			<div>
				<label><span></span>年级：</label> <select id="user_type" name="gradeid">
				<c:forEach items="${grade }" var="grade">
					<option value="">${grade.name }</option>
					</c:forEach>
				</select> <span id="user_type_input"></span>
			</div>
			
			<div>
				<label><span></span>班级：</label> <select id="teacher_class" name="classid">
					<c:forEach items="${teachers }" var="teachers">
					<option value="">${teachers.classid }</option>
					</c:forEach>
					
				</select> <span id="user_type_input"></span>
			</div>
			<div class="btn">
				<button id="teacheradd_btn" type="submit" class="update">修改</button>
				<button class="cancel" type="button">取消</button>
			</div>

		</form>
	</div>


</body>
</html>