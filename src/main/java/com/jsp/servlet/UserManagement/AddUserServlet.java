package com.jsp.servlet.UserManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userId"));
		String userName=req.getParameter("userName");
		String userEmail=req.getParameter("userEmail");
		String userAddress=req.getParameter("userAddress");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO user1 VALUES(?,?,?,?)");
			pstmt.setInt(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userEmail);
			pstmt.setString(4, userAddress);
			int out=pstmt.executeUpdate();
			if(out>0) {
				resp.sendRedirect("Message.jsp?msg=Inserted");
			}else {
				resp.sendRedirect("Message.jsp?msg=NotInserted");
			}
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
