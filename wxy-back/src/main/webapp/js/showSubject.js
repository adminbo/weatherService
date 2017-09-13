
var gid = null;
function showSubject(id){
	$("#showSub").empty();
	gid = id;
	var url = "/wxy-back/subject/getSubject.do";
	 $.post(url,{"id":id},function(date){
	    	var obj = eval('(' + date + ')');
			for(var i=0;i<obj.length;i++){
				var id = obj[i].id;
				var name = obj[i].name;
				//alert(id+"---"+name);
				$("#showSub").append("<li> <input type='text' name='"+id+"' value='"+name+"' disabled='disabled' /><button id='delSub' onclick='deleteSub("+id+")' type='button' class='img'><img src='/wxy-back/images/sub2.jpg'></button></li>");
			}
	    });
}

function saveSub(){
	var sname = $.trim($("#save_sub").val());
	if(sname!=null && sname!=""){
		location.href =  "saveSubject.do?sname="+sname+"&id="+gid;
	}else{
		alert("不能输入空值！");
	}
}

function deleteSub(id){
	location.href =  "deleteSubject.do?id="+id+"&gid="+gid;
}