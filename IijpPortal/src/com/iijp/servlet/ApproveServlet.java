package com.iijp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class ApproveServlet
 */
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user=request.getParameter("user");
		String emp[]=user.split(",");
		
		user=emp[0];
		String job_id=emp[1];
		GetDepartments get= new GetDepartments();
		int result = get.approval(user,job_id);
		
		if(result>0)
		{
			System.out.println("Successfully Applied");
			int result1=get.removeAppliedjobs(user, job_id);
			
			if(result1>0)
			{
				response.sendRedirect("AppliedJobs.jsp");
			}
			
		}
		else
		{
			System.out.println("Rejected");
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
