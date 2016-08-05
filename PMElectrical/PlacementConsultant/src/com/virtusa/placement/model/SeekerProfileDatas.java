package com.virtusa.placement.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.pojo.SeekerProfilePojo;
import com.virtusa.placement.sms.SmsClient;

public class SeekerProfileDatas {
	
	public void seekerprofile(String username,String experience,String minsal,String maxsal,        
			String farea,          
			String industry,       
			String keyskill1,      
			String keyskill2,      
			String keyskill3,      
			String res_obj,        
			String twelfth,        
			String tenth,          
			String ug,             
			String ug_stream,      
			String pg,             
			String pg_stream,      
			String doctorate,      
			String field_phd,      
			String university,
			File resume)
		//,String upload_resume,  String paste_resume   )
	{
		Session session = null;
		try{
			
		
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  session = sessionFactory.openSession();
	  
	  SeekerProfilePojo ob=new SeekerProfilePojo();
	  System.out.println(username+ "," +experience);
	  System.out.println("res:"+resume.toString());
	  ob.setUsername(username);
	  ob.setExperience(Long.parseLong(experience));
	  ob.setMinsal(Long.parseLong(minsal));
	  ob.setMaxsal(Long.parseLong(maxsal));
	  ob.setFarea(farea);
	  ob.setIndustry(industry);
	  ob.setKeyskill1(keyskill1);
	  ob.setKeyskill2(keyskill2);
	  ob.setKeyskill3(keyskill3);
	  ob.setRes_obj(res_obj);
	  ob.setTwelfth(Long.parseLong(twelfth));
	  ob.setTenth(Long.parseLong(tenth));
	  ob.setUg(ug);
	  ob.setUg_stream(ug_stream);
	  ob.setPg(pg);
	  ob.setPg_stream(pg_stream);
	  ob.setDoctorate(doctorate);
	  ob.setField_phd(field_phd);
	  ob.setUniversity(university);
	 
	  ob.setUpload_resume(Hibernate.createClob(characterArray(resume).toString()));
	  
	  
	  Transaction tx = session.beginTransaction();
	  session.save(ob);
	  tx.commit();
	  session.flush();
	  session.close();
	  
	  MatchJob mj=new MatchJob(); 
		mj.matchjobs(experience,farea,minsal,maxsal,keyskill1,keyskill2,keyskill3);
	 } 
	 catch (Exception e) 
	 {
		 e.printStackTrace();
	 
	 }
	  
	 
  }
	
	
	public StringBuilder characterArray(File input)
	{
		StringBuilder sb=new StringBuilder("");
		
		int tempChar;
		try {
			FileInputStream in=new FileInputStream(input);
			
			while((tempChar=in.read())!=-1)
			{
				sb.append((char)tempChar);
			
			}
			
			System.out.println(sb.toString());
			} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	return sb; 	
	}
	
}
