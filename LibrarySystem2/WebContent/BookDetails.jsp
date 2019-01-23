<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Book Details</h1>
		<table>
			<tr>
				<td>Book-Id</td>
				<td>Book-Title</td>
				<td>Book-Edition</td>
				<td>Book-Quantity</td>
				<td>Book-Cost</td>
			</tr>
			<b:forEach var="bList" items="${bList}">
			<tr>
				<td><b:out value="${bList.bookId}"/></td>
				<td><b:out value="${bList.bookTitle}"/></td>
				<td><b:out value="${bList.bookEdition}"/></td>
				<td><b:out value="${bList.bookQuantity}"/></td>
				<td><b:out value="${bList.bookCost}"/></td>
			</tr>	
			</b:forEach>
		</table>
		
		<br><br>Go back to Home page -><a href="Welcome.jsp">Click Here</a>
</body>
</html>