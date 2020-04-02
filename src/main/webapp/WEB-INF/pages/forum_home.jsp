<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游戏论坛主页</title>
    <style type="text/css">
        a {
            text-decoration: none;
        }

        .top-white {
            height: 80px;
            width: 100%;
            background-color: white;
        }

        .top-white .logo {
            height: 100%;
            width: 30%;
            float: left;
            /*
                WEB-INF下访问外部资源
             */
            background-image: url("${pageContext.request.contextPath}/images/logo.jpg");
            background-repeat: no-repeat;
        }

        .top-white .welcome {
            height: 100%;
            width: 20%;
            float: left;
            margin-left: 50%;
            color: #8cc6e5;
        }

        a:visited {
            color: cornflowerblue;
        }

        .major-one {
            height: 400px;
            width: 100%;
            background-color: rgb(36, 40, 51);
            margin: 0;
        }

        .major-one .image-left {
            height: 320px;
            width: 30%;
            float: left;
            margin: 3% 0 3% 2%;
            background-image: url("${pageContext.request.contextPath}/images/lol.jpg");
            background-repeat: no-repeat;
        }

        .major-one .image-middle {
            height: 320px;
            width: 30%;
            float: left;
            margin: 3% 3%;
            background-image: url("${pageContext.request.contextPath}/images/cod.jpg");
            background-repeat: no-repeat;
        }

        .major-one .image-right {
            height: 320px;
            width: 30%;
            float: left;
            margin: 3% 0;
            background-image: url("${pageContext.request.contextPath}/images/pubg.jpg");
            background-repeat: no-repeat;
        }

        .major-two {
            width: 100%;
            background-color: rgb(242,246,252);
            margin: 0;
        }

        .major-two .title {
            font-size: 18px;
            font-family: 楷体;
            color: black;
            font-weight: bold;
            float: left;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        .major-three {
            width: 100%;
            height: 60px;
            background-color: rgb(216,235,249);
        }

        .major-three .opinion {
            height: 100%;
            width: 10%;
            margin: 0 auto;
        }

    </style>
</head>
<body>

    <div class="top-white">
        <div class="top-white logo">
        </div>
        <div class="top-white welcome">
            欢迎您:<a href="../user/showUserInformation?username=<%=session.getAttribute("username")%>">
            <%=session.getAttribute("username")%></a>&nbsp;&nbsp;
            <a href="/game_forum/invalidate.jsp">退出</a>
            <a href="../user/update_password.jsp">修改密码</a>
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

    <div class="major-two">
        <div class="major-two title">选择你喜欢的游戏模块吧</div>
        <div class="major-two content">
            <%
                List<String> games = (List<String>)session.getAttribute("gameSection");
                for (String game : games) {
            %>
            <ul>
                <li><a href="../post/showPost?gameSectionName=<%=game%>"><%=game%></a></li>
            </ul>
            <%
                }
            %>
        </div>
    </div>

    <%
        if (!session.getAttribute("username").equals("tourist")) {
    %>
    <div class="major-three">
        <div class="major-three opinion">
            <a href="opinion/express_opinion.jsp">发表意见</a>
        </div>
    </div>
    <%
        }
    %>
</body>
</html>
