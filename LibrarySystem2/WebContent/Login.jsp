<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method="post">
		Enter User Id: <input type="number" name="uId" required><br><br>
		Enter Password: <input type="password" name="pass" required><br><br>
		<input type="submit" value="Login">
	</form>
	
	
	<% if(request.getAttribute("error")!=null){ %>
		<br><br>${error}
	<%} %>
</body>
</html>