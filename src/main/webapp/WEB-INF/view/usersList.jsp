<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Hall Of Fame</title>
        <jsp:include page="meta.jsp"></jsp:include>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>
            <div class="content">
                <div class="champions1-img">
                    <div class="info">
                        <h2></h2>
                        <h3></h3>
                        <a></a>
                    </div>
                </div>
                <div class="champions2-img">
                    <div class="info">
                        <c:if test="${usersList.size() == 0}">
                            <h3 align="center">DataBase is empty now.</h3>
                        </c:if>
                        <c:forEach var="user" items="${usersList}">
                            <h3 align="center">${user.firstName} ${user.login} - ${user.score}</h3>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>
    </body>
</html>