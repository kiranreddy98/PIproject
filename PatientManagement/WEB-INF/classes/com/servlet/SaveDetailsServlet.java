package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveDetailsServlet
 */
public class SaveDetailsServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int patientid     	=Integer.parseInt(request.getParameter("patientid"));
		String patientname 	=request.getParameter("patientname");
		int doctorid      	=Integer.parseInt(request.getParameter("doctorid"));
		String doctorname 	=request.getParameter("doctorname");
		String email		=request.getParameter("email");
		String date			=request.getParameter("date");
		String treatment	=request.getParameter("treatname");
		String TimetoMeet	=request.getParameter("timename");
		String EndTime		=request.getParameter("etimename");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			PreparedStatement ps=con.prepareStatement("insert into patient_details values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,patientid);
		ps.setString(2, patientname);
		ps.setInt(3,doctorid);
		ps.setString(4, doctorname);
		ps.setString(5, email);
		ps.setString(6,date);
		ps.setString(7, treatment);
		ps.setString(8, TimetoMeet);
		ps.setString(9, EndTime);
		int i=ps.executeUpdate();
		if(i==1){
			request.setAttribute("msg", "Sucessfully Saved");
			
		}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		request.getRequestDispatcher("GetPatientDetails.jsp").forward(request, response);
	}

}
