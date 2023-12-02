<%@ page import="model.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: A Ti
  Date: 11/29/2023
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        .container {
            margin-top: 150px;
        }

        h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .logout-link {
            display: inline-block;
            margin-top: 20px;
            padding: 8px 16px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border-radius: 4px;
        }

        .logout-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <% User user = (User)session.getAttribute("user"); %>
    <h2>
        Welcome <%=user.getFirstName()+" "+ user.getLastName()%>
    </h2>

    <%@include file="FormFilter.jsp"%>

    <a class="logout-link" href="user?action=logout">Logout</a>
</div>
</body>
</html>