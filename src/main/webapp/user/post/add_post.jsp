<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>发表帖子</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
    <style type="text/css">
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

        .title-input {
            background-color: #f2f9fc;
            color: cornflowerblue;
            border: none;
            border-radius: 3px;
            padding: 15px 20px;
            width: 90%;
            outline: 0;
        }
    </style>
</head>
<body>
<div class="login">
    <div class="login-wrapper">
        <div class="login-box">
            <form action="../../post/addPost" method="post">
                <div class="login-group">
                    文章板块:<br/>
                    <%
                        List<String> gameSections = (List<String>)session.getAttribute("gameSection");
                        for (String gameSection : gameSections) {
                    %>
                    <input type="radio" name="ownedSection" value="<%=gameSection%>"/><%=gameSection%><br/>
                    <%
                        }
                    %>
                </div>

                <div class="login-group">
                    文章题目：<input type="text" name="postSubject" class="title-input"/><br/>
                </div>

                <div class="login-group">
                    文章内容：<textarea name="postContent" cols="30px" rows="20px"></textarea><br/>
                </div>

                <div class="login-group">
                    <input type="submit" value="提交" class="login-submit"><br/>
                </div>

                <div class="back-forum-home">
                    <a href="../../post/showPost?gameSectionName=<%=session.getAttribute("gameSectionName")%>">返回帖子列表</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
