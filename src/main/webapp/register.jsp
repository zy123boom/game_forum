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
    <style type="text/css">
        body {
            margin: 0;
            background-color: #fbfbfb;
            text-align: center;
        }

        .login {
            text-align: center;
            margin: 60px 0 0 0;
            font-size: 14px;
        }

        .login .login-wrapper {
            -webkit-transition: all 1s;
            -o-transition: all 1s;
            transition: all 1s;
            -webkit-perspective: 1000px;
            perspective: 1000px;
            position: relative;
            height: 100%;
            width: 360px;
            margin: 0 auto;
        }

        .login .login-wrapper .login-box {
            background-color: #fff;
            -webkit-box-shadow: 0 7px 25px rgba(0, 0, 0, .08);
            box-shadow: 0 7px 25px rgba(0, 0, 0, .08);
            padding: 60px 25px 25px 25px;
            text-align: left;
            border-radius: 3px;
        }

        .login .login-box .login-group {
            margin-bottom: 30px;
        }

        .login .login-box .login-input {
            background-color: #f2f9fc;
            color: cornflowerblue;
            border: none;
            border-radius: 3px;
            padding: 10px 10px;
            width: 100%;
            outline: 0;
        }
        .login .login-box p{
            color: cornflowerblue;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }

        .login .login-box .login-submit {
            background-color: skyblue;
            color: white;
            border: none;
            border-radius: 3px;
            width: 100%;
            padding-top: 5px;
            padding-bottom: 5px;
            outline: 0;
        }
    </style>
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
            </form>
            <a href="/game_forum/login.jsp">已有账号？去登陆吧</a>
        </div>
    </div>
</div>

</body>
</html>
