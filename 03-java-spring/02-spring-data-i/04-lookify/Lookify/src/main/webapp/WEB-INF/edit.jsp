<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<title>Edit ${song.title}</title>
</head>
<body>
	<div class="edit">
	<a href="/delete/${song.id}">Delete</a>
	
	<a href="/dashbord">Home</a>
	
	<h1>Edit Song: <c:out value="${song.title}"/> </h1>
	
	</div>
	<c:forEach items="${errors}" var="err">
		<h4>${err}</h4>
	</c:forEach>
	<div class="edit">
	<form:form method="PUT" action="/update/${song.id}" modelAttribute="song" >
		<div class="form-group row">
			<form:label path="title">Title:
			<form:errors path="title"/>
			<form:input class="form-control" path="title" id="title"/></form:label>
		</div>
		<div class="form-group row">
			<form:label path="artist">Artist:
			<form:errors path="artist"/>
			<form:input class="form-control" path="artist"/></form:label>
		</div>
		<div class="form-group row">
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
		</div>
		<button class="btn btn-secondary">Submit</button>
	</form:form><br>
	</div>
</body>
</html>