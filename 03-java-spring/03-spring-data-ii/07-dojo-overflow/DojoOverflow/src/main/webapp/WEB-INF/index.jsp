<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
	<body>
		<div class ="container">
			<h1>Questions</h1>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>ID</td>
					<td>Question</td>
					<td>Tags</td>
					<td>Answer</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allQuestions}" var ="question">
						<tr>
							<td>${question.id}</td>
							<td>${question.question}</td>
    						<td><c:forEach items="${question.tags}" var="tag"><c:out value="${tag.subject}"/></c:forEach></td>
							<td><a href="/questions/${question.id}">Answer</a></td>
						</tr>
					</c:forEach>	
				</tbody>				
			</table>
			<h3><a href="/questions/new">Add a Question</a></h3>
		</div>
	</body>
</html>