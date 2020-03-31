<%@ page import="com.boomzy.domain.Comment" %>
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

        .post-content {
            height: 300px;
            width: 100%;
            background-color: #f2f9fc;
        }

        .post-content textarea {
            width: 60%;
            height: 80%;
            margin-top: 20px;
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

        .new-commit {
            color: white;
            border: none;
            border-radius: 3px;
            width: 100%;
            padding-top: 5px;
            padding-bottom: 5px;
            outline: 0;
        }

        .commit {
            width:100px;
            color: skyblue;
            border: none;
            border-radius: 3px;
            padding-top: 5px;
            padding-bottom: 5px;
            outline: 0;
        }

    </style>
</head>
<body>
    <div class="post-content">
        <%--帖子内容--%>
        <textarea readonly="readonly">
<%
    String postContent = (String)session.getAttribute("postContent");
    out.print(postContent);
%>
        </textarea>
    </div>

    <div class="back-forum-home">
        <a href="../post/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>
    </div>

    <hr/>
    <%--帖子评论信息--%>
    <table border="1px">
        <tr>
            <th>评论作者</th>
            <th>评论内容</th>
            <th>发表时间</th>
            <th>回复评论</th>
            <th>查看回复</th>
        </tr>
        <%
            List<Comment> comments = (List<Comment>)session.getAttribute("comments");
            for (Comment comment : comments) {
                if (comment.getCommentReplyId() == null) {
        %>
        <tr>
            <td><%=comment.getCommentAuthor()%></td>
            <td><%=comment.getCommentContent()%></td>
            <td><%=DateUtils.conversionDate(comment.getCreateTime())%></td>
            <td><a href="/game_forum/user/post/reply_comment.jsp?commentId=<%=comment.getCommentId()%>">回复评论</a></td>
            <td><a href="../post/showReplies?commentId=<%=comment.getCommentId()%>">查看该评论的所有回复</a></td>
            <%
                    }
            %>
        </tr>
        <%
            }
        %>
    </table>
    <br/>
    <br/>
    <%
        if (!session.getAttribute("username").equals("tourist")) {
    %>
    <form action="../post/addComment?postContent=<%=session.getAttribute("postContent")%>&gameSectionName=<%=session.getAttribute("gameSectionName")%>" method="post">
        <textarea rows="20px" cols="80px" name="commentContent"></textarea><br/>

        <div class="new-commit">
            <input type="submit" value="发表新的评论" class="commit"/><br/>
        </div>
    </form>
    <%
        }
    %>
</body>
</html>
