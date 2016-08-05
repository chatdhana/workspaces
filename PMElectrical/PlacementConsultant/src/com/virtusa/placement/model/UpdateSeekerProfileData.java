
	package com.virtusa.placement.model;

	import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Hibernate;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

import com.virtusa.placement.pojo.SeekerProfilePojo;

	public class UpdateSeekerProfileData {

		public void seekerprofileupdate(String Username,String Experience,String Minsal,String Maxsal,String Farea,String Industry,String Keyskill1,String Keyskill2,String Keyskill3,String Res_obj,String Twelfth,String Tenth,String Ug,String Ug_stream,String Pg,String Pg_stream,String Doctorate,String Field_phd,String University,File resume) throws Exception
		{
			Session session = null;
			
		try {
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			SeekerProfilePojo ob= (SeekerProfilePojo)session.get(SeekerProfilePojo.class, Username);
			
			  ob.setUsername(Username);
			  ob.setExperience(Long.parseLong(Experience));
			  ob.setMinsal(Long.parseLong(Minsal));
			  ob.setMaxsal(Long.parseLong(Maxsal));
			  ob.setFarea(Farea);
			  ob.setIndustry(Industry);
			  ob.setKeyskill1(Keyskill1);
			  ob.setKeyskill2(Keyskill2);
			  ob.setKeyskill3(Keyskill3);
			  ob.setRes_obj(Res_obj);
			  ob.setTwelfth(Long.parseLong(Twelfth));
			  ob.setTenth(Long.parseLong(Tenth));
			  ob.setUg(Ug);
			  ob.setUg_stream(Ug_stream);
			  ob.setPg(Pg);
			  ob.setPg_stream(Pg_stream);
			  ob.setDoctorate(Doctorate);
			  ob.setField_phd(Field_phd);
			  ob.setUniversity(University);
			  if(resume.length()>0)
			  ob.setUpload_resume(Hibernate.createClob(characterArray(resume).toString()));
			 
			  
			Transaction tx = session.beginTransaction();
			session.update(ob);
			
			tx.commit();
			session.flush();
			session.close();
			
			
			MatchJob mj=new MatchJob(); 
			mj.matchjobs(Experience,Farea,Minsal,Maxsal,Keyskill1,Keyskill2,Keyskill3);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
			
		}
		
		public StringBuilder characterArray(File input)
		{
			StringBuilder sb=new StringBuilder(" ");
			
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



