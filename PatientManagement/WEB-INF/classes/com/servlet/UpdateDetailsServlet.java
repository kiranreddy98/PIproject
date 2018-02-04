package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GetPatientDetailsDao;
import com.exception.Myexception;
import com.pojo.PatientPojo;


public class UpdateDetailsServlet extends HttpServlet {
	
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
		PatientPojo pojo=new PatientPojo();
		pojo.setPid(patientid);
		pojo.setPname(patientname);
		pojo.setDid(doctorid);
		pojo.setDname(doctorname);
		pojo.setEmail(email);
		pojo.setDate(date);
		pojo.setTreatment(treatment);
		pojo.setTime_to_meet(TimetoMeet);
		pojo.setEnd_time(EndTime);
		GetPatientDetailsDao dao=new GetPatientDetailsDao();
		try {
		int	result=dao.UpdatePatient(pojo);
		if(result==1){
			request.setAttribute("msg","Sucessfully Updated");
		}
		} catch (Myexception e) {
			request.setAttribute("msg", e.getMessage());
		}
		
		request.getRequestDispatcher("GetPatientDetails.jsp").forward(request, response);
	}

}
