<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>班级相册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/album.js"></script>
    <script>
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
<body>
<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
             <li><a href="${pageContext.request.contextPath }/grade/toGrade.do" class="grade" target="leftFrame">年级结构</a></li>
            <li><a href="${pageContext.request.contextPath }/subject/toSubject.do"  class="subject" target="leftFrame">学科管理</a></li>
            <li><a href="${pageContext.request.contextPath }/teacher/listTeacher.do"  class="teachers" target="leftFrame">教师信息</a></li>
            <li><a href="${pageContext.request.contextPath }/student/listStudent.do" class="students" target="leftFrame">学生管理</a></li>
            <li><a href="${pageContext.request.contextPath }/album/toAlbum.do" class="album" target="leftFrame">班级相册</a></li>
        </ul>
    </div>
    <div class="detail">
        <article class="album_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/grade/toGrade.do" target="leftFrame">教务管理 ></a>
                <a href="${pageContext.request.contextPath }/album/toAlbum.do" target="leftFrame">班级相册</a>
            </section>
          <form action="#" method="post">
                <div class="search">
                   <%--  <div>
                        <label>年级：</label>
                        <select onchange="getclass()"  id="grade_id" name="grade">
                            <option  value="">请选择年级</option>
							<c:forEach items="${grades }" var="grade">
					        <option id="opt${grade.id }" value="${grade.id }">${grade.name}</option>
					        </c:forEach>
                        </select>
                    </div> --%>
                </div>
                <!-- <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <input type="reset" class="clean" value="清空" />
                </div> -->
                <div class="clear"></div>
            </form>
            <div class="grade_con">
                <div id="tab_bar">
                    <ul id="class_input">
					 <li id="tab1" class="tab" style="background-color: #fff">
					 <span id="mr">年级</span>
					 <div style="display: none;position:absolute;z-index:2;top:38px;left:5px;width:inherit;"> 
                     <span onclick="getAllAlbum()">全年级</span>  
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
                <div class="tab_css" id="tab1_content" style="display: block">
                    <!--<div class="choice">请选择园所！</div>-->
                    <div class="tab_con">
                        <div class="album_con">
                            <ul id="lalala">
                               
                                <div class="clear"></div>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="tab_css" id="tab2_content">
                    <!--<div class="choice">请选择园所！</div>-->
                    <div class="tab_con">
                        
                        <div class="pic">
                            <ul>
                                <li>
                                    <a href="#">
                                        <figure>
                                            <img src="${pageContext.request.contextPath }/images/album.jpg">
                                            <figcaption>照片1名称</figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <figure>
                                            <img src="${pageContext.request.contextPath }/images/album2.jpg">
                                            <figcaption>照片2名称</figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <figure>
                                            <img src="${pageContext.request.contextPath }/images/album.jpg">
                                            <figcaption>照片3名称</figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <figure>
                                            <img src="${pageContext.request.contextPath }/images/album2.jpg">
                                            <figcaption>照片4名称</figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <figure>
                                            <img src="${pageContext.request.contextPath }/images/album.jpg">
                                            <figcaption>照片5名称</figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <div class="clear"></div>
                            </ul>
                            <div class="btn">
                                <a href="${pageContext.request.contextPath }/album/toAlbum.do"><button type="submit" class="close">关闭</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </div>
</main>
<div hidden="true" class="pic_main">
    <div class="pic_con"></div>
    <img src="../images/album.jpg">
    <a href="#" class="pic_left"></a>
    <a href="#" class="pic_right"></a>
</div>
<script type="text/javascript">
    var myclick = function(v) {
        var llis = document.getElementsByClassName("tab");
        for(var i = 0; i < llis.length; i++) {
            var lli = llis[i];
            if(lli == document.getElementById("tab" + v)) {
                lli.style.backgroundColor = "#fff";
            } else {
                lli.style.backgroundColor = "#e4e4e4";
            }
        }

        var divs = document.getElementsByClassName("tab_css");
        for(var i = 0; i < divs.length; i++) {

            var divv = divs[i];

            if(divv == document.getElementById("tab" + v + "_content")) {
                divv.style.display = "block";
            } else {
                divv.style.display = "none";
            }
        }

    }
</script>
</body>
</html>