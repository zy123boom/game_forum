<%--
  Created by IntelliJ IDEA.
  User: 赵宇
  Date: 2020/3/11
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增评论失败</title>
</head>
<body>
    评论失败<br/>
    <%
        String failmsg = (String)request.getAttribute("failmsg");
        out.println(failmsg);
    %>
</body>
</html>
