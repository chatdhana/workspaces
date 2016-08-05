package com.virtusa.placement.controller;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.virtusa.placement.pojo.UserNames;
import com.virtusa.placement.sms.SmsClient;

public class ChangePassword extends ActionSupport{
	private String username;
	private String oldpword;
	private String newpword;
	private String cnewpword;
	private String errorReport;
	public String getErrorReport() {
		return errorReport;
	}
	public void setErrorReport(String errorReport) {
		this.errorReport = errorReport;
	}
	public String execute()
	{	
		Query q;
		try {
			 Map session=ActionContext.getContext().getSession();
			 username=session.get("userName").toString();
			 System.out.println(getNewpword());
			 System.out.println(getCnewpword());
			 if((getNewpword().trim()).equals((getCnewpword().trim())))
			 {
			
			 SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
			 Session sess = sessionFactory1.openSession();
			 
			 q=sess.createQuery("from UserNames un where un.password='"+getOldpword()+"'and  un.username='"+getUsername()+"'");
			 System.out.println("1hi...");
			 if(q.iterate().hasNext())
			 {
				 UserNames unames= (UserNames)sess.get(UserNames.class,username );
				 unames.setPassword(getNewpword());
				 Transaction tx = sess.beginTransaction();
				 sess.update(unames);
				 tx.commit();
				 sess.close(); 
				 SmsClient.sendsms(session.get("mobile").toString(),"Hi "+username+", Ur Password is Successfully Changed" );
				 System.out.println("2hi..."); 
				 return "success";
			 }else
			 { 	 
				 System.out.println("3hi...");
				 setErrorReport("You are not authorized change the password since the given old password is incorrect..!");
				 session.clear();
				 return "expiry";
			 }
			
		 }
			 else
			 {
				 setErrorReport("New password is not matched with confirmation password...");
				 return "error";	 
			 }
			
		
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpword() {
		return oldpword;
	}
	public void setOldpword(String oldpword) {
		this.oldpword = oldpword;
	}
	
	public String getNewpword() {
		return newpword;
	}
	public void setNewpword(String newpword) {
		this.newpword = newpword;
	}
	public String getCnewpword() {
		return cnewpword;
	}
	public void setCnewpword(String cnewpword) {
		this.cnewpword = cnewpword;
	}

}
