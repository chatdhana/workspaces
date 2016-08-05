
	package com.virtusa.placement.model;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

	

import com.virtusa.placement.pojo.UserNames;
	

	public class RecruiterLogin  {
		
	public void rinsert(String Username,String Password,String Type) throws Exception
	{
		
		 Session sess = null;
	try {
		
		 SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
			sess = sessionFactory1.openSession();
			UserNames sp= new UserNames();
			sp.setUsername(Username.toLowerCase());
			sp.setPassword(Password);
			sp.setType("R");
			Transaction txx = sess.beginTransaction();
			
			sess.save(sp);
			txx.commit();
			sess.flush();
			sess.close();
		
		
		
	} 
	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
		
	}

	
	}




