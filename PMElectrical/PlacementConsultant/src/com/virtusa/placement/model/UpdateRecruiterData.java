package com.virtusa.placement.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.pojo.RecruiterPojo;

public class UpdateRecruiterData {

	public void recruiterupdate(String Username,String Company_name,String Contactperson_name,String Contactperson_empid,String Contactaddress,String City,String Phone,String Mobile,String Email,String Industry) throws Exception
	{
		Session session = null;
		
	try {
		
		System.out.println(Company_name);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		RecruiterPojo spp= (RecruiterPojo)session.get(RecruiterPojo.class, Username);
		
		spp.setCompany_name(Company_name);
		spp.setContactperson_name(Contactperson_name);
		spp.setContactperson_empid(Contactperson_empid);
		spp.setContactaddress(Contactaddress);
		spp.setCity(City);
		spp.setPhone(Long.parseLong(Phone));
		spp.setMobile(Long.parseLong(Mobile));
		spp.setEmail(Email);
		spp.setIndustry(Industry);
		
		Transaction tx = session.beginTransaction();
		session.update(spp);
		
		tx.commit();
		session.close();
		
		
		
		
	} 
	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
		
	}
}
