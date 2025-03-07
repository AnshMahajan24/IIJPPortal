package com.iijp.model;

public class Departments {

	private String department_id;
	@Override
	public String toString() {
		return "Departments [department_id=" + department_id
				+ ", department_name=" + department_name + ", admin_id="
				+ admin_id + "]";
	}
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departments(String department_id, String department_name,
			String admin_id) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.admin_id = admin_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	private String department_name;
	private String admin_id;
	
	
	
}
