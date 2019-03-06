<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="header.jsp" %>
	<%
		HttpSession currentSession = request.getSession();  
        currentSession.invalidate();  
	%>
</head>
<body>
<form method="post" action="/slamz/public/login" class="ba br3 w-30 center pb5 pl5 pr5 mt6">
    <div class="ma3 flex">
        <div class="w-40">Username:</div>
        <input class="w-60" type="text" name="name" required>
    </div>

    <div class="ma3 flex">
        <div class="w-40">Password:</div>
        <input class="w-60" type="password" name="password" id="password" required >
    </div>
	<c:if test="${not empty errorMsg}">
		<p class="center w-100  tc dark-red">${errorMsg}</p>
	</c:if>
    <br>
    <input class="center w-100 br3 bg-light-blue" name="login" type="submit" value="Login">
    <br><br><p>Don't have an account? <a href="${context}/public/register.jsp" >Click here</a></p>
</form>
</body>
</html>