<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Count</title>
</head>
<body>
<h1>HELLO USER</h1>
<h3>Total Count: ${count}</h3>
<a href="/counter">Counter</a>
<p></p>
<a href="/">+1</a>
<p></p>
<a href="/doublecount">+2</a>
</body>
</html>