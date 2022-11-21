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
<h2>Chuyển Đổi Tiền Tệ</h2>
<table style="border: 10px ">

<form action="" method="post">
    <tr>
        <td>USD</td>
        <td><input type="number" name="usd" value="${saveusd}"></td>
    </tr>
    <tr>
        <td>Rate</td>
        <td><input type="number" name="rate" value="${saverate}"></td>
    </tr>

    <tr>
        <td><input type="submit" name="convert"></td>
    </tr>
    <br>
    <tr>
        <td>
            <a>Result:</a>
            ${vnd} VND
        </td>
    </tr>
</form>
</table>
</body>
</html>
