<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>游戏论坛登陆界面</title>
    <style type="text/css">
        body {
            background-image: url(images/lol.jpg);
            background-size:cover;
        }
    </style>
</head>
<body>
    <form action="user/login" method="post">
        <fieldset>
            <legend>用户登录</legend>
            用户名：<input type="text" name="username"/><br/>
            密码: <input type="password" name="password"/><br/>
            <input type="submit" value="登录"><br/>
        </fieldset>
    </form>

    <br/>

    <a href="tourist/login">游客登录</a><br/>
    <a href="admin/login.jsp">管理员登录</a><br/>
    <a href="register.jsp">还没有账号？去注册吧</a><br/>
</body>
</html>
