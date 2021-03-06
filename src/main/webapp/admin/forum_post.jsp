<%@ page import="com.boomzy.domain.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %>
<%@ page import="com.boomzy.enums.SensitiveEnum" %><%--
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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            margin: 0;
            background-color: rgb(191,225,250);
            /*background-image: url("../images/lol.jpg");*/
            background-size: cover;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <th>帖子编号</th>
            <th>帖子标题</th>
            <th>帖子作者</th>
            <th>浏览量</th>
            <th>评论数</th>
            <th>发布时间</th>
            <th>更新时间</th>
            <th>敏感性</th>
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
            <%
                if (post.getSensitive().equals(SensitiveEnum.NOT_SENSITIVE_POST.getCode())) {
            %>
            <td>非敏感</td>
            <%
                } else if (post.getSensitive().equals(SensitiveEnum.SENSITIVE_POST.getCode())) {
            %>
            <td style="background-color: darkred">疑似敏感帖</td>
            <%
                }
            %>
            <td><a href="../admin/deletePostByPostId?postId=<%=post.getPostId()%>">删除帖子</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
    <br/>
    <a href="../admin/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
</body>
</html>
