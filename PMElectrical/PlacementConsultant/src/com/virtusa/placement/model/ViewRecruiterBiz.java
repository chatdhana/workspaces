package com.virtusa.placement.model;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.controller.ViewRecruiter;
import com.virtusa.placement.pojo.RecruiterPojo;

public class ViewRecruiterBiz {
	public ViewRecruiter viewRecruiterMethod(ViewRecruiter vr)
	{
	Session session = null;
	try {
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		String SQL_QUERY ="from RecruiterPojo r where r.username='"+vr.getUsername()+"'";
		Query query = session.createQuery(SQL_QUERY);
		for(Iterator it=query.iterate();it.hasNext();)
		{
			RecruiterPojo user=(RecruiterPojo)it.next();
			
				vr.setUsername(user.getUsername());
				vr.setCompany_name(user.getCompany_name());
				vr.setEmail(user.getEmail());
				vr.setContactperson_name(user.getContactperson_name());
				vr.setContactperson_empid(user.getContactperson_empid());
				vr.setContactaddress(user.getContactaddress());
				vr.setPhone(user.getPhone());
				vr.setMobile(user.getMobile());
				vr.setEmail(user.getEmail());
				vr.setIndustry(user.getIndustry());
				vr.setCity(user.getCity());				
				vr.setRetVal("success");
				
				return vr;
		}
			
	}
		
	
	
	catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		vr.setErrorReport(e.toString());
		vr.setRetVal("error");
		return vr;
	}
	finally
	{
		session.close();
	}
	return vr;
	}	
}
