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

	<table>
			<tr>
				<td>Transaction-Id</td>
				<td>Book-Id</td>
				<td>Member-Id</td>
				<td>Book-Name</td>
				<td>Book-Quantity</td>
				<td>Issue-Date</td>
				<td>Return-Status</td>
			</tr>
			<b:forEach var="txn" items="${tRecord}">
			<tr>
				<td><b:out value="${txn.transactionId}"/></td>
				<td><b:out value="${txn.bookId}"/></td>
				<td><b:out value="${txn.memberId}"/></td>
				<td><b:out value="${txn.bookName}"/></td>
				<td><b:out value="${txn.bookQuantity}"/></td>
				<td><b:out value="${txn.issueDate}"/></td>
				<td><b:out value="${txn.returnStatus}"/></td>
			</tr>	
			</b:forEach>
		</table>
		
		<br><br>Go back to Home page -><a href="Welcome.jsp">Click Here</a>
</body>
</html>