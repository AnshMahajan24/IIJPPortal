package com.iijp.model;

import java.util.Date;

public class Employees {

	private String emp_id;
	private String emp_name;
	private String mobile;
	private String gender;
	private String mail_id;
	private Date dob;
	@Override
	public String toString() {
		return "Employees [emp_id=" + emp_id + ", emp_name=" + emp_name
				+ ", mobile=" + mobile + ", gender=" + gender + ", mail_id="
				+ mail_id + ", dob=" + dob + ", doj=" + doj + ", designation="
				+ designation + ", branch_id=" + branch_id + ", experience="
				+ experience + ", dept_id=" + dept_id + ", inbox=" + inbox
				+ "]";
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Date doj;
    private String designation;
    private String branch_id;
    private int experience;
    private String dept_id;
    private String inbox;
	public Employees(String emp_id, String emp_name, String mobile,
			String gender, String mail_id, Date dob, Date doj,
			String designation, String branch_id, int experience,
			String dept_id, String inbox) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.mobile = mobile;
		this.gender = gender;
		this.mail_id = mail_id;
		this.dob = dob;
		this.doj = doj;
		this.designation = designation;
		this.branch_id = branch_id;
		this.experience = experience;
		this.dept_id = dept_id;
		this.inbox = inbox;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getInbox() {
		return inbox;
	}
	public void setInbox(String inbox) {
		this.inbox = inbox;
	}
    
   
	

}
