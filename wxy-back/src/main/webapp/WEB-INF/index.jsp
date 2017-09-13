<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>孺学宝</title>
</head>
<frameset rows="84,*" frameborder="0" border="0" framespacing="0">
	<frame src="../page/top.do" name="topFrame" noresize="noresize" scrolling="no" id="leftFrame" />
		<frameset cols="*,260" frameborder="0" border="0" framespacing="0">
			<frame src="../page/left.do" name="leftFrame" noresize="noresize" id="leftFrame" />
			<frame src="../page/right.do" name="rightFrame" id="rightFrame" />
		</frameset>
	<!-- <frame src="../page/main.do" name="mainFrame" id="mainFrame" /> -->
</frameset>
<noframes><body></body></noframes>
</html>
