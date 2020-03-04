<%@page contentType="text/html" pageEncoding="UTF-8" %>

<footer>
    <div class="foot-menu">
        <p>Меню</p>
        <ul>
            <li class="li"><a href=${pageContext.request.contextPath}>Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Войти</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
            <li><a style="color:red" href="${pageContext.request.contextPath}/userInfo">[${loginedUser.login}]</a>
            <li><a href="${pageContext.request.contextPath}/admin">admin</a>
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