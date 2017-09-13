<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>卡片管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
     <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath }/js/qunit-1.11.0.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
    <script type="text/javascript">
    
	
	

        $(function(){
        	$("#import").upload({  
        	    action: '${pageContext.request.contextPath}/card/importApply.do',  
        	    name:'upfile',
        	    onComplete: function (data, self, element) { 
        		     if(-1==data){
        		    	 alert("要导入文件不是合格表格文件");
        		     }else if(1==data){
        		    	 alert("导入成功！");
        		    	 location.reload();
        		     }else if(2==data){
        		    	 alert("请选择上传文件！");
        		     }else{
        		    	 alert("导入失败！");
        		     }
        	    }
            }); 
        	
      
            
            $("#add").window({
                title:'添加卡片',
                width:430,
                minimizable:false,
                modal:true,
                shadow:true,
                closed:true,
                height:425,
                resizable:false
            });
            $("#padd").window({
                title:'添加卡片',
                width:480,
                minimizable:false,
                modal:true,
                shadow:true,
                closed:true,
                height:400,
                resizable:false
            });
            $("#del").window({
                title:'退卡',
                width:430,
                minimizable:false,
                modal:true,
                shadow:true,
                closed:true,
                height:425,
                resizable:false
            });
            $("#fill").window({
                title:'补卡',
                width:430,
                minimizable:false,
                modal:true,
                shadow:true,
                closed:true,
                height:425,
                resizable:false
            });
            
            $("#change").window({
                title:'换卡',
                width:370,
                minimizable:false,
                modal:true,
                shadow:true,
                closed:true,
                height:260,
                resizable:false
            });
            //关闭弹窗
            $("#clo1").click(function(){
            	 $("#add").window("close");
            });
            $("#clo2").click(function(){
            	  $("#del").window("close");
            });
            $("#clo3").click(function(){
            	$("#fill").window("close");
            });
            $("#clo4").click(function(){
            	$("#change").window("close");
            });
            var new1t=true;
            var new2t=true;
            var new3t=true;
            var new4t=true;
            $("#new11").blur(function(){
            	var cid = $("#new11").val();
               	$.ajax({
          		   type: "post",
        			   url: "${pageContext.request.contextPath }/card/findById.do",
        			   dataType:"json",
        			   data: "cid="+cid,
        			   success: function(data){
        					if(data==0){
        			 			$("#cew1").text("输入的卡片未注册，请重新输入。");	
        			 			new1t=false;
        			 		}else if(data==1){
        			 			new1t=true;
        			 		}					
        			   }
          		});
            });
            $("#new22").blur(function(){
            	var cid = $("#new22").val();
               	$.ajax({
          		   type: "post",
        			   url: "${pageContext.request.contextPath }/card/findById.do",
        			   dataType:"json",
        			   data: "cid="+cid,
        			   success: function(data){
        					if(data==0){
        			 			$("#cew2").text("输入的卡片未注册，请重新输入。");
        			 			new2t=false;
        			 		}else if(data==1){
        			 			new2t=true;
        			 		}						
        			   }
          		});
            });
            $("#new33").blur(function(){
            	var cid = $("#new33").val();
               	$.ajax({
          		   type: "post",
        			   url: "${pageContext.request.contextPath }/card/findById.do",
        			   dataType:"json",
        			   data: "cid="+cid,
        			   success: function(data){
        					if(data==0){
        			 			$("#cew3").text("输入的卡片未注册，请重新输入。");	
        			 			new3t=false;
        			 		}else if(data==1){
        			 			new3t=true;
        			 		}						
        			   }
          		});
            });
            $("#new44").blur(function(){
            	var cid = $("#new44").val();
               	$.ajax({
          		  	   type: "post",
        			   url: "${pageContext.request.contextPath }/card/findById.do",
        			   dataType:"json",
        			   data: "cid="+cid,
        			   success: function(data){
        			 		if(data==0){
        			 			$("#cew4").text("输入的卡片未注册，请重新输入。");	
        			 			new4t=false;
        			 		}else if(data==1){
        			 			new4t=true;
        			 		}					
        			   }
          		});
            });
            
            $("#newcard").click(function(){
            	var i=0;
          
            	var a =$.trim($("#new11").val());
            	var b =$.trim($("#new22").val());
            	var c =$.trim($("#new33").val());
            	var d =$.trim($("#new44").val());           	
            	if(a!=""){
            		i=i+1;
            	}
            	if(b!=""){
            		i=i+1;
            	}
            	if(c!=""){
            		i=i+1;
            	}
            	if(d!=""){
            		i=i+1;
            	}
            	if(i!=nums){
            		alert("开卡数量不等于申请数量");
            	}else{
            		if(new1t && new2t && new3t &&new4t){
	            		$("#cardform").submit();
            		}
            	}
            });
            
            
            	


        });
        
        //开卡弹窗
        var newid=null;
        var nums=null;
        function add(id,ok,num){
        	if(ok==1){
        		$.messager.alert('警告','该申请已经处理过了！','warning');
        		return;
        	}
        	newid=id;
        	nums=num;
          	$("#new11").val("");
        	$("#new22").val("");
        	$("#new33").val("");
        	$("#new44").val("");
        	$("#cardnum").val(num);
        	$("#hid").val(id);
        	 $("#add").window("open");
        }
        
        //退卡弹窗
        function back(aid,isok){ 
        	if(isok==1){
        		$.messager.alert('警告','该申请已经处理过了！','warning');
        		return;
        	}       
        	$.ajax({
        		   type: "post",
    			   url: "${pageContext.request.contextPath }/card/getBackById.do",
    			   dataType:"json",
    			   data: "aid="+aid,
    			   success: function(data){
   		 			 $("#bc1").val(data.card1no);
   		 			 $("#bc2").val(data.card2no);
   		 			 $("#bc3").val(data.card3no);
   		 			 $("#bc4").val(data.card4no);
   		 			 $("#bnum").val(data.num);
    			   }
        	});
        	$("#apid").val(aid);
        	$("#del").window("open");
        }
      //换卡  
      var zs;
        function fill(id,isok){
        	$("#applyid").val(id);
        	$("#con").html("");
        	var fid = id;
        	if(isok==1){
        		$.messager.alert('警告','该申请已经处理过了！','warning');
        		return;
        	}  
        	$.ajax({
     		   type: "post",
 			   url: "${pageContext.request.contextPath }/card/getFillById.do",
 			   dataType:"json",
 			   data: "aid="+fid,
 			   success: function(data){
		 		var a =data.length;
		 		$("#fnum").val(a);
		 		zs=a;
		 		for(var i=1;i<=a;i++){
		 			var v=data[i-1];
		 			$("#cad"+i).val(v);
		 			var div="<div ><label>卡片"+i+"编号：</label><input type='text'  value='"+v+"' name='newcard"+i+"'  class='change_card' id='cc"+i+"' />"
		 			+"<p id='p"+i+"' style='color:red'></p></div>"
		 			$("#con").append(div);
		 		}
 			   }
     	});
        	 $("#fill").window("open");
        }
        
		//var inde;
    //    function openchange(cid,index){
    //    	inde=index;
    //    	$("#old").val(cid);
    //    	$("#new").val("");
        	// $("#change").window("open");
     //   }
        function addd(){
        	$("#span1").text("");
        	$("#span2").text("");
        	$("#span3").text("");
        	$("#cs").val("");
        	$("#c1s").val("");
        	$("#c2s").val("");
        	$("#one").attr('checked',true);
        	$("#cs").attr("disabled",false);
        	$("#c1s").attr("disabled",true);
        	$("#c2s").attr("disabled",true);
        	$("#padd").window("open");
        }
       // function ch(){
        	//alert(inde);
        //	var va=$("#new").val();
        //	var vv=va.trim();
        //	if(vv.length==0){
       // 		$.messager.alert('警告',"新卡卡号不能为空",'warning');
       // 		return;
       // 	}
       // 	$("#cc"+inde).val(vv);
       // 	$("#change").window("close");
       // }
        
        function backcard(){
        	$("#bfm").submit();
        }     
        function changes(){
        	var yes=true;
        	for(var p=1;p<=zs;p++){
        		var cid = $("#cc"+p).val();
        		cid=cid.trim();
        		if($("#cad"+p).val()==cid){
        			$.messager.alert('警告',"第"+p+"张卡片没有更换！",'warning');
        			return ;
        		}
        		if(cid==""){
        			$("#p"+p).text("新卡号不能为空！");
					yes=false;
        		}else{
        			$("#p"+p).text("");
        		}
        	}
        	if(yes){
        		var cid1 = $("#cc1").val();
        		var cid2 = $("#cc2").val();
        		var cid3 = $("#cc3").val();
        		var cid4 = $("#cc4").val();
        		if(typeof(cid1) == "undefined"){
        			cid1="";
        		}
        		if(typeof(cid2) == "undefined"){
        			cid2="";
        		}
        		if(typeof(cid3) == "undefined"){
        			cid3="";
        		}
        		if(typeof(cid4) == "undefined"){
        			cid4="";
        		}
        		var cid = cid1+"/"+cid2+"/"+cid3+"/"+cid4;
        		$.ajax({
          		   type: "post",
        			   url: "${pageContext.request.contextPath }/card/findByIds.do",
        			   dataType:"text",
        			   data: "cid="+cid,
        			   success: function(data){       				  
        				   var strs= new Array(); //定义一数组 
        				   var strs2= new Array(); //定义一数组 
        				   strs=data.split("_"); //字符分割
        				   if(strs[0]==-1){
        					   $("#ccform").submit();
        				   }else{
        					   var newstr=strs[1];
        					   strs2=newstr.split("/");
        					   var s="";
        					   for(var j=0;j<strs2.length;j++){
        						   s=s+"、"+strs2[j];
        					   }
        					   alert("你输入的卡号 "+s+"未注册，请重新输入！");
        				   }
        				   
        			   }
          		});
        	}
        }
        
        function abc(v,m){
        	if(""==v){
        		$("#school").val("");
        	}else{
        		$("#school").val(m);
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
        <article class="card_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/access/listEqu.do" target="leftFrame">门禁管理 ></a>
                <a href="${pageContext.request.contextPath }/card/listCard.do" target="leftFrame">卡片管理</a>
            </section>
            <c:if test="${isschool !=1 }">
	            <div class="info_top">
	                <label>学校名称：</label>
	                <span>
	                    <select name="schoolid"  onchange="abc(this.options[this.selectedIndex].value,this.options[this.selectedIndex].text)">
	                        <option value="">请选择学校</option>
	                       <c:forEach items="${schools }" var="school" >
	                        <option value="${school.id }">${school.name }</option>
	                       </c:forEach>
	                    </select>
	                </span><input type="text" id="school" value="${schname }"/>
	                <span></span>
	            </div>
             </c:if>
            <div class="grade_con">
                <div id="tab_bar">
                    <ul>
                        <li id="tab1" class="tab" onclick="myclick(1)" style="background-color: #fff">
                            卡片信息
                        </li>
                        <li id="tab2" class="tab" onclick="myclick(2)">
                            开卡申请
                        </li>
                        <li id="tab3" class="tab" onclick="myclick(3)">
                            退卡申请
                        </li>
                        <li id="tab4" class="tab" onclick="myclick(4)">
                            补卡申请
                        </li>
                    </ul>
                </div>
<!-- **************************************************************** -->       
                <div class="tab_css" id="tab1_content" style="display: block">
                    <form action="${pageContext.request.contextPath }/card/listCard.do" id="fm1" method="post">
                        <input name="schoolname" type="hidden" id="sid"/>
                        <div class="search">
                            <div>
                                <label>卡片编号：</label>
                                <input type="text" name="id" value="${id }"/>
                            </div>
                            <div>
                                <label>年级：</label>
                                <select name="grade" id="g1" onchange="queryClazz(1,this.options[this.selectedIndex].value)">
                                    <option value="">请选择年级</option>
                                    <c:forEach items="${grades }" var="grade">
                                    <option value="${grade.id }">${grade.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        
                       
                        <div class="search">
                            <div>
                                <label>学生姓名：</label>
                                <input type="text" name="sname" value="${sname }"/>
                            </div>
                            <div>
                                <label>班级：</label>
                                <select name="clazz" id="c1" >
                                    <option value="">请选择班级</option>
                                   
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>开卡时间：</label>
                                <input class="Wdate" name="activeTime" type="text" value="${activeTime }" onClick="WdatePicker()">
                            </div>
                        </div>
                        <div class="btn">
                            <button class="lookup" type="button" onclick="sub()" value="查找">查找</button>
        <script type="text/javascript">
				function sub(){
					$("#sid").val($("#school").val());
					$("#fm1").submit();
				}
        </script>
                            <input type="reset" class="clean" value="清除" />
                        </div>
                        <div class="clear"></div>
                    </form>
                    <div class="content">
                        <div class="print_con">
                            <a href="javascript:void(0)" onclick="addd()" class="add">新增</a>
                            <a href="javascript:void(0)" class="print">打印</a>
                            <p id="import" style="color:blue">导入</p>
                        </div>
                        <table>
                            <thead>
                            <tr>
                                <th class="num"></th>
                                <th class="knum">卡片编号</th>
                                <th class="time">开卡时间</th>
                                <th class="sname">学生姓名</th>
                                <th class="kgrade">年级</th>
                                <th class="kclass">班级</th>
                                <th class="do">操作</th>
                            </tr>
                            </thead>
                            <tbody class="con_tbody" id="tb1">
                              <c:forEach items="${pageBean.rows }" var="card" varStatus="status">
                            <tr>
                                <td class="num">${status.count }</td>
                                <td class="knum" title="${card.id }">${card.id }</td>
                                <td class="time" title="${card.activeTime  }">${card.activeTime  }</td>
                                <td class="sname" title="${card.student.name  }">${card.student.name  }</td>
                                <td class="kgrade" title="${card.grade.name  }">${card.grade.name  }</td>
                                <td class="kclass" title="${card.clazz.name  }">${card.clazz.name  }</td>
                                <td class="do">
                                    <a href="javascript:void(0)" class="del" onclick="del(${card.id  })">删除</a>
                                </td>
                            </tr>
                    </c:forEach>
                           
                   
                            </tbody>
                        </table>
                            ${pageBean.pageHtml}
                   <%--      <div class="bar">
                            <div class="barcon">
                                <select>
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
                                <p>共10条记录</p>
                            </div>
                        </div> --%>
                        <!--<div class="choice">请先选择学校！</div>-->
                    </div>
                </div>
                
<!-- ***************************************************************** -->         
                <div class="tab_css" id="tab2_content">
                <input type="hidden" id="h2">
                    <form action="#" method="post" id="fm2" >
                        <div class="search">
                            <div>
                                <label>申请单号：</label>
                                <input type="text" name="id" id="tab21" value="${aid }"/>
                            </div>
                            <div>
                                <label>学生姓名：</label>
                                <input type="text" name="stuname" id="tab22" value="${stuname }"/>
                            </div>
                            <div>
                                <label>处理状态：</label>
                                <select name="isdeal" id="tab23">
                                    <option value="">请选择状态</option>
                                    <c:if test="${isdeal==0 }">selected</c:if>
                                    <option value="0" <c:if test="${isdeal==0 }">selected</c:if>>未处理</option>
                                    <option value="1" <c:if test="${isdeal==1 }">selected</c:if>>已处理</option>
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>申请人：</label>
                                <input type="text" name="applyer" id="tab24" value="${ applyer}"/>
                            </div>
                            <div>
                                <label>年级：</label>
                                <select name="gra" id="g2" onchange="queryClazz(2,this.options[this.selectedIndex].value)">
                                    <option value="${gra2 }" id="g">请选择年级</option>
                                     <c:forEach items="${grades }" var="grade">
                                    <option value="${grade.id }">${grade.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>支付时间：</label>
                                <input class="Wdate" name="applytime"value="${ applytime}" id="tab25" type="text" onClick="WdatePicker()">
                            </div>
                            <div>
                                <label>班级：</label>
                                <select name="cla" id="c2">
                                    <option value="${cla }" id="c">请选择班级</option>                                
                                </select>
                            </div>
                        </div>
                        <script type="text/javascript">
                        	function ck(n){
                        		var sname=$("#school").val();
                        		var aaa = $("#fm"+n).serialize();
                        		$.ajax({
                        			   type: "get",
                        			   url: "${pageContext.request.contextPath }/card/listByType.do?type="+n+"&schoolname="+sname+"&"+aaa,
                        			   dataType:"json",
                        			   success: function(data){
                        					var tot = data.total;
                                			var obj =data.rows;
                                			
                                			$("#tb"+n).html("");
                                			if(obj!=null){
                                				for(var i=0;i<obj.length;i++){ 
                                				var nnum=obj[i].num;
                                					var dd=obj[i].id;
                                					var ok=obj[i].isdeal;
                    		           				var tr2;
                    		           				var tr3;
                                					 var tr1="<tr><td class='num'>"+(i+1)+"</td><td class='knum' title='"+dd+"'>"+obj[i].id+"</td>"
                    		           				 +"<td class='sname' title='"+obj[i].student.name+"'>"+obj[i].student.name+"</td>"
                    		           				 +"<td class='kgrade' title='"+obj[i].gradeName+"'>"+obj[i].gradeName+"</td>"
                    		           				 +"<td class='kclass' title='"+obj[i].className+"'>"+obj[i].className+"</td>"
                    		           				 +"<td class='applicant' title='"+obj[i].applyer+"'>"+obj[i].applyer+"</td>"
                    		           				 +"<td class='time' title='"+obj[i].applytime+"'>"+obj[i].applytime+"</td>"
                    		           				 if(ok==1){
                    		           					tr2="<td class='deal' title=''><input  type='checkbox' checked='checked' /></td>"
                    		           				 }else{
                    		           					tr2="<td class='deal' title=''><input  type='checkbox'/></td>"
                    		           				 }
                    		           					tr3="<td class='do'><a href='javascript:void(0)' onclick='add("+dd+','+ok+','+nnum+")' class='add_card'>开卡</a>"
                    		           				 +"<a href='#' class='del'>删除</a></td></tr>";
                    		           			 $("#tb"+n).append(tr1+tr2+tr3);	
                                				}
                    		           	
                                			}
                        		pages(n,tot,n);
                        			   }
                        			});
                        	}
                        </script>
                        <div class="btn">
                            <button class="lookup" type="button" onclick="ck(2)" value="查找">查找</button>
                            <input type="reset" class="clean" value="清除" />
                        </div>
                        <div class="clear"></div>
                    </form>
                    <div class="content">
                        <table>
                            <thead>
                            <tr>
                                <th class="num"></th>
                                <th class="knum">申请单号</th>
                                <th class="sname">学生姓名</th>
                                <th class="kgrade">年级</th>
                                <th class="kclass">班级</th>
                                <th class="applicant">申请人</th>
                                <th class="time">申请时间
                                    <button type="button"><img src="${pageContext.request.contextPath }/images/order.jpg"></button>
                                </th>
                                <th class="deal">是否处理</th>
                                <th class="do">操作</th>
                            </tr>
                            </thead>
                            <tbody class="con_tbody" id="tb2">
                         
                            </tbody>
                        </table>
            <%--             <div class="bar">
                            <div class="barcon">
                                <select>
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
                                <p>共10条记录</p>
                            </div>
                        </div> --%>
                        <!--<div class="choice">请先选择学校！</div>-->
                    </div>
                        <div align="right" id="pp2" style="background:#efefef;border:1px solid #ccc;height:30px"></div>
                </div>
                
 <!-- ***************************************************************** --> 
                <div class="tab_css" id="tab3_content">
                    <form action="#" method="post" id="fm3">
                        <div class="search">
                            <div>
                                <label>申请单号：</label>
                                <input type="text" name="id" id="tab31"/>
                            </div>
                            <div>
                                <label>学生姓名：</label>
                                <input type="text" name="stuname" id="tab32"/>
                            </div>
                            <div>
                                <label>处理状态：</label>
                                <select name="isdeal" id="tab33">
                                    <option value="">请选择状态</option>
                                    <option value="0">未处理</option>
                                    <option value="1">已处理</option>
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>申请人：</label>
                                <input type="text" name="applyer" id="tab34"/>
                            </div>
                            <div>
                                <label>年级：</label>
                                <select name="gra" id="g3" onchange="queryClazz(3,this.options[this.selectedIndex].value)">
                                    <option value="">请选择年级</option>
                                   <c:forEach items="${grades }" var="grade">
                                    <option value="${grade.id }">${grade.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>申请时间：</label>
                                <input class="Wdate" name="applytime" id="tab35" type="text" onClick="WdatePicker()">
                            </div>
                            <div>
                                <label>班级：</label>
                                <select name="cla" id="c3">
                                     <option value="">请选择班级</option>
                                   
                                </select>
                            </div>
                        </div>
                        <div class="btn">
                            <button class="lookup" type="button" onclick="ck(3)" value="查找">查找</button>
                            <input type="reset" class="clean" value="清除" />
                        </div>
                        <div class="clear"></div>
                    </form>
                    <div class="content">
                        <table>
                            <thead>
                            <tr>
                                <th class="num"></th>
                                <th class="knum">申请单号</th>
                                <th class="sname">学生姓名</th>
                                <th class="kgrade">年级</th>
                                <th class="kclass">班级</th>
                                <th class="applicant">申请人</th>
                                <th class="time">申请时间
                                    <button type="button"><img src="${pageContext.request.contextPath }/images/order.jpg"></button>
                                </th>
                                <th class="deal">是否处理</th>
                                <th class="do">操作</th>
                            </tr>
                            </thead>
                            <tbody class="con_tbody" id="tb3">
                            <tr>
                                <td class="num">1</td>
                                <td class="knum" title=""></td>
                                <td class="sname" title=""></td>
                                <td class="kgrade" title=""></td>
                                <td class="kclass" title=""></td>
                                <td class="applicant" title=""></td>
                                <td class="time" title=""></td>
                                <td class="deal" title=""><input type="checkbox" /></td>
                                <td class="do">
                                    <a href="javascript:void(0)" onclick="back()" class="del_card">退卡</a>
                                    <a href="#" class="del">删除</a>
                                </td>
                            </tr>
                         
                            </tbody>
                        </table>
                        <%-- <div class="bar">
                            <div class="barcon">
                                <select>
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
                                <p>共10条记录</p>
                            </div>
                        </div> --%>
                        <!--<div class="choice">请先选择学校！</div>-->
                    </div>
                        <div align="right" id="pp3" style="background:#efefef;border:1px solid #ccc;height:30px"></div>
                </div>
                
 <!-- ***************************************************************** --> 
                <div class="tab_css" id="tab4_content">
                    <form action="#" method="post" id="fm4">
                        <div class="search">
                            <div>
                                <label>申请单号：</label>
                                <input type="text" name="id" id="tab41"/>
                            </div>
                            <div>
                                <label>学生姓名：</label>
                                <input type="text" name="stuname" id="tab42"/>
                            </div>
                            <div>
                                <label>处理状态：</label>
                                <select name="isdeal" id="tab43">
                                    <option value="">请选择状态</option>
                                    <option value="1">未处理</option>
                                    <option value="0">已处理</option>
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>申请人：</label>
                                <input type="text" name="applyer" id="tab44"/>
                            </div>
                            <div>
                                <label>年级：</label>
                                <select name="gra" id="g4" onchange="queryClazz(4,this.options[this.selectedIndex].value)">
                                    <option value="">请选择年级</option>
                            <c:forEach items="${grades }" var="grade">
                                    <option value="${grade.id }">${grade.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="search">
                            <div>
                                <label>支付时间：</label>
                                <input class="Wdate" name="applytime" id="tab45" type="text" onClick="WdatePicker()">
                            </div>
                            <div>
                                <label>班级：</label>
                                <select  name="cla" id="c4">
                                    <option value="">请选择班级</option>
                                </select>
                            </div>
                        </div>
                        <div class="btn">
                            <button class="lookup" type="button" onclick="ck(4)" value="查找">查找</button>
                            <input type="reset" class="clean" value="清除" />
                        </div>
                        <div class="clear"></div>
                    </form>
                    <div class="content">
                        <table>
                            <thead>
                            <tr>
                                <th class="num"></th>
                                <th class="knum">申请单号</th>
                                <th class="sname">学生姓名</th>
                                <th class="kgrade">年级</th>
                                <th class="kclass">班级</th>
                                <th class="applicant">申请人</th>
                                <th class="time">申请时间
                                    <button type="button"><img src="${pageContext.request.contextPath }/images/order.jpg"></button>
                                </th>
                                <th class="deal">是否处理</th>
                                <th class="do">操作</th>
                            </tr>
                            </thead>
                            <tbody class="con_tbody" id="tb4">
                            <tr>
                                <td class="num">1</td>
                                <td class="knum" title=""></td>
                                <td class="sname" title=""></td>
                                <td class="kgrade" title=""></td>
                                <td class="kclass" title=""></td>
                                <td class="applicant" title=""></td>
                                <td class="time" title=""></td>
                                <td class="deal" title=""><input type="checkbox" /></td>
                     
                                <td class="do">
                                    <a href="javascript:void(0)" onclick="fill()" class="fill_card">补卡</a>
                                    <a href="#" class="del">删除</a>
                                </td>
                            </tr>
                          
                            </tbody>
                        </table>
               <%--          <div class="bar">
                            <div class="barcon">
                                <select>
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
                                <p>共10条记录</p>
                            </div>
                        </div> --%>
                        <!--<div class="choice">请先选择学校！</div>-->
                    </div>
                        <div align="right" id="pp4" style="background:#efefef;border:1px solid #ccc;height:30px"></div>
                </div>
            </div>
        </article>
    </div>
</main>
<!--新增-->
<div class="cardadd  esayui-window" id="padd">
    <h2>卡号录入</h2>
    <div class="card_con">
    <form action="${pageContext.request.contextPath }/card/addBefore.do" method="post" id="fam">
        <p>
            <input type="radio" class="b" checked="checked" name="card" id="one"/>
            <label>单卡录入：</label>
            <input type="text" name="cardNo" id="cs"/>
            <span id="span1" style="color:red"></span>
        </p>
        <div class="card_input">
            <p>
                <input type="radio" class="b" name="card" id="many"/>
                <label>批量录入：</label>
                <input type="text" class="c" disabled="disabled" name="cardNo1" id="c1s"/>
                <span id="span2" style="color:red"></span>
            </p>
            <div>
                <label>至：</label>
                <input type="text" class="c" disabled="disabled" name="cardNo2" id="c2s"/>
                 <span id="span3" style="color:red"></span>
            </div>
            <div>
                <label>卡片数量：</label>
                <span id="num">0</span>
            </div>
        </div>
        </form>
    </div>
    <script type="text/javascript">
    $(function(){
    	$(".b").change(function(){
    		$("#span1").text("");
    		$("#span2").text("");
    		$("#span3").text("");
    	});
    		
    	
    	
    	$("#cs").focus(function(){
    		 $("#span1").text("");
    	});
    	$("#c1s").focus(function(){
    		 $("#span2").text("");
    	});
    	$("#c2s").focus(function(){
    		 $("#span3").text("");
    	});
    	
	    $("#one").click(function(){
	    var sle = $("#one").is(':checked');
	    	if(sle){
	    		$("#c1s").attr("disabled",true);
	    		$("#c2s").attr("disabled",true);
	    		$("#cs").removeAttr("disabled");
	    	}
	    });
	    $("#many").click(function(){
	    var sle = $("#many").is(':checked');
	    	if(sle){
	    		$("#cs").attr("disabled",true);
	    		$("#c1s").removeAttr("disabled");
	    		$("#c2s").removeAttr("disabled");
	    	}
	    });
	    

	    $(".c").keyup(function(event){ 
	    	var v1=$("#c1s").val();
	    	var v2=$("#c2s").val();
	    	var v=v2-v1
	    	if(v>0){
	    		$("#num").text(v+1);
	    	}else{
	    		$("#num").text(0);
	    	}
	    }); 
    });
    
    function adddclose(){
    	$("#cs").val("");
    	$("#c1s").val("");
    	$("#c2s").val("");
    	$("#one").attr('checked','checked');
    	$("#cs").removeAttr("disabled");
    	$("#c1s").attr("disabled",true);
		$("#c2s").attr("disabled",true);
    	$("#padd").window("close");
    }
    function subm(){
    	 var sle = $("#one").is(':checked');
    	 if(sle){
    		 var text=$("#cs").val();
    		 text=text.trim();
    		 if(text==""){
    			 $("#span1").text("请输入卡号！");
    		 }else{
    			 $("#span1").text("");
    			 $("#fam").submit();
    		 }
    	 }else{
    		 var text1=$("#c1s").val();
    		 var text2=$("#c2s").val();
    		 text1=text1.trim();
    		 text2=text2.trim();
    		 if(text1==""){
    			 $("#span2").text("请输入卡号！");
    		 }
    		 if(text2==""){
    			 $("#span3").text("请输入卡号！");
    		 }
    		 if(text1!="" && text2!=""){
    			 $("#span2").text("");
    			 $("#span3").text("");
    			 var nums=$("#num").text();
    			 if(nums!=0){
    				 $("#fam").submit();
    			 }else{
    				 alert("请输入正确的起始卡号！")
    			 }
    		 }
    	 }
    	
    }
    
    </script>
    <div class="btn">
        <button type="submit" onclick="subm()" class="save">保存</button>
        <button class="close" onclick="adddclose()" type="button">关闭</button>
    </div>
</div>
<!--开卡-->
<div class="card_add esayui-window" id="add">
    <h2>开卡</h2>
    <form id="cardform" action="${pageContext.request.contextPath }/card/add.do" method="post">
        <input type="hidden" name="sid" id="hid"/>
        <div>
            <label>卡片数量：</label>
            <input type="text" disabled="disabled" class="card_num" id="cardnum" />
        </div>
        <div>
            <label>卡片1编号：</label>
            <input type="text" id="new11" name="nec"/>
            <p id="cew1" style="color:red"></p>
        </div>
        <div>
            <label>卡片2编号：</label>
            <input type="text" id="new22" name="nec"/>
            <p id="cew2" style="color:red"></p>
        </div>
        <div>
            <label>卡片3编号：</label>
            <input type="text" id="new33" name="nec"/>
            <p id="cew3" style="color:red"></p>
        </div>
        <div>
            <label>卡片4编号：</label>
            <input type="text" id="new44" name="nec"/>
            <p id="cew4" style="color:red"></p>
        </div>
    </form>
    <div class="btn">
        <button type="button" class="save" id="newcard">开卡</button>
       <button class="close" type="button" id="clo1">关闭</button>
    </div>
</div>
<!--退卡-->
<div class="card_del esayui-window" id="del">
    <h2>退卡</h2>
    <form action="${pageContext.request.contextPath }/card/back.do" id="bfm" method="post">
    <input type="hidden" id="apid" name="apid"/>
        <div>
            <label>卡片数量：</label>
            <input type="text" disabled="disabled" class="card_num" name="bnum" id="bnum"/>
        </div>
        <div>
            <label>卡片1编号：</label>
            <input type="text" name="card1" id="bc1"/>
        </div>
        <div>
            <label>卡片2编号：</label>
            <input type="text" name="card2" id="bc2"/>
        </div>
        <div>
            <label>卡片3编号：</label>
            <input type="text" name="card3" id="bc3"/>
        </div>
        <div>
            <label>卡片4编号：</label>
            <input type="text" name="card4" id="bc4"/>
        </div>
    </form>
    <div class="btn">
        <button type="submit" class="save" id="backcard" onclick="backcard()">退卡</button>
       <button class="close" type="button" id="clo2">关闭</button>
    </div>
</div>
<!--补卡-->
<div class="card_fill esayui-window" id="fill">
    <h2>补卡</h2>
    <form action="${pageContext.request.contextPath }/card/changeCards.do" id="ccform" method="post">
    	<input type="hidden" name="applyid" id="applyid"/>
    	<input type="hidden" name="cad1" id="cad1"/>
    	<input type="hidden" name="cad2" id="cad2"/>
    	<input type="hidden" name="cad3" id="cad3"/>
    	<input type="hidden" name="cad4" id="cad4"/>
        <div id="df">
            <label>卡片数量：</label>
            <input type="text" disabled="disabled" class="card_num" id="fnum"/>
        </div>
        <div id="con" style="height:220px;">
       
        </div>     
          <%--  <div>
            <label>卡片1编号：</label>
            <input type="text" disabled="disabled" id="c1"/>
        </div>
        <div>
            <label>卡片2编号：</label>
            <input type="text" disabled="disabled" class="change_card" id="c2" />
            <a href="javascript:void(0)" onclick="openchange('c2')" class="change"><img src="${pageContext.request.contextPath }/images/card3.png" /></a>
        </div>
        <div>
            <label>卡片3编号：</label>
            <input type="text" disabled="disabled" id="c3"/>
        </div>
        <div>
            <label>卡片4编号：</label>
            <input type="text" disabled="disabled" class="card_change" id="c4"/>
            <a href="javascript:void(0)" onclick="openchange('c4')" class="change"><img src="${pageContext.request.contextPath }/images/card3.png" /></a>
        </div> --%>
    </form>
    <div class="btn">
        <button type="submit" class="save" id="bcard" onclick="changes()">补卡</button>
        <button class="close" type="button" id="clo3">关闭</button>
    </div>
</div>


<!--更换卡片-->
<!-- <div class="card_change esayui-window" id="change">
    <h2>更换卡片</h2> 
     <form  method="post">
	        <div>
	            <label>原卡编号：</label>
	            <input type="text" id="old" disabled="disabled"/>
	        </div>
	        <div>
	            <label>新片编号：</label>
	            <input type="text" id="new"/>
	            <p></p>
	        </div>
	 </form>
	    <div class="btn">
	    <button type="button" class="save" onclick="ch()" >保存</button>
	    <button class="close" type="button" id="clo4" >关闭</button>  
	    </div>
</div> -->

<script type="text/javascript">
function pages( no,tatols ,type){
	var name=$("#school").val();
	   $('#pp'+no).pagination({
           total:tatols,
           pageList: [8,10,15],
        onSelectPage:function(currentPage, pageSize){
       		
       		var url="/wxy-back/card/listByType.do";
        		var id=$("#tab"+no+"1").val();
        		var stuname = $("#tab"+no+"2").val();
        		var isdeal = $("#tab"+no+"3").val();
        		var applyer = $("#tab"+no+"4").val();
        		var applytime = $("#tab"+no+"5").val();
        		var grade = $("#g"+no).val();
        		var clazz = $("#c"+no).val();
        		$.post(url,{
        			"schoolname":name,
        			"type":type,
        			"id":id,
        			"stuname":stuname,
        			"isdeal":isdeal,
        			"applyer":applyer,
        			"applytime":applytime,
        			"grade":grade,
        			"clazz":clazz,
        			"currentPage":currentPage,
        			"pageSize":pageSize},function(data){
        				//alert(1111111111111);
        			   	var ob = eval('(' + data + ')');
        			   total2 = ob.total;
          			    var obj =ob.rows;
        		    	//alert(obj);
                        //清空除第一行意外的所有行  
        				$("#tb2").html("");
           			if(obj!=null){
           				for(var i=0;i<obj.length;i++){ 
           				var nnum=obj[i].num;
           					var dd=obj[i].id;
           					var ok=obj[i].isdeal;
		           				var tr2;
		           				var tr3;
           					 var tr1="<tr><td class='num'>"+(i+1)+"</td><td class='knum' title='"+dd+"'>"+obj[i].id+"</td>"
		           				 +"<td class='sname' title='"+obj[i].student.name+"'>"+obj[i].student.name+"</td>"
		           				 +"<td class='kgrade' title='"+obj[i].gradeName+"'>"+obj[i].gradeName+"</td>"
		           				 +"<td class='kclass' title='"+obj[i].className+"'>"+obj[i].className+"</td>"
		           				 +"<td class='applicant' title='"+obj[i].applyer+"'>"+obj[i].applyer+"</td>"
		           				 +"<td class='time' title='"+obj[i].applytime+"'>"+obj[i].applytime+"</td>"
		           				 if(ok==1){
		           					tr2="<td class='deal' title=''><input  type='checkbox' checked='checked' /></td>"
		           				 }else{
		           					tr2="<td class='deal' title=''><input  type='checkbox'/></td>"
		           				 }
		           					tr3="<td class='do'><a href='javascript:void(0)' onclick='add("+dd+','+ok+','+nnum+")' class='add_card'>开卡</a>"
		           				 +"<a href='#' class='del'>删除</a></td></tr>";
		           			 $("#tb2").append(tr1+tr2+tr3);	
           				}
		           	
           			}
        		});
        	}
        });
}
function del(cid){
	$.messager.confirm('确认','您确认想要删除编号为'+ cid +'的卡片吗？',function(flag){       
	if(flag){
		location.href="${pageContext.request.contextPath }/card/deleteById.do?id="+cid;
	}
	});  


}
	function queryClazz(id,gid){
 		$("#c"+id).empty();
 		$("#c"+id).append("<option value='' >请选择班级</option>");
		if(gid!=""){
			$.ajax({
 			   type: "post",
 			   url: "${pageContext.request.contextPath }/card/listClazzByGid.do",
 			   dataType:"json",
 			   data: "gid="+gid,
 			   success: function(data){
		 			 var i=data.length;
					for(var j=1;j<=i;j++){
						 $("#c"+id).append("<option value='"+data[j-1].id+"' >"+data[j-1].name+"</option>");
					}
 			   }
 			});
		}
	}
    var myclick = function(v) {
    	var shname=$("#school").val();
        var llis = document.getElementsByClassName("tab");
        for(var i = 0; i < llis.length; i++) {
            var lli = llis[i];
            if(lli == document.getElementById("tab" + v)) {
                lli.style.backgroundColor = "#fff";

            } else {
                lli.style.backgroundColor = "#e4e4e4";
            }
        }

        var divs = document.getElementsByClassName("tab_css");
        for(var i = 0; i < divs.length; i++) {

            var divv = divs[i];

            if(divv == document.getElementById("tab" + v + "_content")) {
                divv.style.display = "block";
       //*********开卡**************         
				if(2==v){
					
            		$.post("${pageContext.request.contextPath}/card/listByType.do",{"type":v,"schoolname":shname},function(data){
            			var ob = eval('('+ data +')');
            			var total = ob.total;
            			var obj =ob.rows;
            			$("#tb2").html("");
            			if(obj!=null){
            				for(var i=0;i<obj.length;i++){ 
            				var nnum=obj[i].num;
            					var dd=obj[i].id;
            					var ok=obj[i].isdeal;
		           				var tr2;
		           				var tr3;
            					 var tr1="<tr><td class='num'>"+(i+1)+"</td><td class='knum' title='"+dd+"'>"+obj[i].id+"</td>"
		           				 +"<td class='sname' title='"+obj[i].student.name+"'>"+obj[i].student.name+"</td>"
		           				 +"<td class='kgrade' title='"+obj[i].gradeName+"'>"+obj[i].gradeName+"</td>"
		           				 +"<td class='kclass' title='"+obj[i].className+"'>"+obj[i].className+"</td>"
		           				 +"<td class='applicant' title='"+obj[i].applyer+"'>"+obj[i].applyer+"</td>"
		           				 +"<td class='time' title='"+obj[i].applytime+"'>"+obj[i].applytime+"</td>"
		           				 if(ok==1){
		           					tr2="<td class='deal' title=''><input  type='checkbox' checked='checked' /></td>"
		           				 }else{
		           					tr2="<td class='deal' title=''><input  type='checkbox'/></td>"
		           				 }
		           					tr3="<td class='do'><a href='javascript:void(0)' onclick='add("+dd+','+ok+','+nnum+")' class='add_card'>开卡</a>"
		           				 +"<a href='#' class='del'>删除</a></td></tr>";
		           			 $("#tb2").append(tr1+tr2+tr3);	
            				}
		           	
            			}
            		pages(2,total,2);
            		});
                 
				}
	//*********开卡************** 
				if(3==v){					
            		$.post("${pageContext.request.contextPath}/card/listByType.do",{"type":v,"schoolname":shname},function(data){
            			var ob = eval('('+ data +')');
            			var total = ob.total;
            			var obj =ob.rows;
            			$("#tb3").html("");
            			if(obj!=null){
            				for(var i=0;i<obj.length;i++){
             				    var nnum=obj[i].num;
            					var dd=obj[i].id;
            					var ok=obj[i].isdeal;
		           				var tr2;
		           				var tr3;
            					 var tr1="<tr><td class='num'>"+(i+1)+"</td><td class='knum' title='"+dd+"'>"+obj[i].id+"</td>"
		           				 +"<td class='sname' title='"+obj[i].student.name+"'>"+obj[i].student.name+"</td>"
		           				 +"<td class='kgrade' title='"+obj[i].gradeName+"'>"+obj[i].gradeName+"</td>"
		           				 +"<td class='kclass' title='"+obj[i].className+"'>"+obj[i].className+"</td>"
		           				 +"<td class='applicant' title='"+obj[i].applyer+"'>"+obj[i].applyer+"</td>"
		           				 +"<td class='time' title='"+obj[i].applytime+"'>"+obj[i].applytime+"</td>"
		           				 if(ok==1){
		           					tr2="<td class='deal' title=''><input  type='checkbox' checked='checked' /></td>"
		           				 }else{
		           					tr2="<td class='deal' title=''><input  type='checkbox'/></td>"
		           				 }
		           					tr3="<td class='do'><a href='javascript:void(0)' onclick='back("+dd+','+ok+")' class='del_card'>退卡</a>"
		           				 +"<a href='#' class='del'>删除</a></td></tr>";
		           			 $("#tb3").append(tr1+tr2+tr3);	
            				}
		           	
            			}
            			pages(3,total,3);
            		});
				}
	//补卡
				if(4==v){					
            		$.post("${pageContext.request.contextPath}/card/listByType.do",{"type":v,"schoolname":shname},function(data){
            			var ob = eval('('+ data +')');
            			var total = ob.total;
            			var obj =ob.rows;
            			$("#tb4").html("");
            			if(obj!=null){
            				for(var i=0;i<obj.length;i++){
            					var nnum=obj[i].num;
            					var dd=obj[i].id;
            					var ok=obj[i].isdeal;
		           				var tr2;
		           				var tr3;
            					 var tr1="<tr><td class='num'>"+(i+1)+"</td><td class='knum' title='"+dd+"'>"+obj[i].id+"</td>"
		           				 +"<td class='sname' title='"+obj[i].student.name+"'>"+obj[i].student.name+"</td>"
		           				 +"<td class='kgrade' title='"+obj[i].gradeName+"'>"+obj[i].gradeName+"</td>"
		           				 +"<td class='kclass' title='"+obj[i].className+"'>"+obj[i].className+"</td>"
		           				 +"<td class='applicant' title='"+obj[i].applyer+"'>"+obj[i].applyer+"</td>"
		           				 +"<td class='time' title='"+obj[i].applytime+"'>"+obj[i].applytime+"</td>"
		           				 if(ok==1){
		           					tr2="<td class='deal' title=''><input  type='checkbox' checked='checked' /></td>"
		           				 }else{
		           					tr2="<td class='deal' title=''><input  type='checkbox'/></td>"
		           				 }
		           					tr3="<td class='do'><a href='javascript:void(0)' onclick='fill("+dd+','+ok+")' class='fill_card'>补卡</a>"
		           				 +"<a href='#' class='del'>删除</a></td></tr>";
		           			 $("#tb4").append(tr1+tr2+tr3);	
            				}
            				
            			}
            			pages(4,total,4);
            		});
				}
		
            } else {

                divv.style.display = "none";
            }
        }

    }
</script>
</body>
</html>