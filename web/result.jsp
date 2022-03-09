<%@ page import="model.Poll" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Result" %><%--
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
<% Result result = (Result) request.getAttribute("result"); %>
<h1><%=result.getExplanation()%></h1>
<a href="login.jsp">Login </a><br><br>
<a href="register.jsp">Register</a>
</body>
</html>
