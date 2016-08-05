package com.virtusa.placement.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.controller.MaxSalAjax;

public class MaxSalAjaxBiz {
	private Logger myLog=Logger.getLogger(MaxSalAjaxBiz.class);	
	public MaxSalAjax maxSalMethod(MaxSalAjax msa)
	{	List maxSalList=new ArrayList();
		Session session=null;
		
	
	try
	{
	
	try
		{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 	session =sessionFactory.openSession();
		}
		catch(Exception e)
		{
		msa.setErrorReport("Error in conneaction..... Please try again later.");
		msa.setRetVal("error");
		return msa;
		}
	 	String maxSalQueryStr="Select distinct s.salary from PostJob s";
	 	
	 	maxSalList.clear();
	 	Query query=session.createQuery(maxSalQueryStr);
	 	Iterator iterator=query.iterate();
	 	
	 	int sal;
	 	int v_minSalT=new Integer(msa.getMinSalT()).intValue();
	 	for(;iterator.hasNext();)
	 	{
	 		sal=new Integer(iterator.next().toString()).intValue();
	 		
	 		if(sal>=v_minSalT)
	 	maxSalList.add(sal);
	 	}
	 	msa.setMaxSalList(maxSalList);
	 	
	 	
	}catch(Exception e)
	{
		msa.setErrorReport("Internal data processing Error...Try again");
		msa.setRetVal("error");
		return msa;
	}finally
	{
	 	session.close();
	}
	
	msa.setRetVal("success");
	return msa;
	}
	
	
}
