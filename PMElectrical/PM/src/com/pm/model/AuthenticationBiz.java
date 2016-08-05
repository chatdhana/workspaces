package com.pm.model;

import java.util.Iterator;

import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pm.common.ConnectionManager;
import com.pm.controller.Authentication;
import com.pm.pojo.User;

public class AuthenticationBiz {

	public String userAuthentication(Authentication auth) {
		String userType = userVerification(auth);
		System.out.println("userType:" + userType);
		if (userType.length() == 1) {
			if (pwdVerification(auth))
				return userType;
		} else if (userType.length() > 1) {
			return "none";
		}
		return "";
	}

	public String userVerification(Authentication auth) {
		Session sesn=null;
		try {
			sesn = ConnectionManager.getDbSession();
			Query query = sesn.createQuery("from User u where u.id ='"
					+ auth.getUserName().trim() + "'");
			Iterator<User> iter = query.iterate();

			if (auth.getUserName() != null && auth.getPwd() != null)
				if (iter.hasNext()) {
					User userObj = iter.next();
					if (userObj.getId().equalsIgnoreCase(
							auth.getUserName().trim()))
						if (userObj.getPwd().equalsIgnoreCase(
								auth.getPwd().trim()))
							return userObj.getType();
				}
			return "none";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}finally{
			if(sesn!=null){
				sesn.close();
			}
		}
	}

	public boolean pwdVerification(Authentication auth) {
		// Session ses = ConnectionManager.getDbSession();
		// Query query = ses.createQuery("select u.id from User u where u.id ='"
		// + auth.getUserName() + "'");

		return true;
	}

}
