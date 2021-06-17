<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${category.name}</title>
</head>
<body>
<!-- ... -->   
    <h1>Category Name: <c:out value="${category.name}"/></h1>

    <h3>Products:</h3> 
   	<ul>
		<c:forEach items="${ category.products }" var="product">
			<li>${ product.name }</li>			
		</c:forEach>
	</ul>
	


		
				<form action="/categories/${category.id}" method="POST">
		
			<label>Select products for the category: ${category.name}: </label> 
			
			<select name="product">
			
				<c:forEach items="${notInCategory}" var="prod">
				
			        	<option value="${prod.id}">${prod.name}</option>
			        	
			    </c:forEach> 
			    
			</select> 
			
			<button class="btn btn-outline-secondary btn-sm">Add</button>
			
		</form><br>
<!-- ... -->
</body>
</html>