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
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
    <body>
        <div class="login">
            <div class="login-wrapper">
                <div class="login-box">
                    <form action="../admin/login" method="post">
                        <p>欢迎登录游戏论坛</p>
                        <div class="login-group">
                            用户名：<input type="text" name="username" class="login-input"/>
                        </div>

                        <div class="login-group login-password">
                            密码: <input type="password" name="password" class="login-input"/>
                        </div>

                        <div class="login-group login-submit">
                            <input type="submit" value="登录" class="login-submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
