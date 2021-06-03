<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<title>Edit ${language.name}</title>
</head>
<body>
	<div class="edit">
	<a href="/delete/${language.id}">Delete</a>
	
	<a href="/languages">Home</a>
	
	<h1>Edit Language: <c:out value="${language.name}"/> </h1>
	
	</div>
	<c:forEach items="${errors}" var="err">
		<h4>${err}</h4>
	</c:forEach>
	<div class="edit">
	<form:form method="PUT" action="/update/${language.id}" modelAttribute="language" >
		<div class="form-group row">
			<form:label path="name">Name:
			<form:errors path="name"/>
			<form:input class="form-control" path="name" id="name"/></form:label>
		</div>
		<div class="form-group row">
			<form:label path="creator">Creator:
			<form:errors path="creator"/>
			<form:input class="form-control" path="creator"/></form:label>
		</div>
		<div class="form-group row">
			<form:label path="version">Version:
			<form:errors path="version"/>
			<form:input class="form-control" path="version"/></form:label>
		</div>
		<button class="btn btn-secondary">Submit</button>
	</form:form><br>
	</div>
</body>
</html>