<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

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
 <form action="SaveDetailsServlet" method="post">
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><span ></span><a href="#">PATIENT MANAGEMENT SYSTEM</a></h1>
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="home.jsp" accesskey="1" title="">HOMEPAGE</a></li>
					
					<li><a href="GetPatientDetailsServlet" accesskey="3" title="">PATIENT DETAILS</a></li>
					<li><a href="LogoutServlet" accesskey="2" title="">LOGOUT</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="wrapper" style="background-color: #FA8361";>
  
  <h1><span style="font-family:fantasy;margin-left: 400px;">PATIENT APPLICATION FORM</span></h1>
  
  <div style="padding-top: 20px;"></div>
  <fieldset>
 
     <span style="padding-left:200px;padding-right:100px;font-family: cursive;font-size: medium;">Patientid</span>
	     <input placeholder="Enter Patient id" id="pid" name="patientid" type="number" tabindex="2"> 
	 
	    <span style="padding-left:200px;padding-right:100px;font-family: cursive;font-size: medium;">PatientName</span>
	    <input placeholder="Enter Patient Name" id="pname" name="patientname" tabindex="2" pattern="[A-Za-z]+">
	    
	 
   <div style="padding-top: 20px;"></div>
 
 
	  <span style="padding-left:200px;padding-right:100px;font-family: cursive;font-size: medium;">DoctorId</span>
	     <input placeholder="Enter Doctor id" id="did" name="doctorid" type="number" tabindex="1">
	 
	     <span style="padding-left:200px;padding-right:100px;font-family: cursive;font-size: medium;">DoctorName</span>
	    <input placeholder="Enter Doctor Name" id="dname" name="doctorname"  tabindex="1" pattern="[A-Za-z]+">
	 

	    
	
 <div style="padding-top: 20px;"></div>	
	
	     <span style="padding-left:220px;padding-right:120px;font-family: cursive;font-size: medium;">Date</span>
	     <input placeholder="date" id="date" name="date" type="date" tabindex="4"> 
	 
	    <span style="padding-left:220px;padding-right:110px;font-family: cursive;font-size: medium;" >Treatment</span>
	    <input placeholder="Treatment" id="tid" name="treatname" tabindex="6" pattern="[A-Za-z]+">
	 
 <div style="padding-top: 20px;"></div>	 
	 
	  <span style="padding-left:210px;padding-right:110px;font-family: cursive;font-size: medium;">TimetoMeet</span>
	  <input placeholder="" id="timeid" name="timename" type="time" tabindex="7">
	  
	  <span style="padding-left:240px;padding-right:130px;font-family: cursive;font-size: medium;">EndTime</span>
	    <input placeholder="" id="etid" name="etimename" type="time" tabindex="7">
	
	
 <span style="padding-left:225px;padding-right:130px;font-family: cursive;font-size: medium;">Email</span>
	    <input placeholder="Enter Email Id" id="email" name="email" type="email" tabindex="4">
	    <input  class="submit" type="submit"  class="button"/>
	  </span>
</fieldset>	  
  </form>
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
</body>
</html>
