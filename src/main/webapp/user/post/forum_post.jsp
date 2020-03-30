<%@ page import="com.boomzy.domain.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>板块讨论帖</title>
    <link rel="stylesheet" type="text/css" href="../css/table.css">
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
            margin: 30px auto;
            outline: 0;
        }
    </style>
</head>
<body>
    <table border="1px">
        <tr>
            <th>帖子标题</th>
            <th>帖子作者</th>
            <th>浏览量</th>
            <th>评论数</th>
            <th>发布时间</th>
            <th>更新时间</th>
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
            <td><%=DateUtils.conversionDate(post.getUpdateTime())%></td>
        </tr>
        <%
            }
        %>
    </table>

    <div class="back-forum-home">
        <%
            if (!session.getAttribute("username").equals("tourist")) {
        %>
        <a href="../user/post/add_post.jsp">发表新帖</a><br/>
        <%
            }
        %>
    </div>

    <div class="back-forum-home">
        <a href="../user/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
    </div>
</body>
</html>
