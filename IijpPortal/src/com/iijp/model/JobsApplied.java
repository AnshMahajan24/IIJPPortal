package com.iijp.model;

public class JobsApplied {

	private String employee_id;
	public JobsApplied() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobsApplied(String employee_id, String job_id, String apply_date) {
		super();
		this.employee_id = employee_id;
		this.job_id = job_id;
		this.apply_date = apply_date;
	}
	@Override
	public String toString() {
		return "JobsApplied [employee_id=" + employee_id + ", job_id=" + job_id
				+ ", apply_date=" + apply_date + "]";
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	private String job_id;
	private String apply_date;
	
	
	
}
