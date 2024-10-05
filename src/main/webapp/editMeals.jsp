<%@ taglib prefix="form" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 06.10.2024
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="meal.jsp" name="reformedMeal">
    <label>
       DateTime <input type="datetime-local" name="date"/>
    </label>
    <br>
    <br>
    <label>
        Description <input name="description"/>
    </label>
    <br>
    <br>
    <label>
        Calories <input name="calories"/>
    </label>
    <br>
    <br>
</form>
<input type="submit"  value="Отправить" onclick="window.location.href= 'meal.jsp'">

</body>
</html>
