<%--<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>--%>

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
    <title>Add/Update Meal</title>
</head>
<body>

<h3>${meal.id == 0 ? 'Add New Meal' : 'Edit Meal'}</h3>

<%--Отправляем addServlet в метод post--%>
<form action="${pageContext.request.contextPath}/updateMeal" method="post" >
    <input type="hidden" name="id" value="${forUpdateMeal.id}">

    <label>
       DateTime <input type="datetime-local" name="dateTime" value="${forUpdateMeal.dateTime}"/>
    </label>
    <br>
    <br>
    <label>
        Description <input type="text" name="description" value="${forUpdateMeal.description}" required/>
    </label>
    <br>
    <br>
    <label>
        Calories <input  name="calories" value="${forUpdateMeal.calories}" required/>
    </label>
    <br>
    <br>
    <input type="submit" value="Save"/>
</form>

</body>
</html>
