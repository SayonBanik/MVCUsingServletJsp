<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Member Details</h1>
	<table>
	<tr><td>Member Id</td> <td>: ${mRecord.memberId}</td></tr>
	<tr><td>Member Name</td> <td>: ${mRecord.memberName}</td></tr>
	<tr><td>Membership Type</td> <td>: ${mRecord.membershipType}</td></tr>
	<tr><td>Book Holding Time</td> <td>: ${mRecord.bookHoldingTime}</td></tr>
	<tr><td>Registration Date</td> <td>: ${mRecord.registrationDate}</td></tr>
	</table>
	
	<br><br>Go back to Home page -><a href="Welcome.jsp">Click Here</a>
</body>
</html>