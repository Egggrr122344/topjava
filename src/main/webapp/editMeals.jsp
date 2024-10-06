<jsp:useBean id="mealForEdit" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
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
    <title>Add/Update</title>
</head>
<body>

<%--Отправляем на /meals в метод post--%>
<form action="meals" method="post">
    <input type="hidden" name="id" value="${mealForEdit != null ? mealForEdit.id: ''}">
    <input type="hidden" name="action" value="${mealForEdit != null ? 'update' : 'add'}">

    <label>
       DateTime <input type="datetime-local" name="date" value="${mealForEdit != null ? mealForEdit.dateTime: ''}"/>
    </label>
    <br>
    <br>
    <label>
        Description <input type="text" name="description" value="${mealForEdit != null ? mealForEdit.description: ''}"/>
    </label>
    <br>
    <br>
    <label>
        Calories <input  name="calories" value="${mealForEdit != null ? mealForEdit.calories: ''}"/>
    </label>
    <br>
    <br>
</form>
<input type="submit"  value="OK" onclick="window.location.href = 'meal.jsp'">

</body>
</html>
