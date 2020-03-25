<%@ page import="com.boomzy.domain.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>板块讨论帖</title>
</head>
<body>
    <%--帖子内容--%>
    <%
        String postContent = (String)request.getAttribute("postContent");
        out.print(postContent);
    %>

    <br/>
    <a href="../admin/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>

    <hr/>
    <%--帖子评论信息--%>
    <table border="1px">
        <tr>
            <th>评论作者</th>
            <th>评论内容</th>
            <th>发表时间</th>
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
</body>
</html>
