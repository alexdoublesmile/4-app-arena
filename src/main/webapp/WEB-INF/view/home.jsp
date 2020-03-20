<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Home" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="main-img-1">
                    <div class="info">
                        <h2>Как настроение?</h2>
                        <h3>Добро пожаловать на Арену</h3>
                    </div>
                </div>
                <div class="main-img-2">
                    <div class="info">
                        <h2>Не суетись</h2>
                        <h3>Добро пожаловать на Арену</h3>
                        <a href="${pageContext.request.contextPath}/games">Хочу сыграть</a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        ${message}
    </body>
</html>