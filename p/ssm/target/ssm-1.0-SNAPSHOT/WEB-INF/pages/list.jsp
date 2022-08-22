<%--
  Created by IntelliJ IDEA.
  User: Asego
  Date: 2022/8/10
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--table>tr*2>td*4tab--%>
<table border="1" width="800" bgcolor="#ffc0cb" align="center">
    <caption><h1>账户管理系统</h1></caption>
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

        var flag = confirm("你确定要删除吗");
        if (flag) {
            //用js方法访问后端代码
            location.href = "/account/delete?id=" + id;
        }
    }
</script>
