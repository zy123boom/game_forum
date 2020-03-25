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
</body>
</html>
