package com.iijp.servlet;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




/**
 * Servlet implementation class PostJobsServlet
 */
public class PostJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InitialContext ic;
	Connection con = null;
	static int i=1;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		response.setContentType("text/html");
		String position=request.getParameter("position");
		String department=request.getParameter("department");
		String salary=request.getParameter("salary");
		String Branch=request.getParameter("branch");
		String experience=request.getParameter("experience");
		String skills=request.getParameter("skills");
		String lastDate=request.getParameter("lastDay")+"-"+request.getParameter("lastMonth")+"-"+request.getParameter("lastYear");
	
		String job_id="J00"+(float)Math.random()*100000;
       
	
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
	
			
		    String query="insert into iijp_jobs values(?,?,?,?,?,?,?,'"+lastDate+"')";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1,  job_id.substring(0,5));
			i++;
			stmt.setString(2, position);
			stmt.setString(3, department);
			stmt.setString(4, Branch);
			stmt.setInt(5, Integer.parseInt(salary));
			stmt.setInt(6, Integer.parseInt(experience));
			stmt.setString(7,(skills));
			
			int result=stmt.executeUpdate();
			if(result!=0)
			{
				request.getSession().setAttribute("success","Job has been successfully posted");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
				System.out.println("inserted");	
		 }
			else
			{
				request.getSession().setAttribute("success","Sorry Unable to post the Job.Try again!!!");
				response.sendRedirect("Admin.jsp");
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
