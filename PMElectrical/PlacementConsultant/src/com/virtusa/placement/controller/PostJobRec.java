package com.virtusa.placement.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.model.PostJobRecBiz;
import com.virtusa.placement.sms.SmsClient;
import com.opensymphony.xwork2.ActionSupport;

public class PostJobRec extends ActionSupport{

	private String desigT;
	private String skillT;
	private String locationT;
	private String minExpT;
	private String maxExpT;
	private String salaryT;
	private String descriptionT;
	private String funAreaT;
	private String userName;
	private String companyName;
	
	private String errorReport;
	private String retVal;
	public  boolean errorFlag;
	
	
	StringBuilder sb=new StringBuilder("Error: \n");
	PostJobRecBiz pjrb;
	PostJobRec pjr;
	public String execute()
	{	errorFlag=false;
		pjr=new PostJobRec();
		pjrb=new PostJobRecBiz();
		
		pjr.setUserName(getUserName());
		
		if(getDesigT().matches("(([a-zA-Z])+([ ])*)+"))
		{
			pjr.setDesigT(getDesigT());
		}
		else
		{
			sb.append(" * Enter the valid Designation... \n");
			
			errorFlag=true;
		}
		if(getSkillT().matches("(([a-zA-Z])+([ ,])*)+"))
		{
			pjr.setSkillT(getSkillT());
		}
		else
		{
			sb.append(" * Enter the Valid Skill....\n");
			errorFlag=true;
		}
		if(getLocationT().matches("(([a-zA-Z])+([ ])*)+"))
		{
			pjr.setLocationT(getLocationT());
			
		}
		else
		{
			sb.append(" * Enter the Valid location... \n");
			errorFlag=true;
		}
		if(getMinExpT().matches("[0-9][0-9]?"))
		{
			pjr.setMinExpT(getMinExpT());
		}
		else
		{
			sb.append(" * Select minimum experience... \n");
			errorFlag=true;
		}
		if(getMaxExpT().matches("[0-9][0-9]?"))
		{
			pjr.setMaxExpT(getMaxExpT());
		}
		else
		{
			sb.append(" * Select maximum experience... \n");
			errorFlag=true;
		}
		if(getDescriptionT().matches("[ ]*")|| !(getDescriptionT().length()>0))
		{
			pjr.setDescriptionT("No description for this job...");			
		}
		else
		{
			pjr.setDescriptionT(getDescriptionT());
		}
		if(getSalaryT().matches("[0-9]*"))
		{
			pjr.setSalaryT(getSalaryT());
		}
		else
		{
			sb.append(" * Select salary... \n");
			errorFlag=true;
		}
		if(!getFunAreaT().equals("-1"))
		{
			pjr.setFunAreaT(getFunAreaT());
		}
		else
		{
			sb.append(" * Select any suitable functional area... \n");
			errorFlag=true;
		}
		
		
		if(errorFlag)
		{
			setErrorReport(sb.toString());
			return ERROR;
		}
		else
		{
			pjr=pjrb.postingJob(pjr);
			
			setErrorReport(pjr.getErrorReport());
			return pjr.getRetVal();	
		}
				
		
		
		
	}
	public String getDesigT() {
		return desigT;
	}
	public void setDesigT(String desigT) {
		this.desigT = desigT;
	}
	public String getSkillT() {
		return skillT;
	}
	public void setSkillT(String skillT) {
		this.skillT = skillT;
	}
	public String getLocationT() {
		return locationT;
	}
	public void setLocationT(String locationT) {
		this.locationT = locationT;
	}
	public String getMinExpT() {
		return minExpT;
	}
	public void setMinExpT(String minExpT) {
		this.minExpT = minExpT;
	}
	public String getMaxExpT() {
		return maxExpT;
	}
	public void setMaxExpT(String maxExpT) {
		this.maxExpT = maxExpT;
	}
	public String getSalaryT() {
		return salaryT;
	}
	public void setSalaryT(String salaryT) {
		this.salaryT = salaryT;
	}
	public String getDescriptionT() {
		return descriptionT;
	}
	public void setDescriptionT(String descriptionT) {
		this.descriptionT = descriptionT;
	}
	public String getFunAreaT() {
		return funAreaT;
	}
	public void setFunAreaT(String funAreaT) {
		this.funAreaT = funAreaT;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
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
}
