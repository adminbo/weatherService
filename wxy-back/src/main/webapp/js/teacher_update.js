function edit(classid){
	var url="/wxy-back/administration_management/toUpdateTeacher.do";
	$.post(url,{"id":classid},function(date){
		var obj = eval('(' + date + ')');
		$("#teacher_class").append("<option >"+obj.name+"</option>");
	});
}