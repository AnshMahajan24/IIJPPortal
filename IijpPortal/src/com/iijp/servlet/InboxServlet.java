package com.iijp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iijp.model.Employees;
import com.iijp.service.GetDepartments;

/**
 * Servlet implementation class InboxServlet
 */
public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user= request.getParameter("user");
		GetDepartments get= new GetDepartments();
		ArrayList<Employees> emp= get.getEmployees();
		String str="";
		
		for (Employees ite : emp) 
		{
			
			System.out.println(ite.getEmp_id()+ite.getInbox());
			if(ite.getEmp_name().equals(user))
			{
				str=ite.getInbox();
				System.out.println(str);
				request.setAttribute("inbox",str);
				RequestDispatcher rd=request.getRequestDispatcher("Inbox.jsp");
				rd.forward(request, response);
				
			}
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
