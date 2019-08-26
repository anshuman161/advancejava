<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%
 response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");  
 %> 
</head>
<body>

     
      <%
  if(session.getAttribute("email")==null && session.getAttribute("password")==null)
  {
	  response.sendRedirect("loginpage.jsp");
  }
%>
 <form action="logouturl" method="post">
     <input type="submit" value="Confirm-Logout">
      </form>
</body>
</html>