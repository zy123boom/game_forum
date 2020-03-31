<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/16
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回复帖子</title>
</head>
<body>
    <%
        String commentId = request.getParameter("commentId");
    %>
    <form action="../../post/addReply?commentId=<%=commentId%>&gameSectionName=<%=session.getAttribute("gameSectionName")%>" method="post">
        请输入您的回复： <input type="text" name="replyContent"><br/>
        <input type="submit" value="提交"><br/>
    </form>
</body>
</html>
