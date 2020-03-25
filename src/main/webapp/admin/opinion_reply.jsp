<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/25
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>意见回复</title>
</head>
<body>
    <%
        String opinionId = request.getParameter("opinionId");
    %>
    <form action="../admin/addOpinionReply?opinionId=<%=opinionId%>" method="post">
        请输入要回复的意见：<input type="text" name="opinionReply"/><br/>
        <input type="submit" value="回复"/><br/>
    </form>
</body>
</html>
