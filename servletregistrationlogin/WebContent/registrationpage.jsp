<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<centre>
 <h2 style="color: red;">Registration Page</h2>
 <form action="registrationController" method="post">
    <table>
          <tr> <td>UserName</td> <td><input type="text" name="username" required></td></tr>
          <tr> 
               <td>Gender</td><td><input type="text" name="gender" required></i></td>
          </tr>
          <tr> <td>Phone No</td> <td><input type="text" name="phoneno" required></td></tr>
          <tr> <td>Email </td> <td><input type="email" name="email" required></td></tr>
          <tr> <td>Password</td> <td><input type="password" name="password" required></td></tr>
           <tr><td><input type="submit" value="Submit"></td> </tr>                                             
    </table>
 </form>
 </centre>
</body>
</html>