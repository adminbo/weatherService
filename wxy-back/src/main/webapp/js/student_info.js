
function add() {
	    $("#Dao").window("open");
	}
function del() {
    $("#Dao").window("close");
}
$(function(){
	$("#Dao").window({
        title:'信息查看',
        width:450,
        modal:true,
        shadow:true,
        minimizable:false,
        closed:true,
        height:380,
        resizable:false
    });
})


//var ggid=null;
function getclass(gid,gname){
	var name;
//    ggid =$("#grade_id").val();
	$("#banji").empty();
	$("#mr").empty();
	$("#mr").append(""+gname+"");
	$("#yankai").empty();
	var url = "/wxy-back/student/getClasses.do";
	 $.post(url,{"id":gid},function(date){
	    	var obj = eval('(' + date + ')');
			for(var i=0;i<=obj.length;i++){
				var id = obj[i].id;//班级id
			    name = obj[i].name;//班级名字				
				$("#banji").append("<li class='tab' onclick='myclick("+id+","+gid+")'  value='"+id+"'>"+name+"</li>");	
				}
			if(name="一班"){
				var s=obj[i];
				var stus = s.students;
				for(var j=0;j<=stus.length;j++){
					var id = stus[j].id;
				//	var imgurl = stus[j].imgurl;
					var sname = stus[j].name;
					var grade = stus[j].grade;
					var classes = stus[j].classid;
					var num = stus[j].num;
					var sexview = stus[j].sexview;
					var birthday = stus[j].birthday;
					var intime = stus[j].intime;     //<td class='portrait'><img src='/wxy-back/images/pic.png'></td>+"<td class='time'>"+intime+"</td>"
					$("#yankai").append("<tr><td class='num'>"+(j+1)+"</td>"
							+"<td class='sname'>"+sname+"</td>"
								+"<td class='snum'>"+num+"</td>"
								+"<td class='portrait'>"+grade+"</td>"
								+"<td class='time'>"+classes+"</td>"
								+"<td class='sex'>"+sexview+"</td>"
								+"<td class='birthday'>"+birthday+"</td>"
								+"<td class='do'>"+'<a href="/wxy-back/student/showStudent.do?id='+id+'" class="look">查看</a>'
								+'<a href="/wxy-back/student/toUpdateStudent.do?id='+id+'" class="revise">修改</a>'
								+ '<a href="/wxy-back/student/deleteStudent.do?id='+id+'" class="del">删除</a>'+"</td></tr>");
				}
				
						}	
				//alert(id+"---"+name);
				
			
	    });
}

function myclick(id,gid){
	//ggid =$("#grade_id").val();
	$("#yankai").empty();
	var url = "/wxy-back/student/getStudent.do";
	$.post(url,{"id":id,"gid":gid},function(date){
    	var obj = eval('(' + date + ')');
    	for(var i=0;i<obj.length;i++){
			var id = obj[i].id;
		//	var imgurl = obj[i].imgurl;
			var name = obj[i].name;
			var num = obj[i].num;
			var grade = obj[i].grade;
			var classes = obj[i].classid;
			var sexview = obj[i].sexview;
			var birthday = obj[i].birthday;
			var intime = obj[i].intime;
			//alert(id+"---"+name); <td class='portrait'><img src='/wxy-back/images/pic.png'></td>
			$("#yankai").append("<tr><td class='num'>"+(i+1)+"</td>"
		+"<td class='sname'>"+name+"</td>"
			+"<td class='snum'>"+num+"</td>"
			+"<td class='portrait'>"+grade+"</td>"
			+"<td class='time'>"+classes+"</td>"
			+"<td class='sex'>"+sexview+"</td>"
			+"<td class='birthday'>"+birthday+"</td>"
	//		+"<td class='time'>"+intime+"</td>"
			+"<td class='do'>"+'<a href="/wxy-back/student/showStudent.do?id='+id+'" class="look">查看</a>'
			+'<a href="/wxy-back/student/toUpdateStudent.do?id='+id+'" class="revise">修改</a>'
			+ '<a href="/wxy-back/student/deleteStudent.do?id='+id+'" class="del">删除</a>'+"</td></tr>");

		}
    	
    });
}

function getAllStudent(){
	$("#yankai").empty();
	$("#banji").empty();
	$("#mr").empty();
	$("#mr").append("全年级");
	var url = "/wxy-back/student/getAllStudent.do";
	$.post(url,{},function(date){
    	var obj = eval('(' + date + ')');
    	for(var i=0;i<obj.length;i++){
			var id = obj[i].id;
		//	var imgurl = obj[i].imgurl;
			var name = obj[i].name;
			var num = obj[i].num;
			var grade = obj[i].grade;
			var classes = obj[i].classid;
			var sexview = obj[i].sexview;
			var birthday = obj[i].birthday;
			var intime = obj[i].intime;
			//alert(id+"---"+name); <td class='portrait'><img src='/wxy-back/images/pic.png'></td>
			$("#yankai").append("<tr><td class='num'>"+(i+1)+"</td>"
		+"<td class='sname'>"+name+"</td>"
			+"<td class='snum'>"+num+"</td>"
			+"<td class='portrait'>"+grade+"</td>"
			+"<td class='time'>"+classes+"</td>"
			+"<td class='sex'>"+sexview+"</td>"
			+"<td class='birthday'>"+birthday+"</td>"
	//		+"<td class='time'>"+intime+"</td>"
			+"<td class='do'>"+'<a href="/wxy-back/student/showStudent.do?id='+id+'" class="look">查看</a>'
			+'<a href="/wxy-back/student/toUpdateStudent.do?id='+id+'" class="revise">修改</a>'
			+ '<a href="/wxy-back/student/deleteStudent.do?id='+id+'" class="del">删除</a>'+"</td></tr>");

		}
    	
    });
}



