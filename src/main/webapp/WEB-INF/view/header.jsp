<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<header class="clearfix">
    <nav class="main-nav">
        <ul>
            <li class="li"><a href=${pageContext.request.contextPath}>Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Войти</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
            <li><a style="color:red" href="${pageContext.request.contextPath}/userInfo">[${loginedUser.login}]</a>
            <li><a href="${pageContext.request.contextPath}/admin">admin</a>
                <%--<ul class="sub-menu">--%>
                    <%--<li><a href="static/main-2.html">Игры</a></li>--%>
                    <%--<li><a href="http://localhost:8080/bulls-and-cows-1.0/view/profile.jsp">Профиль</a></li>--%>
                <%--</ul>--%>
            </li>
        </ul>
    </nav>
    <div class="search">
        <input type="text" class="search-text">
        <input type="image" value="search-button" src="static/images/icons/search.png" alt="Поиск"/>
    </div>
</header>