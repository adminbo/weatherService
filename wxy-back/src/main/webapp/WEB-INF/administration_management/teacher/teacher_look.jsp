<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教师信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
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
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
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
            <div class="look_con">
                <h2>教师信息</h2>
                <div class="info_con">
                <div class="look_left">
                    <form action="${pageContext.request.contextPath }/teacher/listTeacher.do" method="post" class="add_left">
                        <figure>
                            <img src="${teacher.imgurl }">
                            <figcaption name="imgurl" value="${teacher.imgurl }" disabled="true">头像预览</figcaption>
                        </figure>
                        <div>
                            <label>教师姓名：</label>
                            <input name="name" value="${teacher.name }" disabled="true" type="text" />
                        </div>
                        <div>
                            <label>教师职务：</label>
                            <input name="station" value="${teacher.station }" disabled="true" type="text" />
                        </div>
                        <div>
                            <label>个人简介：</label>
                            <textarea name="introduce" value="${teacher.introduce }" disabled="true"></textarea>
                        </div>
                    </div>
                    <div class="look_right">
                        <div class="info">
                            <div>
                                <label>性别：</label>
                                <input disabled="true" name="sex" value="${teacher.sexview}" type="text"/>
                            </div>
                            <div>
                                <label>年龄：</label>
                                <input disabled="true" name="age" value="${teacher.age}" type="text" />
                            </div>
                            <div>
                                <label>手机号码：</label>
                                <input disabled="true" name="phonenum" value="${teacher.phonenum}" type="text" />
                            </div>
                            <div>
                                <label>毕业院校：</label>
                                <input disabled="true" name="gardschool" value="${teacher.gardschool}" type="text" />
                            </div>
                            <div>
                                <label>工龄：</label>
                                <input disabled="true" name="jobtime" value="${teacher.jobtime}" type="text" />
                                <p></p>
                            </div>
                            <div>
                                <label>入职时间：</label>
                                <input disabled="true" name="entrytime" value="${teacher.entrytime}" type="text" />
                            </div>
                            <div>
                                <label>工号：</label>
                                <input disabled="true" name="num" value="${teacher.num}" type="text" />
                            </div>
                            <div>
                                <label>学科：</label>
                        
                                <input disabled="true" name="subjectname" value="${teacher.subjectname}" type="text" />
                            </div>
                            <div>
                                <label>年级：</label>
                                <input disabled="true" name="gradeid" value="${grade.name}" type="text" />
                            </div>
                            <div>
                                <label>班级：</label>
                                <input disabled="true" name="classid" value="${cla.name}" type="text" />
                            </div>
                        </div>
                        </div>
                        <div class="clear"></div>
                   
                    <div class="clear"></div>
                </div>
                <div class="btn">
                    <button type="submit" class="save">保存</button>
                    <a href="${pageContext.request.contextPath }/teacher/listTeacher.do"><button class="close" type="button">关闭</button></a>
                </div>
            </div>
             </form>
        </article>
    </div>
</main>
</body>
</html>