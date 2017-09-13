<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>公众号配置</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath }/js/checkpeizhi.js"></script>
    <script type="text/javascript">
    $(function(){
        $("#pz_btz").click(function(){
            window.location.href="${pageContext.request.contextPath }/getAllWechateslist.do";
        });
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
    <aside class="main_left" style="height:562px;">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure" target="leftFrame">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage" target="leftFrame">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage" target="leftFrame">学校信息管理</a></li>
            <li><a href="${pageContext.request.contextPath }/safe/toSafeList.do" class="statistics" target="leftFrame">信息统计</a></li>
            <%-- <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </aside>

    <div class="detail">
        <article class="peizhi">
            <section class="top">
                <a href="#" target="leftFrame">首页  </a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%>>技服中心 ></a>
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">公众号配置</a>
            </section>
            <section class="pcon">
                <form id="myform"   action="${pageContext.request.contextPath }/addWechar.do" method="post" >
                    <div class="main">
                        <div>
                            <label><span>*</span>服务号ID：</label>
                            <input id="pz_id" type="text" class="text"  name="serviceids"/>
                            <span id="pz_id_input"></span>
                        </div>
                        <div>
                            <label><span>*</span>服务号名称：</label>
                            <input id="pz_name" type="text" class="text" name="name"  placeholder="2-16个字，与微信服务号后台应用名称保持一致" />
                            <span id="pz_name_input"></span>
                        </div>
                        <div>
                            <label><span>*</span>开通时间：</label>
                            <input id="pz_time" class="Wdate" type="text" readonly="readonly"  name="begintime" onClick="WdatePicker({dateFmt:'yyyyMMdd'})"/>
                            <span id="pz_time_input"></span>
                        </div>
                        <div>
                            <label><span>*</span>appId：</label>
                            <input id="appid" type="text" class="text" name="appId"  placeholder="详见微信公众平台的设置模块页面" />
                            <span id="pz_appid_input"></span>
                        </div>
                        <div>
                            <label><span>*</span>Secret：</label>
                            <input id="pz_secret" type="text" class="text"   name="secret" placeholder="详见微信公众平台的设置模块页面" />
                            <span id="pz_secret_input"></span>
                        </div>
                        <div>
                            <label><span>*</span>学校名称拼音缩写：</label>
                            <input id="schname" type="text" class="text" name="pre"  placeholder="学校名称拼音首字母小写"/>
                            <span id="pz_schname_input"></span>
                        </div>
                      
                    </div>
                    <div class="btn">
                        <button id="pz_btn" class="save" type="button">保存配置</button>
                        <button id="pz_btz" class="cancel" type="button">取消配置</button>
                    </div>
                </form>
            </section>
        </article>
    </div>
</main>
</body>
</html>