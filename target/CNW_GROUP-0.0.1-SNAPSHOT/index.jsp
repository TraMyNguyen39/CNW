<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hi all!
	<a href="TestController">Di test</a>
	<% String mess = (String)request.getAttribute("test"); %>
	<span><%=mess %></span>
</body>
</html>