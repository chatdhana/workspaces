package com.virtusa.placement.controller;

import com.virtusa.placement.model.*;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class PostJobHome extends ActionSupport{
	
	
	
	private List funArea;
	private List salary;
	private List minExp;
	PostJobHome pjh;
	
	public String execute()
	{	
		minExp=new ArrayList();
		funArea=new ArrayList();
		salary=new ArrayList();
		String retVal;
		PostJobHomeBiz pjhb=new PostJobHomeBiz();
		
		pjh=pjhb.initializer();	
		funArea=pjh.getFunArea();
		salary=pjh.getSalary();
		minExp=pjh.getMinExp();
		
		return SUCCESS;
	}


	public void setFunArea(List funArea) {
		this.funArea = funArea;
	}


	public void setSalary(List salary) {
		this.salary = salary;
	}


	public void setMinExp(List minExp) {
		this.minExp = minExp;
	}


	public List getFunArea() {
		return funArea;
	}


	public List getSalary() {
		return salary;
	}


	public List getMinExp() {
		return minExp;
	}

}
