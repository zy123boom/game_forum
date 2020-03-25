<%--
  Created by IntelliJ IDEA.
  User: 赵宇
  Date: 2020/3/13
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户意见反馈</title>
</head>
<body>
    <form action="../../opinion/addOpinion" method="post">
        请发表您的宝贵意见：<input type="text" name="opinionContent">
        <input type="submit" value="发表">
    </form>

</body>
</html>
