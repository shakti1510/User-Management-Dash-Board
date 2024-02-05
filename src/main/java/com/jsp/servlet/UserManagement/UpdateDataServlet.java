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
@WebServlet("/updateUser")
public class UpdateDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement("Select * from user1 where userId=?");
			pstmt.setInt(1, userId);
			ResultSet res=pstmt.executeQuery();
			Object[] data=new Object[4];
			while(res.next()) {
				data[0]=res.getInt("userId");
				data[1]=res.getString("userName");
				data[2]=res.getString("userEmail");
				data[3]=res.getString("userAddress");
			}
			req.setAttribute("userData", data);
			RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
			rd.forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
