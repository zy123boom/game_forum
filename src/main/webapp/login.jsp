<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游戏论坛登陆界面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="login">
    <div class="login-wrapper">
        <div class="login-box">
            <form action="user/login" method="post">
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
    <div class="a1"><a href="tourist/login">游客登录</a></div>

    <a href="admin/login.jsp">管理员登录</a><br/>
    <a href="register.jsp">还没有账号？去注册吧</a><br/>
</body>
</html>
