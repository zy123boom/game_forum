<%@ page import="com.boomzy.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomzy.util.DateUtils" %>
<%@ page import="com.boomzy.enums.UserTypeEnum" %>
<%@ page import="com.boomzy.domain.DarkUser" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/4/1
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理（用户信息）</title>
    <link rel="stylesheet" type="text/css" href="../css/table.css">
    <style type="text/css">
        body {
            margin: 0;
            background-color: rgb(191,225,250);
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

        .back-forum-home a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <p>所有用户</p>
    <table>
        <tr>
            <th>用户名</th>
            <th>真实姓名</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>省份</th>
            <th>城市</th>
            <th>注册时间</th>
            <th>是否失效</th>
            <th>封号</th>
        </tr>
        <%
            List<User> users = (List<User>)request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <td><%=user.getUserName()%></td>
            <td><%=user.getRealName()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getProvince()%></td>
            <td><%=user.getCity()%></td>
            <td><%=DateUtils.conversionDate(user.getCreateTime())%></td>
            <%
                if (user.getUserType().equals(UserTypeEnum.NORMAL_USER.getCode())) {
            %>
            <td>否</td>
            <%
                } else if (user.getUserType().equals(UserTypeEnum.INVALID.getCode())) {
            %>
            <td><a href="../admin/deleteUser?username=<%=user.getUserName()%>">是，可删除</a></td>
            <%
                }
            %>
            <td><a href="../admin/addUserInDarkHouse?username=<%=user.getUserName()%>">封号</a></td>
        </tr>
        <%
            }
        %>
    </table>

    <br/>
    <br/>
    <br/>

    <p>黑名单</p>
    <table>
        <tr>
            <th>用户名</th>
            <th>解封时间</th>
            <th>解封</th>
        </tr>
        <%
            List<DarkUser> darkUsers = (List<DarkUser>)request.getAttribute("darkUsers");
            for (DarkUser darkUser : darkUsers) {
        %>
        <tr>
            <td><%=darkUser.getDarkName()%></td>
            <td><%=DateUtils.conversionDate(darkUser.getUnblockTime())%></td>
            <td><a href="../admin/deleteFromDarkHome?darkName=<%=darkUser.getDarkName()%>">解封</a></td>
        </tr>
        <%
            }
        %>
    </table>

    <div class="back-forum-home">
        <a href="../admin/login?username=<%=session.getAttribute("username")%>&password=<%=session.getAttribute("password")%>">返回主页面</a>
    </div>
</body>
</html>
