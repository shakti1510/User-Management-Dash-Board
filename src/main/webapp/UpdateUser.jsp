<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateUserData" method="post">
		<table>
		<% Object[] res=(Object[])request.getAttribute("userData"); %>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="userId" value="<%=res[0]%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="userName" value="<%=res[1]%>" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="userEmail" value="<%=res[2]%>" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="userAddress" value="<%=res[3]%>" /></td>
			</tr>
			<tr />
		</table>
		<br /> <input type="submit" value="Update Data" required="required" />

	</form>
	<br />
	<a href="index.jsp">Return to Home Page</a>
</body>
</html>