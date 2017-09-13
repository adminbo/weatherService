<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>学生接送</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/jiazhangXT.js"></script>
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
<body>

<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/parent/getAlljiazhangxietong.do" class="pick" target="leftFrame">学生接送</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllTongxunlu.do" class="contact" target="leftFrame">通讯录</a></li>
        </ul>
    </div>

    <div class="detail">
        <article class="pick_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/parent/getAlljiazhangxietong.do" target="leftFrame">家长协同 ></a>
                <a href="${pageContext.request.contextPath }/parent/getAlljiazhangxietong.do" target="leftFrame">学生接送</a>
            </section>
            <form action="#" method="post">
                <div class="search">
                    <div>
                        <label>班级：</label>
                        <input type="text" />
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <input type="reset" class="clean" value="清除" />
                </div>
                <div class="clear"></div>
            </form>
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
                    <div class="content">
                        <table>
                            <thead>
                            <tr>
                                <th class="num"></th>
                                <th class="sname">学生姓名</th>
                                <th class="class">年级</th>
                                <th class="class">班级</th>
                                <th class="knum">卡片编号</th>
                                <th class="mnum">门禁编号</th>
                                <th class="time">打卡时间</th>
                                <th class="photo">打卡照片</th>
                                <th class="send">发送状态</th>
                            </tr>
                            </thead>
                            <tbody id="yankai" class="con_tbody">
                           
                            </tbody>
                        </table>
                        <div class="bar">
                            <div class="barcon">
                               
                            </div>
                        </div>
                        <!--<div class="choice">请先选择学校！</div>-->
                    </div>
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