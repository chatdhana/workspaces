package com.virtusa.placement.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.virtusa.placement.controller.ApplyJobSeek;
import com.virtusa.placement.pojo.ApplyJob;

public class ApplyJobSeekBiz {
	
	private Logger myLog=Logger.getLogger(ApplyJobSeekBiz.class);
	
	public ApplyJobSeek applyJobSeekMethod(ApplyJobSeek ajs)
	{

	Session session = null;

	try{
			String date;
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yy");
			Date today= new Date();
			date=formatter.format(today);
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 	session =sessionFactory.openSession();
			ApplyJob a=new ApplyJob();
			a.setJobId(ajs.getJobIdT());
			a.setUserName(ajs.getSeekerIdT());
			a.setAppliedDate(date);
		 	Transaction tx = session.beginTransaction();
			session.save(a);
			tx.commit();
			
	}
	catch(org.hibernate.exception.GenericJDBCException e)
	{
		e.printStackTrace();
		ajs.setErrorReport("You are trying to apply for the same job twice, Not Allowed.....");
		ajs.setRetval("error");
		myLog.error("trying to apply for the same job twice, Not Allowed.....",e);
		return ajs;
	}
	catch(Exception e)
	{	e.printStackTrace();
		ajs.setErrorReport("Problem in connection , sorry for the inconvenience, Try again later.....");
		ajs.setRetval("error");
		myLog.error("Problem in connection , sorry for the inconvenience, Try again later.....",e);
		return ajs;
	}
	finally
	{
		session.close();

	}
	ajs.setSuccessReport("You have applied for the job Successfully...");
	ajs.setRetval("success");
	return ajs;
	
	}
}
