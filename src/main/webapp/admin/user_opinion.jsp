<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.domain.Opinion" %>
<%@ page import="com.boomzy.util.DateUtils" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/25
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户意见展示</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background-color: rgb(216,235,249);
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

        .back-forum-home a {
            text-decoration: none;
            margin-left: 32%;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <th>意见发表人</th>
            <th>意见内容</th>
            <th>意见回复</th>
            <th>发表时间</th>
            <th>回复意见</th>
        </tr>
        <%
            List<Opinion> opinions = (List<Opinion>)session.getAttribute("opinions");
            for (Opinion opinion : opinions) {
        %>
        <tr>
            <td><%=opinion.getOpinionAuthor()%></td>
            <td><%=opinion.getOpinionContent()%></td>
            <%
                if (null == opinion.getOpinionReply()) {
            %>
            <td>未回复</td>
            <%
                } else {
            %>
            <td><%=opinion.getOpinionReply()%></td>
            <%
                }
            %>
            <td><%=DateUtils.conversionDate(opinion.getCreateTime())%></td>
            <%
                if (null == opinion.getOpinionReply()) {
            %>
            <td><a href="../admin/opinion_reply.jsp?opinionId=<%=opinion.getOpinionId()%>">回复意见</a> </td>
            <%
                } else {
            %>
            <td>意见已回复</td>
            <%
                }
            %>
        </tr>
        <%

            }
        %>
    </table>
</div>

    <div class="back-forum-home">
        <a href="../admin/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
    </div>
</body>
</html>
