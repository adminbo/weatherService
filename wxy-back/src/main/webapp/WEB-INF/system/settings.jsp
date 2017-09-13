<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统设置</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <script>
        $(function(){
            $(".link > a").click(function(){
                $(this).next().slideToggle(200,function(){
                    //TODO
                });
            });
        });
        function exit(){
        	var flag=confirm("您确认想要退出系统么？");  
        	    if (flag){    
        	        location.href="/wxy-back/user/logout.do";   
        	    }    
        	
        }
    </script>
</head>
<body>

<main>
    <aside class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/system/listUser.do" class="users" target="leftFrame">用户管理</a></li>
            <li><a href="${pageContext.request.contextPath }/system/toAuth.do" class="quan" target="leftFrame">权限管理</a></li>
            <li><a href="${pageContext.request.contextPath }/system/settings.do" class="set" target="leftFrame">系统设置</a></li>
            <!--<li><a href="system_security.html" class="safe">系统安全</a></li>-->
            <!--<li><a href="FAQ.html" class="help">帮助中心</a></li>-->
        </ul>
    </aside>
 
    <div class="detail">
        <article class="set_main">
            <section class="top">
                <a href="#" target="leftFrame">首页 ></a>
                <a href="#" target="leftFrame">系统管理 ></a>
                <a href="#" target="leftFrame">系统设置</a>
            </section>
            <div class="set_con">
                <div class="account">
                    <span>账号设置</span>
                    <div class="setting">
                        <div>
                            <label>姓名：</label>
                            <input type="text" />
                        </div>
                        <div>
                            <label>用户名：</label>
                            <input type="text" />
                        </div>
                        <button type="button">修改密码</button><br/>
                        <button type="button" onclick="exit()">退出登录</button>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="common">
                    <span>通用设置</span>
                    <div class="setting">
                        <div>
                            <label>文件管理：</label>
                            <input type="text" disabled="disabled" />
                            <button type="button">更改<input type="file" /></button>
                            <p>后台文件的默认保存位置</p>
                        </div>
                        <div>
                         <!--    <label>自动登录：</label>
                            <input type="checkbox" checked="checked" /> -->
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="school_set">
                    <span>学校设置</span>
                    <div class="setting">
                        <div>
                            <label>第一学期：</label>
                            <em>起：</em>
                            <input class="Wdate" type="text" onClick="WdatePicker()">
                            <em>止：</em>
                            <input class="Wdate" type="text" onClick="WdatePicker()">
                        </div>
                        <div class="weeks">
                            <label>周数：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                        <div>
                            <label>第二学期：</label>
                            <em>起：</em>
                            <input class="Wdate" type="text" onClick="WdatePicker()">
                            <em>止：</em>
                            <input class="Wdate" type="text" onClick="WdatePicker()">
                        </div>
                        <div class="weeks">
                            <label>周数：</label>
                            <input type="text" disabled="disabled" />
                        </div>
                        <div>
                            <label>门禁卡押金：</label>
                            <input type="text" class="money" >
                            元
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="btn">
                <button type="button" class="save">保存设置</button>
            </div>
        </article>
    </div>
</main>
</body>
</html>