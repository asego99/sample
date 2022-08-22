<%--
  Created by IntelliJ IDEA.
  User: Asego
  Date: 2022/8/9
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<br>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<a href="/hello">点击跳转成功页面</a></br>--%>
<%--<a href="/v">跳转"v"页面</a>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <script>
        $(function () {
            $('#btn').click(function () {
                $.ajax({
                    url: '/json',
                    type: 'post',
                    contentType: 'application/json;charset=utf-8',
                    data: '{"name":"fbb","age":18}',
                    dataType: 'json',
                    success: function (data) {
                        console.log(data)
                    }
                });
            });
        });
    </script>
</head>
<body>
<button type="button" id="btn">发送JSON数据</button>
</body>
</html>