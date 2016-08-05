package myejb.sb.stateless;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloBean implements SessionBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public String hello(String name) throws EJBException{
		return "Hello,"+name+". Good "+new HelloBean().currentTime()+"!";
	}
	private String currentTime() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		int hour = new Integer(dateFormat.format(today));
		if (hour < 12) {
			return "morn";
		} else if (hour >= 12 && hour <= 16) {
			if (hour == 12)
				return "noon";
			else
				return "after noon";
		} else if (hour >= 12 && hour <= 23)
			return "evening";

		return "day";
	}

}
