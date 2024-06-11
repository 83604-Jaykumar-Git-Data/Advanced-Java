<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="lb" class="jspapp.loginBean"/>
	<jsp:setProperty  name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="pass"/>
	
	<%lb.authenticate(); %>
	<% if(lb.getUser() !=null){ %>
		Welcome,<jsp:getProperty  name="lb" property="email"/>
		<jsp:forward page="candlistBean.jsp"/>
	<%}else { %>
	Login Failed
	<%} %>
</body>
</html>