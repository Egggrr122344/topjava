<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>User</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>User = ${requestScope.status == 1 ? "Admin" : "User"}</h2>
</body>
</html>