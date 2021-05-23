<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold!</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Your Gold: <c:out value="${gold}"/></h1>

<div class="building">
<form method="POST" action="/addGold">
<input type="hidden" value="farm" name="building">
<h3>Farm</h3>
<p>Earns 10-20 gold</p>
<button>Find Gold!</button>
</form>
</div>

<div class="building">
<form method="POST" action="/addGold">
<input type="hidden" value="cave" name="building">
<h3>Cave</h3>
<p>Earns 5-10 gold</p>
<button>Find Gold!</button>
</form>
</div>

<div class="building">
<form method="POST" action="/addGold">
<input type="hidden" value="house" name="building">
<h3>House</h3>
<p>Earns 2-5 gold</p>
<button>Find Gold!</button>
</form>
</div>

<div class="building">
<form method="POST" action="/addGold">
<input type="hidden" value="casino" name="building">
<h3>Casino</h3>
<p>Earns / Loses 50 gold</p>
<button>Find Gold!</button>
</form>
</div>

<h2>Activies</h2>
<div class="activities">
<c:forEach items="${activity}" var="act">
<p class='${act.contains("ouch")? "red" : "green" }'>${act}</p>

</c:forEach>

</div>
</body>
</html>