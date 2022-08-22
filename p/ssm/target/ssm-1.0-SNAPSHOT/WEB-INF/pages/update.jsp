<%--
  Created by IntelliJ IDEA.
  User: Asego
  Date: 2022/8/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/account/update" method="post">
    <input type="hidden" name="id" value="${account.id}">
    账户名:<input type="text" name="name" value="${account.name}"><br>
    金额:<input type="text" name="money" value="${account.money}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
