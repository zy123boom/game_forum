<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游戏论坛主页</title>
</head>
<body>
    欢迎您：<%=session.getAttribute("username")%>&nbsp;<a href="/game_forum/invalidate.jsp">注销</a><br/>

    <b>选择你喜欢的游戏模块吧</b><br/>
    <%
        List<String> games = (List<String>)session.getAttribute("gameSection");
        for (String game : games) {
    %>
    <ul>
        <li><a href="../post/showPost?gameSectionName=<%=game%>"><%=game%></a></li>
    </ul>
    <%
        }
    %>

    <%
        if (session.getAttribute("username") != "tourist") {
    %>
    <a href="opinion/express_opinion.jsp">发表意见</a>
    <%
        }
    %>
</body>
</html>
