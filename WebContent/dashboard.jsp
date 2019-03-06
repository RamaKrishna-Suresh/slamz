<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/public/header.jsp" %>
<meta charset="UTF-8">
</head>
<body>
Welcome ${activeUser.name}

<div class="ba br3 bw2 w-30">
	<div class="bb"><div class="w-50 center">Your questions ... </div></div>
	<c:forEach var="question" items="${questionContents}">
		<div>${question}</div>
	</c:forEach>
</div>
<div>
	<button onclick="window.location.href='${context}/editQuestions.jsp'">EDIT</button>
</div>

<div class="ba br3 bw2 w-30">
	<div class="bb"><div class="w-50 center">Your Invitations ... </div></div>
	<c:forEach var="invite" items="${invites}">
		<div>${invite.fromUser.name} (${invite.fromUser.email})</div>
	</c:forEach>
</div>

</body>
</html>