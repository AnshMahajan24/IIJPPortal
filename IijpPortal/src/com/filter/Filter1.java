package com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import com.iijp.model.Jobs;
import com.iijp.service.GetDepartments;

/**
 * Servlet Filter implementation class Filter1
 */
public class Filter1 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
			GetDepartments get=new GetDepartments();
			ArrayList<Jobs> jobs=get.getJobs();
			Date date=new Date();
			for (Jobs j : jobs) {
				if(j.getLastdate().before(date))
				{
					try{
					InitialContext ic=new InitialContext();
					DataSource ds=(DataSource) ic.lookup("java:OracleDS");
					Connection con=ds.getConnection();
					String query="delete from iijp_jobs where job_id=?";
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(1, j.getJob_id());
					int result=stmt.executeUpdate();
					con.close();
					
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
					
				}
			}
			
		
		System.out.println("Filter Started");
		chain.doFilter(request, response);
		System.out.println("Filter Ended");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
