<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>
<!-- ... -->   
<div class="container">
	<div class="event-details-side">
    <h1><c:out value="${event.name}"/></h1>
    <h3>Host: <c:out value="${event.host.firstName} ${event.host.lastName }"/></h3>
    <h3>Date: <fmt:formatDate type = "date" dateStyle = "long" value = "${event.date}" /></h3>
    <h3>Location: <c:out value="${event.location}, ${event.state} "/></h3>
    <h3>Joined by: <c:forEach items="${event.attendees}" var="user">${user.firstName} ${user.lastName} <br></c:forEach></h3>
    <h4><c:choose>
								<c:when test = "${event.host.id == user.id}">
            					<h3><a href="/events/delete/${event.id}">Delete</a> | <a href="/events/edit/${event.id}">Edit</a></h3>
         						</c:when>
								
								<c:when test="${event.attendees.contains(user)}">
								<a href="/events/unjoiner/${event.id}">Leave</a> 
								</c:when>
								<c:otherwise>
								<a href="/events/joiner/${event.id}">Join</a> 
								</c:otherwise>
								</c:choose></h4>

								<a class="bottom" href="/events">Home</a>
</div>
			<div class="event-details-side">
				<h3>Message Wall</h3>
				<div class="messages">
				<c:forEach items="${ event.eventMessages }" var="message">
					<c:choose>
					<c:when test = "${message.author.id == user.id}">
					<p class="right">${message.content} <span class="yourname">
					${message.author.firstName} ${message.author.lastName}
					</span>
					</p>
					</c:when>
					<c:otherwise>
					<p><span class="name">
					${message.author.firstName} ${message.author.lastName}
					</span>
					 ${message.content}</p>
					</c:otherwise>
					</c:choose>
					
				</c:forEach>
				</div>
				<form action="/events/message/${event.id}" method="post">
					<div class="form-group">
						<label for="comment">Add Comment</label>
						<span>${error}</span>
						<textarea name="content" id="content" class="form-control"></textarea>
						<button>Submit</button>
					</div>
				</form>
			</div>


</div>
<!-- ... -->
</body>
</html>