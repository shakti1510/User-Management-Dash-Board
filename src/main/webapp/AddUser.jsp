<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Fill in the details</h2>

	<form action="AddUser" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="userId" required="required" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="userName" required="required" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="userEmail" required="required" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="userAddress" required="required" /></td>
			</tr>
			<tr />
		</table>
		<br /> <input type="submit" value="Insert Data" required="required" />

	</form>
	<br />
	<a href ="index.jsp">Return to Home Page</a>
</body>
</html>