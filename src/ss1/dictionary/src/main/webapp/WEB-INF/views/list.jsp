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
<div style="margin-left: 750px">
<h1 style="margin-left: 70px">Từ Điển</h1>
<table style="border: 2px solid;">
<form action="" method="post">
    <tr>
        <td>English</td>
        <td><input type="text" name="word" value="${saveword}"></td>
    </tr>

    <br>
    <tr>
        <td>
            <a>Result:</a>
            ${vietnamese}
        </td>
    </tr>

    <tr>
        <td><input type="submit" name="convert"></td>
    </tr>
</form>
</table>
</div>
</body>
</html>
