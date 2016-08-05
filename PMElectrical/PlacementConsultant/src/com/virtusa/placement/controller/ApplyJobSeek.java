package com.virtusa.placement.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.ApplyJobSeekBiz;
import com.virtusa.placement.sms.SmsClient;


public class ApplyJobSeek extends ActionSupport {

	
	private String jobIdT;
	private String seekerIdT;
	private String errorReport;
	private String successReport;
	private String retval;
	
	public String getRetval() {
		return retval;
	}

	public void setRetval(String retval) {
		this.retval = retval;
	}

	public String execute()
	{
		
		ApplyJobSeek ajs=new ApplyJobSeek();
		ajs.setSeekerIdT(getSeekerIdT());
		ajs.setJobIdT(getJobIdT());
		ApplyJobSeekBiz ajsb=new ApplyJobSeekBiz();
		ajs=ajsb.applyJobSeekMethod(ajs);
		setErrorReport(ajs.getErrorReport());
		setSuccessReport(ajs.getSuccessReport());
		if(ajs.getRetval().equals("success"))
		{
			Map session=ActionContext.getContext().getSession();
			
			String userName=session.get("userName").toString();
			
			try {
				SmsClient.sendsms(session.get("mobile").toString(), "Hi "+userName+", Ur Account is Successfully Updated in JobsCorp.com");
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}
		return ajs.getRetval();
	}
	
	public String getSeekerIdT() {
		return seekerIdT;
	}
	public void setSeekerIdT(String seekerIdT) {
		this.seekerIdT = seekerIdT;
	}
	
	public String getErrorReport() {
		return errorReport;
	}
	public void setErrorReport(String errorReport) {
		this.errorReport = errorReport;
	}
	public String getSuccessReport() {
		return successReport;
	}
	public void setSuccessReport(String successReport) {
		this.successReport = successReport;
	}

	public String getJobIdT() {
		return jobIdT;
	}

	public void setJobIdT(String jobIdT) {
		this.jobIdT = jobIdT;
	}
	
}

