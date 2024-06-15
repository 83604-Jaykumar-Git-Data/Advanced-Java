<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>
<h3>${initParam.appTitle}</h3>
<jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean"/>
<jsp:setProperty property="id" name="fcb" param="id"/>
${fcb.fetchCandidate() }
<form action="updatecand.jsp" method="post">
<input type="hidden" name="id" value="${fcb.candidate.id}"/>
<input type="text" name="name" value="${fcb.candidate.name}"/> <br> <br>
<input type="text" name="party" value="${fcb.candidate.party}"/> <br> <br>
<input type="text" name="votes" value="${fcb.candidate.votes}"/> <br> <br>
<input type="submit" value="Update Candidate"/>
</form>
</body>
</html>