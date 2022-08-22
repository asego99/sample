<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asego
  Date: 2022/8/10
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="800px" bgcolor="#ffc0cb" align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>money</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${accounts}" var="account">
    <tr align="center">
        <td>${account.id}</td>
        <td>${account.name}</td>
        <td>${account.money}</td>
        <td><a href="/account/toAdd">添加</a> <a href="/account/findById?id=${account.id}">修改</a>
            <a href="javascript:void(0);" onclick="_delete(${account.id})">删除</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>

<script>
    function _delete(id) {
        alert(id);

        let flag = confirm("你确定要删除吗");
        if (flag) {
            location.href = "/account/delete?id=" + id;
        }

    }
</script>
