<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/18/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Simple Computer</title>

</head>
<body>
<form action="result" method="get" >
    <h2>Simple Computer</h2>
    <input type="number" name="number1">
    <input type="number" name="number2">
    <br><br>
    <button type="submit" value="add" name="operation">Addation(+)</button>
    <button type="submit" value="sub" name="operation">Subtraction(-)</button>
    <button type="submit" value="mul" name="operation">Multiplication(*)</button>
    <button type="submit" value="div" name="operation">Division(/ )</button>
</form>
<p>Result : ${result}</p>
</body>
</html>
