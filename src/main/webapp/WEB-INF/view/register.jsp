<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta charset="utf-8"/>
    <title>Registration</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <!--<script src="script.js"></script>-->
    <!--<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">-->
</head>
<body>
<div class="wrapper">
    <jsp:include page="header.jsp"></jsp:include>

    <div class="main-img">
        <div class="main-img-1">
            <div class="info">
                <h2>Регистрация</h2>
                <%--<h3>Компания с многолетней историей</h3>--%>
                <%--<a href="#">Получить консультацию прямо сейчас</a>--%>
            </div>
        </div>
        <div class="main-img-2">
            <div class="info">
                <%--<h2>Семейное право</h2>--%>
                <%--<h3>Компания с многолетней историей</h3>--%>
                <%--<a href="static/main-2.html">Получить консультацию прямо сейчас</a>--%>
            </div>
        </div>
    </div>
    <div class="callback">
        <div class="info">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <label for="firstName">Имя</label>
                <input type="text" name="firstName" id="firstName"/>

                <label for="lastName">Фамилия</label>
                <input type="text" name="lastName" id="lastName"/><br/>

                <label for="login">Логин</label>
                <input type="text" name="login" id="login"/>

                <label for="password">Пароль</label>
                <input type="text" name="password" id="password"/>

                <%--<label for="score">Очки</label>--%>
                <%--<input type="text" name="score" id="score"/>--%>
                <input type="submit">Register</input><br>
                <span>${errorString}</span>
            </form>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>
</html>