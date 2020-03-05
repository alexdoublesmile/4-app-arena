<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta charset="utf-8"/>
    <title>Profile</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <!--<script src="script.js"></script>-->
    <!-- <link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet"> -->
</head>
<body>
<div class="wrapper">
    <jsp:include page="header.jsp"></jsp:include>

    <div class="main-img">
        <div class="main-img-1">
            <div class="info">
                <h2>Это твой профиль, ${loginedUser.firstName}</h2>
                <!--<h3>Компания с многолетней историей</h3>-->
                <%--<a href="#">Блеснуть интеллектом</a>--%>
            </div>
        </div>
        <div class="main-img-2">
            <div class="info">
                <%--<h2>Действительно есть же...</h2>--%>
                <!--<h3>Компания с многолетней историей</h3>-->
                <%--<a href="static/main-2.html">Блеснуть интеллектом</a>--%>
            </div>
        </div>
    </div>
    <div class="callback">
        <div class="info">
            <p>Нет времени читать? Засекайте время!<br>
                Мы перезвоним Вам за 10 секунд. <span class="uppercase">Бесплатно.</span></p>
            <input type="text" value="+7">
            <input type="submit" value="Жду звонка">
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>
</html>