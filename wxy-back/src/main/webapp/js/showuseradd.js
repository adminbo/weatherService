/**
 * Created by yankai on 2017/4/24.
 */



function del(id){
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	location.href="deleteUser.do?id="+id;     
	    }    
	});
}
//添加
function add(usertype) {
	$("#user_type").empty();
	$("#user_dls").empty();
	$("#user_name").val("");
	$("#user_dw").val("");
	$("#name").val("");
	$("#phone").val("");
	$("#email").val("");
	 $("#user_name_input").html("").removeClass("ok");
	 $("#user_dw_input").html("").removeClass("ok");
	 $("#user_dw_input").html("").removeClass("ok");
	  $("#name_input").html("").removeClass("ok");
	  $("#phone_input").html("").removeClass("ok");
	    $("#email_input").html("").removeClass("ok");
	  $("#user_dls_input").html("").removeClass("ok");
	if(usertype!=null &&  usertype<4){
		$("#user_type").append("<select id='user_types' name='typeId'></select>");
		$("#user_types").append("<option value=''>请选择角色</option>");
	}
	$("#useradd").window("open");
	var url="/wxy-back/system/listRole.do";
	var url2="/wxy-back/system/listAgent.do";
    $.post(url,{},function(date){
    	var obj = eval('(' + date + ')');
    	//alert(obj);
    	//解析data，填充到左侧的下拉框中
		for(var i=0;i<obj.length;i++){
			var id = obj[i].id;
			var name = obj[i].name;
			//alert(id+"---"+name);		
			if(usertype!=null && usertype<4){				
				$("#user_types").append("<option value='"+id+"'>"+name+"</option>");
			}else{
				$("#user_type").append("<input type='checkbox' id='user_types' name='typeId' value='"+id+"' />"+name);
			}
		}
    });
    $.post(url2,{},function(date){
    	$("#user_dls").append("<option value='' >"+'请选择代理商'+"</option>");
    	var obj2 = eval('(' + date + ')');
    	 // alert(obj2);
    	//解析data，填充到左侧的下拉框中
    	for(var i=0;i<obj2.length;i++){
    		var id = obj2[i].id;
    		var name = obj2[i].name;
    		$("#user_dls").append("<option value='"+id+"'>"+name+"</option>");
    	}
    });
}
//查看
function show(id) {
	
	$("#userShow").window("open");
	var url="/wxy-back/system/findById.do";
	$.post(url,{"id":id},function(date){
		var obj = eval('(' + date + ')');
		//alert(obj);
		//alert(obj.name);
		$("#uname").val(obj.name);
		$("#cname").val(obj.companyname);
		$("#utype").append("<option >"+obj.typeView+"</option>");
		$("#rname").val(obj.realName);
		$("#time").val(obj.regtime);
		$("#pnum").val(obj.phoneNum);
		$("#remail").val(obj.regemail);
		$("#agent").append("<option >"+obj.agent.name+"</option>");
	});

}
//修改
function edit(id,usertype) {
	//alert(usertype);
	$("#ustype").empty();
	$("#dls").empty();
	if(usertype!=null &&  usertype<4){
		$("#ustype").append("<select id='ups' name='typeId'></select>");
		$("#ups").append("<option value=''>请选择角色</option>");
	}
	$("#userEdit").window("open");
	var url="/wxy-back/system/findById.do";
	var url1="/wxy-back/system/listRole.do";
	var url2="/wxy-back/system/listAgent.do";
	var obj;
	var type;
	var agentid;
	$.post(url,{"id":id},function(date){
		 obj = eval('(' + date + ')');
		//alert(obj);
		//alert(obj.name);
		 type=obj.type;
		 agentid=obj.agent.id;
		 $("#uid").val(obj.id);
		$("#usname").val(obj.name);
		$("#dw").val(obj.companyname);
		//$("#utype").append("<option value='"+obj.type+"' <c:if test="'yes' ">checked</c:if>  >"+obj.typeView+"</option>");
		$("#rename").val(obj.realName);
		$("#phonenum").val(obj.phoneNum);
		$("#regemail").val(obj.regemail);
		$("#dls").append("<option >"+obj.agent.name+"</option>");
	});
	
    $.post(url1,{},function(date){
    	var obj1 = eval('(' + date + ')');
    	//alert(obj1);
    	//解析data，填充到左侧的下拉框中
		for(var i=0;i<obj1.length;i++){
			var id = obj1[i].id;
			var name = obj1[i].name;
			//alert(id+"---"+name);
		//	$("#ustype").append("<input type='checkbox' name='typeId' value='"+id+"' />"+name);
			if(usertype!=null && usertype<4){				
				$("#ups").append("<option value='"+id+"'>"+name+"</option>");
			}else{
				$("#ustype").append("<input type='checkbox' name='typeId' value='"+id+"' />"+name);
			}
		}
    });
   
}


$(function(){
	
	
    $("#useradd").window({
        title:'添加用户',
        width:600,
        modal:true,
        shadow:true,
        minimizable:false,
        closed:true,
        height:420,
        resizable:false
    });
    
    $("#userShow").window({
    	title:'查看用户',
    	width:600,
    	modal:true,
    	shadow:true,
    	minimizable:false,
    	closed:true,
    	height:460,
    	resizable:false
    });
    $("#userEdit").window({
    	title:'修改用户',
    	width:600,
    	modal:true,
    	shadow:true,
    	minimizable:false,
    	closed:true,
    	height:420,
    	resizable:false
    });
    
});

$(function () {
	$("#win_close").click(function(){
		$("#useradd").window("close");
	});
	$("#windo_close").click(function(){
		$("#userShow").window("close");
	});
	$("#wind_close").click(function(){
		$("#userShow").window("close");
	});
	$("#win_clo").click(function(){
		$("#userEdit").window("close");
	});
	
   
	
    //验证用户名
    function nickname(){
        var isok = false;
        var nickname =$.trim($("#user_name").val());
        if(nickname==""){
            $("#user_name").css('border-color','#f00');
            $("#user_name").css('background-color','#FFF');
            $("#user_name_input").html("不能为空！").addClass("error");
        }else{
            $("#user_name").css('border-color','#dcdcdc');
            $("#user_name_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //验证单位
    function dw(){
        var isok = false;
        var pwd =$.trim($("#user_dw").val());
        if(pwd==""){
            $("#user_dw").css('border-color','#f00');
            $("#user_dw_input").html("不能为空！").addClass("error");
        }else{
            $("#user_dw").css('border-color','#dcdcdc');
            $("#user_dw_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;
    //用户类型
    }function usertype(){
        var isok = false;
        var pwd =$.trim($("#user_types").val());
        if(pwd==""){
            $("#user_type").css('border-color','#f00');
            $("#user_type_input").html("不能为空！").addClass("error");
        }else{
            $("#user_type").css('border-color','#dcdcdc');
            $("#user_type_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //姓名
    function name(){
        var isok = false;
        var nickname =$.trim($("#name").val());
        if(nickname==""){
            $("#name").css('border-color','#f00');
            $("#name_input").html("不能为空！").addClass("error");
        }else if(isNaN(nickname)==false){
            $("#name").css('border-color','#f00');
            $("#name_input").html("格式错误，请重新填写").addClass("error");
        }else{
            $("#name").css('border-color','#dcdcdc');
            $("#name_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //手机号
    function checktel(){

        var reg = /^[1][3|4|5|7|8][0-9]{9}$/;
        var tel=$.trim($("#phone").val());
        $("#telId").removeClass("ok_prompt");
          if(tel==""){
            $("#phone").css('border-color','#f00');
            $("#phone_input").html("不能为空！").addClass("error");
        }else if(reg.test(tel)==false){
            $("#phone").css('border-color','#f00');
            $("#phone_input").html("手机号码无效").addClass("error")
            return false;
        }else{
            $("#phone").css('border-color','#dcdcdc');
            $("#phone_input").html("").removeClass().addClass("ok")
        }

    }
    
    //邮箱
    function email(){
        var isok = false;
        var email = $.trim($("#email").val());
        var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(email==""){
            $("#email").css('border-color','#f00');
            $("#email_input").html("不能为空！").addClass("error");
        }else if(reg.test(email)==false){
            $("#email").css('border-color','#f00');
            $("#email_input").html("格式错误，请重新输入").addClass("error");
        }else{
            $("#email").css('border-color','#dcdcdc');
            $("#email_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;
    }

    //代理商 
   function dls(){
        var isok = false;
        var pwd =$.trim($("#user_dls").val());
        if(pwd==""){
           $("#user_dls").css('border-color','#f00');
           $("#user_dls_input").html("不能为空！").addClass("error");
        }else{
           $("#user_dls").css('border-color','#dcdcdc');
           $("#user_dls_input").html("").removeClass().addClass("ok");
           isok = true;
        }
           return isok;

        }



    $("#user_name").blur(nickname);

    $("#user_dw").blur(dw);
    $("#user_type").blur(usertype);
    $("#name").blur(name);
    $("#phone").blur(checktel);
    $("#email").blur(email);
    $("#user_dls").blur(dls);


    //注册
    $("#useradd_btn").click(function(){
        var isok = true;
        nickname();
        dw();
        usertype();
        name();
        checktel();
        email();
        dls();

        if(nickname()==false||dw()==false||usertype()==false||name()==false||checktel()==false||email()==false||dls()==false){
            isok = false;
        }
        return isok;
    });

});


