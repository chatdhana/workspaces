package com.virtusa.placement.controller;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.pojo.SeekerProfilePojo;

public class ViewResume extends ActionSupport{
	public String resume;
public String execute() {
		
	//	Map session=ActionContext.getContext().getSession();
	//	String uname=session.get("userName").toString();
		Session sess = null;
		
		try {
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			sess = sessionFactory.openSession();
			String SQL_QUERY ="from SeekerProfilePojo s where s.username='asma'";
			Query query = sess.createQuery(SQL_QUERY);
			for(Iterator it=query.iterate();it.hasNext();)
			{
				SeekerProfilePojo spp=(SeekerProfilePojo)it.next();
				resume=spp.getUpload_resume().getSubString(1,(int)spp.getUpload_resume().length());
				System.out.println(resume);
			}
			
		
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	return "success";
}		
}
