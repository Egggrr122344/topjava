<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Meal</title>
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
<form method="post" action="${pageContext.request.contextPath}/addMeal">
    <label>
        DateTime <input type="datetime-local" name="mealDateTime" required/>
    </label>
    <label>
        Description <input type="text" name="mealDescription" required/>
    </label>
    <label>
        Calories <input type="number" name="mealCalories" required/>
    </label>
    <input type="submit" value="OK" name="OK"/>
</form>
</body>
</html>
