package com.virtusa.placement.pojo;

public class RecruiterPojo {
	
	private String username;
	private String company_name; 
	private String contactperson_name; 
	private String contactperson_empid;
	private String contactaddress;
	private String city;
	private long phone;
	private long mobile;
	private String email;
	private String industry;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getContactperson_name() {
		return contactperson_name;
	}
	public void setContactperson_name(String contactperson_name) {
		this.contactperson_name = contactperson_name;
	}
	public String getContactperson_empid() {
		return contactperson_empid;
	}
	public void setContactperson_empid(String contactperson_empid) {
		this.contactperson_empid = contactperson_empid;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public long getPhone() {
		return phone;
	}
	public long getMobile() {
		return mobile;
	}
	

	}


