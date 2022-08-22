<%--
  Created by IntelliJ IDEA.
  User: Asego
  Date: 2022/8/8
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="hello">点我跳转到后台</a>
<form action="/hello" method="post">
    <div>
        名字：<input name="name" >
    </div>
    <div>
        年龄：<input name="age" >
    </div>
    <div>
        身份证号：<input name="idCard.number" >
    </div>
    <div>
        地址：<input name="idCard.address" >
    </div>
    <div>
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>
