package com.jsp.servlet.UserManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayUser")
public class DisplayAllUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user1");
			ResultSet resultSet = pstmt.executeQuery();
			ArrayList<ArrayList<Object>> users=new ArrayList<ArrayList<Object>>();
			while(resultSet.next()) {
				ArrayList<Object> user=new ArrayList<Object>();
				int userId = resultSet.getInt("userId");
	            String userName = resultSet.getString("userName");
	            String userEmail = resultSet.getString("userEmail");
	            String userAddress = resultSet.getString("userAddress");
	            user.add(userId);
	            user.add(userName);
	            user.add(userEmail);
	            user.add(userAddress);
	            users.add(user);
			}
			req.setAttribute("UserList", users);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayAllUsers.jsp");
			rd.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
