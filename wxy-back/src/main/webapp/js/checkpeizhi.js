/**
 * Created by yankai on 2017/4/24.
 */
$(function () {
    
    //验证企业号id
    function pzid(){
    	var reg = /^[0-9a-zA-Z]{16,33}$/g;
        var pzid=$.trim($("#pz_id").val());
        var isok = false;
        if(pzid==""){
            $("#pz_id").css('border-color','#f00');
            $("#pz_id_input").html("不能为空！").addClass("error");
        }else{
            $("#pz_id").css('border-color','#9F0');
            $("#pz_id_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //验证企业号名称
    function nickname(){
        var isok = false;
        var name =$.trim($("#pz_name").val());
        if(name==""){
            $("#pz_name").css('border-color','#f00');
            $("#pz_name_input").html("不能为空！").addClass("error");
        }else{
            $("#pz_name").css('border-color','#9F0');
            $("#pz_name_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //时间
    function time(){
        var isok = false;
        var fc =$.trim($("#pz_time").val());
        if(fc==""){
            $("#pz_time").css('border-color','#f00');
            $("#pz_time_input").html("不能为空！").addClass("error");
        }else{
            $("#pz_time").css('border-color','#9F0');
            $("#pz_time_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //secret
    function secret(){
        var isok = false;
        var fc =$.trim($("#pz_secret").val());
        if(fc==""){
            $("#pz_secret").css('border-color','#f00');
            $("#pz_secret_input").html("不能为空！").addClass("error");
        }else{
            $("#pz_secret").css('border-color','#9F0');
            $("#pz_secret_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    
    function appid(){
        var isok = false;
        var fc =$.trim($("#appid").val());
        if(fc==""){
            $("#appid").css('border-color','#f00');
            $("#pz_appid_input").html("不能为空！").addClass("error");
        }else{
            $("#appid").css('border-color','#9F0');
            $("#pz_appid_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    
    function schname(){
        var isok = false;
        var fc =$.trim($("#schname").val());
        if(fc==""){
            $("#schname").css('border-color','#f00');
            $("#pz_schname_input").html("不能为空！").addClass("error");
        }else{
            $("#schname").css('border-color','#9F0');
            $("#pz_schname_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }

    
    $("#pz_id").blur(pzid);
    $("#pz_name").blur(nickname);
    $("#pz_time").blur(time);
    $("#pz_secret").blur(secret);
    $("#appid").blur(appid);
    $("#schname").blur(schname);

    //注册
    $("#pz_btn").click(function(){
        var isok = true;
        nickname();
        pzid();
        time();
        secret();
        appid();
        schname();
        if(nickname()==false||pzid()==false||time()==false||secret()==false||appid()==false||schname()==false){
            isok = false;
        }
        if(isok){
			document.getElementById("myform").submit(); 
        }
    });
    
})
