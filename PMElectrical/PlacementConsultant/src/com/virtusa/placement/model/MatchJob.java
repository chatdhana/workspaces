package com.virtusa.placement.model;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.virtusa.placement.pojo.PostJob;
import com.virtusa.placement.sms.SmsClient;

public class MatchJob
{
	
	private Logger myLog=Logger.getLogger(MatchJob.class);
	private String errorReport;
	
	public void matchjobs(String exp,String funArea,String minSal,String maxSal,String skill1,String skill2,String skill3)

	{
	Session sess=null;
	int count=0; 
	List selectedJobs;
	StringBuilder sb=new StringBuilder(" ");
	 try
	 {
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 sess =sessionFactory.openSession();
	 }catch(Exception e)
	 {
		 setErrorReport("Error in conneaction..... Please try again later.");	
	 }
	 String selectQueryStr=null;	
	 try
	 {
	  if(skill1.matches("[a-zA-Z0-9.]+") || skill2.matches("[a-zA-Z0-9.]+") || skill3.matches("[a-zA-Z0-9.]+")) 
	  {
		  if(count>0)
  			{
			  sb.append(" and (lower(s.skill)=lower('"+skill1+"') or lower(s.skill)=lower('"+skill2+"') or lower(s.skill)=lower('"+skill3+"')) ");
  			}
		 
  			else
  			{
  			  sb.append("  (lower(s.skill)=lower('"+skill1+"') or lower(s.skill)=lower('"+skill2+"') or lower(s.skill)=lower('"+skill3+"')) ");
				count++; 
  			}		  
	  }
	  if(exp.matches("[0-9]+"))
	  { 
		  int expi=new Integer(exp).intValue();
	 	  if(count>0)
		  {
			  sb.append(" and (s.minExp<="+expi+" and s.maxExp>="+expi+") ");
		  }
		 
		  else
		  {
  			sb.append(" (s.minExp<="+expi+" and s.maxExp>="+expi+") ");
  			count++; 
  		  }
		  
	  }
	  if(!minSal.equals("1")&& !maxSal.equals("1"))
	  { 
		  int minSalInt=new Integer(minSal).intValue();
		  int maxSalInt=new Integer(maxSal).intValue();
		  if(count>0)
  			{
			  sb.append(" and s.salary>="+minSalInt+" and s.salary<="+maxSalInt+" ");
  			}
		 
  			else
  			{
  			 sb.append("  s.salary>="+minSalInt+" and s.salary<="+maxSalInt+" ");
			count++; 
  			}
	  }
	
		  selectQueryStr="from PostJob s where "+sb.toString();
		  
	  Query query=sess.createQuery(selectQueryStr);
	  Iterator it=query.iterate();
	  if(it.hasNext())
	  {
	  selectedJobs=query.list();
	  for(int g=0;g<selectedJobs.size();g++)
	  {
		  Map session=ActionContext.getContext().getSession();
		  PostJob temp=(PostJob)selectedJobs.get(g);
		  String s=temp.getCompanyName()+"  "+temp.getDesig()+"  ("+temp.getMinExp()+" - "+temp.getMaxExp()+")  "+temp.getLocation()+"  "+temp.getSalary();  
		 	SmsClient.sendsms(session.get("mobile").toString(),"Hi,"+s+" from jobscorp.com");
		if(g>3)
		{
		  SmsClient.sendsms(session.get("mobile").toString(),"Hi,U have more jobs. Please Visit Our Site");
		  break;
		}
	  }
	
	/*for(int m=0;m<selectedJobs.size();m++)
	  {
		 PostJob temp=(PostJob)selectedJobs.get(m);
		 String s="Company Name:"+temp.getCompanyName()+"  Designation:"+temp.getDesig()+"  Experience:"+temp.getMinExp()+"-"+temp.getMaxExp()+"  Location:"+temp.getLocation()+"  Salary:"+temp.getSalary();  
		 EmailClient.sendemail("9952194943",s);
	  }*/
	  }
	  count=0;
	  sb=new StringBuilder(" ");
	 
	 }
	 catch(Exception e)
	 {	
		 myLog.error("Unknown Error  has occured ....",e);
		 setErrorReport("Unknown Error  has occured ....");
	 }
	 finally
	 {
		 sess.close();
	 }
	
	
}


public String getErrorReport() {
	return errorReport;
}


public void setErrorReport(String errorReport) {
	this.errorReport = errorReport;
}



	
}
