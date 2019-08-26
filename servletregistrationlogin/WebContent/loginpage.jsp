<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>LogIn Page</h2>
        <form action="loginController" method="post">
        <table>
        <tr><td>Email</td><td><input type="email" name="email" required></td></tr>
        <tr><td>Password</td><td><input type="password" name="password" required></td></tr>
        <tr><td><input type="submit" value="login"></td></tr>
        </table>
        </form>
</body>
       
</html>