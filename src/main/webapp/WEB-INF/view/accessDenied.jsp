<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Access Denied" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="accessDenied-img">
                    <div class="info">
                        <h2></h2>
                        <h3>У вас нет прав для доступа на эту страницу. Обратитесь к Администратору</h3>
                        <a></a>
                    </div>
                </div>
                <div class="accessDenied5-img">
                    <div class="info">
                        <h2></h2>
                        <h3></h3>
                        <a></a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>