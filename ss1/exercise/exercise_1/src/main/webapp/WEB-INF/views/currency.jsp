<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 7/18/2023
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chuyển Đổi Tiền Tệ</title>
</head>
<body>
<h1>Chuyển Đổi Tiền Tệ</h1>
<form action="/currency" method="get">
    <label>Nhập số tiền(USD)</label><input type="number" name="usd" placeholder="usd" value="${usd}" REQUIRED><br>
    <label>Nhập tỉ giá</label><input type="number" name="rate" placeholder="rate" value="${rate}"REQUIRED><br>
    <button>Tính</button>
</form>
<div>${vnd} ${result}</div>
</body>
</html>
