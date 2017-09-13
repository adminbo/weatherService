Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
function getclass(gid,gname){
		var name;
		$("#yankai").empty();
		$("#banji").empty();
		$("#mr").empty();
		$("#mr").append(""+gname+"");
		var url = "/wxy-back/parent/getClass.do";
		 $.post(url,{"id":gid},function(date){
		    	var obj = eval('(' + date + ')');
				for(var i=0;i<=obj.length;i++){
					var id = obj[i].id;//班级id
				    name = obj[i].name;//班级名字	
					$("#banji").append("<li class='tab' onclick='myclic("+id+","+gid+")'  value='"+id+"'>"+name+"</li>");	
					}
		    });
	}

function myclic(id,gid){
	$("#yankai").empty();
	var url = "/wxy-back/parent/getJieSong.do";
	$.post(url,{"id":id,"gid":gid},function(date){
		var obj = eval('(' + date + ')');
		for(var i=0;i<obj.length;i++){
			var xtid = obj[i].id;
			var imgurl = obj[i].imgurl;
			var stuname = obj[i].stuname;
			var graid = obj[i].gid;
			var claid = obj[i].claid;
			var eid = obj[i].eid;
			var cid = obj[i].cid;
			var oldtime = obj[i].time;
			var time1 = new Date(oldtime).Format("yyyy-MM-dd");
			$("#yankai").append("<tr><td class='num'>"+(i+1)+"</td>"
					+"<td class='sname'>"+stuname+"</td>"
						+"<td class='class'>"+graid+"</td>"
						+"<td class='class'>"+claid+"</td>"
						+"<td class='knum'>"+cid+"</td>"
						+"<td class='mnum'>"+eid+"</td>"
						+"<td class='time'>"+time1+"</td>"
						+"<td class='photo'><input type='checkbox' checked='checked' /></td>"
						+"<td class='send'>已发送</td></tr>");
		}
	})
}