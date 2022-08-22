<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>文件上传</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>传统文件上传</h3>--%>
<%--<form action="/file/mvc/upload" method="post" enctype="multipart/form-data">--%>
<%--    选择文件：<input type="file" name="upload"/><br/>--%>
<%--    <input type="submit" value="上传文件"/>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>远程文件上传</h3>
<form action="/file/remote/upload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传文件"/>
</form>
</body>
</html>