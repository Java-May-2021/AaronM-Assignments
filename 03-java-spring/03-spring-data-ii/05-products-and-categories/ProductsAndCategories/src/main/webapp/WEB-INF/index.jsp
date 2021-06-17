<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products and Categories</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
</head>
	<body>
		<div class ="container">
			<h1>Products</h1>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Price of Item</td>

				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allProducts}" var ="product">
						<tr>
							<td>${product.id}</td>
							<td><a href="products/${product.id}">${product.name}</a></td>
							<td>$${product.price}</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
				<div class ="container">
			<h1>Categories</h1>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td># of Products</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allCategories}" var ="category">
						<tr>
							<td>${category.id}</td>
							<td><a href="categories/${category.id}">${category.name}</a></td>
							<td>${category.products.size()}</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
				<div class ="container">
					<hr>
			<h3><a href="/products/new">Add a Product</a></h3>
					<hr>
			<h3><a href="/categories/new">Add a Category</a></h3>
			</div>
	</body>
</html>