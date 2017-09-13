<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学校管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">


    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath }/js/checksdetail.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/outOfBounds.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type='text/javascript'>
$(function(){
    $(".link > a").click(function(){
        $(this).next().slideToggle(200,function(){
            //TODO
        });
    });
});
</script>

</head>
<body>
<main>
    <aside class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
             <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure" target="leftFrame">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage" target="leftFrame">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage" target="leftFrame">学校信息管理</a></li>
            <li><a href="${pageContext.request.contextPath }/safe/toSafeList.do" class="statistics" target="leftFrame">信息统计</a></li>
            <%-- <li><a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" class="env">校园环境</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllPeitaosheshi.do" class="fac">配套设施</a></li>
            <li><a href="${pageContext.request.contextPath }/teachers/listTeachershow.do" class="teacher">教师风采</a></li>
            <li><a href="${pageContext.request.contextPath }/banxue/banxuelist.do" class="feature">办学特色</a></li>
            <li><a href="${pageContext.request.contextPath }/foodweeks/foodweeklist.do" class="week">每周食谱</a></li>
            <li><a href="${pageContext.request.contextPath }/president.do" class="mailbox">校长信箱</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </aside>
    <div class="detail">
        <article class="sdetail">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a<%--  href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">技服中心 ></a>
                <a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" target="leftFrame">学校信息管理</a>
            </section>
            <form action="#" method="post">
                <div class="search">
                    <div>
                        <label>学校名称：</label>
                        <input type="text" class="text" />
                    </div>
                    <div>
                        <label>服务号名称：</label>
                        <input type="text" class="text" />
                    </div>
                    <div class="belong">
                        <label>所属一级代理商：</label>
                        <select class="sbelong">
                            <option value="请选择代理商">请选择代理商</option>
                            <option value="杭州卓教">杭州卓教</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>学校类型：</label>
                        <select class="type">
                            <option value="请选择分类">请选择分类</option>
                            <option value="幼教">幼教</option>
                            <option value="普教">普教</option>
                        </select>
                    </div>
                    <div>
                        <label>学校地址：</label>
                        <select id="province" name="province">
                            <option value="省份">省份</option>
                        </select>
                        <select name="city" id="city">
                            <option value="地级市">地级市</option>
                        </select>
                        <select name="districtAndCounty" id="districtAndCounty">
                            <option value="市、县级市">市、县级市</option>
                        </select>
                    </div>
                    <div class="belong">
                        <label>所属二级代理商：</label>
                        <select class="sbelong">
                            <option value="请选择代理商">请选择代理商</option>
                            <option value="杭州卓教">杭州卓教</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>办学性质：</label>
                        <select>
                            <option value="请选择分类">请选择分类</option>
                            <option value="公办">公办</option>
                            <option value="民办">民办</option>
                        </select>
                    </div>
                    <div>
                        <label>入驻时间：</label>
                        <input class="Wdate" type="text" onClick="WdatePicker()">
                    </div>
                </div>
                <div class="btn">
                    <button class="lookup" type="submit" value="查找">查找</button>
                    <button class="clean" type="reset" value="清除">清除</button>
                </div>
                <div class="clear"></div>
            </form>
            <section class="s-add">
                <a href="javascript:void(0)" onclick="add()" class="add">新增</a>
                <a href="#" class="import">导入</a>
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num"></th>
                        <th class="sname">学校名称</th>
                        <th class="fname">服务号名称</th>
                        <th class="stype">学校类型</th>
                        <th class="nature">办学性质</th>
                        <th class="sadd">学校地址</th>
                        <!-- <th class="one">一级代理商</th>
                        <th class="two">二级代理商</th> -->
                        <th class="time">入驻时间
                            <button type="button"><img src="../images/order.jpg"></button>
                        </th>
                        <th class="do">操作</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                    <tr>
                        <td class="num">1</td>
                        <td class="sname" title=""></td>
                        <td class="fname" title=""></td>
                        <td class="stype" title=""></td>
                        <td class="nature" title=""></td>
                        <td class="sadd" title=""></td>
                        <!--<td class="one" title=""></td>
                        <td class="two" title=""></td>-->
                        <td class="time" title=""></td>
                        <td class="do">
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>9</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
                            <a href="#" class="del">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>10</td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td title=""></td>
                        <td>
                            <a href="#" class="look">查看</a>
                            <a href="#" class="revise">修改</a>
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
            </section>
        </article>
    </div>
</main>

<div id="conadd" class="easyui-window addcon">
    <h2>学校基本信息</h2>
    <form action="#" method="post">
        <div>
            <label><span>*</span>学校名称：</label>
            <input id="school_name" type="text" class="text" />
            <span id="school_name_input"></span>
        </div>
        <div>
            <label><span>*</span>企业号名称：</label>
            <select id="qiye_name">
                <option>请输入企业号名称</option>
                <option></option>
            </select>
            <span id="qiye_name_input"></span>
        </div>
        <div>
            <label><span>*</span>学校类型：</label>
            <select id="school_type" class="type">
                <option></option>
                <option value="幼教">幼教</option>
                <option value="普教">普教</option>
            </select>
            <span id="school_type_input"></span>
        </div>
        <div>
            <label><span>*</span>学校地址：</label>
            <select id="" name="province" class="province">
                <option value="">省份</option>
            </select>
            <select name="city" class="city">
                <option value="">地级市</option>
            </select>
            <select name="districtAndCounty" class="districtAndCounty">address
                <option value="">市、县级市</option>
            </select>
            <span id="address_input"></span>
        </div>
        <div>
            <label>入驻时间：</label>
            <input type="text" disabled="disabled" />
        </div>
        <div>
            <label><span>*</span>所属一级代理商：</label>
            <select id="frist_dl" class="sbelong">
                <option value="请选择代理商">请选择代理商</option>
                <option value="杭州卓教">杭州卓教</option>
            </select>
            <span id="frist_dl_input"></span>
        </div>
        <div>
            <label><span>*</span>所属二级代理商：</label>
            <select id="two_dl" class="sbelong">
                <option value="请选择代理商">请选择代理商</option>
                <option value="杭州卓教">杭州卓教</option>
            </select>
            <span id="two_dl_input"></span>
        </div>
        <div class="btn">
            <button id="addbtn" type="submit" class="save">保存</button>
            <button class="cancel" type="button">取消</button>
        </div>
    </form>
</div>

<script>
    $(function(){
        var pro=$(".province");
        var city=$(".city");
        var dAC=$(".districtAndCounty");
        var num1=null;
        var num2=null;
        init();
        pro.change(function(){
            num1=pro.prop("selectedIndex");
            city.find("option").eq(0).siblings().remove();
            dAC.find("option").eq(0).siblings().remove();
            if(num1!==0){
                for(var i=0;i<province[num1-1].city.length;i++){
                    var $temp=$("<option value=\"\">"+province[num1-1].city[i].name+"</option>");
                    city.append($temp);
                }
            }
        });
        city.change(function(){
            num2=city.prop("selectedIndex");
            dAC.find("option").eq(0).siblings().remove();
            if(num2!==0){
                for(var i=0;i<province[num1-1].city[num2-1].districtAndCounty.length;i++){
                    var $temp=$("<option value=\"\">"+province[num1-1].city[num2-1].districtAndCounty[i]+"</option>");
                    dAC.append($temp);
                }
            }
        })
    });

    function init(){
        var pro=$(".province");
        for(var i=0;i<province.length;i++){
            var $temp=$("<option value=\"\">"+province[i].name+"</option>");
            pro.append($temp);
        }
    }
</script>
</body>
</html>