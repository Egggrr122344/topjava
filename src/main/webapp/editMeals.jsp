<%@ taglib prefix="form" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add/Update Meal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            width: 300px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h3>${meal.id == 0 ? 'Add New Meal' : 'Edit Meal'}</h3>
<form action="${pageContext.request.contextPath}/updateMeal" method="post">
    <input type="hidden" name="id" value="${forUpdateMeal.id}">
    <label>
        DateTime <input type="datetime-local" name="dateTime" value="${forUpdateMeal.dateTime}" required/>
    </label>
    <label>
        Description <input type="text" name="description" value="${forUpdateMeal.description}" required/>
    </label>
    <label>
        Calories <input type="number" name="calories" value="${forUpdateMeal.calories}" required/>
    </label>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
