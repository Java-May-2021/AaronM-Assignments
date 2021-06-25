<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">

</head>
<body>
	<h1>Welcome, <c:out value="${user.firstName}" /></h1>
	<a href="/logout">Logout</a>
	<h3>Here are some events in your state:</h3>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>Name</td>
					<td>Date</td>
					<td>Location</td>
					<td>Host</td>
					<td>Action/Status</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${inState}" var ="event">
						<tr>
							<td><a href="/events/${event.id}">${event.name}</a></td>
							<td> <p><fmt:formatDate type = "date" dateStyle = "long" value = "${event.date}" /></p></td>
							<td>${event.location}, ${event.state}</td>
							<td>${event.host.firstName} ${event.host.lastName}</td>
							<td>
								<c:choose>
								<c:when test = "${event.host.id == user.id}">
            					<a href="/events/delete/${event.id}">Delete</a> | <a href="/events/edit/${event.id}">Edit</a>
         						</c:when>
								<c:when test="${event.attendees.contains(user)}"><a href="/events/unjoin/${event.id}">Leave</a> 
								</c:when>
								<c:otherwise><a href="/events/join/${event.id}">Join</a> 
								</c:otherwise>
								</c:choose>	
							</td>							
						</tr>
					</c:forEach>	
				</tbody>
			</table>
			<br>
			<h3>Here are some out of state events</h3>
<table class="table table-dark">
				<thead>
				<tr>
					<td>Name</td>
					<td>Date</td>
					<td>Location</td>
					<td>Host</td>
					<td>Action/Status</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${notInState}" var ="event">
						<tr>
							<td><a href="/events/${event.id}">${event.name}</a></td>
							<td> <p><fmt:formatDate type = "date" dateStyle = "long" value = "${event.date}" /></p></td>
							<td>${event.location}, ${event.state}</td>
							<td>${event.host.firstName} ${event.host.lastName}</td>
							<td>
								<c:choose>
								<c:when test = "${event.host.id == user.id}">
            					<a href="/events/delete/${event.id}">Delete</a> | <a href="/events/edit/${event.id}">Edit</a>
         						</c:when>
								<c:when test="${event.attendees.contains(user)}"><a href="/events/unjoin/${event.id}">Leave</a> 
								</c:when>
								<c:otherwise><a href="/events/join/${event.id}">Join</a> 
								</c:otherwise>
								</c:choose>					
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		<hr>
		<br>
		    <h1>Create an Event</h1>
    
    <p><form:errors path="event.*"/></p>
    
    <form:form method="POST" action="/events" modelAttribute="event">
    <form:hidden value="${ user.id }" path="host"/>
        <p>
            <form:label path="name">Event Name:</form:label>
            <form:input type="name" path="name"/>
        </p>    
		        <form:label path="date">Date</form:label>
		        <form:errors path="date"/>
		        <form:input type="date" class="form-control" path="date"/>

        <p>
            <form:label path="location">Location:</form:label>
            <form:input type="location" path="location"/>
        </p>
		<div class="form-group">
		        <form:label path="state">State</form:label>
		        <form:select path="state">
	<option value="AL">Alabama</option>
	<option value="AK">Alaska</option>
	<option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option>
	<option value="CA">California</option>
	<option value="CO">Colorado</option>
	<option value="CT">Connecticut</option>
	<option value="DE">Delaware</option>
	<option value="DC">District Of Columbia</option>
	<option value="FL">Florida</option>
	<option value="GA">Georgia</option>
	<option value="HI">Hawaii</option>
	<option value="ID">Idaho</option>
	<option value="IL">Illinois</option>
	<option value="IN">Indiana</option>
	<option value="IA">Iowa</option>
	<option value="KS">Kansas</option>
	<option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option>
	<option value="ME">Maine</option>
	<option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option>
	<option value="MI">Michigan</option>
	<option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option>
	<option value="MO">Missouri</option>
	<option value="MT">Montana</option>
	<option value="NE">Nebraska</option>
	<option value="NV">Nevada</option>
	<option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option>
	<option value="NM">New Mexico</option>
	<option value="NY">New York</option>
	<option value="NC">North Carolina</option>
	<option value="ND">North Dakota</option>
	<option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option>
	<option value="OR">Oregon</option>
	<option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option>
	<option value="SC">South Carolina</option>
	<option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option>
	<option value="TX">Texas</option>
	<option value="UT">Utah</option>
	<option value="VT">Vermont</option>
	<option value="VA">Virginia</option>
	<option value="WA">Washington</option>
	<option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option>
	<option value="WY">Wyoming</option>
	</form:select>
				
		        <form:errors path="state"/>
		    </div>
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>