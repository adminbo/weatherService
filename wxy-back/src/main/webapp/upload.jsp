<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	 src="${pageContext.request.contextPath}/js/ocupload/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#ut").upload({
			action:'${pageContext.request.contextPath}/file/upload.do',//form表单的提交地址
				name:'file',
					onComplete: function (data, self, element) {//当服务端写回数据后此方法执行
						if(data == '1'){
							//导入成功
							alert("success");
						}else{
							//导入失败
							alert("fail");
						}
					}
		});
	});
</script>
</head>
<body>
		<input type="button" id="ut" value="上传文件"/>
</body>
</html>