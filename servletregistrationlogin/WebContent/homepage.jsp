<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //for 1.1 version
response.setHeader("Expire", "0");
		
%>
</head>

<body>
 <h2>Welcom .This is home page!!!</h2>
 <a href="logout.jsp">Go For LogOut</a>
 <a href="">Profile</a>
 
</body>
</html>