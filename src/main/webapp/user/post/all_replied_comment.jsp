<%@ page import="com.boomzy.domain.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有回复信息</title>
    <link rel="stylesheet" type="text/css" href="../css/table.css">
    <style type="text/css">
        .back-post-content {
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

        .back-post-content a {
            margin-left: 25%;
        }
    </style>
</head>
<body>
    <table border="1px">

        <tr>
            <th>回复内容</th>
            <th>作者</th>
            <th>发表时间</th>
        </tr>
        <%
            List<Comment> replies = (List<Comment>)request.getAttribute("replies");
            for (Comment reply : replies) {
        %>
        <tr>
            <td><%=reply.getCommentContent()%></td>
            <td><%=reply.getCommentAuthor()%></td>
            <td><%=DateUtils.conversionDate(reply.getCreateTime())%></td>
        </tr>
        <%
            }
        %>
    </table>

    <div class="back-post-content">
        <a href="../post/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>
    </div>
</body>
</html>
