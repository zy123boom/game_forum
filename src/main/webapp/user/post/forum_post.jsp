<%@ page import="com.boomzy.domain.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>板块讨论帖</title>
<%--    <link rel="stylesheet" type="text/css" href="../css/table.css">--%>
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

        .back-forum-home {
            background-color: skyblue;
            color: black;
            border: none;
            border-radius: 3px;
            width: 200px;
            padding-top: 5px;
            padding-bottom: 5px;
            margin: 50px auto;
            outline: 0;
        }
    </style>
</head>
<body>

    <div class="container">
    <table class="table table-striped">
        <caption><h3>帖子列表</h3></caption>
        <tr>
            <th>帖子标题</th>
            <th>帖子作者</th>
            <th>浏览量</th>
            <th>评论数</th>
            <th>发布时间</th>
        </tr>

        <%
            List<Post> posts = (List<Post>)session.getAttribute("posts");
            for (Post post : posts) {
        %>
        <tr>
            <%--<td><a href="../post/showPostContent?postId=<%=post.getPostId()%>"><%=post.getPostId()%></a></td>--%>
            <td><a href="../post/showPostContent?postId=<%=post.getPostId()%>"><%=post.getPostSubject()%></a></td>
            <td><%=post.getPostAuthor()%></td>
            <td><%=post.getViewCount()%></td>
            <td><%=post.getCommentCount()%></td>
            <td><%=DateUtils.conversionDate(post.getCreateTime())%></td>
        </tr>
        <%
            }
        %>
    </table>
    </div>

    <br/>
    <br/>
    <br/>

    <%
        List<Post> hotPosts = (List<Post>)session.getAttribute("hotPosts");
        if (hotPosts.size() > 0) {
    %>
    <div class="container">
    <table class="table table-striped">
        <caption><h3>热帖列表</h3></caption>
        <tr>
            <th>帖子标题</th>
            <th>帖子作者</th>
            <th>发布时间</th>
            <th>更新时间</th>
        </tr>

        <%

            for (Post hotPost : hotPosts) {
        %>
        <tr>
            <%--<td><a href="../post/showPostContent?postId=<%=post.getPostId()%>"><%=post.getPostId()%></a></td>--%>
            <td><a href="../post/showPostContent?postId=<%=hotPost.getPostId()%>"><%=hotPost.getPostSubject()%></a></td>
            <td><%=hotPost.getPostAuthor()%></td>
            <td><%=DateUtils.conversionDate(hotPost.getCreateTime())%></td>
            <td><%=DateUtils.conversionDate(hotPost.getUpdateTime())%></td>
        </tr>
        <%
            }
        %>
    </table>
    </div>
    <%
        }
    %>



    <%
        if (!session.getAttribute("username").equals("tourist")) {
    %>
    <div class="back-forum-home">
        <a href="../user/post/add_post.jsp">发表新帖</a><br/>
    </div>
    <%
        }
    %>

    <div class="back-forum-home">
        <a href="../user/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
    </div>
</body>
</html>
