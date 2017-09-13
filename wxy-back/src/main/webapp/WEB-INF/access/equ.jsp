<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设备管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
  
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
    <script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
  
    <script>
    function exit(){
    	var flag=confirm("您确认想要退出系统么？");  
    	    if (flag){    
    	        location.href="/wxy-back/user/logout.do";   
    	    }    
    	
    }
    function del(id){
    	$.messager.confirm('确认','您确认想要删除记录吗？',function(flag){    
    	if(flag){
    		window.location.href="${pageContext.request.contextPath}/access/delById.do?id="+id;
    	}
    	});  


    	
    }
        $(function(){
            $(".link > a").click(function(){
                $(this).next().slideToggle(200,function(){
                    //TODO
                });
            });
            
            
            $("#equadd").window({
                title:'添加设备',
                width:600,
                minimizable:false,
                modal:true,
                shadow:true,
                closed:true,
                height:350,
                resizable:false
            });
            
            $("#addequ").click(function(){
            	 $("#equadd").window("open");
            });
        });
        function checkid(){
	        var eid =$.trim($("#equid").val());
	        	if(eid==""){
	        		$("#pid").html("请输入设备编码！");
	        		return false;
	        	}else if(eid!=""){
	        		$("#pid").html("");
	        		return true;
	        	}
        }	
        function checkmodel(){
	        var emodel =$.trim($("#equmodel").val());
	        	if(emodel==""){
	        		$("#pmodel").html("请输入设备型号！");
	        		return false;
	        	}else if(emodel!=""){
	        		$("#pmodel").html("");	        		
	        		return true
	        	}
        }	
        function checktype(){
	        var etype =$.trim($("#equtype").val());
	        	if(etype==""){
	        		$("#ptype").html("请选择设备类型！");
	        		return false;
	        	}else if(etype!=""){
	        		$("#ptype").html("");
	        		return true
	        	}
        }	
        function add(){
        	
        	var ischool = '${isSchool}';
        	if(ischool!=1){
        		var school = $("#scid").val();
        		var s=$.trim(school);
        		if(s==""){
        			$.messager.confirm('提示','请关闭窗口先选择学校！', function(r){
        				if(r){
            				$("#equadd").window("close");
            			}
        			});


        			
        		}else{
        			if(checkid() && checkmodel() && checktype()){
                		$("#addForm").submit();       		
                	}
        		}
        	}else{
	        	if(checkid() && checkmodel() && checktype()){
	        		$("#addForm").submit();       		
	        	}
        	}
        }
        function clo(){
        	 $("#equadd").window("close");
        }
        
        function abc(v,m){
        	if(""==v){
        		$("#school").val("");
        		$("#schid").val("");
        		$("#scid").val("");
        	}else{
        		$("#school").val(m);
        		$("#schid").val(v);
        		$("#scid").val(v);
        	}
        }
    </script>
</head>
<body>
<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/access/listEqu.do" class="machine" target="leftFrame">设备管理</a></li>
            <li><a href="${pageContext.request.contextPath }/card/listCard.do" class="card" target="leftFrame">卡片管理</a></li>
        </ul>
    </div>
    <div class="detail">
        <article class="machine_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/access/listEqu.do" target="leftFrame">门禁管理 ></a>
                <a href="${pageContext.request.contextPath }/access/listEqu.do" target="leftFrame">设备管理</a>
            </section>

            <section class="s_add">
				<a href="javascript:void(0)" onclick="add()" class="import">导入</a>
			</section>
<%--            <c:if test="${isSchool !=1 }">
            <c:if test="${isSchool !=1 }">
	            <div class="info_top">
	                <label>学校名称：</label>
	                <span>
	                    <select name="schoolid"  onchange="abc(this.options[this.selectedIndex].value,this.options[this.selectedIndex].text)">
	                        <option value="">请选择学校</option>
	                       <c:forEach items="${schools }" var="school" >
	                        <option value="${school.id }">${school.name }</option>
	                       </c:forEach>
	                    </select>
	                </span><input type="text" id="school" value="${sname }"/>
	                <span></span>
	            </div>
             </c:if>
             <c:if test="${isSchool !=1 }">
	            <div class="info_top">
	                <label>学校名称：</label>
	                <span>
	                    <select onchange="this.parentNode.nextSibling.value=this.value">
	                        <option value=""></option>
	                        <option value=""></option>
	                    </select>
	                </span><input type="text" />
	                <span></span>
	            </div>

            </c:if> --%>

            <form action="${pageContext.request.contextPath }/access/listEqu.do" method="post">
            <input type="hidden" name="schoolid" id="schid" value="${sid }">
                <div class="search">
                    <div>
                        <label>设备编号：</label>
                        <input type="text" name="id" id="eqn" value="${bh }"/>
                    </div>
                    <div>
                    
                        <label>运行状态：</label>
                        <select name="runstate" id="rse">
                            <option value="">请选择状态</option>
                            <option value="0" <c:if test="${yz==0 }">selected=selected</c:if>>运行正常</option>
                            <option value="1" <c:if test="${yz==1 }">selected=selected</c:if>>摄像头故障</option>
                            <option value="2" <c:if test="${yz==2 }">selected=selected</c:if>>刷卡器故障</option>
                            <option value="3" <c:if test="${yz==3 }">selected=selected</c:if>>拆机报警</option>
                            <option value="4" <c:if test="${yz==4 }">selected=selected</c:if>>其他</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                   <%--  <div>
                        <label>设备型号：</label>
                        <input type="text" name="model" value="${xh }"/>
                    </div> --%>
                    <div>
                        <label>设备型号：</label>

                        <%-- <input type="text" name="model" value="${xh }"/> --%>

                        <select name="model2" id="xh">
                            <option value="">请选择类型</option>
                            <option value="1" <c:if test="${xh==1 }">selected=selected</c:if>>落地机</option>
                            <option value="2" <c:if test="${xh==2 }">selected=selected</c:if>>支架机</option>
                            <option value="3" <c:if test="${xh==3 }">selected=selected</c:if>>壁挂机</option>
                        </select>

                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>设备类型：</label>
                        <select name="type" id="eqt">
                            <option value="">请选择类型</option>
                            <option value="1" <c:if test="${lx==1 }">selected=selected</c:if>>门禁机</option>
                            <option value="2" <c:if test="${lx==2 }">selected=selected</c:if>>闸机</option>
                            <option value="3" <c:if test="${lx==3 }">selected=selected</c:if>>摄像头</option>
                        </select>
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit"  value="查找">查找</button>
                    <input type="reset" class="clean" value="清除" />
                </div>
                <div class="clear"></div>
            </form>
            <section class="s_add">
                <a href="javascript:void(0)" class="add" id="addequ">新增</a>
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="snum">设备编号</th>
                        <th class="stype">设备类型</th>
                        <th class="model">设备型号</th>
                        <th class="run">运行状态</th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                   
                    <c:forEach items="${pageBean.rows }" var="equipment" varStatus="status">
                    	<tr>
	                        <td class="num">${status.count }</td>
	                        <td class="snum" title="${equipment.id }">${equipment.id  }</td>
	                        <td class="stype" title="${equipment.typeView }">${equipment.typeView }</td>
	                        <td class="model" title="${equipment.modelView }">${equipment.modelView }</td>
	                        <td class="run" title="${equipment.stateView }">${equipment.stateView }</td>
	                        <td class="do">
	                            <a href="javascript:void(0)" class="del" onclick="del(${equipment.id  })">删除</a>
	                        </td>
                   		 </tr>
                    </c:forEach>
                 
                    </tbody>
                </table>
                <div class="bar">
                 <div class="barcon">
                    ${pageBean.pageHtml }
                        <%-- <select>
                            <option value="显示10条">显示10条</option>
                            <option value="显示20条">显示20条</option>
                            <option value="显示30条">显示30条</option>
                        </select>
                        <div class="page">
                            <a href="#" class="first"><img src="${pageContext.request.contextPath }/images/first.jpg" /></a>
                            <a href="#" class="up"><img src="${pageContext.request.contextPath }/images/up.jpg" /></a>
                            <span>第<input value="1"/>页 共1页</span>
                            <a href="#" class="down"><img src="${pageContext.request.contextPath }/images/down.jpg" /></a>
                            <a href="#" class="last"><img src="${pageContext.request.contextPath }/images/last.jpg" /></a>
                        </div>
                        <a href="#" class="reload"><img src="${pageContext.request.contextPath }/images/reload.jpg"></a>
                        <p>共10条记录</p> --%>
                    </div>
                </div>
                <!--<div class="choice">请先选择学校！</div>-->
            </section>
        </article>
    </div>
</main>
<div id="equadd" class="easyui-window machine_add">
    <h2>设备信息</h2>
    <form id="addForm" action="${pageContext.request.contextPath }/access/addEqu.do" method="post">
	    <input type="hidden" name="sch" id="scid">
	    <div class="machine_con">
	        <div>
	            <label>设备编号：</label>
	            <input type="text" name="id" id="equid" onblur="checkid()"/>
	            <p id="pid" style="color:red"></p>
	        </div>
	        <div>
	            <label>设备型号：</label>
	            <!-- <input type="text" name="model" id="equmodel" onblur="checkmodel()"/> -->
	                <select name="model" id="equmodel" onblur="checkmodel()">
	                <option value="">请选择型号</option>
	                <option value="1">落地机</option>
	                <option value="2">支架机</option>
	                <option value="3">壁挂机</option>
	                </select>
	            <p id="pmodel" style="color:red"></p>
	        </div>
	        <div>
	            <label>设备类型：</label>
	            <select name="type" id="equtype" onblur="checktype()">
	                <option value="">请选择类型</option>
	                <option value="1">门禁机</option>
	                <option value="2">闸机</option>
	                <option value="3">摄像头</option>
	            </select>
	            <p id="ptype" style="color:red"></p>
	        </div>
	    </div>
    <div class="btn">
    <button class="save" type="button" onclick="add()" value="保存">保存</button>
        <!-- <input class="save" onclick="add()" type="button" value="保存"/> -->
        <a href="javascript:void(0)"><button class="close" type="button" onclick="clo()" value="取消">取消</button></a>
    </div>
    </form>
</div>
</body>
</html>