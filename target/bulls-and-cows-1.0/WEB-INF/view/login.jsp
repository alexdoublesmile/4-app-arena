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
                        <h4>Вход на Арену</h4>
                        <form action="${pageContext.request.contextPath}/login" method="post">
                            <input type="hidden" name="redirectId" value="${param.redirectId}"/>
                            <div class="form-group">
                                <label for="login">Логин</label>
                                <input type="text" name="login" id="login" value="${user.login}" required
                                       onclick="
                                            this.style.border='none'"
                                       onblur="
                                            if (this.value !='') {
                                                this.style.border='none';
                                                this.style.textAlign='center';
                                            }"
                                />
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="password">Пароль</label>
                                <input type="text" name="password" id="password" value="${user.password}" required
                                       onclick="
                                            this.style.border='none'"
                                       onBlur="
                                            if (this.value !='') {
                                                this.style.border='none';
                                                this.style.textAlign='center';
                                            }"
                                />
                            </div>
                            <br>
                            <div class="login-submit">
                                <input type="submit" value="Войти"/>
                            </div>
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