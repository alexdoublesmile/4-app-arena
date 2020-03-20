<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Admin Panel" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="admin-img">
                    <div class="info">
                        <h2>Admin Panel</h2>
                        <h3></h3>
                        <a></a>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>