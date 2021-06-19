<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>"${question.question}"</title>
</head>
<body>
<h1>"${question.question}"</h1>
    <h3>Answers:</h3> 
   	<ul>
		<c:forEach items="${ question.answers }" var="answer">
			<li>"${answer.answer}"</li>			
		</c:forEach>
	</ul>
<h3>Add your answer:</h3>
		<form:form action="/questions/answers" method="post" modelAttribute="a">
			 <div class="form-group">
		        <form:label path="answer"></form:label>
		        <form:errors path="answer"/>
		        <form:textarea class="form-control" path="answer"></form:textarea>
		    </div>
		    <form:hidden path="question" value="${ question.id }"/>
		    <button class="btn btn-primary">Submit</button>
		</form:form>
</body>
</html>