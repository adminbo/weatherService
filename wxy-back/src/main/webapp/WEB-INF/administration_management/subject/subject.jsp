<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学科管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/showSubject.js"></script>
      <script src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
    <script type='text/javascript'>
$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
    
	$("#import").upload({  
	    action: '${pageContext.request.contextPath}/subject/import.do',  
	    name:'upfile',
	    onComplete: function (data, self, element) {  
		     if(-1==data){
		    	 alert("要导入文件不是合格表格文件");
		     }else if(1==data){
		    	 alert("导入成功！");
		    	 window.location.reload();
		     }else if(2==data){
		    	 alert("请选择上传文件！");
		     }else{
		    	 alert("导入失败！");
		     }
	    }
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
        <article class="subject_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/grade/toGrade.do" target="leftFrame">教务管理 ></a>
                <a href="${pageContext.request.contextPath }/subject/toSubject.do" target="leftFrame">学科管理</a>
            </section>
            <section class="s_add">
                <p id="import" class="import">导入</p>
            </section>
           <%--  <div class="info_top">
                <label>学校名称：</label> <span> <select name="schoolid" onchange="this.parentNode.nextSibling.value=this.value">
						    
					        <c:forEach items="${schools }" var="sch">
					        <option value="${sch.id }">${sch.name}</option>
					        </c:forEach>
					        
				</select>
				</span><input type="text" name="schoolid" value="${school.name }"/>
            </div> --%>
            <div class="grade_con">
                <div id="tab_bar">
                    <ul>
                    <c:forEach items="${grades }" var="grade">
                    <li id="tab1" class="tab" onclick="showSubject('${grade.id}')" value="${grade.id }" style="background-color: #fff">${grade.name}</li>
					</c:forEach>
                    </ul>
                </div>
                <h3></h3>
                <div class="tab_css" id="tab1_content" style="display: block">
                    <div class="tab_con">
                        <!--<div class="choice">请选择园所！</div>-->
                        <!-- <h3>现有学科</h3> -->
                        <div class="subject_con">
                            <ul>
                            <div id="showSub"></div>
                                
                                <li class="new">
                                    <input id="save_sub" onblur="saveSub()" name="name" value="${subject.name }" type="text" placeholder="新建学科"/>
                                    <button type="button" class="img"><img src="${pageContext.request.contextPath }/images/sub2.jpg"></button>
                                </li>
                                <!-- <li class="last"><a href="#"></a></li> -->
                            
                                <div class="clear"></div>
                            </ul>
                        </div>
                    </div>
                    <!-- <div class="btn">
                        <button type="submit" class="save">保存</button>
                    </div> -->
                </div>
                
                
            </div>
        </article>
    </div>
</main>
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