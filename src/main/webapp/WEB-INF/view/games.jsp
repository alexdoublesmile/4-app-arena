<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
    <c:set var="title" value="Games" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="games-img-1">
                    <div class="info">
                        <h2>Интеллектуальные Игры</h2>
                    </div>
                </div>
                <div class="games-img-2">
                    <div class="info">
                        <h2>Интеллектуальные Игры</h2>
                    </div>
                </div>
            </div>

            <div class="articles">
                <div class="bg-article">
                    <div class="article">
                        <p class="article-head">Тут будет что-то</p>
                        <p class="article-text">Текст с описанием того, что тут будет, наверное</p>
                        <a href="">Вход в это</a>
                    </div>
                </div>
                <div class="bg-article">
                    <div class="article">
                        <p class="article-head">Тут будет что-то</p>
                        <p class="article-text">Текст с описанием того, что тут будет, наверное</p>
                        <a href="">Вход в это</a>
                    </div>
                </div>
                <div class="bg-article">
                    <div class="article">
                        <p class="article-head">Тут будет что-то</p>
                        <p class="article-text">Текст с описанием того, что тут будет, наверное</p>
                        <a href="">Вход в это</a>
                    </div>
                </div>
                <div class="bg-article">
                    <div class="article">
                        <p class="article-head">Тут будет что-то</p>
                        <p class="article-text">Текст с описанием того, что тут будет, наверное</p>
                        <a href="">Вход в это</a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>