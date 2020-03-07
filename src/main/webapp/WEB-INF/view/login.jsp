<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
    <head>
        <title>Login</title>
        <jsp:include page="meta.jsp"></jsp:include>
    </head>
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
                            <label for="login">Login</label>
                            <input type="text" name="login" id="login" value="${user.login}" required/>
                            <br>
                            <label for="password">Password</label>
                            <input type="text" name="password" id="password" value="${user.password}" required/>
                            <br>
                            <input type="submit" value="Login"/>
                            <br>
                            <span class="error">${errorString}</span>
                            <br>
                        </form>
                        <a href="${pageContext.request.contextPath}/register">Зарегистрироваться</a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>
    </body>
</html>