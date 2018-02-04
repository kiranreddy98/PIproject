package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GetPatientDetailsDao;
import com.exception.Myexception;
import com.pojo.PatientPojo;

/**
 * Servlet implementation class GetPatientDetailsServlet
 */
public class GetPatientDetailsServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetPatientDetailsDao dao=new GetPatientDetailsDao();
		  
		try {
			List<PatientPojo>	list = dao.getDetails();
			if(list!=null){
				request.setAttribute("patientdetails", list);
			}
		} catch (Myexception e) {
			
			request.setAttribute("msg", e.getMessage());
		}
	
		request.getRequestDispatcher("PatientDetails.jsp").forward(request, response);
	}

}
