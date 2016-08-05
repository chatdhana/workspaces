package com.virtusa.placement.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.controller.ViewSeeker;
import com.virtusa.placement.pojo.SeekerPersonalPojo;

public class ViewSeekerBiz {
	public ViewSeeker viewSeekerMethod(ViewSeeker vs)
	{
		
		DateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");
		Session session = null;
		try {
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			String SQL_QUERY ="from SeekerPersonalPojo s where s.username='"+vs.getUsername()+"'";
			Query query = session.createQuery(SQL_QUERY);
			for(Iterator it=query.iterate();it.hasNext();)
			{
				SeekerPersonalPojo user=(SeekerPersonalPojo)it.next();
					vs.setUsername(user.getUsername());
					vs.setFirst_name(user.getFirst_name());
					vs.setLast_name(user.getLast_name());
					vs.setEmail(user.getEmail());
					vs.setGender(user.getGender());
					vs.setContact_address(user.getContact_address());
					vs.setZip(user.getZip());
					vs.setLandline(user.getLandline());
					vs.setMobile(user.getMobile());
					vs.setDob(formatter2.format( formatter1.parse(user.getDob().substring(0,10))));   
					vs.setRetVal("success");
									
					return vs;
				
			}			
		}catch (Exception e)
		{
			e.printStackTrace();
			vs.setErrorReport(e.toString());
			vs.setRetVal("error");
			return vs;
		}
		
		
		return vs;
	}

}
