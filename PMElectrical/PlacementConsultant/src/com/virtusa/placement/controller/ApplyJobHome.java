package com.virtusa.placement.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.ApplyJobHomeBiz;

public class ApplyJobHome extends ActionSupport{
private Logger myLog=Logger.getLogger(ApplyJobHome.class);


	
	private Set skill;
	private List experience;
	private List location;
	private List funArea;
	private List desig;
	private List minSal;
	private String errorReport;
	private String retVal;
	
	public String execute()
	{
		skill=new HashSet();
		experience=new ArrayList();
		location=new ArrayList();
		funArea=new ArrayList();
		desig=new ArrayList();
		minSal=new ArrayList();
		ApplyJobHome ajh=new ApplyJobHome();
		ApplyJobHomeBiz ajhb=new ApplyJobHomeBiz();
		ajh=ajhb.applyJobHomeMethod(ajh);
		
		setSkill(ajh.getSkill());
		setExperience(ajh.getExperience());
		setLocation(ajh.getLocation());
		setFunArea(ajh.getFunArea());
		setDesig(ajh.getDesig());
		setMinSal(ajh.getMinSal());
		setErrorReport(ajh.getErrorReport());
		if(ajh.getRetVal().equals("success"))
			myLog.info("Success at ApplyJobHome");
			
		return ajh.getRetVal();
	}
	
	
	
	
	public List getExperience() {
		return experience;
	}
	public void setExperience(List experience) {
		this.experience = experience;
	}
	public List getLocation() {
		return location;
	}
	public void setLocation(List location) {
		this.location = location; 
	}
	public List getFunArea() {
		return funArea;
	}
	public void setFunArea(List funArea) {
		this.funArea = funArea;
	}
	public List getDesig() {
		return desig;
	}
	public void setDesig(List desig) {
		this.desig = desig;
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


	public List getMinSal() {
		return minSal;
	}



	public void setMinSal(List minSal) {
		this.minSal = minSal;
	}



	public void setSkill(Set skill) {
		this.skill = skill;
	}




	public Set getSkill() {
		return skill;
	}
}
