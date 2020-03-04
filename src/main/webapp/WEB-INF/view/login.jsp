<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
    <head>
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div style=
                         "font-size: 20px;
                      padding-top: 120px;
                      padding-left: 250px;
                      color: #ffffff">

                <h3>Login Page</h3>
                <br>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <%--<input type="hidden" name="redirectId" value="${param.redirectId}"/>--%>
                    <input type="hidden" name="redirectId" value="2"/>
                    <label for="login">Login</label>
                    <input type="text" name="login" id="login" value="${user.login}"/>
                    <br>
                    <label for="password">Password</label>
                    <input type="text" name="password" id="password" value="${user.password}"/>
                    <br>
                    <input type="submit" value="Login"/>
                    <br>
                    <span class="error">${errorString}</span>
                    <br>
                </form>
                <a href="${pageContext.request.contextPath}/register">Зарегистрироваться</a>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>
    </body>
</html>