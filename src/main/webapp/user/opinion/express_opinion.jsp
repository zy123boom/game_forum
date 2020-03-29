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
    <style type="text/css">
        body {
            margin: 0;
            background-color: rgb(191,225,250);
            background-size: cover;
            text-align: center;
        }

        .opinion {
            text-align: center;
            margin: 60px 0 0 0;
            font-family: 'Segoe UI';
            font-size: 14px;
        }

        .opinion .opinion-wrapper {
            -webkit-transition: all 1s;
            -o-transition: all 1s;
            transition: all 1s;
            -webkit-perspective: 1000px;
            perspective: 1000px;
            position: relative;
            height: 100%;
            width: 360px;
            margin: 0 auto;
        }

        .opinion .opinion-wrapper .opinion-box {
            background-color: #fff;
            -webkit-box-shadow: 0 7px 25px rgba(0, 0, 0, .08);
            box-shadow: 0 7px 25px rgba(0, 0, 0, .08);
            padding: 60px 25px 25px 25px;
            text-align: left;
            border-radius: 3px;
        }

        .comment-opinion {
            height: 200px;
            width: 100%;
        }

        .comment-opinion textarea {
            height: 80%;
            width: 100%;
            font-family: 楷体;
            font-size: 18px;
            background-color: rgb(242,249,252);
        }

        .opinion-box .opinion-commit {
            background-color: skyblue;
            color: black;
            border: none;
            border-radius: 3px;
            width: 100%;
            padding-top: 5px;
            padding-bottom: 5px;
            margin-top: 10px;
            outline: 0;
        }

        .comment-opinion p {
            color: #8cc6e5;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="opinion">
        <div class="opinion-wrapper">
            <div class="opinion-box">
                <form action="../../opinion/addOpinion" method="post">
                    <div class="comment-opinion">
                        <p>请发表您的宝贵意见：</p>
                        <textarea name="opinionContent"></textarea>
                    </div>

                    <div class="opinion-commit">
                        <input type="submit" value="发表" class="opinion-commit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
