<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/19
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改游戏模块</title>
</head>
<body>
    <%
        String gameSectionName = request.getParameter("gameSectionName");
    %>
    <form action="../admin/updateGameSectionName?oldGameSectionName=<%=gameSectionName%>" method="post">
        请输入修改后的游戏模块名：<input type="text" name="newGameSectionName"/><br/>
        <input type="submit" value="修改"/><br/>
    </form>
</body>
</html>
