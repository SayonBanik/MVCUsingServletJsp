<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FindBookBetweenDates">
		Enter Start Date: <input type="date" name="sDate" required><br>
		Enter End Date: <input type="date" name="eDate" required><br><br>
		<input type="submit" value="Get Details">
	</form>
	
	<% if(request.getAttribute("error")!=null){ %>
		<br><br>${error}
	<%} %>
</body>
</html>