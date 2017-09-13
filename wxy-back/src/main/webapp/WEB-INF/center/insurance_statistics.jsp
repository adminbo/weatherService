<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息统计</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script>
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
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure" target="leftFrame">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage" target="leftFrame">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage" target="leftFrame">学校管理</a></li>
            <li><a href="${pageContext.request.contextPath }/safe/toSafeList.do" class="statistics" target="leftFrame">信息统计</a></li>
        </ul>
    </div>
    <div class="detail">
        <article class="sta_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">技服中心 ></a>
                <a href="${pageContext.request.contextPath }/safe/toSafeList.do" target="leftFrame">保险统计</a>
            </section>
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
            <div class="sta_con">
                <div class="year">
                    <label>投保年份：</label>
                    <select>
                        <option value=""></option>
                        <option value="2014年">2014年</option>
                        <option value="2015年">2015年</option>
                        <option value="2016年">2016年</option>
                        <option value="2017年">2017年</option>
                        <option value="2018年">2018年</option>
                        <option value="2019年">2019年</option>
                        <option value="2020年">2020年</option>
                    </select>
                    至
                    <select>
                        <option value=""></option>
                        <option value="2014年">2014年</option>
                        <option value="2015年">2015年</option>
                        <option value="2016年">2016年</option>
                        <option value="2017年">2017年</option>
                        <option value="2018年">2018年</option>
                        <option value="2019年">2019年</option>
                        <option value="2020年">2020年</option>
                    </select>
                </div>
                <div class="clear"></div>
                <div class="chart">
                    <h2>趋势图</h2>
                    <div class="chart_main">
                        <div class="chart_con">
                        <img src="${pageContext.request.contextPath }/images/insurance.jpg" style="height: 240px; margin-left: 6%;">
                        </div>
                        <div class="notes">
                            <div class="note1">
                                <em></em>
                                <span>学平险保额总计</span>
                            </div>
                            <div class="note2">
                                <em></em>
                                <span>已购买学平险人数</span>
                            </div>
                            <div class="note3">
                                <em></em>
                                <span>未购买学平险人数</span>
                            </div>
                        </div>
                        <div class="chart_info">
                            <p>2015年第一学期</p>
                            <p><span>已购买人数</span><em>3,0000</em></p>
                            <p><span>未购买人数</span><em>3,0000</em></p>
                            <p><span>保额总计</span><em>300,0000</em></p>
                        </div>
                    </div>
                </div>
                <div class="content">
                    <table class="ins_table1">
                        <thead>
                        <tr>
                            <th class="num">编号</th>
                            <th class="sname">学校名称</th>
                            <th class="btype">保险类型</th>
                            <th class="byear">投保年份</th>
                            <th class="term">投保学期</th>
                            <th class="bnum">保险人数比例</th>
                            <th class="money">保险金额</th>
                        </tr>
                        </thead>
                        <tbody class="con_tbody">
                        <tr>
                            <td class="num">1</td>
                            <td class="sname" title="">卓教科技大学</td>
                            <td class="btype" title="">学平险</td>
                            <td class="byear" title="">2011-11-12</td>
                            <td class="term" title="">2011第一学期</td>
                            <td class="bnum" title="">30%</td>
                            <td class="money" title="">100</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td class="sname" title="">山东大学</td>
                            <td class="btype" title="">学平险</td>
                            <td class="byear" title="">2009-11-12</td>
                            <td class="term" title="">2009第一学期</td>
                            <td class="bnum" title="">30%</td>
                            <td class="money" title="">100</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td class="sname" title="">北京大学</td>
                            <td class="btype" title="">学平险</td>
                            <td class="byear" title="">2011-11-12</td>
                            <td class="term" title="">2011第一学期</td>
                            <td class="bnum" title="">50%</td>
                            <td class="money" title="">100</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td class="sname" title="">卓教科技大学</td>
                            <td class="btype" title="">学平险</td>
                            <td class="byear" title="">2011-11-12</td>
                            <td class="term" title="">2011第一学期</td>
                            <td class="bnum" title="">30%</td>
                            <td class="money" title="">100</td>
                        </tr>
                        </tbody>
                    </table>
                    <!--<table class="ins_table2">-->
                        <!--<thead>-->
                        <!--<tr>-->
                            <!--<th class="num">编号</th>-->
                            <!--<th class="igrade">年级</th>-->
                            <!--<th class="iclass">班级</th>-->
                            <!--<th class="btype">保险类型</th>-->
                            <!--<th class="byear">投保年份</th>-->
                            <!--<th class="term">投保学期</th>-->
                            <!--<th class="bnum">保险人数比例</th>-->
                            <!--<th class="money">保险金额</th>-->
                        <!--</tr>-->
                        <!--</thead>-->
                        <!--<tbody class="con_tbody">-->
                        <!--<tr>-->
                            <!--<td class="num">1</td>-->
                            <!--<td class="igrade" title=""></td>-->
                            <!--<td class="iclass" title=""></td>-->
                            <!--<td class="btype" title=""></td>-->
                            <!--<td class="byear" title=""></td>-->
                            <!--<td class="term" title=""></td>-->
                            <!--<td class="bnum" title=""></td>-->
                            <!--<td class="money" title=""></td>-->
                        <!--</tr>-->
                        <!--<tr>-->
                            <!--<td>2</td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                        <!--</tr>-->
                        <!--<tr>-->
                            <!--<td>3</td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                        <!--</tr>-->
                        <!--<tr>-->
                            <!--<td>4</td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                            <!--<td title=""></td>-->
                        <!--</tr>-->
                        <!--</tbody>-->
                    <!--</table>-->
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
                </div>
            </div>
        </article>
    </div>
</main>
</body>
</html>