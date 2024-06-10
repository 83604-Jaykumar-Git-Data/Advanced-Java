<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Error Page</h3>
	Some error occurred. Please contact your vendor. <br>
	Email: test@gmail.com <br><br>
	Error: <%= exception.getMessage() %>

</body>
</html>