package com.iijp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iijp.model.Branch;
import com.iijp.model.Departments;
import com.iijp.model.Jobs;
import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Jobs> specbranch=new ArrayList<Jobs>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department=request.getParameter("user");
		GetDepartments get=new GetDepartments();
		String showJobs="";
		ArrayList<Jobs> jobs=get.getJobs();
		ArrayList<Departments> dept=get.getdepartments();
		for (Jobs j : jobs) {
			if(j.getDepartment_id().equals(department))
			{
				specbranch.add(j);
				
			}
			
		}
		
		
				for(Departments d:dept){
				if(department.equals(d.getDepartment_id()))
				{
					showJobs=d.getDepartment_name();
				break;
				}
				                        }
	
		//response.getWriter().println(specbranch);
		if(specbranch!=null)
		{
			request.setAttribute("specbranch", specbranch);
			request.setAttribute("showJobs", showJobs);
			RequestDispatcher rd=request.getRequestDispatcher("Locations.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("NotAvailable.jsp");
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
