/**
 * Created by yankai on 2017/4/22.
 */
$(function () {

    //验证昵称
    function nickname(){
        var isok = false;
        var nickname =$.trim($("#login_name").val());
        if(nickname==""){
            $("#login_name").css('border-color','#f00');
            $("#login_name_input").html("不能为空！").addClass("error");
        }else if(isNaN(nickname)==false){
            $("#login_name").css('border-color','#f00');
            $("#login_name_input").html("用户名必须为字符串，请重新填写").addClass("error");
        }else{
            $("#login_name").css('border-color','#dcdcdc');
            $("#login_name_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //验证密码
    function pwd(){
        var isok = false;
        var pwd =$.trim($("#login_pwd").val());
      
        if(pwd==""){
            $("#login_pwd").css('border-color','#f00');
            $("#login_pwd_input").html("密码不能为空！").addClass("error");
        }else if(pwd.length<6||pwd.length>16){
            $("#login_pwd").css('border-color','#f00');
            $("#login_pwd_input").html("密码必须大于6且小于16").addClass("error");
        }else{
            $("#login_pwd").css('border-color','#dcdcdc');
            $("#login_pwd_input").html("").removeClass().addClass("ok");
            isok = true;
        }
       
        return isok;

    }
    //验证吗
    function yzm(){
        var isok = false;
        var pwd =$.trim($("#login_yzm").val());
        if(pwd==""){
            $("#login_yzm").css('border-color','#f00');
            $("#login_yzm_input").html("验证码不能为空！").addClass("error");
        }else{
            $("#login_yzm").css('border-color','#dcdcdc');
            $("#login_yzm_input").html("").removeClass().addClass("");
            isok = true;
        }
        return isok;

    }
    //验证码
    
function cleanname(){
	$("#login_name_input").html("").removeClass();
}
function cleanpwd(){
	  $("#login_pwd_input").html("").removeClass();
}
function cleanyzm(){
	 $("#login_yzm_input").html("").removeClass();
}
    $("#login_name").blur(nickname);
    $("#login_name").focus(cleanname);
    
    $("#login_pwd").blur(pwd);
    $("#login_pwd").focus(cleanpwd);
    $("#login_yzm").blur(yzm);
    $("#login_yzm").focus(cleanyzm);
    

    //注册
    $("#login_btn").click(function(){
        var isok = true;
        nickname();
        pwd();
        yzm();
        if(nickname()==false||pwd()==false||yzm()==false){
            isok = false;
        }
        return isok;
    });

})