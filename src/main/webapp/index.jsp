<%--
  Created by IntelliJ IDEA.
  User: 赵宇
  Date: 2020/2/24
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="user/findAll">测试</a>

    <form action="user/save" method="post">
        用户名：<input type="text" name="userName"><br/>
        真实姓名：<input type="text" name="realName"><br/>
        密码：<input type="text" name="password"><br/>
        性别：<input type="text" name="sex"><br/>
        邮箱：<input type="text" name="email"><br/>
        省份：<input type="text" name="province"><br/>
        城市：<input type="text" name="city"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
