
	package com.virtusa.placement.controller;



	import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.UpdateRecruiterData; 
import com.virtusa.placement.model.UpdateSeekerProfileData;
import com.virtusa.placement.sms.SmsClient;
	
	public class UpdateRecruiter extends ActionSupport{
		private static final long serialVersionUID = 1L;
	private String username;
	
	private String company_name; 
	private String contactperson_name; 
	private String contactperson_empid;
	private String contactaddress; 
	private String city;
	private String phone;
	private String mobile;
	private String email;
	private String industry;
	public String execute() throws Exception
	{
		
	try {
		
		Map session=ActionContext.getContext().getSession();
		
		String userName=session.get("userName").toString();
		UpdateRecruiterData obj= new UpdateRecruiterData();
		obj.recruiterupdate(userName,getCompany_name(),getContactperson_name(),getContactperson_empid(),getContactaddress(),getCity(),getPhone(),getMobile(),getEmail(),getIndustry());
		SmsClient.sendsms(getMobile(), "Hi "+userName+", Ur Account is Successfully Updated in JobsCorp.com");

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return SUCCESS;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	}

