<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Registration Success" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="registrationSuccess-img">
                    <div class="info">
                        <h3>Регистрация прошла успешно! Можете войти в систему, используя свои логин и пароль.</h3>
                        <a></a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>