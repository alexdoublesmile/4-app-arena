<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer>
    <div class="foot-menu">
        <p>Меню</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}">Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/games">Игры</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>
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
            <li><a href="https://vk.com/feed" target="_blank"><img src="static/images/icons/vk.png" alt="picture"/></a></li>
            <li><a href="https://www.facebook.com/" target="_blank"><img src="static/images/icons/fb.png" alt="picture"/></a></li>
            <li><a href="https://ok.ru/" target="_blank"><img src="static/images/icons/ok.png" alt="picture"/></a></li>
        </ul>
    </div>
</footer>