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
                <div class="champions-img-1">
                    <div class="info">
                        <h2></h2>
                        <h3></h3>
                        <a></a>
                    </div>
                </div>
                <div class="champions-img-2">
                    <div class="info">
                        <div class="dictum">
                            <h3>${randomDictum}</h3>
                        </div>
                        <div class="usersList">
                            <c:if test="${usersList.size() == 0}">
                                <h2>DataBase is empty now.</h2>
                            </c:if>
                            <c:forEach var="user" items="${usersList}">
                                <h3>${user.firstName} ${user.login} - ${user.score}</h3>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>

            <%--




Есть две вещи, которые ты можешь делать: смотреть и видеть








--%>

        </div>
    </body>
</html>