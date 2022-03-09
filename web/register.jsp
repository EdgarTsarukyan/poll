<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.02.2022
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
<form action="/register" method="post">
  <input type="text" placeholder="email" name="email" ><br>
  <input type="text" placeholder="password" name="password"><br>
  <input type="submit" value="register">
</form>
<a href="login.jsp">Login </a><br><br>
</body>
</html>
