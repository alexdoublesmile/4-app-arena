<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
</head>
<body>
    <div class="wrapper">
        <jsp:include page="header.jsp"></jsp:include>

        <div class="main-img">
            <div class="main-img-1">
                <div class="info">
                    <h2>Как настроение?</h2>
                    <h3>Добро пожаловать на Арену</h3>
                    <a href="#">Хочу сыграть</a>
                </div>
            </div>
            <div class="main-img-2">
                <div class="info">
                    <h2>Поразмыслим..?</h2>
                    <h3>Добро пожаловать на Арену</h3>
                    <a href="static/main-2.html">Хочу сыграть</a>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>