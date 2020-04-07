<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
<body>
    登陆失败<br/>
    <%
        String failmsg = (String)request.getAttribute("failmsg");
        out.print(failmsg);
    %>
    <br/>
    点击登录页返回登陆页面
    <a href="/game_forum/login.jsp">登录页</a>
</body>
</body>
</html>
