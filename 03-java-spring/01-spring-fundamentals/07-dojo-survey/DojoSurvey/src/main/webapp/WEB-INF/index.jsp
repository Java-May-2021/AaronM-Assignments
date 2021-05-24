<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
    <form action="/sessioned" method='POST'>
        Your Name: <input type="text" name='name'>
        <div class=spacer></div>

        Dojo Location: <select name='location'>
        <option value="Seattle">Seattle</option>
        <option value="San Jose">San Jose</option>
        <option value="Dallas">Dallas</option>
        </select>

        <div class=spacer></div>
        <label for="language">Favorite Language:</label>
        <select name="language">
        <option value="JavaScript">JavaScript</option>
        <option value="Python">Python</option>
        <option value="C++">C++</option>
        <option value="java">java</option>
        </select>
        <div class=spacer></div>
        <label for='comment'>Comment (optional):</label>
        <textarea name='comment'></textarea>
        </select>
    
        <input type="submit" value="View User">
    </form>
</div>
</body>
</html>