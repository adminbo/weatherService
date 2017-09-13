<%@ page pageEncoding="utf-8"%>
<aside class="main_left">
	<h2>
		用户名
		<span>${loginUser.name }</span>
	</h2>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure" class="configure" target="leftFrame">公众号配置</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath  }/getAllWechateslist.do" class="gmanage" target="leftFrame">公众号管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath  }/getAllSchoolMaster.do" class="smanage" target="leftFrame">学校信息管理</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath  }/getAllMenu.do" class="app" target="leftFrame">应用中心</a>
		</li>
	</ul>
</aside>
