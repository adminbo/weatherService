<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>校长信箱</title>
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
<body>

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
        <article class="email_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a <%-- href="${pageContext.request.contextPath }/getAllSchoolMaster.do" --%> target="leftFrame">校园管理 ></a>
                <a href="${pageContext.request.contextPath }/president.do" target="leftFrame">校长信箱</a>
            </section>
            <div class="search">
                <input type="text" class="text" placeholder="搜索${pageContext.request.contextPath }." />
                <button type="button"></button>
                <select>
                    <option value="全部">全部</option>
                    <option value="未读">未读</option>
                    <option value="已读">已读</option>
                </select>
            </div>
            <table>
                <thead>
                <tr>
                    <th class="state">状态</th>
                    <th class="sender">发送人</th>
                    <th class="title">标题</th>
                    <th class="con">内容</th>
                    <th class="time">收件日期</th>
                </tr>
                </thead>
                <tbody class="con_tbody">
                <tr>
                    <td class="state"><img src="${pageContext.request.contextPath }/images/email.png"></td>
                    <td class="sender" title=""></td>
                    <td class="title" title=""></td>
                    <td class="con" title=""></td>
                    <td class="time" title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                <tr>
                    <td><img src="${pageContext.request.contextPath }/images/email2.png"></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                    <td title=""></td>
                </tr>
                </tbody>
            </table>
        </article>
    </div>
</main>
</body>
</html>