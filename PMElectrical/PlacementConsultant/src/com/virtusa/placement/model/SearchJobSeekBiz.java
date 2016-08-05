package com.virtusa.placement.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.controller.ApplyJobSeek;
import com.virtusa.placement.controller.SearchJobSeek;

public class SearchJobSeekBiz {
	public SearchJobSeek applyJobSeekMethod(SearchJobSeek sjs)
	{
		

		Session session=null;
		int count=0; 
		String desig,exp,loc,funArea,minSal,maxSal,skill;
			desig=sjs.getDesigT();
			exp=sjs.getExperienceT();
			loc=sjs.getLocationT();
			funArea=sjs.getFunAreaT();
			minSal=sjs.getMinSalT();
			maxSal=sjs.getMaxSalT();
			skill=sjs.getSkillT();
			
			
		 
		 StringBuilder sb=new StringBuilder(" ");
		 
		 
		 try
		 {
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		 }catch(Exception e)
		 {
			sjs.setErrorReport("Error in conneaction..... Please try again later.");
			sjs.setRetVal("error");
			return sjs;
		 }
		 String selectQueryStr=null;	
		 
		 try
		 {
			 
			 System.out.println(desig);
		//if(!desig.matches("[\\W]*")&& !desig.equalsIgnoreCase("Select Designation"))
	  	  if(!desig.equals("-1"))
		  {
			if(count>0)
	  		{
				sb.append(" and lower(p.desig)=lower('"+ desig+"') "); 
	  		}
			 
	  		else
	  		{
	  			sb.append(" lower(p.desig)=lower('"+ desig+"') ");  count++; 
	  		}
	  			
	  		}
		
		  //if(skill.matches("[a-zA-Z0-9.+#]+")&& !skill.equalsIgnoreCase("Select Skill"))
		  if(!skill.equals("-1"))
		  {
			
			  if(count>0)
	  			{
				  sb.append(" and lower(p.skill) like lower('%"+skill+"%') ");
				  
	  			}
			 
	  			else
	  			{
	  				sb.append(" lower(p.skill) like lower('%"+skill+"%') ");
	  				count++; 
	  			}		  
			  
		  }
		 
		 // if(exp.matches("[0-9]+")&& !exp.equalsIgnoreCase("Select Experience"))
		  if(!exp.equals("-1"))
		  { 
			  int expi=new Integer(exp).intValue();
		 
			  
			  if(count>0)
			  {
				 
				  sb.append(" and (p.minExp<="+expi+" and p.maxExp>="+expi+")");
			  }
			 
			  else
			  {
	  			
	  			sb.append(" (p.minExp<="+expi+" and p.maxExp>="+expi+")");
	  			  count++; 
	  		  }
			  
		  }
		 // if(loc.matches("[a-zA-Z0-9]+")&& !loc.equalsIgnoreCase("Select Location"))
		  if(!loc.equals("-1"))
		  {
			 
			  if(count>0)
	  			{
				  sb.append(" and lower(p.location)=lower('"+loc+"') ");
	  			}
			 
	  			else
	  			{
	  			 sb.append(" lower(p.location)=lower('"+loc+"') ");count++; 
	  			}
		  }
		 
		//  if(funArea.matches("(([a-zA-Z0-9])+([-,]*))+")&& !funArea.equalsIgnoreCase("Select Functional Area"))
		  if(!funArea.equals("-1"))
		  {
			  
			  if(count>0)
			  {
				  sb.append(" and lower(p.funArea)=lower('"+funArea+"') ");
			  }
			  
			  else
			  {
	  			sb.append(" lower(p.funArea)=lower('"+funArea+"') ");count++; 
			  }
		  }
		  
	 
		  if(!minSal.equals("-1"))
		  { 
			  
			  int minSalInt=new Integer(minSal).intValue();
			 
			  if(!maxSal.equals("-1"))
			  {
				  int maxSalInt=new Integer(maxSal).intValue();
				 
				  if(count>0)
		  			{
					  sb.append(" and p.salary between "+minSalInt+" and "+maxSalInt+" ");
		  			}
				 
		  			else
		  			{
		  			 sb.append("  p.salary between "+minSalInt+" and "+maxSalInt+" ");count++; 
		  			}
			  }
			  else
			  {
			  if(count>0)
	  			{
				  sb.append(" and p.salary="+minSalInt+" ");
	  			}
			 
	  			else
	  			{
	  			 sb.append("  p.salary="+minSalInt+" ");count++; 
	  			}
			  }
		  }
		  if(minSal.equals("-1")&& !maxSal.equals("-1"))
		  {
			  		  
			  int maxSalInt=new Integer(maxSal).intValue();
			 
			  if(count>0)
	  			{
				  sb.append(" and  p.salary="+maxSalInt+" ");
	  			}
			 
	  			else
	  			{
	  			 sb.append(" p.salary="+maxSalInt+" ");count++; 
	  			}
		  }
		
		  if(count>0)
		  {
			  
			  selectQueryStr="from PostJob p where "+sb.toString();
		
		  }
		  else
		  {
			  selectQueryStr="from PostJob";
			  sjs.setErrorReport("You have not selected any option. But we are providing you all the available jobs... ");
		  }
		 
		  Query query=session.createQuery(selectQueryStr);
		  sjs.setSelectedJobs(query.list());
		 
		  count=0;
		  sb=new StringBuilder(" ");
		 
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
			sjs.setErrorReport("Internal data processing error. Try again...");
			sjs.setRetVal("error");
			return sjs;
			
		 }
		 finally
		 {
			 session.close();
		 }
		
		sjs.setRetVal("success");
		return sjs;
	}

}
