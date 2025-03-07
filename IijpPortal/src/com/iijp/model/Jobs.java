package com.iijp.model;

import java.util.Date;

public class Jobs {

	private String job_id;
	@Override
	public String toString() {
		return "Jobs [job_id=" + job_id + ", job_name=" + job_name
				+ ", department_id=" + department_id + ", branch_id="
				+ branch_id + ", expected_sal=" + expected_sal
				+ ", experience_req=" + experience_req + ", skill_set="
				+ skill_set + ", lastdate=" + lastdate + "]";
	}
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jobs(String job_id, String job_name, String department_id,
			String branch_id, int expected_sal, int experience_req,
			String skill_set, Date lastdate) {
		super();
		this.job_id = job_id;
		this.job_name = job_name;
		this.department_id = department_id;
		this.branch_id = branch_id;
		this.expected_sal = expected_sal;
		this.experience_req = experience_req;
		this.skill_set = skill_set;
		this.lastdate = lastdate;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public int getExpected_sal() {
		return expected_sal;
	}
	public void setExpected_sal(int expected_sal) {
		this.expected_sal = expected_sal;
	}
	public int getExperience_req() {
		return experience_req;
	}
	public void setExperience_req(int experience_req) {
		this.experience_req = experience_req;
	}
	public String getSkill_set() {
		return skill_set;
	}
	public void setSkill_set(String skill_set) {
		this.skill_set = skill_set;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	private String job_name;
	private String department_id;
	private String branch_id;
	private int expected_sal;
	private int experience_req;
	private String skill_set;
	private Date lastdate;
	
}
