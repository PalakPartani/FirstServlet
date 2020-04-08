<%--
  Created by IntelliJ IDEA.
  User: Palak Rubi
  Date: 08-04-2020
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset-US-ASCII">
    <title>Registration success</title>
</head>
<body>
<h1> Hi, <%= request.getAttribute("user")%> Registration successful! </h1>
<a href="login.html">Login Page</a>
</body>
</html>
