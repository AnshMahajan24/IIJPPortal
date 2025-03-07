package com.iijp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.iijp.model.Jobs;
import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class ApplyJobServlet
 */
public class ApplyJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InitialContext ic;
	Connection con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String job_id=(String) request.getSession().getAttribute("job_id");
		String employee_id=(String)request.getSession().getAttribute("user");
		
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
		response.getWriter().println(job_id+employee_id);
		
		
		try{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
	
			
		    String query="insert into iijp_jobs_applied values(?,?,'"+sf.format(new Date())+"')";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(2,  job_id);
			
			stmt.setString(1, employee_id);
			
			int result=stmt.executeUpdate();
			if(result!=0)
			{
				request.getSession().setAttribute("success","You have successfully applied for this job");
				request.getRequestDispatcher("Employee.jsp").forward(request, response);
				System.out.println("inserted");	
		 }
			else
			{
				request.getSession().setAttribute("success","Sorry Unable to apply for the Job.Try again!!!");
				response.sendRedirect("Employee.jsp");
				System.out.println("fail");	
		 }
				
			
			
		}catch(Exception e)
		{
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
