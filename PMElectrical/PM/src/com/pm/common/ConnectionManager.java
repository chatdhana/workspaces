package com.pm.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.impl.SessionImpl;

public class ConnectionManager {

	
public static Session getDbSession() {

		SessionFactory sFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sFactory.openSession();
		return session;
	}     
}
