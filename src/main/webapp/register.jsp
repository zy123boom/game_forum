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
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="login">
    <div class="login-wrapper">
        <div class="login-box">
            <form action="user/register" method="post">
                <p>欢迎注册游戏论坛</p>
                <div class="login-group">
                    用户名：<input type="text" name="userName" class="login-input"/>
                </div>
                <div class="login-group">
                    真实姓名：<input type="text" name="realName" class="login-input"/>
                </div>
                <div class="login-group">
                    密码：<input type="password" name="password" class="login-input"/>
                </div>
                <div class="login-group">
                    确认密码:<input type="password" name="confirmPassword" class="login-input"/>
                </div>

                <div class="login-group">
                    性别：<input type="radio" name="sex" value="男"/>男
                    <input type="radio" name="sex" value="女"/>女
                </div>

                <div class="login-group">
                    邮箱：<input type="text" name="email" class="login-input"/>
                </div>

                <div class="login-group">
                    省份：<input type="text" name="province" class="login-input"/>
                </div>

                <div class="login-group">
                    城市：<input type="text" name="city" class="login-input"/><br/>
                </div>

                <div class="login-group">
                    <input type="submit" value="提交" class="login-submit"/>
                </div>

                <div class="text-foot">
                    已有账号？<a href="/game_forum/login.jsp">去登陆吧</a>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
