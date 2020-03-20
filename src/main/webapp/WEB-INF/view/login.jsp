<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
    <c:set var="title" value="Login" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="login-img">
                    <div class="info">
                        <h3>Не будь бомжом - залогинься!</h3>
                        <br>
                        <form action="${pageContext.request.contextPath}/login" method="post">
                            <input type="hidden" name="redirectId" value="${param.redirectId}"/>
                            <div class="form_group">
                                <label for="login">Логин</label>
                                <input type="text" name="login" id="login" value="${user.login}" required/>
                            </div>
                            <br>
                            <div class="form_group">
                                <label for="password">Пароль</label>
                                <input type="text" name="password" id="password" value="${user.password}" required/>
                            </div>
                            <br>
                            <input type="submit" value="Войти"/>
                        </form>
                        <span class="error">${errorString}</span><br>
                        <a href="${pageContext.request.contextPath}/register">Зарегистрироваться</a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>