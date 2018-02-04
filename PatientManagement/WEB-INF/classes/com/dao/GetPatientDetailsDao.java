package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.Myexception;
import com.pojo.PatientPojo;

public class GetPatientDetailsDao {
public List<PatientPojo> getDetails() throws Myexception{
	List<PatientPojo> list=new ArrayList<PatientPojo>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("select * from patient_details");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
		PatientPojo pojo=new PatientPojo();
		pojo.setPid(rs.getInt("patientid"));
		pojo.setPname(rs.getString("patientname"));
		pojo.setDid(rs.getInt("doctorid"));
		pojo.setDname(rs.getString("doctorname"));
		pojo.setEmail(rs.getString("email"));
		pojo.setDate(rs.getString("date"));
		pojo.setTreatment(rs.getString("treatment"));
		pojo.setTime_to_meet(rs.getString("time_to_meet"));
		pojo.setEnd_time(rs.getString("ending_time"));
		list.add(pojo);
		}
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
	
		throw new Myexception("PLEASE CHECK SQL QUERY");
	}
	return list;
	
	
	
}

public List<PatientPojo> getPatient(Integer id) throws Myexception{
	List<PatientPojo> list=new ArrayList<PatientPojo>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("select * from patient_details where patientid=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
		PatientPojo pojo=new PatientPojo();
		pojo.setPid(rs.getInt("patientid"));
		pojo.setPname(rs.getString("patientname"));
		pojo.setDid(rs.getInt("doctorid"));
		pojo.setDname(rs.getString("doctorname"));
		pojo.setEmail(rs.getString("email"));
		pojo.setDate(rs.getString("date"));
		pojo.setTreatment(rs.getString("treatment"));
		pojo.setTime_to_meet(rs.getString("time_to_meet"));
		pojo.setEnd_time(rs.getString("ending_time"));
		list.add(pojo);
		}
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
	
		throw new Myexception("PLEASE CHECK SQL QUERY");
	}
	return list;
	

}

public int DeletePatient(Integer id) throws Myexception{
	int result = 0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("delete  from patient_details where patientid=?");
		 ps.setInt(1, id);
		result=ps.executeUpdate();
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
	
		e.printStackTrace();
		throw new Myexception("PLEASE CHECK SQL QUERY");
	}
	return result;

}

public int UpdatePatient(PatientPojo pojo) throws Myexception{
	int result = 0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		PreparedStatement ps=con.prepareStatement("update  patient_details set patientname=?,doctorid=?, doctorname=?, email=?, date=?, treatment=?, time_to_meet=?, ending_time=? where patientid=?");
		 ps.setString(1, pojo.getPname());
		 ps.setInt(2, pojo.getDid());
		 ps.setString(3,pojo.getDname());
		 ps.setString(4, pojo.getEmail());
		 ps.setString(5, pojo.getDate());
		 ps.setString(6, pojo.getTreatment());
		 ps.setString(7, pojo.getTime_to_meet());
		 ps.setString(8, pojo.getEnd_time());
		 ps.setInt(9, pojo.getPid());
		  result=ps.executeUpdate();
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	
	} catch (SQLException e) {
	
		throw new Myexception("PLEASE CHECK SQL QUERY");
		
	}
	return result;

}


}
