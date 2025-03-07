package com.iijp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class ValidateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
 
    public ValidateServlet() 
    {
        super();
       
    }


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String[] errorList=new String[5];
		for (int i = 0; i < errorList.length; i++) {
			errorList[i]="";
		}
		
		String userId=request.getParameter("userId");
		
		if(userId.length()==0||userId.isEmpty()||userId.trim().isEmpty())
		{
			errorList[0]="User Id can't be empty";
			request.getSession().setAttribute("errorList", errorList);
			response.sendRedirect("New folder/form.jsp");
			return;
		}
		else if(!userId.matches("[0-9]+"))
		{
			errorList[1]="User Id not valid";
			request.getSession().setAttribute("errorList", errorList);
			response.sendRedirect("New folder/form.jsp");
			return;
		}
		
		String password=request.getParameter("password");
		if(password.length()==0||password.isEmpty()||password.trim().isEmpty())
		{
			errorList[2]="Password can't be empty";
			request.getSession().setAttribute("errorList", errorList);
			response.sendRedirect("New folder/form.jsp");
			return;
		}
		else if(password.length()<6)
		{
			errorList[3]="Password should be minimum of 6 digits";
			request.getSession().setAttribute("errorList", errorList);
			response.sendRedirect("New folder/form.jsp");
			return;
		}
		
		
		InitialContext ic;
		Connection con = null;
		try
		{
			String employee_id="";
			String type="";
			String pass="";
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_Login where employee_id="+userId+"and password="+password;
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			if(result.next())
			{
				employee_id=result.getString(1);
				pass=result.getString(2);
				type=result.getString(3);
				
				request.getSession().invalidate();
				request.getSession().setAttribute("user", employee_id);
				
				if(type.equalsIgnoreCase("A"))
				{
					String query1="select e.employee_name,e.designation,d.department_name" +
							" from iijp_Employees e,iijp_Departments d " +
							"where e.department_id=d.department_id and e.employee_id="+userId;
					Statement stmt1=con.createStatement();
					ResultSet result1=stmt1.executeQuery(query1);
					if(result1.next())
					{
						String employee_name=result1.getString(1);
						String designation=result1.getString(2);
						String department_name=result1.getString(3);
						request.getSession().setAttribute("admin", employee_name);
						
						request.getSession().setAttribute("designation", designation);
						request.getSession().setAttribute("department_name", department_name);
					RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
					rd.forward(request, response);
					}
					}
				else{
					String query2="select e.employee_name,e.designation,d.department_name" +
							" from iijp_Employees e,iijp_Departments d " +
							"where e.department_id=d.department_id and e.employee_id="+userId;
					Statement stmt2=con.createStatement();
					ResultSet result2=stmt2.executeQuery(query2);
					if(result2.next())
					{
						String employee_name=result2.getString(1);
						String designation=result2.getString(2);
						String department_name=result2.getString(3);
						request.getSession().setAttribute("employee_name", employee_name);
						request.getSession().setAttribute("designation", designation);
						request.getSession().setAttribute("department_name", department_name);
						RequestDispatcher rd=request.getRequestDispatcher("Employee.jsp");
						rd.forward(request, response);
					}
				
				}
				
			}
			else
			{
				errorList[4]="Authentication Failed. Please enter valid details";
				request.getSession().setAttribute("errorList", errorList);
				response.sendRedirect("New folder/form.jsp");
				return;
				
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
		
		/*if(errorList!=null)
		{
			System.out.println("error aaya");
		}*/
		
		//this code is creating problem in dispatching request to form.jsp after checking the credentials in db
		/*if(errorList!=null)
		{
			request.getSession().setAttribute("errorList", errorList);
			response.sendRedirect("New folder/form.jsp");

		}*/
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
