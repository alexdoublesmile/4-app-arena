<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta charset="utf-8"/>
    <title>Mind Arena</title>
    <link href="../static/css/style.css" rel="stylesheet"/>
    <!--<script src="script.js"></script>-->
    <!-- <link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet"> -->
</head>
<body>
<div class="wrapper">
    <header class="clearfix">
        <nav class="main-nav">
            <ul>
                <li class="li"><a href="/bulls-and-cows-1.0/index.html">Главная</a>
                    <ul class="sub-menu">
                        <li><a href="#">Игры</a></li>
                        <li><a href="#">Профиль</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div class="search">
            <input type="text" class="search-text">
            <input type="image" value="search-button" src="static/images/icons/search.png" alt="Поиск"/>
        </div>
    </header>
    <div class="main-img">
        <div class="main-img-1">
            <div class="info">
                <h2>Это твой профиль</h2>
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
    <footer>
        <div class="foot-menu">
            <p>Меню</p>
            <ul>
                <li><a href="#">услуги</a></li>
                <li><a href="#">новости</a></li>
                <li><a href="#">контакты</a></li>
            </ul>
        </div>
        <div class="foot-services">
            <p>Услуги</p>
            <ul>
                <li><a href="#">земельное право</a></li>
                <li><a href="#">семейное право</a></li>
                <li><a href="#">медицинское право</a></li>
                <li><a href="#">проблемы с кредитами</a></li>
                <li><a href="#">банкротство физ лиц</a></li>
                <li><a href="#">банкротство юр лиц</a></li>
                <li><a href="#">защита потребителей</a></li>
            </ul>
        </div>
        <div class="foot-blog">
            <p>Мы в соц сетях</p>
            <ul>
                <li><a href="#"><img src="static/images/icons/vk.png" alt="picture"/></a></li>
                <li><a href="#"><img src="static/images/icons/fb.png" alt="picture"/></a></li>
                <li><a href="#"><img src="static/images/icons/ok.png" alt="picture"/></a></li>
            </ul>
        </div>
    </footer>
</div>
<p>${message}</p>
</body>
</html>