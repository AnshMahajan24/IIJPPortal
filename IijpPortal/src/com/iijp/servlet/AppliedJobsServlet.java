package com.iijp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iijp.model.Employees;
import com.iijp.model.Jobs;
import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class DeleteServlet
 */
public class AppliedJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppliedJobsServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String emp=request.getParameter("user");
		String spit[]=emp.split(",");
		
		emp=spit[0];
		String job_id=spit[1];
		GetDepartments get=new GetDepartments();
		
		if(!emp.startsWith("J"))
		{
			Employees e=new Employees();
			e=get.getEmployeesById(emp);
			Jobs j=new Jobs();
			j=get.getJobsById(job_id);
			request.setAttribute("applied",j);
			request.setAttribute("employee",e);
			RequestDispatcher rd=request.getRequestDispatcher("JobsByemployees.jsp");
			rd.forward(request, response);
			
		}		
		
		else 
		{
			
			response.getWriter().println("hello");
			Employees e=new Employees();
			e=get.getEmployeesById(job_id);
			Jobs j=new Jobs();
			j=get.getJobsById(emp);
			request.setAttribute("applied",j);
			request.setAttribute("employee",e);
			RequestDispatcher rd=request.getRequestDispatcher("JobsByjobsID.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
