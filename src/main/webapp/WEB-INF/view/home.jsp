<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <jsp:include page="meta.jsp"></jsp:include>
</head>
<body>
    <div class="wrapper">
        <jsp:include page="header.jsp"></jsp:include>

        <div class="content">
            <div class="main-img-1">
                <div class="info">
                    <h2>Как настроение?</h2>
                    <h3>Добро пожаловать на Арену</h3>
                    <%--<a href="${pageContext.request.contextPath}/games">Хочу сыграть</a>--%>
                </div>
            </div>
            <div class="main-img-2">
                <div class="info">
                    <h2>Всё завершится</h2>
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