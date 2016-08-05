package com.virtusa.placement.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.placement.pojo.SeekerPersonalPojo;
import com.virtusa.placement.pojo.UserNames;
import com.virtusa.placement.sms.SmsClient;

public class SeekerDatas {

	public void seekerinsert(String Username,String Password,String Type,String first_name,String last_name,String email,String dob,String gender,String Contact_address,String zip,String landline,String mobile) throws Exception


{


Session session = null;
Session sess = null;

try {

SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
sess = sessionFactory1.openSession();
UserNames sp= new UserNames();
sp.setUsername(Username.toLowerCase());
sp.setPassword(Password);
sp.setType("S");
Transaction txx = sess.beginTransaction();
sess.save(sp);
txx.commit();
sess.flush();
sess.close();


SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
session = sessionFactory.openSession();
SeekerPersonalPojo spp= new SeekerPersonalPojo();
spp.setUsername(Username.toLowerCase());
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
session.save(spp);
tx.commit();
session.flush();
session.close();


} 
catch (Exception e) {
e.printStackTrace();

}
}
}


 

 

