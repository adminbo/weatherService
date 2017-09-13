<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>每周食谱</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
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
<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
             <%-- <li><a href="${pageContext.request.contextPath }/toAddwechar.do" class="configure">公众号配置</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllWechateslist.do" class="gmanage">公众号管理</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolMaster.do" class="smanage">学校信息管理</a></li> --%>
            <li><a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do" class="env" target="leftFrame">校园环境</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllPeitaosheshi.do" class="fac" target="leftFrame">配套设施</a></li>
            <li><a href="${pageContext.request.contextPath }/teachers/listTeachershow.do" class="teacher" target="leftFrame">教师风采</a></li>
            <li><a href="${pageContext.request.contextPath }/banxue/banxuelist.do" class="feature" target="leftFrame">办学特色</a></li>
            <li><a href="${pageContext.request.contextPath }/foodweeks/foodweeklist.do" class="week" target="leftFrame">每周食谱</a></li>
            <li><a href="${pageContext.request.contextPath }/president.do" class="mailbox" target="leftFrame">校长信箱</a></li>
            <%-- <li><a href="${pageContext.request.contextPath }/getAllMenu.do" class="app">应用中心</a></li> --%>
        </ul>
    </div>
    <div class="detail">
        <article class="recipe_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">校园管理 ></a>
                <a href="${pageContext.request.contextPath }/foodweeks/foodweeklist.do" target="leftFrame">每周食谱</a>
            </section>
            <form action="#" method="post">
                <div class="search">
                    <div>
                        <label>学期：</label>
                        <select>
                            <option value="请选择学期">请选择学期</option>
                            <option value="2017年第一学期">2017年第一学期</option>
                            <option value="2017年第二学期">2017年第二学期</option>
                            <option value="2018年第一学期">2018年第一学期</option>
                            <option value="2018年第二学期">2018年第二学期</option>
                        </select>
                    </div>
                </div>
                <div class="search">
                    <div>
                        <label>周次：</label>
                        <select>
                            <option value="请选择某一周的食谱">请选择某一周的食谱</option>
                            <option value="第一周">第一周</option>
                            <option value="第二周">第二周</option>
                            <option value="第三周">第三周</option>
                            <option value="第四周">第四周</option>
                        </select>
                    </div>
                </div>
                <div class="clear"></div>
            </form>
            <section class="s_add">
                <a href="#" class="import">导入</a>
            </section>
            <section class="content">
                <table>
                    <thead>
                    <tr>
                        <th class="num first"></th>
                        <th class="monday">星期一</th>
                        <th class="tuesday">星期二</th>
                        <th class="wednesday">星期三</th>
                        <th class="thursday">星期四</th>
                        <th class="friday">星期五</th>
                    </tr>
                    </thead>
                    <tbody class="con_tbody">
                    <tr>
                        <td class="num recipe_row" title="餐饮类别">
                            <input type="text" value="餐饮类别" />
                            <button type="button" class="recipe_left"></button>
                            <button type="button" class="recipe_right"></button>
                        </td>
                        <td class="monday" title=""><input type="text" value="" /></td>
                        <td class="tuesday" title=""><input type="text" value="" /></td>
                        <td class="wednesday" title=""><input type="text" value="" /></td>
                        <td class="thursday" title=""><input type="text" value="" /></td>
                        <td class="friday" title=""><input type="text" value="" /></td>
                    </tr>
                    <tr>
                        <td class="recipe_row" title="餐饮类别">
                            <input type="text" value="餐饮类别" />
                            <button type="button" class="recipe_left"></button>
                            <button type="button" class="recipe_right"></button>
                        </td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                    </tr>
                    <tr>
                        <td class="recipe_row" title="餐饮类别">
                            <input type="text" value="餐饮类别" />
                            <button type="button" class="recipe_left"></button>
                            <button type="button" class="recipe_right"></button>
                        </td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                    </tr>
                    <tr>
                        <td class="recipe_row" title="餐饮类别">
                            <input type="text" value="餐饮类别" />
                            <button type="button" class="recipe_left"></button>
                            <button type="button" class="recipe_right"></button>
                        </td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                        <td title=""><input type="text" value="" /></td>
                    </tr>
                    </tbody>
                </table>
            </section>
        </article>
    </div>
</main>
<div class="import_con">
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
    <div class="mould">
        <label>从已有食谱导入：</label>
        <select>
            <option value="请选择某一周的食谱">请选择某一周的食谱</option>
            <option value="第一周">第一周</option>
            <option value="第二周">第二周</option>
            <option value="第三周">第三周</option>
            <option value="第四周">第四周</option>
        </select>
    </div>
    <div class="btn">
        <button type="submit" class="save">保存</button>
        <a href="recipe.html"><button class="close" type="button">取消</button></a>
    </div>
</div>
</body>
</html>