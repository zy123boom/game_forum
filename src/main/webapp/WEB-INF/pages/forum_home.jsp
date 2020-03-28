<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游戏论坛主页</title>
    <style type="text/css">
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
            width: 15%;
            float: left;
            margin-left: 55%;
            color: #8cc6e5;
        }

        a:visited {
            color: cornflowerblue;
        }

        .major-one {
            height: 400px;
            width: 100%;
            background-color: rgb(36, 40, 51);
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
    </style>
</head>
<body>

    <div class="top-white">
        <div class="top-white logo">
        </div>
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

    <b>选择你喜欢的游戏模块吧</b><br/>
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

    <%
        if (session.getAttribute("username") != "tourist") {
    %>
    <a href="opinion/express_opinion.jsp">发表意见</a>
    <%
        }
    %>
</body>
</html>
