<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<html>
<head>
    <title>Meals</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        h3 {
            color: #333;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .value1 {
            background-color: #e7f9e7;
        }
        .value2 {
            background-color: #f9e7e7;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
        }
        input[type="button"] {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 15px;
            cursor: pointer;
        }
        input[type="submit"]:hover,
        input[type="button"]:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<table>
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
        <tr class="${currentMeal.excess ? 'value2' : 'value1'}">
            <td>${currentMeal.dateTime}</td>
            <td>${currentMeal.description}</td>
            <td>${currentMeal.calories}</td>
            <td>
                <form method="get" action="${pageContext.request.contextPath}/updateMeal" style="display:inline;">
                    <input type="hidden" name="id" value="${currentMeal.id}"/>
                    <input type="submit" value="Edit"/>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/deleteMeal" style="display:inline;">
                    <input type="hidden" name="mealId" value="${currentMeal.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<input type="button" value="Add" onclick="window.location.href='addMeal.jsp'">
</body>
</html>
