<%@page contentType="text/html" pageEncoding="UTF-8" %>

<footer>
    <div class="foot-menu">
        <p>Меню</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}">Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/games">Игры</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>

            <%--<c:choose>--%>
                <%--<c:when test="${loginedUser.equals('no')}">--%>
                    <%--<li><a style="color: limegreen" href="${pageContext.request.contextPath}/login?redirectId=0">Войти</a></li>--%>

                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<li><a style="color: limegreen" href="${pageContext.request.contextPath}/userInfo">${loginedUser.login}</a></li>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        </ul>
    </div>
    <div class="foot-services">
        <p>Действия</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}/userInfo">Открыть профиль</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Выйти из профиля</a></li>
            <li><a href="${pageContext.request.contextPath}/admin">Открыть Admin Panel</a>

        </ul>
    </div>
    <div class="foot-blog">
        <p>Соц сети</p>
        <ul>
            <li><a href="https://vk.com/feed"><img src="static/images/icons/vk.png" alt="picture"/></a></li>
            <li><a href="https://www.facebook.com/"><img src="static/images/icons/fb.png" alt="picture"/></a></li>
            <li><a href="https://ok.ru/"><img src="static/images/icons/ok.png" alt="picture"/></a></li>
        </ul>
    </div>
</footer>