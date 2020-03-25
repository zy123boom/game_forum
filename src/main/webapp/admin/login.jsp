<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/18
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录页面</title>
</head>
<body>
    <form action="../admin/login" method="post">
        用户名：<input type="text" name="username" /><br/>
        密码：<input type="password" name="password" /><br/>
        <input type="submit" value="登录"/><br/>
    </form>
</body>
</html>
