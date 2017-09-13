<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设置新密码</title>
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
            padding: 0 20px 18px 20px;
        }
        .find h2{
            font-size: 13px;
            border-bottom: 1px solid #c8c8c8;
            height: 50px;
            line-height: 50px;
        }
        .find form{
            margin-top: 20px;
            text-align: center;
        }
        .find form span{
            width: 110px;
            display: inline-block;
            padding-left: 15px;
            height: 20px;
        }
        .find form div{
            margin: 0 0 15px 130px;
        }
        .find input{
            border: 1px solid #d9d9d9;
            height: 28px;
            padding-left: 10px;
            width: 220px;
        }
        input:focus{
            border:1px solid #85c5e8;
        }
        .find button{
            width: 232px;
            height: 30px;
            color: #fff;
            background: #d7d7d7;
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
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		
    		
    		var cok =false;
    		var pok =false;
    		var rpok =false;
    		var pwd = "";
    		//校验验证码不为空
    		$("#code").blur(function(){
    			var code = $.trim($("#code").val());
    			if(""==code){
    				$("#code_span").html("验证码不能为空！").addClass("error");
    			}else if(""!=code || null!=code){
    				cok=true;
    				$("#code_span").html("").removeClass().addClass("ok");
    			}
    		});
    		//校验新密码不为空
    		$("#pwd").blur(function(){
    			pwd= $.trim($("#pwd").val());
    			if(""==pwd){
    				$("#pwd_span").html("密码不能为空！").addClass("error");
    				
    			}else if(pwd.length<6||pwd.length>16){
    		        $("#pwd_span").html("密码必须大于6且小于16").addClass("error");
    			}else{
    				pok=true;
    				$("#pwd_span").html("").removeClass().addClass("ok");
    			}
    		});
    		//校验重复密码
    		$("#repwd").blur(function(){
    			var repwd= $.trim($("#repwd").val());
    			if(""==repwd){
    				$("#repwd_span").html("不能为空！").addClass("error");
    				
    			}else if(repwd!=pwd){
    				$("#repwd_span").html("两次密码输入不一致").addClass("error");
    			}else{
    				rpok=true;
    				$("#repwd_span").html("").removeClass().addClass("ok");
    			}
    				
    		});
    		
    		$("#repwd").mouseout(function(){
    			
    			if(cok && pok && rpok){
    				$("#btn").removeAttr("disabled");
    			}
    		});
    		
    		$("#btn").click(function(){
					//alert(111);
    				$("#form").submit();
    			
    		});
    		
    	});
    </script>
</head>
<body>
<header>
    <h1><img src="../images/logo.png">孺学宝移动办公平台</h1>
</header>
<div class="find">
    <h2>设置新密码</h2>
    <form id="form" action="${pageContext.request.contextPath }/pwd/upPwd.do" method="post">
        <div>
            <input type="text" id="code" name="code" placeholder="输入验证码" />
            <span id="code_span">${codeError }</span>
        </div>
        <div>
            <input type="password" id="pwd" type="password" name="password" placeholder="请输入6~20位密码" />
            <span id="pwd_span">${pwdError }
        </div>
        <div>
            <input type="password" id="repwd" placeholder="确认密码" />
            <span id="repwd_span"></span>
        </div>
        <input id="btn" type="button" value="确定" disabled="disabled">
    </form>
</div>
</body>
</html>