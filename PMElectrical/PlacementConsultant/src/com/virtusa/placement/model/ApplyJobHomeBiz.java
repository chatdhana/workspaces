package com.virtusa.placement.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.controller.ApplyJobHome;

public class ApplyJobHomeBiz {
	private Logger myLog=Logger.getLogger(ApplyJobHomeBiz.class);
	
	
	private List experience;
	private List location;
	private List funArea;
	private List desig;
	private List minSal;
	private String errorReport;
	private String retVal;
	private Set skill;
	
	public ApplyJobHome applyJobHomeMethod(ApplyJobHome ajh)
	{
		skill=new HashSet();
		experience=new ArrayList();
		location=new ArrayList();
		funArea=new ArrayList();
		desig=new ArrayList();
		minSal=new ArrayList();
		
		 int[] expOld= new int[500],expNew=new int[500];
		 int indexOld=0,indexNew=0;
		 List commonList =new ArrayList();
		
		
		Session session = null;
		Iterator iterator=null;
		Query query=null;
		
			
			
			try
			{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 	session =sessionFactory.openSession();
			}catch(Exception e)
			{
				ajh.setErrorReport("Error in conneaction..... Please try again later.");
				ajh.setRetVal("error");
				myLog.error(e.getMessage());
				return ajh;
			}
			String skillQueryStr="Select  distinct p.skill  from PostJob p";
			String salaryQueryStr="Select distinct p.salary from PostJob p";
			String funAreaQueryStr="Select distinct p.funArea from PostJob p";
			String desigQueryStr="Select distinct p.desig from PostJob p";
			String minExpQueryStr="Select distinct p.minExp from PostJob p";
			String maxExpQueryStr="Select distinct p.maxExp from PostJob p";
			String locationQueryStr="Select distinct p.location from PostJob p";
			
			try
			{
		 	query=session.createQuery(desigQueryStr);
		 	iterator=query.iterate();
		 	
		 	for(;iterator.hasNext();)
		 	{
		 						
		 	desig.add(iterator.next());
		 	
		 	}
		 	ajh.setDesig(desig);
		 	
		 	query=session.createQuery(skillQueryStr);
		 	iterator=query.iterate();
		 	String tempSkill;
		 	
		 	
		 	
		 	String[] str;
		 	
		 	for(;iterator.hasNext();)
		 	{
		 		tempSkill=iterator.next().toString().toLowerCase();
		 		if(tempSkill.contains(","))
		 		{
		 			str=tempSkill.split("[,]");
		 			for(int i=0;i<str.length;i++)
		 			{
		 				skill.add(str[i]);
		 			}
		 			
		 		}
		 		else
		 		{
		 			skill.add(tempSkill);
		 		}
		 		
		 	
		 	}
		 			 	
		 	ajh.setSkill(skill);
		
		 	query=session.createQuery(minExpQueryStr);
		 	iterator=query.iterate();
		 		
		 	for(;iterator.hasNext();)
		 	{
		 		
		 		
		 	expOld[indexOld++]=Integer.parseInt(iterator.next().toString());
		 	
		 	}
		 	query=session.createQuery(maxExpQueryStr);
		 	iterator=query.iterate();
		 		
		 	for(;iterator.hasNext();)
		 	{
		 	expOld[indexOld++]=Integer.parseInt(iterator.next().toString());
		 	
		 	}
		 	
		 	for(int i=0;i<indexOld;i++)
		 		for(int j=1;j<(indexOld)-i;j++)
		 		{
		 			if(expOld[j-1]>expOld[j])
		 			{
		 				int temp;
		 				temp=expOld[j-1];
		 				expOld[j-1]=expOld[j];
		 				expOld[j]=temp;
		 			}
		 			
		 		}
		 	
		 	
		 	expNew[0]=expOld[0];indexNew++;
		 	for(int i=0;i<indexOld-1;i++)
		 		if(expOld[i]!=expOld[i+1])
		 			expNew[indexNew++]=expOld[i+1];
		 	
		 	
		 for(int i=expNew[0];i<=expNew[indexNew-1];i++)
		 {
		 		experience.add(i);
		 		
		 }
		 
		 ajh.setExperience(experience);
		 
		 	query=session.createQuery(locationQueryStr);
		 	iterator=query.iterate();
		 		
		 	for(;iterator.hasNext();)
		 	{
		 	location.add(iterator.next());
		 	}
		 	ajh.setLocation(location);
		 	query=session.createQuery(funAreaQueryStr);
		 	iterator=query.iterate();
		 		
		 	for(;iterator.hasNext();)
		 	{
		 	funArea.add(iterator.next());
		 	}
		 	ajh.setFunArea(funArea);
		 	query=session.createQuery(salaryQueryStr);
		 	iterator=query.iterate();
		 	String sal;
		 	for(;iterator.hasNext();)
		 	{
		 		sal=iterator.next().toString();
		 	minSal.add(sal);
		 	
		 	}
		 	
		 
		 	ajh.setMinSal(minSal);
			
		
			}
			catch(Exception e)
			{
				ajh.setErrorReport("Internal data processing Error...Try again:");
				e.printStackTrace();
				ajh.setRetVal("error");
				myLog.error(e.getMessage());
				return ajh;
			}finally
			{
				session.close();
			}
		 	
	
			ajh.setRetVal("success");
			myLog.info("Success at ApplyJobHomeBiz");
			
			return ajh;
			
		
	}
	
	
}
