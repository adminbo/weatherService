<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/student_look.js"></script>
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
                <div class="bar_con">
                        <div class="look_con">
                            <h2>学生信息</h2>
                            <div class="info_con">
                                <div class="add_left">
                                    <figure>
                                        <img src="${student.imgurl }">
                                        <div class="clear"></div>
                                    </figure>
                                </div>
                                <div class="add_right">
                                    <form action="#" method="post">
                                        <div>
                                            <label>姓名：</label>
                                            <input name="name" value="${student.name }" disabled="true" type="text" />
                                        </div>
                                        <div>
                                            <label>学号：</label>
                                            <input name="num" value="${student.num }" disabled="true" type="text" />
                                        </div>
                                        <div>
                                            <label>年级：</label>
                                            <input name="num" value="${gra.name }" disabled="true" type="text" />
                                        </div>
                                        <div>
                                            <label>班级：</label>
                                            <input name="num" value="${cla.name }" disabled="true" type="text" />
                                        </div>
                                        <div>
                                            <label>性别：</label>
                                            <input name="sex" value="${student.sexview }" disabled="true" type="text" />
                                        </div>
                                        <div>
                                            <label>生日：</label>
                                            <input name="birthday" value="${student.birthday }" disabled="true" type="text" />
                                        </div>
                                        <div>
                                            <label>入学时间：</label>
                                            <input name="intime" value="${student.intime }" disabled="true" type="text" />
                                        </div>
                                            <label>备注：</label><br/>
                                            <textarea name="marks" value="${student.marks }" disabled="true"></textarea>
                                    </form>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="btn">
                               <a href="${pageContext.request.contextPath }/student/listStudent.do"><button class="close" type="button" onclick="myclick(${student.grade},${student.classid})">关闭</button></a> 
                            </div>
                        </div>
                </div>
        </article>
    </div>
</main>

</body>
</html>