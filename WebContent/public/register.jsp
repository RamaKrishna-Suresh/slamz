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
    <form method="post" action="/slamz/public/signup" class="ba br3 w-30 center pb5 pl5 pr5 mt6">
        <div class="ma3 flex">
            <div class="w-40">Username:</div>
            <input class="w-60" type="text" name="user" required>
        </div>

        <div class="ma3 flex">
            <div class="w-40">Email:</div>
            <input class="w-60" type="text" name="email" required>
        </div>

        <div class="ma3 flex">
            <div class="w-40">Password:</div>
            <input class="w-60" type="password" name="password" id="password" required >
        </div>

        <br>
        <input class="center w-100 br3 bg-light-blue" name="submit" type="submit" value="Register">
        <br><br><p>Already have an account? <a href="/slamz/public/index.jsp" >Click here</a></p>
    </form>
</body>
</html>