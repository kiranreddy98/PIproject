package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GetPatientDetailsDao;
import com.exception.Myexception;
import com.pojo.PatientPojo;


public class GetPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetPatientServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int patientid  =Integer.parseInt(request.getParameter("patientid"));
		GetPatientDetailsDao dao=new GetPatientDetailsDao();
		 List<PatientPojo> list = null;
		try {
			list = dao.getPatient(patientid);
			for(PatientPojo pojo:list){
				 System.out.println(pojo.getEmail());
				 request.setAttribute("pid", pojo.getPid());
				request.setAttribute("email", pojo.getEmail());
				request.setAttribute("patientname", pojo.getPname());
				request.setAttribute("did", pojo.getDid());
				request.setAttribute("doctorname", pojo.getDname());
				request.setAttribute("date", pojo.getDate());
				request.setAttribute("treatment", pojo.getTreatment());
				request.setAttribute("ttom", pojo.getTime_to_meet());
				request.setAttribute("endt", pojo.getEnd_time());
				
		} 
		}catch (Myexception e) {
			request.setAttribute("msg", e.getMessage());
			
		}
		request.getRequestDispatcher("GetPatientDetails.jsp").forward(request, response);	
				
			
	}

}
