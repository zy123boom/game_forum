<%--
  Created by IntelliJ IDEA.
  User: boomzy
  Date: 2020/3/19
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改游戏模块</title>
    <style type="text/css">
        .update-game-section {
            -webkit-transition: all 1s;
            -o-transition: all 1s;
            transition: all 1s;
            -webkit-perspective: 1000px;
            perspective: 1000px;
            position: relative;
            height: 600px;
            width: 450px;
            margin: 50px auto;
        }

        .update-game-section p {
            color: #8cc6e5;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }

        .update-game-section .update-box {
            height: 60%;
            width: 100%;
            background-color: #fff;
            -webkit-box-shadow: 0 7px 25px rgba(0, 0, 0, .08);
            box-shadow: 0 7px 25px rgba(0, 0, 0, .08);
            padding: 60px 25px 25px 25px;
            text-align: left;
            float: left;
            border-radius: 3px;
        }

        .update-game-section .update-game-section-input {
            background-color: #f2f9fc;
            color: cornflowerblue;
            border: none;
            border-radius: 3px;
            padding: 15px 20px;
            width: 100%;
            outline: 0;
        }

        .update-game-section .update-game-section-submit {
            background-color: skyblue;
            color: white;
            border: none;
            border-radius: 3px;
            width: 50%;
            padding-top: 5px;
            padding-bottom: 5px;
            margin-top: 40px;
            margin-left: 25%;
            outline: 0;
        }
    </style>
</head>
<body>
    <%
        String gameSectionName = request.getParameter("gameSectionName");
    %>
    <div class="update-game-section">
        <div class="update-game-section update-box">
            <form action="../admin/updateGameSectionName?oldGameSectionName=<%=gameSectionName%>" method="post">
                <p>请输入修改后的游戏模块名：</p>
                <input type="text" name="newGameSectionName" class="update-game-section-input"/>
                <input type="submit" value="修改" class="update-game-section-submit"/>
            </form>
        </div>
    </div>
</body>
</html>
