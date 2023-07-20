<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form modelAttribute="emailBox" action="/box/success" method="post" >
    <table>
        <tr>
            <td>Languages:</td>
            <td>
                <form:select path="languages">
                    <c:forEach var="lang" items="${language}">
                        <form:option value="${lang.name}" label="${lang.name}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Page size:</td>
            <td>
                <form:select path="pageSizes">
                    <c:forEach var="size" items="${pageSize}">
                        <form:option value="${size.size}" label="${size.size}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Spam filter:</td>
            <td><form:checkbox path="spamsFilter" id="spam" label="Enable spams filter"/></td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea rows="4" cols="50" path="signature"/></td>
        </tr>
    </table>
    <form:button>Update</form:button>

</form:form>
</body>
</html>
