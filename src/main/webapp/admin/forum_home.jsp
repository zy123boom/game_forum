<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/18
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛主页面（管理员）</title>
    <link rel="stylesheet" type="text/css" href="../css/home.css">
    <link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>
    <div class="top-white">
        <div class="top-white logo"></div>
        <div class="top-white welcome">
            欢迎您：<%=session.getAttribute("username")%>&nbsp;<a href="/game_forum/invalidate.jsp">注销</a>
        </div>
    </div>

    <div class="major-one">

    </div>
    <table border="1px">
        <tr>
            <th>游戏模块名</th>
            <th>修改游戏模块名选项</th>
            <th>删除游戏模块名选项</th>
            <th>查看板块对应讨论帖</th>
        </tr>
        <%
            List<String> gameSections =  (List<String>)session.getAttribute("gameSection");
            for (String gameSection : gameSections) {
        %>
        <tr>
            <td><%=gameSection%></td>
            <td><a href="../admin/update_game_section_name.jsp?gameSectionName=<%=gameSection%>">修改游戏模块名</a></td>
            <td><a href="../admin/deleteGameSectionName?gameSectionName=<%=gameSection%>">删除游戏模块名</a></td>
            <td><a href="../admin/showPost?gameSectionName=<%=gameSection%>">查看讨论帖</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <br/>
    <br/>
    <br/>
    新增游戏模块名选项<br/>
    <form action="../admin/addGameSectionName" method="post">
        请输入要新增的游戏模块：<input type="text" name="gameSectionName"/><br/>
        <input type="submit" value="增加"><br/>
    </form>

    <br/>
    <a href="../admin/showUserOpinion">查看用户意见</a>
</body>
</html>
