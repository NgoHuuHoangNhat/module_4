<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 7/19/2023
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sandwich Condiments </title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/condiment/select" method="post">
  <label for="lettuce"><input type="checkbox" id="lettuce" name="condiment" value="Lettuce">Lettuce</label>
  <label for="tomato"><input type="checkbox" id="tomato" name="condiment" value="Tomato">Tomato</label>
  <label for="mustard"><input type="checkbox" id="mustard" name="condiment" value="Mustard">Mustard</label>
  <label for="sprouts"><input type="checkbox" id="sprouts" name="condiment" value="Sprouts">Sprouts</label>
  <button type="submit" value="Submit">Submit</button>
</form>
</body>
</html>
