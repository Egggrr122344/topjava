<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 09.10.2024
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add meal</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/addMeal">
        <label>
           DateTime <input type="datetime-local" name="mealDateTime"/>
        </label>

        <br><br>

        <label>
           Description <input type="text" name="mealDescription"/>
        </label>
        <br><br>

        <label>
           Calories <input type="number" name="mealCalories"/>
        </label>

        <br><br>

        <input type="submit" value="OK" name="OK"/>
    </form>
</body>
</html>
