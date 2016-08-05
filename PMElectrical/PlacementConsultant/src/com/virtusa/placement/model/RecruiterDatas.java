package com.virtusa.placement.model;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

	
	
import com.virtusa.placement.pojo.RecruiterPojo;
import com.virtusa.placement.sms.SmsClient;

	public class RecruiterDatas  {
		
	public void recruiterinsert(String Username,String Company_name,String Contactperson_name,String Contactperson_empid,String Contactaddress,String City,String Phone,String Mobile,String Email,String Industry) throws Exception
	{
		Session session = null;
		
	try {
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		
		RecruiterPojo spp= new RecruiterPojo();
		
		spp.setUsername(Username.toLowerCase());
		spp.setCompany_name(Company_name.toLowerCase());
		spp.setContactperson_name(Contactperson_name);
		spp.setContactperson_empid(Contactperson_empid);
		spp.setContactaddress(Contactaddress);
		spp.setCity(City);
		spp.setPhone(Long.parseLong(Phone));
		spp.setMobile(Long.parseLong(Mobile));
		spp.setEmail(Email);
		spp.setIndustry(Industry);
		
		Transaction tx = session.beginTransaction();
		session.save(spp);
		
		tx.commit();
		session.flush();
		session.close();
		SmsClient.sendsms(Mobile, "Hi "+Username.toLowerCase()+", Ur Account is Successfully Created in JobsCorp.com");
		
		
		
	} 
	catch (Exception e) {
		e.printStackTrace();
		
	}
	
		
	}

	
	}


