<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<h3>${initParam.appTitle }</h3>
Hello, ${lb.user.firstName} ${lb.user.lastName } <hr>

<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean" />
<jsp:setProperty name="vb" property="candId" param="candidate" />
<jsp:setProperty name="vb" property="userId" value="${lb.user.id}" />
<c:choose>
	<c:when test="${lb.user.status==0}" >
	${vb.vote()}
	Voted Successfully..!!
	${vb.setStatus() }
	<a href="logout.jsp">Sign Out</a>
	</c:when> 
	<c:otherwise>
		Already Voted!!!
		<a href="logout.jsp">Sign Out</a>
	</c:otherwise>
</c:choose>
</body>
</html>