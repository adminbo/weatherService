<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">

	<script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrapv3.js"></script>
    <script src="${pageContext.request.contextPath }/js/qunit-1.11.0.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/showuseradd.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type='text/javascript'>
function exit(){
	var flag=confirm("您确认想要退出系统么？");  
	    if (flag){    
	        location.href="/wxy-back/user/logout.do";   
	    }    
	
}

$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
});

var tol="${pageBean.total}";
var cupg="${pageBean.currentPage}";
var ps="${pageBean.pageSize}";
$(function(){
    test("Test bootstrap v3 rendering", function(){

        var element = $('#bp-3-element-test');

        var options = {
            bootstrapMajorVersion:3,
            currentPage: 3,
            numberOfPages: 5,
            totalPages:11
        }

        element.bootstrapPaginator(options);
    })
    
    $('#pp').pagination({
       total:"${pageBean.total}",
       pageList: [8,10,15],
    onSelectPage:function(currentPage, pageSize){
   		
   		var url="/wxy-back/system/listUserByPage.do";
    		var userName=$("#un").val();
    		var regTime = $("#rgt").val();
    		var companyName = $("#cn").val();
    		var type = $("#ty").val();
    		var realName = $("#rn").val();
    		$.post(url,{"userName":userName,
    			"regTime":regTime,
    			"companyName":companyName,
    			"type":type,
    			"realName":realName,
    			"currentPage":currentPage,
    			"pageSize":pageSize},function(data){
    				//alert(1111111111111);
    			   	var obj = eval('(' + data + ')');
    		    	//alert(obj);
                    //清空除第一行意外的所有行  
                    $("#datelist").html("");  
                    $.each( obj, function(i, n){
                    	 // alert( "Item #" + i + ": " + n.name );
                    	  var tr = " <tr><td class='num'>"+(i+1)+"</td><td class='username' title="+n.name+">"+n.name+"</td><td class='dname' title="+n.companyname+">"+n.companyname+"</td><td class='utype' title="+n.typeView+">"+n.typeView+"</td>"+
	                        "<td class='real' title="+n.realName+">"+n.realName+"</td><td class='time' title="+n.regtime+">"+n.regtime +"</td>"+
	                        "<td class='do'><a href='javascript:void(0)' onclick='show("+n.id+")' class='look'>查看</a><a href='javascript:void(0)' onclick='edit("+n.id+","+n.type+")' class='revise'>修改</a>"+
	                            "<a href='javascript:void(0)' onclick='del("+n.id+")' class='del'>删除</a></td></tr>" 
	                            $("#datelist").append(tr);
                    	});
    		});
    	}
    });
});
</script>
</head>
<body>

<main>
    <aside class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/system/listUser.do" class="users" target="leftFrame">用户管理</a></li>
            <li><a href="${pageContext.request.contextPath }/system/toAuth.do" class="quan" target="leftFrame">权限管理</a></li>
           <!--  <li><a href="#" class="safe">系统安全</a></li> -->
            <li><a href="${pageContext.request.contextPath }/system/settings.do" class="set" target="leftFrame">系统设置</a></li>
            <!-- <li><a href="#" class="help">帮助中心</a></li> -->
        </ul>
    </aside>
 
    <div class="detail">
        <article class="user">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/system/listUser.do" target="leftFrame">系统管理 ></a>
                <a href="${pageContext.request.contextPath }/system/listUser.do" target="leftFrame">用户管理</a>
            </section>
            
            <form action="${pageContext.request.contextPath }/system/listUser.do" method="post">
                <div class="search">
                    <div>
                        <label>用户名：</label>
                        <input type="text" id="un" name="userName" class="text" value="${userName}"/>
                    </div>
                    <div>
              
                        <label>开通时间：</label>
                        <input class="Wdate" id="rgt" in="rt" type="text" name="regTime" onClick="WdatePicker()" value="${regTime}">
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>单位名称：</label>
                        <input type="text" id="cn" name="companyName" class="text" value="${companyName }"/>
                    </div>
                    <div>
                        <label>用户类型：</label>
                        <select id="ty" name="type">
                            <option value="">请选择分类</option>
                         	<c:forEach items="${roles }" var="role">
                            <option value="${role.id }"  >${role.name }</option>
							</c:forEach>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div class="belong">
                        <label>真实姓名：</label>
                        <input type="text" id="rn" name="realName" class="text" value="${realName }"/>
                    </div>
                </div>
    
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <input type="reset" id="caaa" class="clean" value="清空" />
                </div>
                <div class="clear"></div>
            </form>
            <section class="s_add">
                <a href="javascript:void(0)" onclick="add('${loginUser.type}')" class="add">新增</a>
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="username">用户名</th>
                        <th class="dname">单位名称</th>
                        <th class="utype">用户类型</th>
                        <th class="real">真实姓名</th>
                        <th class="time">开通时间</th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody id="datelist" class="con_tbody" >
	                    <c:forEach items="${pageBean.rows }"  var="user" varStatus="status">
		                    <tr>
		                   
		                        <td class="num">${status.count }</td>
		                        <td class="username" title="${user.name }">${user.name }</td>
		                        <td class="dname" title="${user.companyname}">${user.companyname}</td>
		                        <td class="utype" title="${user.typeView }">${user.typeView }</td>
		                        <td class="real" title="${user.realName }">${user.realName }</td>
		                        <td class="time" title="${user.regtime }">${user.regtime }</td>
		                        <td class="do">
		                            <a href="javascript:void(0)" onclick="show('${user.id}')" class="look">查看</a>
		                            <a href="javascript:void(0)" onclick="edit('${user.id}','${loginUser.type}')" class="revise">修改</a>
		                            <a href="javascript:void(0)" onclick="del('${user.id}')" class="del">删除</a>
		                        </td>
		                    </tr>
	                    </c:forEach>
                   
                    </tbody>
                </table>		                
            </section>
	          <div id="pp" style="background:#efefef;border:1px solid #ccc;height:30px"></div>                                        
        </article>
    </div>
</main>
<div id="useradd" class="easyui-window uadd">
    <h2>用户基本信息</h2>
    <form action="${pageContext.request.contextPath }/system/addUsers.do" method="post">
        <div>
            <label><span>*</span>用户名：</label>
            <input id="user_name" type="text" class="text" name="userName"/>
            <span id="user_name_input"></span>
        </div>
        <div>
            <label><span>*</span>单位名称：</label>
            <input id="user_dw" type="text" class="text" name="companyName"/>
            <span id="user_dw_input"></span>
        </div>
        <div>
            <label><span>*</span>用户类型：</label>
            <p id="user_type"></p>
            <!-- <input type="checkbox"  name="typeId" value="" />123 -->                
            <span id="user_type_input"></span>
        </div>
        <div>
            <label><span>*</span>真实姓名：</label>
            <input id="name" type="text" class="text" name="realName"/>
            <span id="name_input"></span>
        </div>
        <div>
            <label><span>*</span>手机号：</label>
            <input id="phone" type="text" class="text" name="phoneNum"/>
            <span id="phone_input"></span>
        </div>
        <div>
            <label><span>*</span>邮箱：</label>
            <input id="email" type="email" class="email" name="email"/>
            <span id="email_input"></span>
        </div>
        <div>
            <label><span>*</span>所属代理商：</label>
            <select id="user_dls" name="agentId">
                <option value="">请选择代理商</option>
             
            </select>
            <span id="user_dls_input"></span>
        </div>
        <div class="btn">
            <button id="useradd_btn" type="submit" class="save">保存</button>
            <button class="cancel" type="button" id="win_close">取消</button>
        </div>

    </form>
</div>
<div id="userEdit" class="easyui-window uadd">
    <h2>用户基本信息</h2>
    <form action="${pageContext.request.contextPath }/system/updateUser.do" method="post">
       <input type="hidden" id="uid" name="uid" />
        <div>
            <label><span>*</span>用户名：</label>
            <input id="usname" type="text" class="text" name="userName" disabled="disabled"/>
            <span id="user_name_input"></span>
        </div>
        <div>
            <label><span>*</span>单位名称：</label>
            <input id="dw" type="text" class="text" name="companyName" disabled="disabled"/>
            <span id="user_dw_input"></span>
        </div>
        <div>
            <label><span>*</span>用户类型：</label>
            <p id="ustype"></p>
            <span id="user_type_input"></span>
        </div>
        <div>
            <label><span>*</span>真实姓名：</label>
            <input id="rename" type="text" class="text" name="realName"/>
            <span id="name_input"></span>
        </div>
        <div>
            <label><span>*</span>手机号：</label>
            <input id="phonenum" type="text" class="text" name="phoneNum"/>
            <span id="phone_input"></span>
        </div>
        <div>
            <label><span>*</span>邮箱：</label>
            <input id="regemail" type="email" class="email" name="email"/>
            <span id="email_input"></span>
        </div>
        <div>
            <label><span>*</span>所属代理商：</label>
            <select id="dls" name="agentId" disabled="disabled">
               
             
            </select>
            <span id="user_dls_input"></span>
        </div>
        <div class="btn">
            <button id="useradd_btn" type="submit" class="save">保存</button>
            <button class="cancel" type="button" id="win_clo">取消</button>
        </div>

    </form>
</div>
<div id="userShow" class="easyui-window uadd">
    <h2>用户基本信息</h2>
        <div>
            <label><span>*</span>用户名：</label>
            <input id="uname" type="text" class="text" name="userName" disabled="disabled"/>
            <span id="user_name_input"></span>
        </div>
        <div>
            <label><span>*</span>单位名称：</label>
            <input id="cname" type="text" class="text" name="companyName" disabled="disabled"/>
            <span id="user_dw_input"></span>
        </div>
        <div>
            <label><span>*</span>用户类型：</label>
            <select id="utype" name="typeId" disabled="disabled">
                
                
            </select>
            <span id="user_type_input"></span>
        </div>
        <div>
            <label><span>*</span>真实姓名：</label>
            <input id="rname" type="text" class="text" name="realName" disabled="disabled"/>
            <span id="name_input"></span>
        </div>
        <div>
            <label><span>*</span>手机号：</label>
            <input id="pnum" type="text" class="text" name="phoneNum" disabled="disabled"/>
            <span id="phone_input"></span>
        </div>
        <div>
            <label><span>*</span>邮箱：</label>
            <input id="remail" type="email" class="email" name="email" disabled="disabled"/>
            <span id="email_input"></span>
        </div>
        <div>
            <label>开通时间：</label>
            <input id="time" type="text" disabled="disabled" />
            <span id="time_input"></span>
        </div>
        <div>
            <label><span>*</span>所属代理商：</label>
            <select id="agent" name="agentId" disabled="disabled">
                
             
            </select>
            <span id="user_dls_input"></span>
        </div>
        <div class="btn">
            <button id="windo_close" type="button" class="save">确定</button>
            <button class="cancel" type="button" id="wind_close">取消</button>
        </div>

</div>
</body>
</html>