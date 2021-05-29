<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1><c:out value="${show.title}"/></h1>
<p>Description: <c:out value="${show.description}"/></p>
<p>Language: <c:out value="${show.language}"/></p>
<p>Number of pages: <c:out value="${show.pages}"/></p>
<a href="/books/${show.id}/edit">Edit Book</a>
<form action="/books/${show.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>