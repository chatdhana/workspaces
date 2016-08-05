package myejb.sb.stateless;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

/*	Remote interface for Session Bean
 * 	
 * 	This interface has the declaration of actual biz method.
 * 	 * 
 */
public interface RemoteInterface extends EJBObject {
	String hello(String name) throws RemoteException;
}
