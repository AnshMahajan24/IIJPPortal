package com.iijp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.iijp.model.Employees;
import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class EditProfileservlet
 */
public class EditProfileservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InitialContext ic;
	Connection con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String eskills=request.getParameter("eskills");
		String eprojects=request.getParameter("eprojects");
		String ecertificate=request.getParameter("eaddress");
		String phone=request.getParameter("phone");
		String employee_id=(String) request.getSession().getAttribute("user");
		GetDepartments get=new GetDepartments();
		System.out.println(employee_id);
			String oldSkill="";
			String oldProjects="";
			String oldCertifications="";
				try{
				ic= new InitialContext();
			    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
			    con=ds.getConnection();
		       String q1  = "select skills , projects , certifications from iijp_skills where employee_id='"+ employee_id+"'";
				Statement ss = con.createStatement();
				ResultSet rs = ss.executeQuery(q1);
				while (rs.next()){
					oldSkill = rs.getString(1);
					oldProjects = rs.getString(2);
					oldCertifications = rs.getString(3);
				}
				
			    String query="update iijp_employees set mobile_number=? where employee_id=?";
				PreparedStatement stmt=con.prepareStatement(query);
				stmt.setString(1,  phone);
				
				stmt.setString(2, employee_id);
				
				
				int result=stmt.executeUpdate();
				System.out.println(result);
				String query1="update iijp_skills set skills=?,projects=?,certifications=? where employee_id=?";
				PreparedStatement stmt1=con.prepareStatement(query1);
				stmt1.setString(1,  oldSkill+","+eskills);
				
				stmt1.setString(2, oldProjects+","+eprojects);
				stmt1.setString(3, oldCertifications+","+ecertificate);
				stmt1.setString(4, employee_id);
				
				int result1=stmt1.executeUpdate();
				System.out.println(result1);
				if(result!=0 && result1!=0)
				{
					request.getSession().setAttribute("success1","Your Profile has been successfully updated");
					request.getRequestDispatcher("Employee.jsp").forward(request, response);
					System.out.println("inserted");	
			 }
				else
				{
					request.getSession().setAttribute("success1","Sorry Unable to update your profile.Try again!!!");
					response.sendRedirect("Employee.jsp");
					System.out.println("fail");	
			 }
					
				
				
				
				
			    
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}
			
			
		    
			finally{
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				
				
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
