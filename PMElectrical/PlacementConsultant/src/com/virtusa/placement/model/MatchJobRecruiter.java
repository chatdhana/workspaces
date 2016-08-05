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
import com.virtusa.placement.pojo.SeekerProfilePojo;
import com.virtusa.placement.sms.SmsClient;



public class MatchJobRecruiter 
{
	private Logger myLog=Logger.getLogger(MatchJobRecruiter.class);	
	private String errorReport;
	public void matchjobs(String compname,String desig,String minexp,String maxexp,String funArea,String Sal,String skill,String loc)

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
		 
		
	
	  if(skill.matches("[a-zA-Z0-9.]+")&& !skill.equalsIgnoreCase("Select Skill"))
	  {
			  
		  
		  if(count>0)
  			{
			  sb.append(" and (lower(s.keyskill1) like lower('%"+skill+"%') or lower(s.keyskill2) like lower('%"+skill+"%') or lower(s.keyskill3)like lower('%"+skill+"%'))");
  			}
		 
  			else
  			{
  			  sb.append("  (lower(s.keyskill1) like lower('%"+skill+"%') or lower(s.keyskill2) like lower('%"+skill+"%') or lower(s.keyskill3) like lower('%"+skill+"%')) ");
			  count++; 
  			}		  
		  
	  }
	  if(minexp.matches("[0-9]+")&& maxexp.matches("[0-9]+") )
	  { 
		  int exp1=new Integer(minexp).intValue();
		  int exp2=new Integer(maxexp).intValue();
		  
		  if(count>0)
		  {
			 
			  sb.append(" and s.experience>="+exp1+" and s.experience<="+exp2+" ");
		  }
		 
		  else
		  {
  			
  			sb.append(" s.experience>="+exp1+" and s.experience<="+exp2+" ");
  			  count++; 
  		  }
		  
	  }
	
	 
	  
 
	  if(!Sal.equals("1"))
	  { 
		  
		 
		  int SalInt=new Integer(Sal).intValue();
		  if(count>0)
  			{
			  sb.append(" and s.minsal<="+SalInt+" and s.maxsal>="+SalInt+" ");
  			}
		 
  			else
  			{
  			 sb.append("  s.minsal<="+SalInt+" and s.maxsal>="+SalInt+" ");count++; 
  			}
	  }
	
	  	
		  selectQueryStr="from SeekerProfilePojo s where "+sb.toString();
	
	  Query query=sess.createQuery(selectQueryStr);
	 
	  Iterator it=query.iterate();
	  if(it.hasNext())
	  {
	  
	  selectedJobs=query.list();
	  System.out.println(selectedJobs.size());
	  
	  for(int g=0;g<selectedJobs.size();g++)
	  {
		  Map session=ActionContext.getContext().getSession();
		  SeekerProfilePojo temp=(SeekerProfilePojo)selectedJobs.get(g);
		  String s=compname+"  "+desig+"  "+minexp+"  "+maxexp+"  "+loc+"  "+funArea+"  "+Sal+"  "+skill;  
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
		 e.printStackTrace();
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
