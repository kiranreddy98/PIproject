package com.pojo;

public class PatientPojo {
private int pid;
private String pname;
private int did;
private String dname;
private String email;
private String date;
private String treatment;
public String getTreatment() {
	return treatment;
}
public void setTreatment(String treatment) {
	this.treatment = treatment;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
private String time_to_meet; 
private String end_time;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getTime_to_meet() {
	return time_to_meet;
}
public void setTime_to_meet(String time_to_meet) {
	this.time_to_meet = time_to_meet;
}
public String getEnd_time() {
	return end_time;
}
public void setEnd_time(String end_time) {
	this.end_time = end_time;
} 

}
