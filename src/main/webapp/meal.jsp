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
<body>
<h3><a href="index.html">Home</a> </h3>
<table border="1" cellpadding="2" cellspacing="0" width="50%">

    <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
    </thead>
    <tbody>



    <jsp:useBean id="listMealTo" scope="request" type="java.util.List"/>
    <c:forEach items="${listMealTo}" var="meals">
        <tr>
            <td>${meals.dateTime}</td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<br>
<input type="submit" value="add" onclick="window.location.href='editMeals.jsp' "  />

</body>
</html>
