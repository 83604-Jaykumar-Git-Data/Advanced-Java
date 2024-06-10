<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input</title>
</head>
<body>
<h2>NEW USER</h2>
<form action="register.jsp" method="post">
First Name:<input type="text" name="firstname"/><br><br>
Last Name:<input type="text" name="lastname"/><br><br>
Email: <input type="text" name="email"/> <br> <br>
Password: <input type="password" name="passwd" /> <br><br>
DOB:<input type="Date" name="date" /><br><br> 
Status:<input type="number" value=0 readonly><br><br>
Role:<input type="text" value="voter" readonly><br><br>	
	<input type="submit" value="Sign Up"/>
	</form>
</body>
</html>