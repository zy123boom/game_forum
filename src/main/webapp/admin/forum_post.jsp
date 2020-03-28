<%@ page import="com.boomzy.domain.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/20
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>讨论帖展示</title>
    <link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>
    <table border="1px">
        <tr>
            <th>帖子编号</th>
            <th>帖子标题</th>
            <th>帖子作者</th>
            <th>浏览量</th>
            <th>评论数</th>
            <th>发布时间</th>
            <th>更新时间</th>
            <th>删除帖子选项</th>
        </tr>

        <%
            List<Post> posts = (List<Post>)request.getAttribute("posts");
            for (Post post : posts) {
        %>
        <tr>
            <td><a href="../admin/showPostContent?postId=<%=post.getPostId()%>"><%=post.getPostId()%></a></td>
            <td><%=post.getPostSubject()%></td>
            <td><%=post.getPostAuthor()%></td>
            <td><%=post.getViewCount()%></td>
            <td><%=post.getCommentCount()%></td>
            <td><%=DateUtils.conversionDate(post.getCreateTime())%></td>
            <td><%=DateUtils.conversionDate(post.getUpdateTime())%></td>
            <td><a href="../admin/deletePostByPostId?postId=<%=post.getPostId()%>">删除帖子</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <br/>
    <a href="../admin/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
</body>
</html>
