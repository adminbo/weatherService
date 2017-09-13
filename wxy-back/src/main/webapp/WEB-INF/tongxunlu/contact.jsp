<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>通讯录</title>
    <script src="${pageContext.request.contextPath }/js/checksdetail.js"></script>
    <script src="${pageContext.request.contextPath }/js/address.js"></script>
    <script type='text/javascript'>
$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
	$("#import").upload({  
	    action: '${pageContext.request.contextPath}/studentParent/import.do',  
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
});
</script>
</head>
<body>

<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/getAlljiazhangxietong.do" class="pick" target="leftFrame">学生接送</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllTongxunlu.do" class="contact" target="leftFrame">通讯录</a></li>
        </ul>
    </div>

    <div class="detail">
        <article class="contact_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/getAlljiazhangxietong.do" target="leftFrame">家长协同 ></a>
                <a href="${pageContext.request.contextPath }/getAllTongxunlu" target="leftFrame">通讯录</a>
            </section>
           <!--  <div class="info_top">
                <label>学校名称：</label>
                <span>
                    <select onchange="this.parentNode.nextSibling.value=this.value">
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </span><input type="text" />
                <span></span>
            </div> -->
            <form action="#" method="post">
                <div class="search">
                    <div>
                        <label>学生姓名：</label>
                        <input type="text" />
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>家长姓名：</label>
                        <input type="text" />
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <input type="reset" class="clean" value="清除" />
                </div>
                <div class="clear"></div>
            </form>
            <div id="tab_bar">
                <ul>
                    <li id="tab1" class="tab" onclick="myclick(1)" style="background-color: #fff">
                        <span>全年级</span>
                    </li>
                    <li id="tab2" class="tab" onclick="myclick(2)">
                        一班
                    </li>
                    <li id="tab3" class="tab" onclick="myclick(3)">
                        二班
                    </li>
                </ul>
            </div>
            <div class="tab_con">
                <div class="tab_css" id="tab1_content" style="display: block">
                    <section class="s_add">
                        <a href="${pageContext.request.contextPath }/toaddjiazhangxietong.do" class="add">新增</a>
                       <!--  <a href="javascript:void(0)" onclick="add()" class="import">导入</a> -->
                        <p id="import" class="import">导入</p>
                    </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="cname">学生姓名</th>
                        <th class="pname">家长姓名</th>
                        <th class="relation">关系</th>
                        <th class="phone">家长手机</th>
                        <th class="attention">关注</th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                    <tr>
                        <td class="num">1</td>
                        <td class="cname" title="">王小帅</td>
                        <td class="pname" title="">王丽娜</td>
                        <td class="relation" title="">母子</td>
                        <td class="phone" title="">1345556332</td>
                        <td class="attention" title=""><input type="checkbox" />关注成功</td>
                        <td class="do">
                            <a href="${pageContext.request.contextPath }/toshowjiazhangxietong.do" class="look">查看</a>
                            <a href="${pageContext.request.contextPath }/toeditjiazhangxietong.do" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                   
                    </tbody>
                </table>
                <div class="bar">
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
                </div>
                <!--<div class="choice">请先选择学校！</div>-->
            </section>
                </div>
                
         
            </div>
        </article>
    </div>
</main>
<div class="easyui-window import_con" id="import_con">
    <h2>导入</h2>
    <div class="mould">
        <label>从模板导入：</label>
        <div class="upload">
            <input type="text" class="text" disabled="disabled" />
            <span>浏览...<input type="file" class="file" /></span>
            <div class="clear"></div>
        </div>
        <a href="#">模板下载</a>
        <div class="clear"></div>
    </div>
    <div class="btn">
        <button type="submit" class="save">保存</button>
        <a href="${pageContext.request.contextPath }/getAllTongxunlu.do"><button class="close" type="button">关闭</button></a>
    </div>
</div>

<script type="text/javascript">
	function add(){
		 $("#import_con").window("open");
	}
	
	
	$(function(){
	    $("#import_con").window({
	        title:'导入信息',
	        width:450,
	        modal:true,
	        shadow:true,
	        closed:true,
	        height:270,
	        resizable:false
	    });
	});
</script>

</body>
</html>