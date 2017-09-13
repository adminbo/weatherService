<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        html, body, div, span, iframe, h1, p, a, em, img, strong, var, dl, dt, dd, ol, ul, li, form, label, table, tbody, thead, tr, th, td,figure,figcaption,button{
            border:none;
            margin: 0;
            padding: 0;
        }
        .clear:after{
            content:"\20";
            display:block;
            height:0;
            clear:both;
        }
        .error{
            width: 386px;
            height: 268px;
            margin: 200px auto;
            text-align: center;
        }
        .error_main{
            width: 155px;
            height: 74px;
            background: #000;
            border: 1px solid #82db5b;
            color: #82db5b;
            font-size: 14px;
            text-align: center;
            float: right;
        }
        .error_main button{
            background: none;
            color: #82db5b;
            margin: 30px 20px 0;
            outline:none;
        }
        .error_main button:hover{
            color: #6599ff;
        }
        .error img{
            margin: 0 0 20px 0;
        }
        .error span{
            display: block;
            color: #858585;
        }
    </style>
</head>
<body>
<div class="error">
    <div class="error_main">
        <p>C:\Users\admin>exit_</p>
        <button type="button">上一页</button>
        <button type="button">退出</button>
    </div>
    <div class="clear"></div>
    <img src="${pageContext.request.contextPath }/images/timg.gif">
    <span>系统正忙，请稍后重试或联系客服...</span>
</div>
</body>
</html>