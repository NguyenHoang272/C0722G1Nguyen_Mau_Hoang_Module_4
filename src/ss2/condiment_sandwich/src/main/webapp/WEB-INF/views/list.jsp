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
    <title>Title</title>

</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post">
    <input type="checkbox"  value="Lettuce" name="condiment"> Lettuce
    <input type="checkbox"  value="Tomato" name="condiment"> Tomato
    <input type="checkbox"  value="Mustard" name="condiment"> Mustard
    <input type="checkbox"  value="Sprouts" name="condiment">Sprouts
    <input type="submit" value="Save">
</form>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Condiments</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${condiment}" var="data" varStatus="c" >
        <tr>
            <td>${c.count}</td>
            <td>${data}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
