<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<body>
<div class="header">
    <h1>孺学宝移动办公平台</h1>
    
    <ul>
        <li>
            <a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/school.png" />
                    <figcaption>校园管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/grade/toGrade.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/class.png" />
                    <figcaption>教务管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="#" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/teacher.png" />
                    <figcaption>教学管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/parent/getAlljiazhangxietong.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/parent.png" />
                    <figcaption>家长协同</figcaption>
                </figure>
            </a>
        </li>
                 <%--  <shiro:hasPermission name="admin">     --%>                          
        <li>
            <a href="${pageContext.request.contextPath }/access/listEqu.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/door.png" />
                    <figcaption>门禁管理</figcaption>
                </figure>
            </a>
        </li>
                 <%--  </shiro:hasPermission> --%>
        <li>
            <a href="${pageContext.request.contextPath }/safe/toSafe.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/baoxian.png" />
                    <figcaption>保险管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/system/listUser.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                    <img src="${pageContext.request.contextPath }/images/system.png" />
                    <figcaption>系统管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" <c:choose ><c:when test="${not empty loginUser }">target='leftFrame'</c:when><c:otherwise>target='_parent'</c:otherwise></c:choose>>
                <figure>
                   <img src="${pageContext.request.contextPath }/images/center.png" />
                    <figcaption>技服中心</figcaption>
                </figure>
            </a>
        </li>
    </ul>
    <div class="head_right">
        <select id="ss" name="sid" onchange="changeSid(this.options[this.options.selectedIndex].value)">
	        <option value="">请选择学校</option>
	       		<c:forEach items="${sessionScope.schools }" var="school">
	            <option value="${school.id }" <c:if test="${school.id ==requestScope.schoolid }">selected="selected"</c:if> >${school.name }</option>
	        </c:forEach>
        </select>
        <script type="text/javascript">
        function changeSid(id){
        	if(id==""){
        		alert("请先选择学校");
        	}else{
        		 $.ajax({
        	     	    type: "get",
        	     	    url: "${pageContext.request.contextPath}/page/setSid.do",
        	     	    data: {"sid":id},
        	     		 jsonp:"callback",
        	     		 contentType: "application/text;charset=UTF-8",
        	     	    success: function(d){
        	          	     
        	          	 },
        	     	});	
        	}
        }
        function exit(){
        	var flag=confirm("您确认想要退出系统么？");  
        	    if (flag){    
        	        window.parent.location.href="/wxy-back/user/logout.do";   
        	    }    
        }
        $(function(){
	        $(".link > a").click(function(){
	            $(this).next().slideToggle(200,function(){
	                //TODO
	            });
	        });
        });
        </script>
        <div class="link">
        <a href="javascript:void(0)" onclick="exit()" class="switch" target="_parent"></a>
           <!--  <a href="#" class="switch"></a> -->
         <%--    <ul>
                <li><a href="${pageContext.request.contextPath }/system/settings.do" target="leftFrame">系统设置</a></li>
                <li><a href="javascript:void(0)" onclick="exit()" >退出</a></li>
            </ul> --%>
        </div>
    </div>
</div>
</body>
</html>