<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="lb" class="jspapp.RegisterBean"/>
<jsp:setProperty name="lb" property="email" param="email"/>
<jsp:setProperty name="lb" property="password" param="passwd"/>
<%lb.save(); %>
<% if(lb.getUser() != null) { %>
	Registration Success. <jsp:getProperty property="email" name="lb"/>
<% } else { %>
	Registration Failed.
<% } %>
</body>
</html>