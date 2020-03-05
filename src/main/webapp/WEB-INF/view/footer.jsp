<%@page contentType="text/html" pageEncoding="UTF-8" %>

<footer>
    <div class="foot-menu">
        <p>Меню</p>
        <ul>
            <li class="li"><a href=${pageContext.request.contextPath}>Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>

            <%--<c:choose>--%>
                <%--<c:when test="${loginedUser.equals('no')}">--%>
                    <%--<li><a style="color: limegreen" href="${pageContext.request.contextPath}/login?redirectId=0">Войти</a></li>--%>

                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<li><a style="color: limegreen" href="${pageContext.request.contextPath}/userInfo">${loginedUser.login}</a></li>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
            <li><a href="${pageContext.request.contextPath}/admin">admin panel</a>
        </ul>
    </div>
    <div class="foot-services">
        <p>Услуги</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}/userInfo">профиль</a></li>
        </ul>
    </div>
    <div class="foot-blog">
        <p>Мы в соц сетях</p>
        <ul>
            <li><a href="#"><img src="static/images/icons/vk.png" alt="picture"/></a></li>
            <li><a href="#"><img src="static/images/icons/fb.png" alt="picture"/></a></li>
            <li><a href="#"><img src="static/images/icons/ok.png" alt="picture"/></a></li>
        </ul>
    </div>
</footer>