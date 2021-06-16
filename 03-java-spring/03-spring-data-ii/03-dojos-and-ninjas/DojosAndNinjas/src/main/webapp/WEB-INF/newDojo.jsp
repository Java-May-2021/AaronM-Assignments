<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A Dojo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>New Dojo</h1>
		
		
<form:form action="/dojo/create" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    
		
		
		<hr>
		<c:forEach items="${errors}" var="e">
		<p>${e}</p>
		</c:forEach>
	</div>

</body>
</html>