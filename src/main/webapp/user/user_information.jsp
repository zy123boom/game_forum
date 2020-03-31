<%@ page import="com.boomzy.domain.User" %>
<%@ page import="com.boomzy.util.DateUtils" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/31
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="../css/table.css">
    <style type="text/css">
        body {
            margin: 0;
            background-color: rgb(191,225,250);
            /*background-image: url("../images/lol.jpg");*/
            background-size: cover;
            text-align: center;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>用户属性名</th>
            <th>用户属性</th>

        </tr>
        <%
            User user = (User)request.getAttribute("user");
        %>
        <tr>
            <td>用户名</td>
            <td><%=user.getUserName()%></td>
        </tr>
        <tr>
            <td>真实姓名</td>
            <td><%=user.getRealName()%></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><%=user.getSex()%></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><%=user.getEmail()%></td>
        </tr>
        <tr>
            <td>省份</td>
            <td><%=user.getProvince()%></td>
        </tr>
        <tr>
            <td>城市</td>
            <td><%=user.getCity()%></td>
        </tr>
        <tr>
            <td>注册时间</td>
            <td><%=DateUtils.conversionDate(user.getCreateTime())%></td>
        </tr>
    </table>
</body>
</html>
