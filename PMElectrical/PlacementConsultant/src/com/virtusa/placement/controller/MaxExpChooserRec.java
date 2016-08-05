package com.virtusa.placement.controller;

import com.virtusa.placement.model.*;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class MaxExpChooserRec extends ActionSupport {

	private List maxExp;
	private String minExpT;
	MaxExpChooserRec mecr;
	public String execute()
	{	String retVal;
		maxExp=new ArrayList();
		MaxExpChooserRecBiz mecrb=new MaxExpChooserRecBiz();
		mecr=new MaxExpChooserRec();
		mecr.setMinExpT(getMinExpT());
		mecr=mecrb.expChooser(mecr);
		maxExp=mecr.getMaxExp();
	return SUCCESS;
	}

	public List getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(List maxExp) {
		this.maxExp = maxExp;
	}

	public String getMinExpT() {
		return minExpT;
	}

	public void setMinExpT(String minExpT) {
		this.minExpT = minExpT;
	}

}
