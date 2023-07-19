<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 7/19/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Select Sandwich Condiments</title>
</head>
<body>
<h1>Select Sandwich Condiments</h1>
<c:if test="${list != null}">
<table>
    <thead>
    <th>STT</th>
    <th>Select</th>
    </thead>
    <c:forEach var="condiments" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${condiments}</td>
        </tr>
    </c:forEach>
</table>
</c:if>
<c:if test="${msg != null}">
    <h2>${msg}</h2>
</c:if>
<a href="/condiment/list">Return</a>

</body>
</html>
