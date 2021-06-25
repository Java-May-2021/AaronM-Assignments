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
	<form:form method="PUT" action="/events/commit/${event.id}" modelAttribute="event" >
		<div class="form-group row">
			<form:label path="name">Name:
			<form:errors path="name"/>
			<form:input class="form-control" path="name" id="name"/></form:label>
		</div>
		<div class="form-group row">
			<form:label path="location">Location:
			<form:errors path="location"/>
			<form:input class="form-control" path="location"/></form:label>
		</div>

		<button class="btn btn-secondary">Submit</button>
	</form:form><br>

	</div>
</body>
</html>