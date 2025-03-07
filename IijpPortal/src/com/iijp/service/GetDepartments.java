package com.iijp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.iijp.model.*;

public class GetDepartments {

	
	InitialContext ic;
	Connection con = null;
	ArrayList<Departments> departments=new ArrayList<Departments>();
	ArrayList<Branch> branch=new ArrayList<Branch>();
	ArrayList<Jobs> jobs=new ArrayList<Jobs>();
	ArrayList<JobsApplied> appliedJobs=new ArrayList<JobsApplied>();
	ArrayList<Employees> employees=new ArrayList<Employees>();
	ArrayList<String> name=new ArrayList<String>();
	public ArrayList<Departments> getdepartments()
	{
		
		try
		{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_departments";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				departments.add(new Departments(result1.getString(1),result1.getString(2),result1.getString(3)));
				
			}
				
			return departments;
	
			
		    
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
		return departments;
		
	}
	
	public ArrayList<Branch> getBranch()
	{
		try
		{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_branch";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				branch.add(new Branch(result1.getString(1),result1.getString(2),result1.getString(3)));
				
			}
				
			return branch;
	
			
		    
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
		return branch;
	}
	
	public ArrayList<Jobs> getJobs(){
		try
		{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_jobs";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				jobs.add(new Jobs(result1.getString(1),result1.getString(2),result1.getString(3),result1.getString(4),result1.getInt(5),result1.getInt(6),result1.getString(7),result1.getDate(8)));
				
			}
			
				
			return jobs;
	
			
		    
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
		return jobs;
		
		
	}
	
	
	public ArrayList<JobsApplied> getAppliedJobs(){
		try
		{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_jobs_applied";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				appliedJobs.add(new JobsApplied(result1.getString(1),result1.getString(2),result1.getString(3)));
				
			}
			
				
			return appliedJobs;
	
			
		    
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
		return appliedJobs;
		
		
	}
	
	
	
	
	public ArrayList<String> getJobNames(){
		try
		{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select distinct job_name from iijp_jobs";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				name.add(result1.getString(1));
				
			}
			
				
			return name;
	
			
		    
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
		return name;
		
		
	}
	
	public ArrayList<Employees> getEmployees()
	{
		try
		{
			
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_employees";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				employees.add(new Employees(result1.getString(1),result1.getString(2),result1.getString(3),result1.getString(4),result1.getString(5),result1.getDate(6),result1.getDate(7),result1.getString(8),result1.getString(9),result1.getInt(10),result1.getString(11),result1.getString(12)));
				
			}
				
			return employees;
	
			
		    
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
		return employees;
	}
	
	
	public Employees getEmployeesById(String id)
	{
		try
		{
			Employees emp = null;
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
		    String query="select * from iijp_employees";
			Statement stmt=con.createStatement();
			
			
			
			ResultSet result1=stmt.executeQuery(query);
			while(result1.next())
			{
				if(result1.getString(1).equalsIgnoreCase(id))
				{
				emp=new Employees(result1.getString(1),result1.getString(2),result1.getString(3),result1.getString(4),result1.getString(5),result1.getDate(6),result1.getDate(7),result1.getString(8),result1.getString(9),result1.getInt(10),result1.getString(11),result1.getString(12));
				break;
				}
				}
				
				
			return emp;
	
			
		    
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
		return null;
	}
	
	public Jobs getJobsById(String id)
	{
		try
		{ 
			Jobs jobs=new Jobs();
			ic= new InitialContext();
		    DataSource ds=(DataSource) ic.lookup("java:OracleDS");
		    con=ds.getConnection();
			String query ="select * from iijp_jobs";
			Statement stme=con.createStatement();
			ResultSet result1=stme.executeQuery(query);
			while(result1.next())
			{
				if(result1.getString(1).equalsIgnoreCase(id))
				{
					jobs=new Jobs(result1.getString(1),result1.getString(2),result1.getString(3),result1.getString(4),result1.getInt(5),result1.getInt(6),result1.getString(7),result1.getDate(8));
			break;}
			}
		    return jobs;
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
		return null;
	}
	
	
	public Skills getSkills(String employee_id)
	{
		Skills skills= new Skills();
		InitialContext ic;
		try {
			ic = new InitialContext();
			DataSource ds =(DataSource)ic.lookup("java:OracleDS");
			Connection con= ds.getConnection();
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from IIJP_SKILLS where EMPLOYEE_ID="+employee_id+"");
			while(rs.next())
			{
				skills.setEmployee_id(rs.getString(1));
				skills.setSkills(rs.getString(2));
				skills.setCertifications(rs.getString(3));
				skills.setProjects(rs.getString(4));
			}
			return skills;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in connection with db");
			e.printStackTrace();
		}
		
		
		
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public int approval(String id,String job_id)
	{
		
		InitialContext ic;
		String j_id="";
		String inbox="";
		try {
			ic = new InitialContext();
			DataSource ds =(DataSource)ic.lookup("java:OracleDS");
			Connection con= ds.getConnection();
			String query="select inbox from iijp_employees where employee_id="+id;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				inbox=rs.getString(1);
			}
			String str="update iijp_employees set inbox=? where EMPLOYEE_ID="+id;
			PreparedStatement stmt=con.prepareStatement(str);
			GetDepartments get =new GetDepartments();
			ArrayList<Jobs> jobs=get.getJobs();
			for (Jobs j : jobs) {
				if(j.getJob_id().equals(job_id))
				{
					j_id=j.getJob_name();
					break;
				}
			}
			stmt.setString(1,inbox+","+"Your Application for "+j_id+" post has been Accepted");
			int result=stmt.executeUpdate();
			
			
			return result;
			
		} 
		
		catch (Exception e) 
		{
			
			System.out.println("error in connection with db");
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
	}
	
	
	public int rejected(String id,String job_id)
	{
		
		InitialContext ic;
		String j_id="";
		String inbox="";
		try {
			ic = new InitialContext();
			DataSource ds =(DataSource)ic.lookup("java:OracleDS");
			Connection con= ds.getConnection();
			String query="select inbox from iijp_employees where employee_id="+id;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				inbox=rs.getString(1);
			}
			String str="update iijp_employees set inbox=? where EMPLOYEE_ID="+id;
			PreparedStatement stmt=con.prepareStatement(str);
			GetDepartments get =new GetDepartments();
			ArrayList<Jobs> jobs=get.getJobs();
			for (Jobs j : jobs) {
				if(j.getJob_id().equals(job_id))
				{
					j_id=j.getJob_name();
					break;
				}
			}
			stmt.setString(1,inbox+","+"Your Application for "+j_id+" post has been Rejected");
			int result=stmt.executeUpdate();
			
			
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in connection with db");
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
	}
	public int removeAppliedjobs(String id, String job_id)
	{
		
		InitialContext ic;
		
		try {
			ic = new InitialContext();
			DataSource ds =(DataSource)ic.lookup("java:OracleDS");
			Connection con= ds.getConnection();
			String str="delete from iijp_jobs_applied where employee_id=? and job_id=?";
			PreparedStatement stmt=con.prepareStatement(str);
			stmt.setString(1,id);
			stmt.setString(2,job_id);
			int result=stmt.executeUpdate();
			
			
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in connection with db");
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return 0;
		
		
		
	}
	
}
