
	package com.virtusa.placement.controller;

	import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
import com.virtusa.placement.model.ViewRecruiterBiz;
import com.virtusa.placement.model.ViewSeekerBiz;
import com.virtusa.placement.pojo.RecruiterPojo;
	public class ViewRecruiter extends ActionSupport{
		private static final long serialVersionUID = 1L;
	private String username;
	
	private String company_name; 
	private String contactperson_name; 
	private String contactperson_empid;
	private String contactaddress; 
	private long phone;
	private long mobile;
	private String email;
	private String industry;
	private String retVal;
	private String city;
	private String errorReport;
	

public String getErrorReport() {
		return errorReport;
	}

	public void setErrorReport(String errorReport) {
		this.errorReport = errorReport;
	}

public String getRetVal() {
		return retVal;
	}

	public void setRetVal(String retVal) {
		this.retVal = retVal;
	}
	public String execute() throws Exception{
		System.out.print("view");
		Map session=ActionContext.getContext().getSession();
		ViewRecruiter vr=new ViewRecruiter();
		ViewRecruiterBiz vrb=new ViewRecruiterBiz();
		vr.setUsername(session.get("userName").toString());
		vr.company_name=company_name;
		vr.contactperson_name=contactperson_name;
		vr.contactperson_empid=contactperson_empid;
		vr.contactaddress=contactaddress;
		vr.phone=phone;
		vr.mobile=mobile;
		vr.email=email;
		vr.industry=industry;
		vr.city=city;
		vr=vrb.viewRecruiterMethod(vr);
		
		company_name=vr.company_name;
		contactperson_name=vr.contactperson_name;
		contactperson_empid=vr.contactperson_empid;
		contactaddress=vr.contactaddress;
		phone=vr.phone;
		mobile=vr.mobile;
		email=vr.email;
		industry=vr.industry;
		city=vr.city;
		return vr.getRetVal();
			
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
	

	


	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	}

	
	
	
	
	
	