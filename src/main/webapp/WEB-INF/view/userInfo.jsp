<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>Profile</title>
    <jsp:include page="meta.jsp"></jsp:include>
    <!--<script src="checkRegistration.js"></script>-->
    <!-- <link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet"> -->
</head>
<body>
<div class="wrapper">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
        <div class="profile-img">
            <div class="info">
                <h3>Имя - ${loginedUser.lastName} ${loginedUser.firstName}</h3>
                <br>
                <h3>Логин - ${loginedUser.login}</h3>
                <br>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>
</html>