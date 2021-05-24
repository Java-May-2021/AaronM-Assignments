<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>${error}</h1>
<form action="/code" method="POST">
<h3>What is the Code?</h3>
<input type="text" name="guess">
<button type="submit">Try Code</button>
</body>
</html>