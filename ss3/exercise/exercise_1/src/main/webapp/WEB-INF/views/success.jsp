<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 7/20/2023
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h2>Success</h2>
<table>
    <tr>
        <td>Language:</td>
        <td>${emailBox.languages}</td>
    </tr>

    <tr>
        <td>Page Size:</td>
        <td>${emailBox.pageSizes}</td>
    </tr>

    <tr>
        <td>Spams filter:</td>
        <td>${emailBox.spamsFilter}</td>
    </tr>

    <tr>
        <td>Signature:</td>
        <td>${emailBox.signature}</td>
    </tr>
</table>
<a href="/box/update"><button>Return</button></a>
</body>
</html>
