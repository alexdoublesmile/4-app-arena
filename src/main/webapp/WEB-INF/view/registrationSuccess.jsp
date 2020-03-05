<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Moder</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
    <jsp:include page="header.jsp"></jsp:include>
    <div style=
                 "font-size: 20px;
                          padding-top: 120px;
                          color: #ffffff">

        <p>YOU HAVE BEEN REGISTERED!</p>
        <br>
        <p style="
        color:green;
        white-space: pre-wrap">
            Регистрация прошла успешно! Можете войти в систему, используя свои логин и пароль.</p>

    </div>



    <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>
</html>