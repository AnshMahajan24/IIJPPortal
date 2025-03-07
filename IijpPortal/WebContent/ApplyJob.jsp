<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


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
if(session.getAttribute("employee_name")==null)
{
	response.sendRedirect("index.jsp");
}
String job_id=request.getParameter("user");
GetDepartments get=new GetDepartments();
ArrayList<Jobs> jobs=get.getJobs();
ArrayList<Departments> departments=get.getdepartments();
ArrayList<Branch> branch=get.getBranch();
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
          <li class="selected"><a href="index.jsp">Home</a></li>
         <li><a href="Organise.html">Organisation chart</a></li>
          
            
             
		   
		    
          <li><a href="contact.html">Contact Us</a></li>
		     
			 <li><a href="index.jsp">Log Out</a></li>
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
      <form action="./ApplyJobServlet">
        <%
        for (Jobs j : jobs) {
        	if(job_id.equals(j.getJob_id()))
        	{
        	session.setAttribute("job_id",job_id);
        	%>
        		<h3><%=j.getJob_name() %></h3>
        		<p>Skills Required:- <%=j.getSkill_set()
        		%></p>
        		<%for(Departments d:departments)
        		{
        		     if(j.getDepartment_id().equals(d.getDepartment_id()))
        		%>
        		        		<p>Department: <%=d.getDepartment_name() %></p>
        	<%break;} %>
        		
        		<%for(Branch b:branch)
        		{
        		     if(j.getBranch_id().equals(b.getBranch_id()))
        		%>
        		        		<p>Branch Location: <%=b.getBranch_name() %></p>
        	<%break;} %>
                <p>Experience Required: <%=j.getExperience_req() %></p>        	
        		<p>Salary: <%=j.getExpected_sal() %></p>
        		<p>Application Deadline: <%=j.getLastdate() %></p>
        		
        	<%}
        	%>
        <% }
        %>  
       <input type="submit" value="Apply For This Job"/>
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




</body>
</html>