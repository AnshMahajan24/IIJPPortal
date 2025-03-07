<%@page import="java.util.ArrayList"%>
<%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Job post form</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="shortcut icon" href=http://www.freshdesignweb.com/wp-content/themes/fv28/images/icon.ico />
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="fdw-demo.css" media="all" />
     <link rel="stylesheet" type="text/css" href="register.css" media="all" />
    <!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700' rel='stylesheet' type='text/css'> -->
   
</head>
<body bgcolor="black">

<header>
		<div id="sash-container" >
			<div class="hide-sash-top" ></div>
			<div class="hide-sash-left"></div>
			<!-- <div class="sash-shadow-top"></div>
			<div class="sash-shadow-left"></div>
			<div class="hide-sash-shadow-top"></div>
			<div class="hide-sash-shadow-left"></div> -->
			<div id="sash">
				<p>INFOGAIN<strong></strong></p>
			</div>
		</div>
    	</header>
    	<h1 ><font color="lightgrey">POST JOBS HERE..</font></h1>

 <div class="container">
     <!--  <div class="freshdesignweb-top"><h1>JOB Post Form</h1></div><div class="clr"></div> 
      <br><br>  -->
      <div  class="form">
    		<form id="contactform" action="../PostJobsServlet"> 
    			<p class="contact"><label for="position">Position</label></p> 
    			<input id="name" name="position" placeholder="Position" required tabindex="1" type="text"> 
    			 <%GetDepartments get= new GetDepartments(); 
    			 	ArrayList <Departments> departments= get.getdepartments();%>
    			 	
    			 	 <fieldset>
                 <label>Departments:&nbsp;&nbsp;</label>
                  <label class="month"> 
                  <select class="select-style" name="department">
                  <option value="">Select a Department</option>
                  <%
                  for(Departments s:departments)
                  {
                  %>
                  <option value="<%=s.getDepartment_id()%>"><%=s.getDepartment_name()%> </option>
                  <%
                  }
                  %>
                 </select>    
                 </label><br><br>
                
              </fieldset>
    			 
                
                <p class="contact"><label for="salary">Expected Salary</label></p> 
    			<input id="salary" name="salary" placeholder="Salary"  type="text" required> 
    			 
                <%
    			 	ArrayList <Branch> branch= get.getBranch();%>
    			 	
    			 	 <fieldset>
                 <label>Branch:&nbsp;&nbsp;</label>
                  <label class="month"> 
                  <select class="select-style" name="branch">
                  <option value="">Select a Branch</option>
                  <%
                  for(Branch s:branch)
                  {
                  %>
                  <option value="<%=s.getBranch_id()%>"><%=s.getBranch_name()%> </option>
                  <%
                  }
                  %>
                 </select>    
                 </label><br><br>
                
              </fieldset>


                <p class="contact"><label for="experience">Experience Required</label></p> 
    			<input  id="experience" name="experience" placeholder="Experience"  type="text" required> 
                <p class="contact"><label for="skills">Required Skills</label></p> 
    			<input  id="skills" name="skills" placeholder="Skills" required tabindex="2" type="text" required> 
    			<!-- <p class="contact"><label for="salary">Expected Salary</label></p> 
            <input id="phone" name="salary" placeholder="Salary" required type="text"> <br> -->
        
               <fieldset>
                 <label>Application Deadline:&nbsp;&nbsp; Month</label>
                  <label class="month"> 
                  <select class="select-style" name="lastMonth">
                  <option value="">Month</option>
                  <option  value="JAN">January</option>
                  <option value="Feb">February</option>
                  <option value="Mar" >March</option>
                  <option value="Apr">April</option>
                  <option value="May">May</option>
                  <option value="Jun">June</option>
                  <option value="Jul">July</option>
                  <option value="Aug">August</option>
                  <option value="Sep">September</option>
                  <option value="Oct">October</option>
                  <option value="Nov">November</option>
                  <option value="Dec" >December</option>
                 </select>    
                 </label><br><br>
                <label>Day<input class="birthday" maxlength="2" name="lastDay"  placeholder="Day" required></label>
               <label>Year<input class="birthyear" maxlength="4" name="lastYear" placeholder="Year" required> </label>
              </fieldset>
            
            
            <input class="buttom" name="submit" id="submit" tabindex="5" value="POST" type="submit"> 	 
   </form> 
  </div>       
          </div>
           
<script type="text/javascript">
//<![CDATA[
(function() {
var _analytics_scr = document.createElement('script');
_analytics_scr.type = 'text/javascript'; _analytics_scr.async = true; _analytics_scr.src = '/_Incapsula_Resource?SWJIYLWA=2977d8d74f63d7f8fedbea018b7a1d05&ns=1';
var _analytics_elem = document.getElementsByTagName('script')[0]; _analytics_elem.parentNode.insertBefore(_analytics_scr, _analytics_elem);
})();
// ]]>
</script></body>
</html>