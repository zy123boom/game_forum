<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>发表帖子</title>
</head>
<body>

    <form action="../../post/addPost" method="post">
        文章板块:
        <%
            List<String> gameSections = (List<String>)session.getAttribute("gameSection");
            for (String gameSection : gameSections) {
        %>
        <input type="radio" name="ownedSection" value="<%=gameSection%>"/><%=gameSection%><br/>
        <%
            }
        %>
        文章题目：<input type="text" name="postSubject" /><br/>
        文章内容：<input type="text" name="postContent"/><br/>
        <input type="submit" value="提交"><br/>
        <a href="../../post/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>
    </form>
</body>
</html>
