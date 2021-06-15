<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All People</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
	<body>
		<div class="dash">
		<h3><a href="/person/new">Add Person</a></h3>
		<hr>
		<form method = "POST" action="/search">
		</form>
		<div class ="container">
			<h1>People</h1>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>License Number</td>
					<td>License State</td>
					<td>Expiration Date</td>
					<td>Edit</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allPeople}" var ="person">
						<tr>
							<td>${person.id}</td>
							<td>${person.firstName}</td>
							<td>${person.lastName}</td>
							<td>${person.license.getNumberAsString()}</td>
							<td>${person.license.state}</td>
							<td>${person.license.expiration_date}</td>
							<td><a href="edit/${person.id}">Edit</a></td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
					<hr>
			<h3><a href="/license/new">Add License</a></h3>
	</body>
</html>