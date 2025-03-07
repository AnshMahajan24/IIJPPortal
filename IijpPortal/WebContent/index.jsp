<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
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
  <div id="main">
    <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><font size=5px><a href="">INFOGAIN JOB<span class="logo_colour">PORTAL</span></a></font></h1>
			<img src="logo.jpg" height=60 width=220/>
		</div>
      </div>
      <nav>
        <ul class="sf-menu" id="nav">
          <li class="selected"><a href="index.jsp">Home</a></li>
          <li><a href="New folder/form.jsp">Login</a></li>
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
			   
                  <li><a href="New folder/form.jsp"><%=b.getBranch_name() %> </a></li>
                  
               
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
                
                  <li><a href="New folder/form.jsp"><%=j %> </a></li>
                  
                
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
			  
                  <li><a href="New folder/form.jsp"><%=d.getDepartment_name() %> </a></li>
                 
                
                 <%
              }
              %>	
              </ul>  
			  </li>
        
            </ul>
          </li>
		  
          <li><a href="contact.html">Contact Us</a></li>
		     
			
       
        </ul>
      </nav>
    </header>
    <div id="site_content">
      <div id="sidebar_container">
        <div class="gallery">
          <ul class="images">
            <li class="show"><img width="450" height="450" src="1.jpg" alt="photo_one" /></li>
            <li><img width="450" height="450" src="2.jpg" alt="photo_two" /></li>
            <li><img width="450" height="450" src=" 3.jpg" alt="photo_three" /></li>
          </ul>
        </div>
      </div>
      <div id="content">
        <h1><font size=6px>Latest Jobs</font></h1>
        <p><font size=3px>Responsible for supervising promotions programs to incentivize 
        the point-of-employee-satisfaction.</font></p>
			<p>A Transparent system allowing everyone 
			to play fair and get deserving promotions</p>
		<p>Explore our exciting career opportunities
		 across technical, non-technical and BPO categories.</p>
		<p>A place that empowers people who perform</p>
        
      </div>
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