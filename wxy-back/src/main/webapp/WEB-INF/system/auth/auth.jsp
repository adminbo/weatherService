<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>权限管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/quan.js"></script>
<style type="text/css">
.ztree li{line-height:40px; }	
</style>
<!-- 导入ztree类库 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css" />
<script src="${pageContext.request.contextPath }/js/jquery.ztree.core.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.ztree.excheck.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.ztree.exedit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/role.js" type="text/javascript"></script>


<script type="text/javascript">
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
var tree;
var newCount = 1;
	// 初始化ztree菜单
	$(function() {
		var setting1 = {
			data : {
				simpleData : { // 简单数据 
					enable : true
				},
		key: {
			keyWord: "keyWord"
		}
			},
			//视图
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false,
				showLine: false	//是否显示连线		
			},
			//编辑
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			//回掉函数
			callback : {
				//onAsyncSuccess: zTreeOnAsyncSuccess
				beforeClick: zTreeBeforeClick,//点击前
				onClick : onClick,//点击
				beforeEditName: beforeEditName,//编辑前
				beforeRemove: beforeRemove,//删除前
				beforeRename: beforeRename,//修改前
				
				onRemove: onRemove,//删除后
				onRename: onRename//修改后
			}
		};
		var setting2 = {
			check: {
				enable: true,
				chkStyle: "checkbox",
				chkboxType: { "Y": "p", "N": "s" }
			},
			data : {
				simpleData : { // 简单数据 
					enable : true
				},
				key: {
					keyWord: "keyWord"
				}
			},
			//视图
			view: {
				selectedMulti: false,								
			},
			//编辑
			edit: {
				//enable: true,
			},
			//回掉函数
			callback : {
				//onAsyncSuccess: zTreeOnAsyncSuccess	
				//beforeClick: beforeClick,//点击前
				onCheck: zTreeOnCheck,//勾选
				beforeCheck: zTreeBeforeCheck//勾选前
			}
		};
		// 角色菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/system/findRole.do',
			type : 'POST',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				tree=$.fn.zTree.init($("#treeMenu"), setting1, zNodes);
				$("ul span").attr("style","font-size:14px;");
				
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		// 权限菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/system/findAuth.do',
			type : 'POST',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				tree=$.fn.zTree.init($("#AuthMenu"), setting2, zNodes);
				$("ul span").attr("style","font-size:15px;");
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		//操作权限
		$.ajax({
			url : '${pageContext.request.contextPath}/system/findAuthForOper.do',
			type : 'POST',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				tree=$.fn.zTree.init($("#AuthMenu2"), setting2, zNodes);
				$("ul span").attr("style","font-size:15px;");
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});

	});
	//点击前
	function zTreeBeforeClick(treeId, treeNode, clickFlag){
		//没有权限-不能给管理员分配权限
		if(treeNode.isParent && treeNode.name=="学校管理员"){
			//alert(treeNode.name);
			return false;
		}		
	}
	//取消节点选中状态 
	function onClick(event, treeId, treeNode) {
		//如果选择了角色，保存按钮可用
		$("#but111").removeAttr("disabled");
		$("#but222").removeAttr("disabled");
		//获取权限树
		var obj1 = $.fn.zTree.getZTreeObj("AuthMenu");
		var obj2 = $.fn.zTree.getZTreeObj("AuthMenu2");
		//获取权限树被选中节点
		var nodes1=obj1.getCheckedNodes(true);
		var nodes2=obj2.getCheckedNodes(true);
		//清空
		obj1.checkAllNodes(false);
		obj2.checkAllNodes(false);
		//根据角色名称异步查询权限集
		$.post(
				'${pageContext.request.contextPath}/system/findAuthByName.do',
				{'name':treeNode.name},
				function(date){
					var obj = eval('(' + date + ')');
					for(var i=0;i<obj.length;i++){
						//过滤权限树
						var node11 = obj1.getNodesByFilter(function(node){return (node.keyWord==obj[i].keyWord)},true); // 查找节点集合	
						var node22 = obj2.getNodesByFilter(function(node){return (node.keyWord==obj[i].keyWord)},true); // 查找节点集合	
						//选中已有权限
							obj1.checkNode(node11, true, true);												
							obj2.checkNode(node22, true, true);					
					}
		});
	}
	
	//鼠标移到上
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0)
			return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='添加角色' onfocus='this.blur();'></span>";
			if(treeNode.tId=="treeMenu_1" && treeNode.name=="学校管理员" ){//
					sObj.after(addStr);
			}
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			 rolename =prompt("请输入新添角色名称，不要重名！")
			 //alert(rolename);
			 var url ="/wxy-back/system/findRoleByName.do";
			   $.post(url,{"name":rolename},function(date){
				   //如果存在，提示
			    	if(1==date){
			    		alert("角色名称已存在，请重新添加！");
			    	}
				   //不存在就添加
			    	if(0==date){			    		
			location.href="addRole.do?name="+rolename;
			    	}
			    	
			    });
			return false;
		});
	};
	//鼠标移开
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	//是否显示删除
	function showRemoveBtn(treeId, treeNode) {
		var flag =treeNode.isParent
		var node =treeNode.getParentNode();
	//	alert(node);
	//有父级节点，才显示删除
		if(node!=null){
			if(!flag && treeNode.name != "学校管理员"){
				return true;
			}				
		}
		return false;
	}
	//是否显示修改按钮
	function showRenameBtn(treeId, treeNode) {
		var flag =treeNode.isParent
		var node =treeNode.getParentNode();
		//有父级节点，才显示修改
		if(node!=null){
			if(!flag && treeNode.name != "学校管理员"){
				return true;
			}
		}
		return false;
	}
	var prename;
	//是否编辑
	function beforeEditName(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeMenu");
		zTree.selectNode(treeNode);
		setTimeout(function() {
			if (confirm("要进入角色-- " + treeNode.name + "-- 的编辑状态吗？")) {
				setTimeout(function() {
					zTree.editName(treeNode);
				}, 0);
			}
		}, 0);
		return false;
	}
	//是否删除
	function beforeRemove(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeMenu");
		zTree.selectNode(treeNode);
		return confirm("确认删除角色 --" + treeNode.name + "-- 吗？");
	}
	//是否修改名称
	function beforeRename(treeId, treeNode, newName, isCancel) {
		if (newName.length == 0) {
			setTimeout(function() {
				var zTree = $.fn.zTree.getZTreeObj("treeMenu");
				zTree.cancelEditName();
				alert("角色名称不能为空！");
			}, 0);
			return false;
		}
		prename=treeNode.name;
		return true;
	}
	//删除后回调
	function onRemove(e, treeId, treeNode) {
		//alert(treeNode.name );
		location.href="deleteRole.do?name="+treeNode.name; 
		}
	//改名后回调
	function onRename(e, treeId, treeNode, isCancel) {
		//alert(prename)
		//alert(treeNode.name );
		location.href="updateRole.do?prename="+prename+"&name="+treeNode.name;
	}
	//选中复选框回调
	function zTreeOnCheck(e, treeId, treeNode) {
		//alert(prename)
		//alert(treeNode.name );
		
	}
	//选中复选框之前回调
	function zTreeBeforeCheck(e, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("treeMenu");
		var nodes = treeObj.getSelectedNodes();
		var node=nodes[0];
		if(nodes.length==0){
			alert("请至少选择一个角色分配权限！");
			return false;
		}

		return true;
	}
	
	//模块权限保存按钮
	function saveauth1(){
		//获取权限树
		var obj1 = $.fn.zTree.getZTreeObj("AuthMenu");		
		var obj = $.fn.zTree.getZTreeObj("treeMenu");
		//获取权限树被选中节点
		var nodes1=obj1.getCheckedNodes(true);
		//角色树被选中节点
		var role = obj.getSelectedNodes();
		var arr = [];
		for(var i=0;i<nodes1.length;i++){
			//alert(nodes1[i].keyWord);
			arr.push(nodes1[i].keyWord);
		}
		location.href="updateOrAddAuth.do?auths="+arr+"&rolename="+role[0].name;
	}
	//操作权限保存按钮
	function saveauth2(){
		//获取树对像
		var obj2 = $.fn.zTree.getZTreeObj("AuthMenu2");
		var obj = $.fn.zTree.getZTreeObj("treeMenu");
		//权限树被选中的节点
		var nodes2=obj2.getCheckedNodes(true);
		//角色树被选中节点
		var role = obj.getSelectedNodes();
		
		//获取权限树被选中节点
		var nodes2=obj2.getCheckedNodes(true);
		var arr = [];
		for(var i=0;i<nodes2.length;i++){
			//alert(nodes1[i].keyWord);
			arr.push(nodes2[i].keyWord);
		}
		location.href="updateOrAddAuth.do?auths="+arr+"&rolename="+role[0].name;
	}
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
         <!--    <li><a href="#" class="help">帮助中心</a></li> -->
        </ul>
    </aside>

    <div class="detail">
        <article class="power">
            <section class="top">
                <a href="#" target="leftFrame">首页 ></a>
                <a href="#" target="leftFrame">系统管理 ></a>
                <a href="#" target="leftFrame">权限管理</a>
            </section>
            <section class="powercon">
                <div class="pleft">
                    <h2>角色列表</h2>
                    <ul id="treeMenu" class="ztree" ></ul>
                    
                </div>
                <div class="pright">
                    <h2>
                        <div id="tab_bar">
                            <ul>
                                <li id="tab1" class="tab" onclick="myclick(1)" style="background-color: #fff">
                                    模块权限
                                </li>
                                <li id="tab2" class="tab" onclick="myclick(2)">
                                    操作权限
                                </li>
                            </ul>
                        </div>
                        <div class="tab_css" id="tab1_content" style="display: block">                                 
       <ul id="AuthMenu" class="ztree" ></ul>  
       <input onclick="saveauth1()" id="but111" type="button" disabled="disabled" value="分配权限"/>        
                        </div>
                        <div class="tab_css"  id="tab2_content">                          
       <ul id="AuthMenu2" class="ztree" ></ul>                                                        
       <input onclick="saveauth2()" id="but222" type="button" disabled="disabled" value="分配权限"/>        
                        </div>
                    </h2>
                </div>
                <div class="clear"></div>
            </section>
        </article>
    </div>
</main>
<script type="text/javascript">
    var myclick = function(v) {
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
            } else {
                divv.style.display = "none";
            }
        }

    }
</script>
</body>
</html>