<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/checkfind.js"></script>
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
            display: block;
            height:0;
            clear:both;
        }
        html{
            height: 769px;
        }
        body{
            background: url("../images/bgt.jpg") no-repeat;
            background-size:100% 100%;
            font-size: 12px;
            filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src="../images/bgt.jpg", sizingMethod='scale');
            width:100%;
        }
        .find{
            margin: 0 auto;
            width: 522px;
            background: #f4f4f4;
            border-radius: 20px;
            padding: 0 20px 25px 20px;
        }
        .find h2{
            font-size: 13px;
            border-bottom: 1px solid #c8c8c8;
            height: 50px;
            line-height: 50px;
        }
        .find form{
            margin: 28px 0 0 90px;
            width:440px ;
        }
        .find form span{
            width: 110px;
            display: inline-block;
            padding-left: 15px;
            height: 20px;
        }
        .find input{
            margin-bottom: 10px;
            border: 1px solid #d9d9d9;
            height: 28px;
            padding-left: 10px;
        }
        input:focus{
            border:1px solid #85c5e8;
        }
        .email{
            width: 286px;
        }
        .code{
            width: 132px;
            float: left;
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
            margin: 10px 0 25px 0;
        }
        .btn button{
            width: 144px;
            height: 30px;
            color: #fff;
            background: #d7d7d7;
            border-radius: 4px;
        }
        .return{
            width: 144px;
            height: 30px;
            margin-right: 7px;
            color: #fff;
            background: #d7d7d7;
            display: inline-block;
            text-align: center;
            line-height: 30px;
            border-radius: 4px;
        }
        .ok{
            background: url("../images/ok.jpg") no-repeat 0 bottom;
        }
        .error{
            background: url("../images/false.jpg") no-repeat 0 3px;
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
</head>
<body>
<header>
    <h1><img src="../images/logo.png">孺学宝移动办公平台</h1>
</header>
<div class="find">
    <h2>通过邮箱找回密码</h2><br/>
    <div style="color:red">${senderror }</div>
    <form action="${pageContext.request.contextPath }/user/sendMail.do" method="post">
        <div>
            <input id="find_email" type="email" name="mail" class="email" placeholder="默认邮箱地址" />
            <span id="email_input" style="color:red">${mailError }</span>
        </div>
        <div>
            <input id="find_yzm" type="text" class="code" name="validateCode" placeholder="验证码" />
            <div class="img"> <img id="loginform:vCode" src="${pageContext.request.contextPath }/validatecode.jsp"
	    onclick=
	    "javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath 
	    }/validatecode.jsp?'+Math.random();" /></div>
            
            <span id="yzm_input" style="color: red">${vError }</span>
        </div>
        <div class="clear"></div>
        <div class="btn">
            <a href="${pageContext.request.contextPath }/user/toLogin.do" class="return">返回</a>
            <input id="find_btn" type="submit" class="send" value="发送重置密码邮件"/>
            
        </div>
    </form>
</div>
</body>
</html>