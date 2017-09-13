<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>教师信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
</head>
<body>
<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="grade.html" class="grade" target="leftFrame">年级结构</a></li>
            <li><a href="" class="subject" target="leftFrame">学科管理</a></li>
            <li><a href="${pageContext.request.contextPath}/teacher/listTeacher.do" class="teachers" target="leftFrame">教师信息</a></li>
            <li><a href="${pageContext.request.contextPath}/student/listStudent.do"  class="students" target="leftFrame">学生管理</a></li>
        </ul>
    </div>
    <div class="detail">
        <article class="teacher_info_main">
            <section class="top">
                <a href="#" target="leftFrame">首页 ></a>
                <a href="#" target="leftFrame">教务管理 ></a>
                <a href="${pageContext.request.contextPath}/teacher/showteacher.do" target="leftFrame">教师信息</a>
            </section>

        </article>
    </div>
</main>
</body>
</html>