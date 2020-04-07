<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/4/7
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<body>
<head>
    <title>密码重置</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<div class="login">
    <div class="login-wrapper">
        <div class="login-box">
            <form action="../user/updatePasswordByForget" method="post">
                <div class="login-group">
                    用户名：<input type="text" name="username" class="login-input"/>
                </div>

                <div class="login-group">
                    新密码：<input type="password" name="newPassword" class="login-input"/>
                </div>

                <div class="login-group">
                    新密码确认：<input type="password" name="confirmPassword" class="login-input"/>
                </div>

                <div class="login-group">
                    <input type="submit" value="提交修改" class="login-submit"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
