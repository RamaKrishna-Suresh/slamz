<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/public/header.jsp" %>
<meta charset="UTF-8">
</head>
<body>
Hi ${activeUser.name}

<form action="${context}/editQuestions">
  <div class "wd-50">
  First Question:<br>
  <input type="text" name="question1" size='150'>
  <br>
  Second Question:<br>
  <input type="text" name="question2" size='150'>
  <br>
  Third Question:<br>
  <input type="text" name="question3" size='150'>
  <br>
  </div>
  <br>
  <input type="submit" value="Submit">
</form>


</body>
</html>