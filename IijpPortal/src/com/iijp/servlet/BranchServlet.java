package com.iijp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iijp.model.Branch;
import com.iijp.model.Jobs;
import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class BranchServlet
 */
public class BranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Jobs> specbranch=new ArrayList<Jobs>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String branch=request.getParameter("user");
		GetDepartments get=new GetDepartments();
		ArrayList<Jobs> jobs=get.getJobs();
		
		ArrayList<Branch> branch1=get.getBranch();
		String branch_name="";
		for (Jobs j : jobs) 
		{
			if(j.getBranch_id().equals(branch))
			{
				specbranch.add(j);
				
			}
			
		}
		for (Branch branch2 : branch1) {
			if(branch.equals(branch2.getBranch_id()))
					{
				branch_name=branch2.getBranch_name();
				break;
					}
		}
		//response.getWriter().println(specbranch);
		if(specbranch!=null)
		{
			//response.getWriter().println("hello");
			request.setAttribute("specbranch", specbranch);
			request.setAttribute("showJobs", branch_name);
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
