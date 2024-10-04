<%--<jsp:useBean id="listMealTo" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 05.10.2024
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<table>
    <c:forEach var="list" items="${listMealTo}">
    <tr>
        <td>Date: ${list.dateTime}</td>
        <td>Description: ${list.description} </td>
        <td>Calories: ${list.calories}</td>
        <td>isExceed: ${list.excess} </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
