package com.virtusa.placement.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.opensymphony.xwork2.ActionContext;
import com.virtusa.placement.controller.PostJobRec;
import com.virtusa.placement.pojo.PostJob;
import com.virtusa.placement.sms.SmsClient;

public class PostJobRecBiz {

	
	public PostJobRec postingJob(PostJobRec pjr)
	{	String date;
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yy");
		Date today= new Date();
		date=formatter.format(today);
		try{
		SessionFactory sFactory= new Configuration().configure().buildSessionFactory();
		Session session=sFactory.openSession();
		
		Query query=session.createQuery("select rec.company_name from RecruiterPojo rec where rec.username='"+pjr.getUserName()+"'");
		
		System.out.println(pjr.getUserName());
		
		PostJob pj=new PostJob();
		String compname=query.iterate().next().toString();
		pj.setCompanyName(compname);
		pj.setUserName(pjr.getUserName());		
		pj.setFunArea(pjr.getFunAreaT());
		pj.setDesig(pjr.getDesigT());
		pj.setMinExp(pjr.getMinExpT());
		pj.setMaxExp(pjr.getMaxExpT());
		pj.setSkill(pjr.getSkillT().toUpperCase());
		pj.setLocation(pjr.getLocationT());
		pj.setSalary(pjr.getSalaryT());
		pj.setJobDesc(pjr.getDescriptionT());
		pj.setPostedDate(date);
	
		Transaction tx=session.beginTransaction();
		session.save(pj);		
		tx.commit();
		
		Query query1=session.createQuery("select rec.mobile from RecruiterPojo rec where rec.username='"+pjr.getUserName()+"'");
		SmsClient.sendsms(query1.iterate().next().toString(), "New job is posted successfully in JobsCorp.com");
		session.flush();
		session.close();
		
		MatchJobRecruiter mjr=new MatchJobRecruiter();
		mjr.matchjobs(compname,pjr.getDesigT(), pjr.getMinExpT(), pjr.getMaxExpT(), pjr.getFunAreaT(), pjr.getSalaryT(), pjr.getSkillT().toUpperCase(),pjr.getLocationT());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			pjr.setErrorReport("Error in connection...");
			pjr.setRetVal("error");
			return pjr;		
		}
		pjr.setRetVal("success");
		return pjr;
	}
	
}
