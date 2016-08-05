
	package com.virtusa.placement.model;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

import com.virtusa.placement.pojo.SeekerPersonalPojo;

	public class UpdateSeekerPersonalData {

		public void seekerpersonalupdate(String Username,String first_name,String last_name,String email,String dob,String gender,String Contact_address,String zip,String landline,String mobile) throws Exception
		{
			Session session = null;
			
		try {
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			SeekerPersonalPojo spp= (SeekerPersonalPojo)session.get(SeekerPersonalPojo.class, Username);
			
			spp.setFirst_name(first_name);
			spp.setLast_name(last_name);
			spp.setEmail(email);
			spp.setGender(gender);
			spp.setDob(dob);
			spp.setContact_address(Contact_address);
			spp.setZip(Long.parseLong(zip));
			spp.setLandline(Long.parseLong(landline));
			spp.setMobile(Long.parseLong(mobile));
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


