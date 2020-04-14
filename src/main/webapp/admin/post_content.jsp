<%@ page import="com.boomzy.domain.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>板块讨论帖</title>
    <link rel="stylesheet" type="text/css" href="../css/post_content.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="post-content">
        <%--帖子内容--%>
        <textarea readonly="readonly">
<%
    String postContent = (String)request.getAttribute("postContent");
    out.print(postContent);
%>
            </textarea>
    </div>

    <div class="back-forum-home">
        <a href="../admin/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>
    </div>

    <hr/>
    <%--帖子评论信息--%>
    <div class="container">
        <table class="table table-striped">
        <tr>
            <th>评论作者</th>
            <th>评论内容</th>
            <th>发表时间</th>
            <th>查看回复</th>
            <th>删除评论</th>
        </tr>
        <%
            List<Comment> comments = (List<Comment>)request.getAttribute("comments");
            for (Comment comment : comments) {
                if (comment.getCommentReplyId() == null) {
        %>
        <tr>
            <td><%=comment.getCommentAuthor()%></td>
            <td><%=comment.getCommentContent()%></td>
            <td><%=DateUtils.conversionDate(comment.getCreateTime())%></td>
            <td><a href="../post/showReplies?commentId=<%=comment.getCommentId()%>">查看该评论的所有回复</a></td>
            <td><a href="../admin/deleteCommentByCommentId?commentId=<%=comment.getCommentId()%>&postId=<%=comment.getPostId()%>">删除该评论</a></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
        </table>
    </div>
</body>
</html>
