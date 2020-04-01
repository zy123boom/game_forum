
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
    <%
        session.invalidate();
        response.sendRedirect("/game_forum/login.jsp");
    %>
</body>
</html>
