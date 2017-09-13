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
});
</script>
</head>
<body>

<main>
    <div class="main_left">
        <h2>用户名<span>${loginUser.name }</span></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath }/getAlljiazhangxietong.do" class="pick" target="leftFrame">学生接送</a></li>
            <li><a href="${pageContext.request.contextPath }/getAllTongxunlu.do" class="contact"  target="leftFrame">通讯录</a></li>
        </ul>
    </div>

    <div class="detail">
        <article class="contact_main">
            <section class="top">
                <a href="${pageContext.request.contextPath }/toAddwechar.do" target="leftFrame">首页 ></a>
                <a href="${pageContext.request.contextPath }/grade/toGrade.do" target="leftFrame">教务管理 ></a>
                <a href="${pageContext.request.contextPath }/teacher/listTeacher.do" target="leftFrame">教师信息</a>
            </section>
            <%-- <div class="info_top">
                <label>学校名称：</label>
                <span>
                    <select onchange="this.parentNode.nextSibling.value=this.value">
                        <option value=""></option>
                        <option value=""></option>
                    </select>
                </span><input type="text" />
            </div>
            <form action="#" method="post">
                <div class="search">
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
                    <input type="reset" class="clean" value="清除" />
                </div>
                <div class="clear"></div>
            </form>
            <section class="s_add">
                <a href="${pageContext.request.contextPath }/toaddjiazhangxietong.do" class="add">新增</a>
                <a href="javascript:void(0)" onclick="add()" class="import">导入</a>
            </section> --%>
            <div class="contact_con">
                <h2>家长信息</h2>
                <div class="contact_add">
                    <div class="search">
                        <div>
                            <label>学生姓名：</label>
                            <input type="text" />
                            <span></span>
                        </div>
                    </div>
                    <div class="search">
                        <div>
                            <label>年级：</label>
                            <input type="text" />
                        </div>
                    </div>
                    <div class="search">
                        <div>
                            <label>班级：</label>
                            <input type="text" />
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="parents">
                        <div class="par_con">
                            <div class="par_left">
                                <span>家长1</span>
                                <div>
                                    <label>关注：</label>
                                    <input type="checkbox" />
                                </div>
                            </div>
                            <div class="par_right">
                                <div>
                                    <label>姓名：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>性别：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>关系：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>手机：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>微信号：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="par_con">
                            <div class="par_left">
                                <span>家长2</span>
                                <div>
                                    <label>关注：</label>
                                    <input type="checkbox" />
                                </div>
                            </div>
                            <div class="par_right">
                                <div>
                                    <label>姓名：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>性别：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>关系：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>手机：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>微信号：</label>
                                    <input type="text" />
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="par_con">
                            <div class="par_left">
                                <span>家长3</span>
                                <div>
                                    <label>关注：</label>
                                    <input type="checkbox" />
                                </div>
                            </div>
                            <div class="par_right">
                                <div>
                                    <label>姓名：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>性别：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>关系：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>手机：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>微信号：</label>
                                    <input type="text" />
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="par_con">
                            <div class="par_left">
                                <span>家长4</span>
                                <div>
                                    <label>关注：</label>
                                    <input type="checkbox" />
                                </div>
                            </div>
                            <div class="par_right">
                                <div>
                                    <label>姓名：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>性别：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>关系：</label>
                                    <input type="text" />
                                </div>
                                <div>
                                    <label>手机：</label>
                                    <input type="text" />
                                    <p></p>
                                </div>
                                <div>
                                    <label>微信号：</label>
                                    <input type="text" />
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    </div>
                <div class="btn">
                    <button type="submit" class="save">保存</button>
                    <a href="${pageContext.request.contextPath }/toaddjiazhangxietong.do"><button class="close" type="button">关闭</button></a>
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
	        title:'学校信息',
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