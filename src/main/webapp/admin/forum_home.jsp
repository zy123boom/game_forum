<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/18
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛主页面（管理员）</title>
    <link rel="stylesheet" type="text/css" href="../css/home.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        .add-game-section {
            height: 300px;
            width: 100%;
            background-color: rgb(191,225,250);
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .add-game-section .add-box {
            height: 75%;
            width: 25%;
            float: left;
            background-color: white;
            margin: 35px 550px;
        }

        .add-box p {
            color: #8cc6e5;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }

        .add-box .add-game {
            background-color: #f2f9fc;
            color: cornflowerblue;
            border: none;
            border-radius: 3px;
            padding: 15px 20px;
            width: 80%;
            margin-left: 10%;
            margin-right: 10%;
            outline: 0;
        }

        .add-game-submit {
            background-color: skyblue;
            color: white;
            border: none;
            border-radius: 3px;
            width: 80%;
            padding-top: 5px;
            padding-bottom: 5px;
            margin-left: 10%;
            margin-right: 10%;
            margin-top: 20px;
            outline: 0;
        }

        .other {
            height: 40px;
            width: 100%;
        }

        .other .show-opinion {
            height: 100%;
            width: 20%;
            float: left;
            margin-left: 30%;
        }

        .show-opinion a {
            height: 100%;
            width: 100px;
            text-decoration: none;
            margin-left: 45%;
        }

        .other .show-user {
            height: 100%;
            width: 20%;
            float: left;
        }

        .show-user a {
            height: 100%;
            width: 100px;
            text-decoration: none;
            margin-left: 45%;
        }
    </style>
</head>
<body>
    <div class="top-white">
        <div class="top-white logo"></div>
        <div class="top-white welcome">
            欢迎您：<%=session.getAttribute("username")%>&nbsp;<a href="/game_forum/invalidate.jsp">注销</a>
        </div>
    </div>

    <div class="major-one">
        <div class="major-one image-left">
        </div>
        <div class="major-one image-middle">
        </div>
        <div class="major-one image-right">
        </div>
    </div>
    <div class="container">
        <table class="table table-striped">
        <tr>
            <th>游戏模块名</th>
            <th>修改游戏模块名选项</th>
            <th>删除游戏模块名选项</th>
            <th>查看板块对应讨论帖</th>
        </tr>
        <%
            List<String> gameSections =  (List<String>)session.getAttribute("gameSection");
            for (String gameSection : gameSections) {
        %>
        <tr>
            <td><%=gameSection%></td>
            <td><a href="../admin/update_game_section_name.jsp?gameSectionName=<%=gameSection%>">修改游戏模块名</a></td>
            <td><a href="../admin/deleteGameSectionName?gameSectionName=<%=gameSection%>">删除游戏模块名</a></td>
            <td><a href="../admin/showPost?gameSectionName=<%=gameSection%>">查看讨论帖</a></td>
        </tr>
        <%
            }
        %>
    </table>
    </div>

    <div class="add-game-section">
        <div class="add-box">
            <p>新增游戏模块名选项</p>
            <form action="../admin/addGameSectionName" method="post">
                <p>请输入要新增的游戏模块：</p>
                <input type="text" name="gameSectionName" class="add-game"/><br/>
                <input type="submit" value="增加" class="add-game-submit"><br/>
            </form>
        </div>
    </div>

    <div class="other">
        <div class="show-opinion">
            <a href="../admin/showUserOpinion">意见管理</a>
        </div>

        <div class="show-user">
            <a href="../admin/showUsers">用户管理</a>
        </div>
    </div>
</body>
</html>
