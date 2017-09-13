<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>应用中心</title>
<%@include file="/WEB-INF/include/static.jsp"%>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx }/js/jquery-form/jquery.form.min.js"></script>
</head>
<body>
	<main> <%@include file="/WEB-INF/include/left_menu.jsp"%> 
	<div class="detail">
		<article class="appcon"> <section class="top"> 
		<a href="#" target="leftFrame">首页 ></a> 
		<a href="#" target="leftFrame">应用中心</a> 
		</section> 
		<section class="appmain">
		<div class="app_main">
			<%-- <form action="${ctx }/getAppMenu.do" method="post" onsubmit="return false;">
				<div class="text_drop">
					<label>学校名称：</label>
					<span>
						<select id="searchSelect">
								<c:forEach items="${listes }" var="foeachls" >  
									<option value="${foeachls.name }">${foeachls.name }</option>
								</c:forEach>
						</select>
					</span>
					<input type="text" id="searchInput" name="name" placeholder="请输入学校名称" />
				</div>
			</form> --%>
			<div class="all">
				<h2>所有应用</h2>
				<div class="allcon">
					<ul id="apps">
					</ul>
				</div>
			</div>
		</div>
		<div id="moduleApp"></div>
		<div class="clear"></div>
		<div class="btn">
			<button id="saveBtn" type="button" class="save">保存</button>
		</div>
		</section> <!-- </form> --> </article>
	</div>
	</main>
</body>
</html>