<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<header class="clearfix">
    <nav class="main-nav">
        <ul>
            <li><a href=${pageContext.request.contextPath}>Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>
            <li><a href="${pageContext.request.contextPath}/admin">admin panel</a></li>
            <c:choose>
                <c:when test="${not empty loginedUser.login}">
                    <li class="sub-li"><a style="color: limegreen" href="${pageContext.request.contextPath}/userInfo">${loginedUser.login}</a>
                        <ul class="sub-menu">
                            <li><a href="${pageContext.request.contextPath}/userInfo">Профиль</a></li>
                            <li><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a style="color: navajowhite" href="${pageContext.request.contextPath}/login">Войти</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>
    <div class="search">
        <input type="text" class="search-text">
        <input type="image" value="search-button" src="static/images/icons/search.png" alt="Поиск"/>
    </div>
</header>