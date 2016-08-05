package com.virtusa.placement.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.MaxSalAjaxBiz;

public class MaxSalAjax extends ActionSupport{
	private String minSalT;
	private String maxSalT;
	private String errorReport;
	private List maxSalList;
	private String retVal;
	
	
	public String getRetVal() {
		return retVal;
	}


	public void setRetVal(String retVal) {
		this.retVal = retVal;
	}


	public String execute() 
	{
		MaxSalAjax msa=new MaxSalAjax();
		MaxSalAjaxBiz msab=new MaxSalAjaxBiz();
		msa.setMinSalT(getMinSalT());
		msa=msab.maxSalMethod(msa);
		setMaxSalList(msa.getMaxSalList());
		setErrorReport(msa.getErrorReport());
		
		return msa.getRetVal();
	}
	
	
	public String getMinSalT() {
		return minSalT;
	}
	public void setMinSalT(String minSalT) {
		this.minSalT = minSalT;
	}
	public String getMaxSalT() {
		return maxSalT;
	}
	public void setMaxSalT(String maxSalT) {
		this.maxSalT = maxSalT;
	}
	
	public String getErrorReport() {
		return errorReport;
	}
	public void setErrorReport(String errorReport) {
		this.errorReport = errorReport;
	}


	public List getMaxSalList() {
		return maxSalList;
	}


	public void setMaxSalList(List maxSalList) {
		this.maxSalList = maxSalList;
	}

}
