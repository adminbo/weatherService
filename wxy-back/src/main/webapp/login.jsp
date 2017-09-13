<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
     <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/checklogin.js"></script>
    <style>
        html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td,figure,figcaption,button{
            border:none;
            margin: 0;
            padding: 0;
        }
        input,select,option,textarea,button{
            outline:none;
        }
        a{
            text-decoration:none;
            color: #000;
        }
        img{
            border:0;
        }
        .clear:after{
            content:"\20";
            display:block;
            height:0;
            clear:both;
        }
        html{
            height: 769px;
        }
        body{
            background: url("./images/bgt.jpg") no-repeat;
            background-size:100% 100%;
            font-size: 12px;
            filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src="./images/bgt.jpg", sizingMethod='scale');
            width:100%;
        }
        .login{
            margin: 0 auto;
            width: 552px;
            background: #f4f4f4;
            border-radius: 20px;
            padding:10px 0 10px 10px;
        }
        .left{
            float: left;
            width: 120px;
            height: 200px;
            text-align: center;
            margin: 15px 0;
            border-right: 1px solid #b0b0b0;
        }
        .left img{
            margin-top: 40px;
        }
        .right{
            float: left;
            width: 410px;
            margin: 15px 0 15px 20px;
        }
        .right span{
            width: 90px;
            display: inline-block;
            padding-left: 15px;
            height: 20px;
        }
        .right input{
            margin-bottom: 10px;
            border: 1px solid #d9d9d9;
        }
        .right input:focus{
            border:1px solid #85c5e8;
        }
        .text,.pwd{
            width: 286px;
            height: 28px;
            padding-left: 10px;
        }
        .right input.code{
            width: 132px;
            float: left;
            height: 28px;
            padding-left: 10px;
            margin-bottom: 20px;
        }
        .img,.reload{
            float: left;
            border: 1px solid #d9d9d9;
        }
        .img{
            width: 100px;
            height: 28px;
            margin: 0 12px 0 10px;
        }
        .reload{
            width: 28px;
            height: 28px;
            background: #e4e4e4;
            text-align: center;
        }
        .reload img{
            width: 18px;
            height: 18px;
            margin-top: 5px;
        }
        .btn{
            width: 298px;
            height: 30px;
            background: #d7d7d7;
            border-radius: 4px;
            color: #fff;;
            margin-bottom: 15px;
        }
        .right input.box{
            margin-bottom: 0;
            vertical-align: middle;
        }
        label{
            vertical-align: middle;
            margin-right: 30px;
        }
        .forgot{
            float: right;
            color: #3f5eff;
            margin-right: 116px;
        }
        .ok{
            background: url("images/ok.jpg") no-repeat 0 bottom;
        }
        .error{
            background: url("images/false.jpg") no-repeat 0 3px;
            color: red;
        }
        header{
            text-align: center;
            margin: 110px 0 40px;
            color: #3399cc;
            font-size: 18px;
            min-width: 552px;
        }
        header img{
            width: 90px;
            vertical-align: middle;
            margin-right: 20px;
        }
    </style>
    <script type="text/javascript">
    	$(function(){
    		var flag ;
    		$("#al").click(function(){
    			flag=$("#al").is(":checked");  	
	    		if(flag){	    			
	    			 $("#kp").attr("checked",true);
	    		}	
    		});
    	});
    </script>
   
</head>
<body>
<header>
    <h1><img src="images/logo.png">孺学宝移动办公平台</h1>
</header>
<div class="login">
    <div class="left">
        <img src="images/lock.jpg" /><br/>
        <span style="color:red">${error }</span>
    </div>
    <form action="${pageContext.request.contextPath }/user/login.do" method="post" class="right">
        <input id="login_name" type="text" class="text" name="userName" value="${userName}" placeholder="用户名"/>
        <span id="login_name_input"></span>
        <input id="login_pwd" type="password" class="pwd" name="passWord" value="${passWord}"  placeholder="密码"/>
        <span id="login_pwd_input"></span>
        <input id="login_yzm" type="text" class="code" name="validateCode" placeholder="验证码" />     
        <div class="img"> <img id="loginform:vCode" src="${pageContext.request.contextPath }/validatecode.jsp"
	    onclick=
	    "javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath 
	    }/validatecode.jsp?'+Math.random();" /></div>
        
	    <span id="login_yzm_input"><span style="color:red">${vmsg }</span> </span>
        <input id="login_btn" type="submit" class="btn" value="登录"/><br/>
        
        <input type="checkbox" id="kp" class="box" name="keepPwd" value="1" <c:if test="${keepUser=='yes' }">checked</c:if> /><label>记住密码</label>
        <input type="checkbox" id="al" class="box" name="autoLogin"  value="1" <c:if test="${autoLogin=='yes' }">checked</c:if> /><label>自动登录</label>
        <a id="tbp" href="${pageContext.request.contextPath }/user/toBackPwd.do"  class="forgot">忘记密码
        	
        </a>
    </form>
    <div class="clear"></div>
    <% session.removeAttribute("error"); %>
    <% session.removeAttribute("vmsg"); %>
</div>
</body>
</html>