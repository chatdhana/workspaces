package com.pm.model;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pm.common.ConnectionMgr;
import com.pm.controller.Login;

public class LoginBiz {

	public static boolean userVerification(Login login) {
		try {
			Session ses = ConnectionMgr.getDbSession();
			Query query = ses.createQuery("select u.id from User u where u.id ='auser1'");
			for(Iterator itr=query.iterate();itr.hasNext();)
			{
				System.out.println("User:"+itr.next());
			}

			// query.list();
			if (query.list().size() >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

}
