


     <%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>photo_style</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="modernizr-1.5.min.js"></script>
</head>




<body>
<%
GetDepartments get= new GetDepartments();
Employees e = new Employees();
Jobs j= new Jobs();
j=(Jobs)request.getAttribute("applied");
e=(Employees)request.getAttribute("employee");


%>
  <div id="main">
    <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><font size=5px><a href="index.jsp">INFOGAIN JOB<span class="logo_colour">PORTAL</span></a></font></h1>
        </div>
      </div>
      
      <nav>
        <ul class="sf-menu" id="nav">
          <li class="selected"><a href="Employee.jsp">Home</a></li>
		     <li><a href="index.jsp">Log Out</a></li>
        
        </ul>
        
      </nav>
    </header>
    </div>
    <div id="site_content">
      <div id="sidebar_container">
        <div class="gallery">
          <ul class="images">
            <li class="show"><img width="450" height="450" src="1.jpg" alt="photo_one" /></li>
            <li><img width="450" height="450" src="2.jpg" alt="photo_two" /></li>
            <li><img width="450" height="450" src="3.jpg" alt="photo_three" /></li>
          </ul>
        </div>
      </div>
      <div id="content">
  <form action="view.html">
	<table >
	<%
	
	Skills skill= get.getSkills(e.getEmp_id());
	
	
	%>

	 <tr><td> Employee ID</td><td><%=e.getEmp_id() %></td></tr>
	<tr><td>Mobile No</td><td><%=e.getMobile() %></td></tr>
	<tr><td>Email ID</td><td><%=e.getMail_id() %></td></tr>
	<tr><td>Designation</td><td><%=e.getDesignation() %></td></tr>
	<tr><td>Branch id</td><td><%=e.getBranch_id() %></td></tr> 
	<tr><td>Skills</td><td><%=skill.getSkills()%></td></tr>
	<tr><td>Certifications</td><td><%=skill.getCertifications() %></td></tr>
    <tr><td>Projects Undertaken</td><td><%=skill.getProjects()%></td></tr>
	 <tr><td>D.O.B</td><td><%=e.getDob() %></td></tr>
	<tr><td>D.O.J</td><td><%=e.getDoj() %></td></tr> 
	
   <tr><td>Experience</td><td><%=e.getExperience() %></td></tr>
	
 
	</table>
	 </form>
	
	
	 <!-- <a href="postjobs/ProfileEdit.jsp"><input class="buttom" name="submit" id="submit" tabindex="5" value="Edit Profile" type="button"></a> --> 	
	

	 <a href="./ApproveServlet?user=<%=e.getEmp_id()+","+j.getJob_id()%>">Approve</a>
	 <a href="./RejectServlet?user=<%=e.getEmp_id()+","+j.getJob_id()%>">Reject</a>
	
   </div>
    
    <footer>
      <p>Copyright &copy; 2015 Infogain Corporation. All rights reserved.</p>
    </footer>
  </div>
  <p>&nbsp;</p>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="jquery.js"></script>
  <script type="text/javascript" src="jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="jquery.sooperfish.js"></script>
  <script type="text/javascript" src="image_fade.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>
</body>
</html>