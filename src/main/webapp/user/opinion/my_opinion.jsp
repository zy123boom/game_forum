<%@ page import="com.boomzy.domain.Opinion" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %><%--
  Created by IntelliJ IDEA.
  User: 赵宇
  Date: 2020/3/13
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我提出的意见</title>
    <link rel="stylesheet" type="text/css" href="../css/table.css">
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
    <%--展示我提出的意见--%>
    <table>
        <tr>
            <th>意见内容</th>
            <th>意见回复</th>
            <th>发布时间</th>
        </tr>
        <%
            List<Opinion> opinions = (List<Opinion>)request.getAttribute("opinions");
            for (Opinion opinion : opinions) {
        %>
        <tr>
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
        </tr>
        <%
            }
        %>
    </table>

    <div class="back-forum-home">
        <a href="../user/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
    </div>
</body>
</html>
