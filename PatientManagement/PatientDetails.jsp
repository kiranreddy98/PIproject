<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.pojo.PatientPojo"%>
<%@page import="java.util.ArrayList"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<%
String username = (String) session.getAttribute("username");
if(username == null){
	//response.sendRedirect("Login.jsp");
	 out.println("SESSION EXPIRED");
	response.sendRedirect("LogoutServlet");
}
%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="styles1/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="styles1/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->


</head>
<body>
<form  action="DeletePatientDetailsServlet" method="post" name="form1">
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><span class=""></span><a href="#">PATIENT MANAGEMENT SYSTEM</a></h1>
			<div id="menu">
				<ul>
					
					<li><a href="home.jsp" accesskey="2" title="">HOME PAGE</a></li>
					<li><a href="GetPatientDetails.jsp" accesskey="3" title="">PATIENT ENTRY</a></li>
					<li><a href="LogoutServlet" accesskey="2" title="">LOGOUT</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div id="page-wrapper" style="background: #FA8361">
	<div id="page" class="container">
	<div  style="font-family:fantasy;">
	<h1>PATIENT DETAILS</h1>
	</div>
	 <%String msg=(String)request.getAttribute("msg"); 
 if(msg!=null){
	out.print("<font color='yellow'>"+msg+"</font>");

 }
 %>
	<table id="grid" border="1" style="background-color: white;font-family:serif;color: #1ABC9C">
		<tr>
		
		<th>PERSONID</th>
		<th>PERSON NAME</th>
		<th>DOCTOR ID</th>
		<th>DOCTOR NAME</th>
		<th>EMAIL</th>
		<th>DATE</th>
		<th>TREATMENT</th>
		<th>TIME TO MEET</th>
		<th>END TIME</th>
		</tr>	
		<%List<PatientPojo> li;%>
	<%List<PatientPojo> list=(List<PatientPojo>)request.getAttribute("patientdetails"); 
	if(list!=null){
	for(PatientPojo pojo:list){

	%>
	
		<td><%out.print(pojo.getPid());%></td>	
		<td><%out.print(pojo.getPname());%></td>
		<td><%out.print(pojo.getDid());%></td>
		<td><%out.print(pojo.getDname());%></td>
		<td><%out.print(pojo.getEmail());%></td>
		<td><%out.print(pojo.getDate());%></td>
		<td><%out.print(pojo.getTreatment());%></td>
		<td><%out.print(pojo.getTime_to_meet());%></td>
		<td><%out.print(pojo.getEnd_time());%></td>
		
		</tr>
		
		<%} }%>
	</table>
	</div>
</div>



<div id="copyright" class="container">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="#"></a> | Design by <a href="#" rel="nofollow">KIRAN</a>.</p>
		<ul class="contact">
			<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
			<li><a href="#" class="icon icon-facebook"><span></span></a></li>
			<li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
			<li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
			<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
		</ul>
</div>
</form>
</body>
</html>
