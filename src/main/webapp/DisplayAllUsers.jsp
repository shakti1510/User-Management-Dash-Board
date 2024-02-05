<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% ArrayList<ArrayList<Object>> userList =  (ArrayList<ArrayList<Object>>)request.getAttribute("UserList"); %>

	<table border="">
	<tr>
	<th>User Id</th>
	<th>User Name</th>
	<th>User Email</th>
	<th>User Address</th>
	<th>Update</th>
	<th>Delete</th>
	</tr>
	
<% for (int i = 0; i < userList.size(); i++) { %>
        <tr>
            <td><%= userList.get(i).get(0) %></td>
            <td><%= userList.get(i).get(1) %></td>
            <td><%= userList.get(i).get(2) %></td>
            <td><%= userList.get(i).get(3) %></td>
            <!-- Add other columns as needed -->
            <td><a href="updateUser?userId=<%=userList.get(i).get(0)%>" >Update</a></td>
			<td><a href="deleteUser?userId=<%=userList.get(i).get(0)%>">Delete</a></td>
        </tr>
    <% } %>
	</table>
</body>
</html>