<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Profile" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="userInfo-img">
                    <div class="info">
                        <h3>Пользователь - ${loginedUser.lastName} ${loginedUser.firstName}</h3>
                        <br>
                        <h3>Логин - ${loginedUser.login}</h3>
                        <br>
                        <br>
                        <c:choose>
                            <c:when test="${loginedUser.login=='Richbankir'}">
                                <h4>Че там? как дела, Димасик? ;)</h4>

                            </c:when>
                            <c:when test="${loginedUser.login=='Denchik'}">
                                <h4>Дэнчик, ты как всегда самый усердный ученик на планете - даже первое задание оказалось не по силам?)</h4>
                                <br>
                                <%--<a class="profile-pictures" href="https://javarush.ru/groups/posts/2418-pochemu-stoit-uchitjh-java-v-2020-godu">--%>
                                    <%--<img src="static/images/pictures/06.png">--%>
                                <%--</a>--%>
                                <%--<a href="https://javarush.ru/groups/posts/2502-java-v-oblakakh-kak-oblachnihe-prilozhenija-zavoevihvajut-mir-i-zachem-im-java" target="_blank">--%>
                                    <%--<img src="static/images/pictures/01.png">--%>
                                <%--</a>--%>
                                <%--<a href="https://javarush.ru/groups/posts/2426-java-i-internet-vejshey-kak-statjh-uspeshnihm-iot-developerom" target="_blank">--%>
                                    <%--<img src="static/images/pictures/02.png">--%>
                                <%--</a>--%>
                                <%--<a href="https://javarush.ru/groups/posts/2546-java-i-blokcheyn-naydetsja-li-v-tekhnologii-budujshego-mesto-dlja-java-koda" target="_blank">--%>
                                    <%--<img src="static/images/pictures/03.png">--%>
                                <%--</a>--%>
                                <%--<a href="https://javarush.ru/groups/posts/2445-razmer-imeet-znachenie-gayd-po-java-programmirovaniju-v-big-data" target="_blank">--%>
                                    <%--<img src="static/images/pictures/04.png">--%>
                                <%--</a>--%>
                                <%--<a href="https://javarush.ru/groups/posts/2558-java-i-ai-mozhno-li-napisatjh-iskusstvennihy-intellekt-na-java" target="_blank">--%>
                                    <%--<img src="static/images/pictures/05.png">--%>
                                <%--</a>--%>

                            </c:when>
                            <c:when test="${loginedUser.login=='Игорь Талалай'}">
                                <h4>Игоречек, только для тебя! ;) нажми на картинку</h4>
                                <br>
                                <a style="
                                    display: inline-block;
                                    width: 400px;
                                    height: 400px;"
                                   href="https://cdn.pixabay.com/photo/2014/04/02/16/26/sword-307282_1280.png" target="_blank">
                                    <img style="
                                    width: 800px;
                                    height: 500px;"
                                         src="https://forum.sources.ru/uploads/photo-11789.jpg">
                                </a>
                            </c:when>
                            <c:when test="${loginedUser.login==''}">

                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>