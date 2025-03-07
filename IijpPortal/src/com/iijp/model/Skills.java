package com.iijp.model;

public class Skills {

	private String employee_id;
	private String skills;
	private String certifications;
	private String projects;
	
	
	
	
	@Override
	public String toString() {
		return "Skills [employee_id=" + employee_id + ", skills=" + skills
				+ ", certifications=" + certifications + ", projects="
				+ projects + "]";
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	
	
	

}
