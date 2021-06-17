<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${product.name}</title>
</head>
<body>
<!-- ... -->   
    <h1>Product Name: <c:out value="${product.name}"/></h1>
    <h3>Price: $<c:out value="${product.price}"/> </h3>
    <h3>Description:</h3> 
    <p><c:out value="${product.description}"/></p>
   	<ul>
		<c:forEach items="${ product.categories }" var="category">
			<li>${ category.name }</li>			
		</c:forEach>
	</ul>
	


		
				<form action="/products/${product.id}" method="POST">
		
			<label>Select category for the product: ${product.name}: </label> 
			
			<select name="category">
			
				<c:forEach items="${notInProduct}" var="cat">
				
			        	<option value="${cat.id}">${cat.name}</option>
			        	
			    </c:forEach> 
			    
			</select> 
			
			<button class="btn btn-outline-secondary btn-sm">Add</button>
			
		</form><br>
<!-- ... -->
</body>
</html>