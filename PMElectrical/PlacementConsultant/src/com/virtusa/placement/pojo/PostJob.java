package com.virtusa.placement.pojo;

import java.util.Date;

public class PostJob {
private long jobId;
private String minExp;
private String maxExp;
private String salary;
private String companyName;
private String userName;
private String desig;
private String funArea;
private String skill;
private String location;
private String jobDesc;
private String postedDate;

public String getJobDesc() {
	return jobDesc;
}
public void setJobDesc(String jobDesc) {
	this.jobDesc = jobDesc;
}


public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getDesig() {
	return desig;
}
public void setDesig(String desig) {
	this.desig = desig;
}
public String getFunArea() {
	return funArea;
}
public void setFunArea(String funArea) {
	this.funArea = funArea;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

public String getPostedDate() {
	return postedDate;
}
public void setPostedDate(String postedDate) {
	this.postedDate = postedDate;
}

public String getMinExp() {
	return minExp;
}
public void setMinExp(String minExp) {
	this.minExp = minExp;
}
public String getMaxExp() {
	return maxExp;
}
public void setMaxExp(String maxExp) {
	this.maxExp = maxExp;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public long getJobId() {
	return jobId;
}
public void setJobId(long jobId) {
	this.jobId = jobId;
}



}
