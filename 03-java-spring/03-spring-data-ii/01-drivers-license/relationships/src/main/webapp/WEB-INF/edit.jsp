<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<title>Edit ${person.firstName}</title>
</head>
<body>
	<div class="edit">
	<a href="/delete/${person.id}">Delete</a>
	
	<a href="/">Home</a>
	
	<h1>Edit: <c:out value="${person.firstName} ${person.lastName}"/> </h1>
	
	</div>
	<c:forEach items="${errors}" var="err">
		<h4>${err}</h4>
	</c:forEach>
	<div class="edit">
	<form:form method="PUT" action="/update/${person.id}" modelAttribute="person" >
		<div class="form-group row">
			<form:label path="firstName">Name:
			<form:errors path="firstName"/>
			<form:input class="form-control" path="firstName" id="firstName"/></form:label>
		</div>
		<div class="form-group row">
			<form:label path="lastName">Last:
			<form:errors path="lastName"/>
			<form:input class="form-control" path="lastName"/></form:label>
		</div>

		<button class="btn btn-secondary">Submit</button>
	</form:form><br>

	</div>
</body>
</html>