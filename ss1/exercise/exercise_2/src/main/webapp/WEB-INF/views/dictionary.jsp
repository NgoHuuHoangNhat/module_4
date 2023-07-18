<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 7/18/2023
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<h3>From Vietnamese To English</h3>
<form action="/dictionary" method="get">
    <label for="input">Input</label>&nbsp;<input type="text" id="input" name="search"><br>
    <button style="margin-top: 20px" type="submit">Submit</button>
</form>
<h3>${result}</h3>


</body>
</html>
