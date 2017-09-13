<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>校园环境</title>
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
            <%-- <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage">学校信息管理</a></li> --%>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" class="env" target="leftFrame">校园环境</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllPeitaosheshi.do" class="fac" target="leftFrame">配套设施</a></li>
            <li><a href="${pageContext.request.contextPath }/teachers/listTeachershow.do" class="teacher" target="leftFrame">教师风采</a></li>
            <li><a href="${pageContext.request.contextPath }/banxue/banxuelist.do" class="feature" target="leftFrame">办学特色</a></li>
            <li><a href="${pageContext.request.contextPath }/foodweeks/foodweeklist.do" class="week" target="leftFrame">每周食谱</a></li>
            <li><a href="${pageContext.request.contextPath }/president.do" class="mailbox" target="leftFrame">校长信箱</a></li>
            <%-- <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </div>

    <div class="detail">
        <article class="campus_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">校园管理 ></a>
                <a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" target="leftFrame">校园环境</a>
            </section>
            <div class="campuscon">
                <ul>
<c:forEach items="${img }" var="img" >
                    <li>
                        <figure>
                            <img src="${img.url}" />
                            <figcaption>
                                <label>标题：</label>
                                <input type="text" value="${img.title }"/>
                            </figcaption>
                        </figure>
                        <div class="mask"></div>
                        <div class="ico">
                            <button type="button" onclick="picShow('${img.id}','${img.isdown }')" class="up"><img src="${pageContext.request.contextPath }/images/up.png" /></button>
                            <button type="button" onclick="picNoShow('${img.id}','${img.isdown }')" class="down"><img src="${pageContext.request.contextPath }/images/down.png" /></button>
                            <button type="button" onclick="del('${img.id}')" class="close"><img src="${pageContext.request.contextPath }/images/del3.png" /></button>
                        </div>
                    </li>
</c:forEach>
                    <li id="addLi" class="upload" style="display:none">
                    	<form id="form" action="${pageContext.request.contextPath }/addSchoolEnv.do" method="post" enctype="multipart/form-data">
                        <figure>
                            <div class="img">
                                <span>选择图片
                                    <input name="pic" type="file" class="file" accept="image/png,image/gif,image/jpg">
                                </span>
                                <p>支持jpg/png/gif格式的图片</p>
                            </div>
                            <figcaption>
                                <label>标题：</label>
                                <input name="title" id="title" type="text" placeholder="新建图片"/>
                            </figcaption>
                        </figure>
                        <div class="mask"></div>
                        <div class="ico">
                            <button id="sub" type="button" class="up"><img src="${pageContext.request.contextPath }/images/up.png" /></button>
                            <%-- <button type="button" class="down"><img src="${pageContext.request.contextPath }/images/down.png" /></button>
                            <button type="button" class="close"><img src="${pageContext.request.contextPath }/images/del3.png" /></button> --%>
                        </div>
                        <script type="text/javascript">
                        function getEnv(sid){
                        	location.href="getAllSchoolEnvire.do?sid="+sid;
                        }
                        	$(function(){
                        		$("#sub").click(function(){
                        			var file=$(".file").val();
                        			file=file.trim();
                        			if(""==file){
                        				alert("请选择上传的图片");
                        				return;
                        			}
                        			var title=$("#title").val();
                        			title=title.trim();
                        			if(""==title){
                        				alert("请填写标题");
                        				return;
                        			}
                        			if(""!=file && ""!=title){
                        				$("#form").submit();
                        			}
                        		});
                        	});
                        	function toShow(){
                        		$(".file").val("");
                				$("#title").val("");
                        		$("#addLi").attr("style","display:block");
                        	}
                        	function del(id){ //删除图片
                        		var flag=confirm("确定要删除么？");
                        		if(flag){
                        			location.href='env/deleteById.do?id='+id;
                        		}
                        	}
                        	
                        	function picShow(id,isdown){ //显示图片，上架
                        		if(isdown==0){
                        			alert("该图片已经上架，不能重复操作！");
                        			return;
                        		}
                        		var flag=confirm("确定要显示该图片？");
                        		if(flag){
                        			location.href='env/showPicById.do?id='+id;
                        		}
                        	}
                        	function picNoShow(id,isdown){ //bu显示图片，下架
                        		if(isdown==1){
                        			alert("该图片已经下架，不能重复操作！");
                        			return;
                        		}
                        		var flag=confirm("确定不显示该图片？");
                        		if(flag){
                        			location.href='env/noShowPicById.do?id='+id;
                        		}
                        	}
                        </script>
                        </form>
                    </li>
                    <li class="last"><a href="javascript:void(0)" onclick="toShow()"></a></li>
                </ul>
            </div>
        </article>
    </div>
</main>
</body>
</html>