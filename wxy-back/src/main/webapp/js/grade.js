
//var gid = null;
//function updateGrade(id){
//	//alert(id);
//	gid = id;
//	alert(gid);
//	var rname = $("#g_name"+id).val();
//	$("#g_name"+id).empty();
//	var url = "/wxy-back/grade/updateGrade.do";
//	 $.post(url,{"id":id,"rname":rname},function(date){
//	    	var obj = eval('(' + date + ')');
//	    	$("#g_name"+id).val(obj.name);
//	    });
//}

function saveGrade(){
	//alert("11");
	var rname = $.trim($("#save_g").val());
	var sid = $("#schid").val();
	if(rname==""){
		alert("不能输入空值！");
	}else{
		location.href =  "saveGrade.do?rname="+rname;
	}
}

function deleteGrade(id){
	var url = "/wxy-back/grade/isdelete.do";
	 $.post(url,{"id":id},function(date){
	    	if(date==1){
	    		alert("无法删除！");
	    	}else if(date==0){
             	location.href =  "deleteGrade.do?id="+id;
	    	}
	    });
}



function saveClasses(id){
	var cname = $.trim($("#cla_name"+id).val());
	alert(cname);
	if(cname==""){
		alert("不能输入空值！");
	}else{
		location.href =  "saveClasses.do?cname="+cname+"&id="+id;
	}	
}

function isdeleteCl(id){
//	var str = id.substr(0, id.indexOf(','));
//	alert(str);
	var gid=null;
	var cid = null;
	var gc = id.split(",");
	$.each(gc, function(n,values){
		 cid=gc[0];
		 gid=gc[1];
	})
	var url = "/wxy-back/grade/isdeleteCl.do";
	 $.post(url,{"id":cid,"gid":gid},function(date){
	    	if(date==0){
	    		alert("无法删除！");
	    	}else if(date==1){
	    		location.href =  "deleteClasses.do?id="+cid;
	    	}
	    });
}

