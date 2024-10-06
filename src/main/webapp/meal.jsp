<%--<jsp:useBean id="listMealTo" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 05.10.2024
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<html>
<head>
    <title>Meals</title>
</head>
<style>
    .value1 {border-color: #009900}
    .value2 {border-color: #cc0000;}
</style>
<body>
<h3><a href="index.html">Home</a> </h3>
<table border="2" cellpadding="2" cellspacing="0" width="50%">

    <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>



    <jsp:useBean id="listMealTo" scope="request" type="java.util.List<ru.javawebinar.topjava.model.MealTo>"/>

    <c:forEach items="${listMealTo}" var="currentMeal">

        <tr class="${currentMeal.excess ? 'value2' : 'value1' }">
            <td>${currentMeal.dateTime}</td>
            <td>${currentMeal.description}</td>
            <td>${currentMeal.calories}</td>
            <td>
                <a href="addOrUpdateMeal?action=update${currentMeal.id}">Edit</a>
                <a href="addOrUpdateMeal?action=delete${currentMeal.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<br>
<a href="addOrUpdateMeal?action=add">Add</a>

</body>
</html>
