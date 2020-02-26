<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <c:if test="${playerList.size() == 0}">
            <h2 align="center">DataBase is empty now.</h2>
        </c:if>
        <c:forEach var="player" items="${playerList}">
            <h2 align="center">${player.firstName} ${player.login} - ${player.score} очков</h2>
        </c:forEach>
    </body>
</html>