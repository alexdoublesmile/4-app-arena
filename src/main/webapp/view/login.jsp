<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Log In</title>
</head>
<body>
    <h3>Login</h3>
    <br>
    <form action="login" method="post">
        <input type="text" name="login"/>
        <input type="text" name="password"/>
        <input type="submit" value="login"/>
        <span class="error">${error}</span>
    </form>
</body>
</html>