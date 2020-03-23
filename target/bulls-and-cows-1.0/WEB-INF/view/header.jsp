<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="clearfix">
    <script>
        function checkTheme() {
            var themeButton = document.getElementsByName('satisfaction'),
                newLink = document.createElement('link'),
                head = document.getElementById('head');
            for (var i = 0; i < themeButton.length; i++) {
                if (themeButton[1].checked) {
                    newLink.href = "${pageContext.request.contextPath}/static/css/funTheme/fun.css";
                    newLink.rel = "stylesheet";
                    newLink.id = "link";
                    head.insertBefore(newLink, null);

                } else {
                    link.remove(newLink);

                }
            }
        }
    </script>
    <nav class="main-nav">
        <ul>
            <li><a href="${pageContext.request.contextPath}/home">Главная</a></li>
            <c:if test="${not empty loginedUser.login}">
                <li><a href="${pageContext.request.contextPath}/games">Игры</a></li>
                <li><a href="${pageContext.request.contextPath}/usersList">Рекорды</a></li>
            </c:if>
            <c:forEach var="role" items="${loginedUser.roles}">
                <c:if test="${role.name=='MODER'}">
                    <li>
                        <form class="theme-form">
                            <input id="bad" name="satisfaction" type="radio" value="bad" onclick="checkTheme()" checked/>
                            <input id="fun" name="satisfaction" type="radio" value="fun" onclick="checkTheme()"/>

                            <label for="bad" class="theme-label bad-theme-label">Bad</label>

                            <div class="theme-head"></div>
                            <div class="theme-eye theme-left-eye"></div>
                            <div class="theme-eye theme-right-eye"></div>
                            <div class="theme-mouth"></div>

                            <div class="theme-pill"></div>
                            <label for="fun" class="theme-label fun-theme-label">Fun</label>
                        </form>
                    </li>
                </c:if>
            </c:forEach>

            <c:choose>
                <c:when test="${not empty loginedUser.login}">
                    <li class="sub-li" id="sub-li"><a style="color: limegreen" href="${pageContext.request.contextPath}/userInfo">${loginedUser.login}</a>
                        <ul class="sub-menu">
                            <li><a href="${pageContext.request.contextPath}/userInfo">Профиль</a></li>
                            <li><a href="${pageContext.request.contextPath}/statistic">Статистика</a></li>
                            <li><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a style="color: navajowhite" href="${pageContext.request.contextPath}/login">Войти</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach var="role" items="${loginedUser.roles}">
                <c:if test="${role.name=='ADMIN'}">
                    <li><a style="color: navajowhite" href="${pageContext.request.contextPath}/admin">Admin Panel</a>
                </c:if>
            </c:forEach>

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

    <script>
        <c:forEach var="role" items="${loginedUser.roles}">
            <c:if test="${role.name!='USER'}">
                document.getElementById('sub-li').style.marginLeft = 0;
            </c:if>
        </c:forEach>
    </script>
</header>