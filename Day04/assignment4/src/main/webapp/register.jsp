<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="n" class="jspapp.RegisterBean"/>
	<jsp:setProperty  name="n" property="firstName" param="firstname"/>
	<jsp:setProperty name="n" property="lastName" param="lastname"/>
	<jsp:setProperty  name="n" property="email" param="email"/>
	<jsp:setProperty name="n" property="password" param="pass"/>
	<jsp:setProperty name="n" property="birth" param="dob"/>
	
	<%n.register(); %>
	<% if(n.getCnt() !=0){ %>
		Welcome,<jsp:getProperty  name="n" property="firstName"/>
		<a href="index.jsp">Login</a>
		
	<%}else { %>
	Registration Failed
	<%} %>
</body>
</html>