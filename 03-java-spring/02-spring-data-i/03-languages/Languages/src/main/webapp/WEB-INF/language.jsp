<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- ... -->   
    <h1>Language Name: <c:out value="${language.name}"/></h1>
    <h1>Creator: <c:out value="${language.creator}"/></h1>
    <h1>Current Version: <c:out value="${language.version}"/></h1>
    <h2><a href="/delete/${language.id}">Delete</a></h2>
    <h2><a href="/edit/${language.id}">Edit</a></h2>

<!-- ... -->
</body>
</html>