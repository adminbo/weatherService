/**
 * Created by yankai on 2017/4/24.
 */
function add() {
	$.ajax({
		   type: "POST",
		   url: "agent/getAll.do",
		   //data: "name=John&location=Boston",
		   success: function(msg){
		     var l=msg.length;
			   $("#frist_dl").html("");
			   $("#frist_dl").append("<option value=''>请选择代理商</option>");
		     for(var i=0;i<l;i++){
		    	 var t="<option value='"+msg[i].id+"'>"+msg[i].name+"</option>";
		    	 $("#frist_dl").append(t);
		     }
		   }
		});
	$("#school_name").val("");
	$("#qiye_name").val("");
	$("#n1").attr("selected","selected");
//	$("#province2").val("");
//	$("#city2").val("");
//	$("#districtAndCounty2").val("");
	
    $("#conadd").window("open");
}


function cos(){
	 $("#conadd").window("close");
}


$(function(){
    $("#conadd").window({
        title:'学校信息',
        width:600,
        modal:true,
        shadow:true,
        closed:true,
        height:452,
        resizable:false
    });
});


$(function(){
    $("#conlook").window({
        title:'学校信息',
        width:600,
        modal:true,
        shadow:true,
        closed:true,
        height:380,
        resizable:false
    });
});

$(function(){
    $("#conedit").window({
        title:'学校信息',
        width:600,
        modal:true,
        shadow:true,
        closed:true,
        height:480,
        resizable:false
    });
});

$(function () {

    //学校名
    function nickname(){
        var isok = false;
        var nickname =$.trim($("#school_name").val());
        if(nickname==""){
            $("#school_name").css('border-color','#f00');
            $("#school_name").css('background-color','#FFF');
            $("#school_name_input").html("不能为空！").addClass("error");
        }else{
            $("#school_name").css('border-color','#dcdcdc');
            $("#school_name_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //企业号
    function dw(){
        var isok = false;
        var pwd =$.trim($("#qiye_name").val());
        if(pwd==""){
            $("#qiye_name").css('border-color','#f00');
            $("#qiye_name_input").html("不能为空！").addClass("error");
        }else{
            $("#qiye_name").css('border-color','#dcdcdc');
            $("#qiye_name_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;
    }
    
    //学校类型
    function usertype(){
        var isok = false;
        var pwd =$.trim($("#school_type").val());
        if(pwd==""){
            $("#school_type").css('border-color','#f00');
            $("#school_type_input").html("不能为空！").addClass("error");
        }else{
            $("#school_type").css('border-color','#dcdcdc');
            $("#school_type_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }
    //地址
    function name(){
        var isok = false;
        var province =$.trim($("#province2").val());
        var city =$.trim($("#city2").val());
        var districtAndCounty =$.trim($("#districtAndCounty2").val());
        if(province=="" || city=="" || districtAndCounty==""){
            //$("#address").css('border-color','#f00');
            $("#address_input").html("不能为空！").addClass("error");
        }else{
            //$("#address").css('border-color','#dcdcdc');
            $("#address_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }


    //代理商
    function fristdls(){
        var isok = false;
        var email = $.trim($("#frist_dl").val());
        if(email==""){
            $("#frist_dl").css('border-color','#f00');
            $("#frist_dl_input").html("不能为空！").addClass("error");
        }else{
            $("#frist_dl").css('border-color','#dcdcdc');
            $("#frist_dl_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;
    }

    //代理商 
    function twodls(){
        var isok = false;
        var pwd =$.trim($("#two_dl").val());
        if(pwd==""){
            $("#two_dl").css('border-color','#f00');
            $("#two_dl_input").html("不能为空！").addClass("error");
        }else{
            $("#two_dl").css('border-color','#dcdcdc');
            $("#two_dl_input").html("").removeClass().addClass("ok");
            isok = true;
        }
        return isok;

    }

    $("#school_name").blur(nickname);
    $("#qiye_name").blur(dw);
    $("#school_type").blur(usertype);
   // $("#address").blur(name);
    $("#frist_dl").blur(fristdls);
    $("#two_dl").blur(twodls);


    //注册
    $("#addbtn").click(function(){
        var isok = true;
        nickname();
        dw();
        usertype();
        name();
        fristdls();
        twodls();

        if(nickname()==false||dw()==false||usertype()==false||name()==false||fristdls()==false){
            isok = false;
        }
    	   return isok;
    });

})


