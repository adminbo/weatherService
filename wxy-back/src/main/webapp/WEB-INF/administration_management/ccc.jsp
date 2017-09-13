<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="teacheradd" class="easyui-window teacheradd">
		<h2>教师基本信息</h2>
		<form action="${pageContext.request.contextPath }/teacher/listTeacher.do" method="post">
		    <div>
				<label><span>*</span>头像：</label> <input name="imgurl" id="" type="text" disabled="true"
					class="text" value="${teacher.imgurl }" /> <span id="user_name_input"></span>
			</div>
			<div>
				<label><span>*</span>教师姓名：</label> <input name="name" id="" type="text" disabled="true"
					class="text" value="${teacher.name}" /> <span id="user_name_input"></span>
			</div>
			<div>
				<label><span>*</span>教师职务：</label> <input name="station" id="" type="text" disabled="true"
					class="text" value="${teacher.station}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>个人简介：</label> <input name="introduce" id="" type="text" disabled="true"
					class="text" value="${teacher.introduce}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>性别：</label> 
				<input disabled="true" name="sex" type="text" value="${teacher.sexview}"/>
			</div>
			<div>
				<label><span></span>年龄：</label> <input name="age" id="user_dw" type="text" disabled="true"
					class="text" value="${teacher.age}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>手机号码：</label> <input name="phonenum" id="user_dw" type="text" disabled="true"
					class="text"  value="${teacher.phonenum}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>毕业院校：</label> <input name="gardschool" id="user_dw" type="text" disabled="true"
					class="text"  value="${teacher.gardschool}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>工龄：</label> <input name="jobtime" id="user_dw" type="text" disabled="true"
					class="text" value="${teacher.jobtime}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>入职时间：</label> <input name="entrytime" id="user_dw" type="text" disabled="true"
					class="text" value="${teacher.entrytime}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>工号：</label> <input name="num" id="user_dw" type="text" disabled="true"
					class="text" value="${teacher.num}" /> <span id="user_dw_input"></span>
			</div>
			<div>
				<label><span></span>学科：</label> <select id="user_type" disabled="true">
					<option value="请选择分类">请选择学科</option>
					<option value=""></option>
					<option value=""></option>
				</select> <span id="user_type_input"></span>
			</div>
			<div>
				<label><span></span>年级：</label> <select id="user_type" disabled="true">
					<option value="">请选择年级</option>
					<option value=""></option>
					<option value=""></option>
				</select> <span id="user_type_input"></span>
			</div>
			<div>
				<label><span></span>班级：</label> <select id="user_type" disabled="true">
					<option value="">请选择班级</option>
					<option value=""></option>
					<option value=""></option>
				</select> <span id="user_type_input"></span>
			</div>
			<div class="btn">
				<button id="teacheradd_btn" type="submit" class="save">保存</button>
				<button class="cancel" type="button">关闭</button>
			</div>

		</form>
	</div>


</body>
</html>