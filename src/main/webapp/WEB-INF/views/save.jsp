

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
 <title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  <script src = "js/app.js"></script>
</head>
<body>

<form class="save" method="POST" action="/add">
    <input type="text" name="isbn" placeholder="isbn">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="publisher" placeholder="publisher">
    <input type="text" name="type" placeholder="type">
    <input type="text" name="author" placeholder="author">
    <input type="submit" value="save book">
</form>
<h2>List of books:</h2>
<ul class="books"></ul>

</body>

</html>