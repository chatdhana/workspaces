package com.virtusa.placement.model;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.placement.controller.*;

public class PostJobHomeBiz {

	PostJobHome pjh;
	private List funArea;
	private List salary;
	private List minExp;
	
	public PostJobHome initializer()
	{
		pjh=new PostJobHome();
		minExp=new ArrayList();
		funArea=new ArrayList();
		salary=new ArrayList();
		
		minExp.add("0");
		for(int i=1;i<=30;i++)
		{
		minExp.add(String.valueOf(i));
		}
		for(int i=1;i<=50;i++)
		{
		salary.add(String.valueOf(i*10000));
		}
		
		
		funArea.add("Accounts / Finance / Tax / CS / Audit");
		funArea.add("Agent");
		funArea.add("Architecture / Interior Design");
		funArea.add("Banking / Insurance</option>");
		funArea.add("Content / Journalism");
		funArea.add("Corporate Planning / Consulting");
		funArea.add("Engineering Design / R&D");
		funArea.add("Export / Import / Merchandising");
		funArea.add("Fashion / Garments / Merchandising");
		funArea.add("Guards / Security Services");
		funArea.add("Hotels / Restaurants");
		funArea.add("HR / Administration / IR");
		funArea.add("IT Software - Client Server");
		funArea.add("IT Software - Mainframe");
		funArea.add("IT Software - Middleware");
		funArea.add("IT Software - Mobile");
		funArea.add("IT Software - Other");
		funArea.add("IT Software - System Programming");
		funArea.add("IT Software - Telecom Software");
		funArea.add("IT Software- Application Programming / Maintenance");
		funArea.add("IT Software- DBA / Datawarehousing");
		funArea.add("IT Software- E-Commerce / Internet Technologies");
		funArea.add("IT Software- Embedded /EDA /VLSI /ASIC /Chip Des.");
		funArea.add("IT Software- ERP / CRM");
		funArea.add("IT Software- Network Administration / Security");
		funArea.add("IT Software- QA & Testing");
		funArea.add("IT Software- Systems / EDP / MIS");
		funArea.add("IT- Hardware / Telecom / Technical Staff / Support");
		funArea.add("ITES / BPO / KPO / Customer Service / Operations");
		funArea.add("Legal");
		funArea.add("Marketing / Advertising / MR / PR");
		funArea.add("Packaging");
		funArea.add("Pharma / Biotech / Healthcare / Medical / R&D");
		funArea.add("Production / Maintenance / Quality");
		funArea.add("Purchase / Logistics / Supply Chain");
		funArea.add("Sales / BD");
		funArea.add("Secretary / Front Office / Data Entry");
		funArea.add("Self Employed / Consultants");
		funArea.add("Site Engineering / Project Management");
		funArea.add("Teaching / Education");
		funArea.add("Ticketing / Travel / Airlines");
		funArea.add("Top Management");
		funArea.add("TV / Films / Production");
		funArea.add("Web / Graphic Design / Visualiser");		
		
		
		pjh.setFunArea(funArea);
		pjh.setMinExp(minExp);
		pjh.setSalary(salary);
		
		
		
		return pjh;
	}
	
}
