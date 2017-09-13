<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
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
                    <form action="${pageContext.request.contextPath }/student/addStudent.do" method="post" enctype="multipart/form-data">
                        <div class="add_con">
                            <h2>学生信息</h2>
                            <div class="info_con">
                                <div class="add_left">
                                   <figure>
                                        <img src="${pageContext.request.contextPath }/images/portrait2.jpg">
                                        <figcaption>头像预览</figcaption>
                                        <div class="clear"></div>
                                    </figure>
                                    <p>更换头像照片
                                        <input type="file" class="file" name="fileName" accept="image/png,image/gif,image/jpg">
                                    </p>
                                    <div>
                                        <label>备注：</label>
                                        <textarea name="marks" placeholder="若有需要请输入备注，不超过150字..."></textarea>
                                    </div>
                                </div>
                                <div class="add_right">
                                <div>
                                        <label><span>*</span>姓名：</label>
                                        <input name="name" type="text" class="text" />
                                        <span></span>
                                    </div>
                                    <div>
                                        <label>学号：</label>
                                        <input name="num" type="text" class="text" />
                                    </div>
                                    <div>
                                        <label><span>*</span>年级：</label>
                                   <select name="grade">
                                          <option value="">请选择年级</option>
                                          <c:forEach items="${grades }" var="grade">
					                      <option value="${grade.id }">${grade.name}</option>
					                    </c:forEach>
                                   </select>
                                        <span></span>
                                    </div>
                                    <div>
                                        <label><span>*</span>班级：</label>
                                     <select name="classid">
                                            <option value="">请选择班级</option>
                                            <c:forEach items="${classes }" var="cla">
					                        <option value="${cla.id }">${cla.name}</option>
					                        </c:forEach>
                                     </select>
                                        <span></span>
                                    </div>
                                    <div>
                                        <label><span>*</span>性别：</label>
                                        <select name="sex">
                                            <option value="">请选择性别</option>
                                            <option value="1">男</option>
                                            <option value="0">女</option>
                                        </select>
                                        <span></span>
                                    </div>
                                    <div>
                                        <label><span>*</span>生日：</label>
                                        <input name="birthday" class="Wdate" type="text" onClick="WdatePicker()">
                                        <span></span>
                                    </div>
                                <div>
                                        <label>入学时间：</label>
                                        <input name="intime" class="Wdate" type="text" onClick="WdatePicker()">
                                        
                                    </div>
                                    <div>
                                        <label>身份证号：</label>
                                        <input name="idNum" type="text" class="text" />
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="btn">
                                <button type="submit" class="save">保存</button>
                                <a href="${pageContext.request.contextPath }/student/listStudent.do"><button class="close" type="button">关闭</button></a>
                            </div>                          
                        </div>
                        </form>
                </div>
        </article>
    </div>
</main>

</body>
</html>