<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP Syntax Demo</h1>
	<!-- HTML COMMENT -->
	<%-- JSP Comment --%>
	
	<%-- JSP DECLARATION --%>
	<%! 
		int count = 0;
		public void jspInit(){
			System.out.println("Demo1 jspInit() called. ");
		}
		public void jspDestroy(){
			System.out.println("Demo2 jspDestroy() called. ");
		}
		%>
		<%-- JSP Scriptlet --%>
		
		<%	
			Date now = new Date();
			out.println("Server Time: " + now);
		%>
		
		<br> <br>
		
		<% count++; %>
		<% if(count % 2 == 0) { %>
			Even count: <%= count %>
		<% } else { %>
			Odd count: <%= count %> <%-- JSP Expression --%>
		<% } %>
		<br> <br>
		<%
			if(count % 2 ==0)
				out.println("Even count: " + count);
			else
				out.println("Odd count: " + count);
		%>
</body>
</html>