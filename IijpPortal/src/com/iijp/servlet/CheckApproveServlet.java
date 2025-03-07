package com.iijp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iijp.service.GetDepartments;

public class CheckApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CheckApproveServlet() 
    {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emp="";
		String job_id="";
		String selectedItem[] = request.getParameterValues("selectedItem");
		GetDepartments get= new GetDepartments();
	
		
		for (int i=0;i<selectedItem.length;i++) 
		{
			String str[]=selectedItem[i].split(",");
			
				 emp=str[0];
				job_id=str[1];
				int result = get.approval(emp,job_id);
				if(result>0)
				{
					System.out.println("Successfully Applied");
					int result1=get.removeAppliedjobs(emp, job_id);
					
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
