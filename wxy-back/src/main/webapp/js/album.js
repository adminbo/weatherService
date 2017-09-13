//var ggid=null;
function getclass(gid,gname){
	$("#banji").empty();
	$("#mr").empty();
	$("#mr").append(""+gname+"");
	var url = "/wxy-back/album/getClasses.do";
	 $.post(url,{"id":gid},function(date){
	    	var obj = eval('(' + date + ')');
			for(var i=0;i<obj.length;i++){
				var id = obj[i].id;
				var name = obj[i].name;
				//alert(id+"---"+name);
				$("#banji").append("<li class='tab' onclick='myclic("+id+","+gid+")'  value='"+id+"'>"+name+"</li>");
			}
	    });
}

function myclic(id,gid){
	$("#lalala").empty();
	var url = "/wxy-back/album/getAlbum.do";
	$.post(url,{"id":id,"gid":gid},function(date){
    	var obj = eval('(' + date + ')');
    	for(var i=0;i<obj.length;i++){
			var abid = obj[i].id;//相册id
		//	var imgurl = obj[i].imgurl;
			var name = obj[i].name;
			var num = obj[i].num;
			var imgurl = obj[i].img;
			//alert(id+"---"+name); <td class='portrait'><img src='/wxy-back/images/pic.png'></td>
			$("#lalala").append("<li><a href='/wxy-back/album/getphotoByAbid.do?abid="+abid+"&albumname="+name+"'><figure><img src="+imgurl+"><figcaption>"+name+"</figcaption></figure></a><span>"+num+"</span></li>");
			   
		}
    	
    });
}

function getAllAlbum(){
	$("#banji").empty();
	$("#mr").empty();
	$("#mr").append("全年级");
	$("#lalala").empty();
	var url = "/wxy-back/album/getAllAlbum.do";
	$.post(url,{},function(date){
    	var obj = eval('(' + date + ')');
    	for(var i=0;i<obj.length;i++){
			var abid = obj[i].id;//相册id
		//	var imgurl = obj[i].imgurl;
			var name = obj[i].name;
			var num = obj[i].num;
			var imgurl = obj[i].img;
			//alert(id+"---"+name); <td class='portrait'><img src='/wxy-back/images/pic.png'></td>
			$("#lalala").append("<li><a href='/wxy-back/album/getphotoByAbid.do?abid="+abid+"&albumname="+name+"'><figure><img src="+imgurl+"><figcaption>"+name+"</figcaption></figure></a><span>"+num+"</span></li>");
			   
		}
    	
    });
}


