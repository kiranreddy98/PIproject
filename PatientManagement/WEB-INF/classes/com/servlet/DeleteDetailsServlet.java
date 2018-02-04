package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GetPatientDetailsDao;
import com.exception.Myexception;


public class DeleteDetailsServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int patientid  =Integer.parseInt(request.getParameter("patientid"));
		GetPatientDetailsDao dao=new GetPatientDetailsDao();
		try {
			int result=dao.DeletePatient(patientid);
			if(result==1){
				request.setAttribute("msg", "Sucessfully Deleted");
			}
		} catch (Myexception e) {
			
			request.setAttribute("msg", e.getMessage());
			
		}
		
		
		request.getRequestDispatcher("GetPatientDetails.jsp").forward(request, response);
	}

}
