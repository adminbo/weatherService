<%@ page pageEncoding="utf-8"%>
<header>
    <h1>孺学宝移动办公平台</h1>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath }/getAllSchoolEnvire.do">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/school.png" />
                    <figcaption>校园管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/grade/toGrade.do">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/class.png" />
                    <figcaption>教务管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="#">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/teacher.png" />
                    <figcaption>教学管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/getAlljiazhangxietong.do">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/parent.png" />
                    <figcaption>家长协同</figcaption>
                </figure>
            </a>
        </li>
                  <shiro:hasPermission name="admin">                              
        <li>
            <a href="${pageContext.request.contextPath }/access/listEqu.do">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/door.png" />
                    <figcaption>门禁管理</figcaption>
                </figure>
            </a>
        </li>
                  </shiro:hasPermission>
        <li>
            <a href="${pageContext.request.contextPath }/safe/toSafe.do">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/baoxian.png" />
                    <figcaption>保险管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/system/listUser.do">
                <figure>
                    <img src="${pageContext.request.contextPath }/images/system.png" />
                    <figcaption>系统管理</figcaption>
                </figure>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath }/getAllSchoolMaster.do">
                <figure>
                   <img src="${pageContext.request.contextPath }/images/center.png" />
                    <figcaption>技服中心</figcaption>
                </figure>
            </a>
        </li>
    </ul>
    <div class="head_right">
        <select>
            <option>幼儿园1</option>
            <option>幼儿园2</option>
            <option>幼儿园3</option>
            <option>幼儿园4</option>
        </select>
        <div class="link">
            <a href="#" class="switch"></a>
            <ul>
                <li><a href="${pageContext.request.contextPath }/system/settings.do">系统设置</a></li>
                <li><a href="javascript:void(0)" onclick="exit()">退出</a></li>
            </ul>
        </div>
    </div>
</header>