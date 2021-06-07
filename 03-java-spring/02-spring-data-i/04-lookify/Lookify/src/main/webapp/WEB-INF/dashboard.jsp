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
		<div class="dash">
		<a href="/song/add">Add New</a><a href="/top10">Top Songs</a><a href="/">Exit</a>
		<form method = "POST" action="/search">
	<div class="input-group mb-2 mr-sm-2">
		<input class="form-control" type="text" placeholder="Search Artist" name="artist">
		<button class="btn btn-outline-danger mb-2">Search Artist</button>
	</div>
		</form>
		<div class ="container">
			<h1>Lookify Library</h1>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Artist</td>
					<td>Rating</td>
					<td>Edit</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allSongs}" var ="song">
						<tr>
							<td>${song.id}</td>
							<td>${song.title}</td>
							<td>${song.artist}</td>
							<td>${song.rating}</td>
							<td><a href="edit/${song.id}">Edit</a></td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
			<hr>
			<a href="/new">Add a Song</a>

		</div>
	</body>
</html>