package com.virtusa.placement.model;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.controller.ViewSeeker;
import com.virtusa.placement.controller.ViewSeekerProfile;
import com.virtusa.placement.pojo.SeekerProfilePojo;

public class ViewSeekerProfileBiz {
	public ViewSeekerProfile viewSeekerProfileMethod(ViewSeekerProfile vsp)
	{
		
		Session session = null;
		try
		{
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			String SQL_QUERY ="from SeekerProfilePojo s where s.username='"+vsp.getUsername()+"'";
			Query query = session.createQuery(SQL_QUERY);
			for(Iterator it=query.iterate();it.hasNext();)
			{
				SeekerProfilePojo user=(SeekerProfilePojo)it.next();
				System.out.println(user.getUsername());
				
					vsp.setUsername(user.getUsername());
				
					vsp.setExperience(user.getExperience());
					
					vsp.setMinsal(user.getMinsal());
					vsp.setMaxsal(user.getMaxsal());
					vsp.setFarea(user.getFarea());
					vsp.setIndustry(user.getIndustry());
					vsp.setKeyskill1(user.getKeyskill1());
					vsp.setKeyskill2(user.getKeyskill2());
					vsp.setKeyskill3(user.getKeyskill3());
					vsp.setRes_obj(user.getRes_obj());
					vsp.setTwelfth(user.getTwelfth());
					vsp.setTenth(user.getTenth());
					vsp.setUg(user.getUg());
					vsp.setUg_stream(user.getUg_stream());
					vsp.setPg(user.getPg());
					vsp.setPg_stream(user.getPg_stream());
					vsp.setDoctorate(user.getDoctorate());
					vsp.setField_phd(user.getField_phd());
					vsp.setUniversity(user.getUniversity());
					if(user.getUpload_resume()!=null)
					System.out.println("Length: "+user.getUpload_resume().toString());
					
					vsp.setRetVal("success");
					
					return vsp;
					
				
			}
				
			
			
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			vsp.setErrorReport(e.toString());
			vsp.setRetVal("error");
			return vsp;
		}
		return vsp;
	}
}
