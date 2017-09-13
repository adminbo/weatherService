<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>保险信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script>
    function look() {
	    $("#slook").window("open");
	}
    $(function(){
	    $("#slook").window({
        title:'信息查看',
        width:600,
        modal:true,
        shadow:true,
        minimizable:false,
        closed:true,
        height:450,
        resizable:false
       });
    })
        $(function(){
            $(".link > a").click(function(){
                $(this).next().slideToggle(200,function(){
                    //TODO
                });
            });
        });
    
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
	function clo(){
		$("#import_con").window("close");
	}
	function down(){
		location.href="/wxy-back/downLoad.do";
	}
    </script>
</head>
<body>
<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/safe/toSafe.do" class="insurance" target="leftFrame">保险信息</a></li>
            <li><a href="${pageContext.request.contextPath }/safe/toSafeList.do" class="statistics" target="leftFrame">保险统计</a></li>
        </ul>
    </div>
    <div class="detail">
        <article class="ins_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/safe/toSafe.do" target="leftFrame">保险管理 ></a>
                <a href="${pageContext.request.contextPath }/safe/toSafe.do" target="leftFrame">保险信息</a>
            </section>
            <!-- <div class="info_top">
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
                        <label>投保年份：</label>
                        <select>
                            <option value="请选择年份">请选择年份</option>
                            <option value=""></option>
                        </select>
                    </div>
                    <div>
                        <label>学生姓名：</label>
                        <input type="text" />
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>投保学期：</label>
                        <select>
                            <option value="请选择学期">请选择学期</option>
                            <option value="第一学期">第一学期</option>
                            <option value="第二学期">第二学期</option>
                        </select>
                    </div>
                    <div>
                        <label>年级：</label>
                        <select>
                            <option value="请选择年级">请选择年级</option>
                            <option value="一年级">一年级</option>
                            <option value="二年级">二年级</option>
                            <option value="三年级">三年级</option>
                            <option value="四年级">四年级</option>
                            <option value="五年级">五年级</option>
                            <option value="六年级">六年级</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>投保人：</label>
                        <input type="text" />
                    </div>
                    <div>
                        <label>班级：</label>
                        <select>
                            <option value="请选择班级">请选择班级</option>
                            <option value="一班">一班</option>
                            <option value="二班">二班</option>
                            <option value="三班">三班</option>
                        </select>
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <input type="reset" class="clean" value="清空" />
                </div>
                <div class="clear"></div>
            </form>
            <div class="s_add">
            <a href="javascript:void(0)" onclick="add()" class="export">导入</a>
            </div>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num">编号</th>
                        <th class="sname">学生姓名</th>
                        <th class="ins_grade">年级</th>
                        <th class="ins_class">班级</th>
                        <th class="policy">投保人</th>
                        <th class="phone">投保人手机</th>
                        <th class="btype">保险类型</th>
                        <th class="year">投保年份</th>
                        <th class="term">投保学期</th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                    <tr>
                        <td class="num">1</td>
                        <td class="sname" title="">刘丽</td>
                        <td class="ins_grade" title="">一年级</td>
                        <td class="ins_class" title="">二班</td>
                        <td class="policy" title="">刘华</td>
                        <td class="phone" title="">15462355225</td>
                        <td class="btype" title="">学平险</td>
                        <td class="year" title="">2014-02-01</td>
                        <td class="term" title="">2014第一学期</td>
                        <td class="do">
                            <a href="javascript:void(0)" onclick="look()" class="look">查看</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td class="sname" title="">孙丽</td>
                        <td class="ins_grade" title="">一年级</td>
                        <td class="ins_class" title="">二班</td>
                        <td class="policy" title="">孙华</td>
                        <td class="phone" title="">15462355225</td>
                        <td class="btype" title="">学平险</td>
                        <td class="year" title="">2014-02-01</td>
                        <td class="term" title="">2014第一学期</td>
                        <td class="do">
                            <a href="javascript:void(0)" onclick="look()" class="look">查看</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td class="sname" title="">王丽</td>
                        <td class="ins_grade" title="">一年级</td>
                        <td class="ins_class" title="">二班</td>
                        <td class="policy" title="">方华</td>
                        <td class="phone" title="">15462355225</td>
                        <td class="btype" title="">学平险</td>
                        <td class="year" title="">2014-02-01</td>
                        <td class="term" title="">2014第一学期</td>
                        <td class="do">
                            <a href="javascript:void(0)" onclick="look()" class="look">查看</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td class="sname" title="">赵丽</td>
                        <td class="ins_grade" title="">一年级</td>
                        <td class="ins_class" title="">二班</td>
                        <td class="policy" title="">赵华</td>
                        <td class="phone" title="">15462355225</td>
                        <td class="btype" title="">学平险</td>
                        <td class="year" title="">2014-02-01</td>
                        <td class="term" title="">2014第一学期</td>
                        <td class="do">
                            <a  href="javascript:void(0)" onclick="look()" class="look">查看</a>
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
                            <a href="#" class="first"><img src="../images/first.jpg" /></a>
                            <a href="#" class="up"><img src="../images/up.jpg" /></a>
                            <span>第<input value="1"/>页 共1页</span>
                            <a href="#" class="down"><img src="../images/down.jpg" /></a>
                            <a href="#" class="last"><img src="../images/last.jpg" /></a>
                        </div>
                        <a href="#" class="reload"><img src="../images/reload.jpg"></a>
                        <p>共10条记录</p>
                    </div>
                </div>
                <!--<div class="choice">请先选择学校！</div>-->
            </section>
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
        <a href="javascript:void(0)" onclick="down()">模板下载</a>
        <div class="clear"></div>
    </div>
    <div class="btn">
        <button type="submit" class="save">保存</button>
        <button class="close"   onclick="clo()" type="button">关闭</button>
    </div>
</div>
<!--查看-->
<div id="slook" class="easyui-window ins_look">
    <h2>保险信息</h2>
    <form action="#" method="post">
        <div class="search">
            <div>
                <label>姓名：</label>
                <input type="text" value="王小明"/>
            </div>
            <div>
                <label>年级：</label>
                <input type="text" value="一年级" />
            </div>
            <div>
                <label>身份证：</label>
                <input type="text" value="84654641534" />
            </div>
        </div>
        <div class="search">
            <div>
                <label>学号：</label>
                <input type="text" value="2011111"/>
            </div>
            <div>
                <label>班级：</label>
                <input type="text" value="一班" />
            </div>
        </div>
        <div class="clear"></div>
    </form>
    <form action="#" method="post">
        <div class="search">
            <div>
                <label>投保人：</label>
                <input type="text" value="王大明"/>
            </div>
            <div>
                <label>投保人身份证：</label>
                <input type="text" value="125534153453848" />
            </div>
        </div>
        <div class="search">
            <div>
                <label>投保人手机：</label>
                <input type="text" value="132222256325"/>
            </div>
        </div>
        <div class="clear"></div>
    </form>
    <form action="#" method="post">
        <div class="search">
            <div>
                <label>保险类型：</label>
                <input type="text" value="学平险" />
            </div>
            <div>
                <label>投保年份：</label>
                <input type="text" value="2016" />
            </div>
        </div>
        <div class="search">
            <div>
                <label>投保金额：</label>
                <input type="text" value="2000" />
            </div>
            <div>
                <label>投保学期：</label>
                <input type="text" value="第一学期" />
            </div>
        </div>
        <div class="clear"></div>
    </form>
    <form action="#" method="post">
        <div class="search">
            <div>
                <label>缴费凭证号：</label>
                <input type="text" value="1654534" />
            </div>
            <div>
                <label>缴费金额：</label>
                <input type="text" value="100" />
            </div>
        </div>
        <div class="search">
            <div>
                <label>缴费时间：</label>
                <input type="text" value="2017-01-01" />
            </div>
        </div>
        <div class="clear"></div>
    </form>
    <div class="btn">
        <a href="${pageContext.request.contextPath }/safe/toSafe.do"><button class="close" type="button">关闭</button></a>
    </div>
</div>

</body>
</html>