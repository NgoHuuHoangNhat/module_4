<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator/result" method="post">
  <table>
    <tr>
      <td>First Number</td>
      <td><input type="number" id="firstNumber" name="firstNumber" value="${firstNumber}"></td>
    </tr>

    <tr>
      <td>Second Number</td>
      <td><input type="number" id="secondNumber" name="secondNumber" value="${secondNumber}"></td>
    </tr>
  </table>
  <button type="submit" name="operator" value="+">Addition(+)</button>
  <button type="submit" name="operator" value="-">Subtraction(-)</button>
  <button type="submit" name="operator" value="*">Multiplication(*)</button>
  <button type="submit" name="operator" value="/">Division(/)</button>
</form>
<c:if test="${result != null}">
  <h2>Result: ${result}</h2>
</c:if>
<c:if test="${err != null}">
  <h2>${err}</h2>
</c:if>
</body>
</html>
