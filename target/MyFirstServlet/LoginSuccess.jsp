<%--
  Created by IntelliJ IDEA.
  User: Palak Rubi
  Date: 07-04-2020
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset-US-ASCII">
    <title>Login success page</title>
</head>
<body>
<h1> Hi, <%= request.getAttribute("user")%> Login successful! </h1>
<a href="login.html">Login Page</a>
</body>
</html>
