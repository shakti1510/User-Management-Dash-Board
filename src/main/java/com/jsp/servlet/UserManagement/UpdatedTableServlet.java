package com.jsp.servlet.UserManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateUserData")
public class UpdatedTableServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName=req.getParameter("userName");
		String userEmail=req.getParameter("userEmail");
		String userAddress=req.getParameter("userAddress");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement("UPDATE user1 SET userName=?,userEmail=?,userAddress=? where userId=?");
			pstmt.setInt(4, userId);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userAddress);
			int res=pstmt.executeUpdate();
			if(res>0) {
				resp.sendRedirect("Message.jsp?msg=1_Data_Updated");
			}else {
				resp.sendRedirect("Message.jsp?msg=Nothing_Updated");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
