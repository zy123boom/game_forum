<%--
  Created by IntelliJ IDEA.
  User: 赵宇
  Date: 2020/2/27
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游戏论坛用户注册</title>
</head>
<body>
    <form action="user/register" method="post">
        用户名：<input type="text" name="userName"/><br/>
        真实姓名：<input type="text" name="realName"/><br/>
        密码：<input type="password" name="password"/><br/>
        确认密码:<input type="password" name="confirmPassword" /><br/>
        性别：<input type="radio" name="sex" value="男"/>男
            <input type="radio" name="sex" value="女"/>女 <br/>
        邮箱：<input type="text" name="email"/><br/>
        省份：<input type="text" name="province"/><br/>
        城市：<input type="text" name="city"/><br/>
        <input type="submit" value="提交" /><br/>
    </form>

    <a href="/game_forum/login.jsp">已有账号？去登陆吧</a>
</body>
</html>
