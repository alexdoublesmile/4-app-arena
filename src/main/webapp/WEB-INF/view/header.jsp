<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<header class="clearfix">
    <nav class="main-nav">
        <ul>
            <li><a href=${pageContext.request.contextPath}>Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/games">Игры</a></li>
            <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>
            <li>
                <div class="normal-container">
                    <div class="smile-rating-container">
                        <div class="smile-rating-toggle-container">
                            <form class="submit-rating">
                                <input id="meh"  name="satisfaction" type="radio" />
                                <input id="fun" name="satisfaction" type="radio" />
                                <label for="meh" class="rating-label rating-label-meh">Bad</label>
                                <div class="smile-rating-toggle"></div>

                                <div class="rating-eye rating-eye-left"></div>
                                <div class="rating-eye rating-eye-right"></div>

                                <div class="mouth rating-eye-bad-mouth"></div>

                                <div class="toggle-rating-pill"></div>
                                <label for="fun" class="rating-label rating-label-fun">Fun</label>
                            </form>
                        </div>
                    </div>
                </div>
            </li>
            <%--<li><a href="${pageContext.request.contextPath}/admin">admin panel</a></li>--%>
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
        <form action="//yandex.ru/yandsearch" target="_blank">
            <input type="text" class="search-text" name="text"
                   onBlur="if (this.value != '') {this.value=''}"
                   onclick="if (this.value !='') {this.value=''}"/>
            <input type="image" value="search-button" src="static/images/icons/search.png" alt="Поиск"/>
            <input type="submit" id="submit"/>
        </form>
    </div>
</header>