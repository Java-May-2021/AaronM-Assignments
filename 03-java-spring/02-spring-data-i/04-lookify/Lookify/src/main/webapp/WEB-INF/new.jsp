<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Song</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>New Song</h1>
		
		
<form:form action="/create" method="post" modelAttribute="song">
    <p>
        <form:label path="title">Title:</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist:</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>
    <p>
<form:label path="rating">Rating:
			<form:errors path="rating"/>
			<form:select path="rating">
			<form:option value="1" />
			<form:option value="2" />
			<form:option value="3" />
			<form:option value="4" />
			<form:option value="5" />
			<form:option value="6" />
			<form:option value="7" />
			<form:option value="8" />
			<form:option value="9" />
			<form:option value="10" />
			</form:select></form:label>
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