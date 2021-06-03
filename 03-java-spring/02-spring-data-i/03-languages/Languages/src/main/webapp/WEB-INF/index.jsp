<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
	<body>
		<div class ="container">
			<h1>Hi</h1>
			<a href="/new">Add a Language</a>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>id</td>
					<td>language</td>
					<td>creator</td>
					<td>version</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allLanguages}" var ="language">
						<tr>
							<td>${language.id}</td>
							<td>${language.name}</td>
							<td>${language.creator}</td>
							<td>${language.version}</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
	</body>
</html>