<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tachyons/4.11.1/tachyons.css">
    <%  
    	String contextPath = request.getContextPath(); 
    	pageContext.setAttribute("context", contextPath);
    %>
</head>
<body>
<div class="cover white bg-dark-blue mt0 flex pa2">
    <h1 class="dib ml5 w-90"> SLAMZ </h1>
    <c:if test="${not empty activeUser.id}">
		<a class="f4 link dim ba br3 bw1 ph3 pv2 mb2 dib white h2 w-10 v-mid" href="${context}/public/logout">Logout</a>
    </c:if>
</div>
</body>
</html>