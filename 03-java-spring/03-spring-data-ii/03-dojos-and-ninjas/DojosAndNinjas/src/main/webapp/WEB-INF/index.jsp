<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Dojos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
	<body>
		<div class="dash">
		<h3><a href="/dojo/new">Add Dojo</a></h3>
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
					<td>Name</td>
					<td>View</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allDojos}" var ="dojo">
						<tr>
							<td>${dojo.id}</td>
							<td>${dojo.name}</td>
							<td><a href="dojo/${dojo.id}">View</a></td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
					<hr>
			<h3><a href="/ninja/new">Add ninja</a></h3>
	</body>
</html>