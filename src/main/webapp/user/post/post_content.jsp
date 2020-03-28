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
        String postContent = (String)session.getAttribute("postContent");
        out.print(postContent);
    %>

    <br/>
    <a href="../post/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>

    <hr/>
    <%--帖子评论信息--%>
    <table border="1px">
        <tr>
            <th>评论作者</th>
            <th>评论内容</th>
            <th>发表时间</th>
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
        <textarea rows="25px" cols="50px" name="commentContent" ></textarea><br/>
        <input type="submit" value="发表新的评论"/><br/>
    </form>
    <%
        }
    %>
</body>
</html>
