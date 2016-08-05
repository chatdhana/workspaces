package com.virtusa.placement.controller;


import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.TestIDBiz;

public class TestID extends ActionSupport {
	private String retVal;
	
	public String execute()
	{
		TestID tid=new TestID();
		tid=TestIDBiz.uniqueid(tid);
		
		return tid.getRetVal();
	}

	
	public String getRetVal() {
		
		return retVal;
	}
	
	public void setRetVal(String retVal) {
		this.retVal = retVal;
	}
}
