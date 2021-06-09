<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Songs</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
<body>
<div class="top">
	
	<a href="/dashboard">Dashboard</a>
	
	<h1>Top Ten Songs</h1>
	</div>
	<table class="table table-success">
	<thead>
       		<tr>
            	<th>Rating</th>
            	<th>Title</th>
            	<th>Artist</th>
        	</tr>
    	</thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
		<tr>    
    		<td><c:out value="${song.rating}"/></td>
    		<td><c:out value="${song.title}"/></td>
    		<td><c:out value="${song.artist}"/></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>
