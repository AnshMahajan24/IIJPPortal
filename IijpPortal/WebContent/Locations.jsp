<%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@page import="java.util.*"%>
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
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="modernizr-1.5.min.js"></script>
</head>

<body>
<%
if(session.getAttribute("employee_name")==null)
{
	response.sendRedirect("index.jsp");
}

%>
<%
 ArrayList<Jobs> specbranch=(ArrayList<Jobs>)request.getAttribute("specbranch");
String showJobs=(String) request.getAttribute("showJobs");

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
          
            
             <li><a href="#">JOBS</a>
            <ul>
              <li><a href="#">Jobs By Location</a>
              <ul>
			  <%
			  GetDepartments get=new GetDepartments();
			  ArrayList<Branch> branch=get.getBranch();
			  ArrayList<String> jobnames=get.getJobNames();
			  ArrayList<Departments> departments=get.getdepartments();
			  for(Branch b:branch)
			  {
			  %>
			   
                  <li><a href="./BranchServlet?user=<%=b.getBranch_id() %>"><%=b.getBranch_name() %> </a></li>
                  
               
                <%
               }
                %>
                </ul>
				</li>
              <li><a href="#">Jobs By Designation</a>
              <ul>
              <%
              for(String j:jobnames)
			  {
              %>
                
                  <li><a href="./DesignationServlet?user=<%=j %>"><%=j %> </a></li>
                  
                
                <%
			  }
                %>
                </ul>
              </li>
              <li><a href="#">Jobs By Departments</a>
               <ul>
              <%
              for(Departments d:departments)
              {
              
              %>
			  
                  <li><a href="./DepartmentServlet?user=<%=d.getDepartment_id() %>"><%=d.getDepartment_name() %> </a></li>
                 
                
                 <%
              }
              %>	
              </ul>  
			  </li>
        
            </ul>
          </li>
		   <li><a href="view.html">View Profile</a></li>
		    
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
        <h1>Jobs For <%=showJobs %></h1>
        <p> In case of Any Queries Please feel free to comprehend</p>
        
          <div class="form_settings">
          <%
          int i=1;
          %>
          <table border="" >
          <tr>
          <th>Job</th><th>Job Position</th><th>Salary</th><th>Last date to apply</th>
          </tr>
          <%for(Jobs j:specbranch)
			{%>
			<tr>
			<td><%=i++ %></td>
			<td><a href="ApplyJob.jsp?user=<%=j.getJob_id() %>"><%=j.getJob_name() %></a></td>
			<td> <%=j.getExpected_sal()%></td> <td><%=j.getLastdate() %></td>
			</tr>
			
			<% }%>
			</table>
			<%specbranch.clear(); %>
         </div>
        
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