package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginVerifyServlet extends HttpServlet {
	
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	PrintWriter pw=response.getWriter();
	String username=request.getParameter("username");
	String password= request.getParameter("password");
	HttpSession session=request.getSession();
	session.setAttribute("username", username);
	boolean result=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("select * from login where username=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			result=true;
		}
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	if(result){
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	else{
		request.setAttribute("valid", "Please enter valid username and password");
	request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
}
	

}
