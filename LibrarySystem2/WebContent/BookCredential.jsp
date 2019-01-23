<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="FindBookByTitle">
		Enter book Title: <input type="text" name="bookTitle" required><br><br>
		<input type="submit" value="Get Details">
	</form>
	
	<% if(request.getAttribute("error")!=null){ %>
		<br><br>${error}
	<%} %>
	

</body>
</html>