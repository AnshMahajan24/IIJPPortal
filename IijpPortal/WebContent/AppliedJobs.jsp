<%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>photo_style</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="style.css" />

  <script type="text/javascript" src="modernizr-1.5.min.js"></script>
</head>



<body>

<%GetDepartments get= new GetDepartments();
ArrayList<JobsApplied> appliedJobs= get.getAppliedJobs();%>
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
          <li class="selected"><a href="index.jsp">Home</a></li>
         <li><a href="Organise.html">Organisation chart</a></li>
          <li><a href="./Logoutservlet">Log Out</a></li>
          </ul>
      </nav>
    </header>
    <div id="site_content">
      <div id="sidebar_container">
        <div id="gallery">
          <ul class="images">
            <li class="show"><img width="450" height="450" src="1.jpg" alt="photo_one" /></li>
            <li><img width="450" height="450" src="2.jpg" alt="photo_two" /></li>
            <li><img width="450" height="450" src="3.jpg" alt="photo_three" /></li>
          </ul>
        </div>
      </div>
      <div id="content">
        
        <form id="contact" action="CheckApproveServlet">
          <div class="form_settings">
            <p><font size=5px>Following are the Applied Jobs</font></p>
           <%for ( JobsApplied ite:appliedJobs ) 
            {%>
				<h3>
				<a href="AppliedJobsServlet?user=<%=ite.getEmployee_id()+","+ite.getJob_id()%>"><%=ite.getEmployee_id() %></a>&nbsp;&nbsp;
				<a href="AppliedJobsServlet?user=<%=ite.getJob_id()+","+ite.getEmployee_id()%>"><%=ite.getJob_id() %></a>
				</h3>
				<h3><%=ite.getApply_date() %></h3>
				
				<br>
	
			<%} %>
			
         </div>
        </form>
      </div>
    </div>
    <footer>
      <p>Copyright &copy; 2015 Infogain Corporation. All rights reserved.</p>
    </footer>
  </div>
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