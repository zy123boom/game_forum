<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/4/1
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码失败</title>
</head>
<body>
    修改密码失败<br/>
    <%
        String failmsg = (String)request.getAttribute("failmsg");
        out.println(failmsg);
    %>
</body>
</html>
