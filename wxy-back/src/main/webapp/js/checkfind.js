/**
 * Created by yankai on 2017/4/23.
 */
$(function () {
    /*验证邮箱*/
    function email(){
        var isok = false;
        var email = $.trim($("#find_email").val());
        var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(email==""){
            $("#email_input").html("email地址不能为空！").addClass("error");
        }else if(reg.test(email)==false){
            $("#email_input").html("格式错误，请重新输入").addClass("error");
        }else{
            $("#email_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;
    }
    
    //验证码
    function yzm(){
        var isok = false;
        var yzm =$.trim($("#find_yzm").val());
        if(yzm==""){
            $("#yzm_input").html("验证码不能为空！").addClass("error");
        }else{
            $("#yzm_input").html("").removeClass("error");
            isok = true;
        }
        return isok;

    }
    
    $("#find_email").blur(email);
    $("#find_yzm").blur(yzm);

    $("#find_btn").click(function(){
        var isok = true;
        email();
        yzm();
        if(email()==false||yzm()==false){
            isok = false;
        }
        return isok;
    });
})