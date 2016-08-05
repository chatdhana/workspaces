
	package com.virtusa.placement.controller;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.virtusa.placement.model.ViewSeekerBiz;
 

	public class ViewSeeker extends ActionSupport{
		private static final long serialVersionUID = 1L;

		private String username;
		private String first_name;
		private String last_name;
		private String email;
		private String dob;
		private String gender;
		private String contact_address;
		private long zip;
		private long landline;
		private long mobile;
		private String retVal;
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
		
		Map session=ActionContext.getContext().getSession();
		
		ViewSeeker vs=new ViewSeeker();
		ViewSeekerBiz vsb=new ViewSeekerBiz();
		vs.setUsername(session.get("userName").toString());
		vs.setFirst_name(getUsername());
		vs.setLast_name(getLast_name());
		vs.setEmail(getEmail());
		vs.setDob(getDob());
		vs.setGender(getGender());
		vs.setContact_address(getContact_address());
		vs.setZip(getZip());
		vs.setLandline(getLandline());
		vs.setMobile(getMobile());
		
		vs=vsb.viewSeekerMethod(vs);
		
		setFirst_name(vs.getFirst_name());
		setLast_name(vs.getLast_name());
		setEmail(vs.getEmail());
		setDob(vs.getDob());
		setGender(vs.getGender());
		setContact_address(vs.getContact_address());
		setZip(vs.getZip());
		setLandline(vs.getLandline());
		setMobile(vs.getMobile());
		
		
			
		return vs.getRetVal();
		}	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_address() {
		return contact_address;
	}

	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public long getLandline() {
		return landline;
	}

	public void setLandline(long landline) {
		this.landline = landline;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	
	}

	
	
	
	
	
	

