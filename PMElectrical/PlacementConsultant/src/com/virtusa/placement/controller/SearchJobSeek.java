package com.virtusa.placement.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.SearchJobSeekBiz;

public class SearchJobSeek extends ActionSupport {
	
	private String desigT ;
	private String skillT;
	private String locationT;
	private String experienceT;
	private String funAreaT;
	private String minSalT;
	private String maxSalT;
	
	
	private static List selectedJobsList;
	private  List selectedJobs;
	
	private String errorReport;
	private String retVal;
	
public String execute()
{		
	SearchJobSeek sjs=new SearchJobSeek();
	SearchJobSeekBiz  sjsb=new SearchJobSeekBiz();
	try
	{
		
	
	
	sjs.setDesigT(getDesigT());
	sjs.setSkillT(getSkillT());
	sjs.setLocationT(getLocationT());
	sjs.setExperienceT(getExperienceT());
	sjs.setFunAreaT(getFunAreaT());
	sjs.setMinSalT(getMinSalT());
	sjs.setMaxSalT(getMaxSalT());
	
	sjs=sjsb.applyJobSeekMethod(sjs);
	
	setErrorReport(sjs.getErrorReport());
	setSelectedJobs(sjs.getSelectedJobs());
	selectedJobsList=sjs.getSelectedJobs();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return sjs.getRetVal();

}



public String getRetVal() {
	return retVal;
}

public void setRetVal(String retVal) {
	this.retVal = retVal;
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


public String getExperienceT() {
	return experienceT;
}


public void setExperienceT(String experienceT) {
	this.experienceT = experienceT;
}


public String getFunAreaT() {
	return funAreaT;
}


public void setFunAreaT(String funAreaT) {
	this.funAreaT = funAreaT;
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

public static List getSelectedJobsList() {
	return selectedJobsList;
}

public static void setSelectedJobsList(List selectedJobsList) {
	SearchJobSeek.selectedJobsList = selectedJobsList;
}



public List getSelectedJobs() {
	return selectedJobs;
}



public void setSelectedJobs(List selectedJobs) {
	this.selectedJobs = selectedJobs;
}

public List selectedList()
{
	return selectedJobsList;
}
	
}
