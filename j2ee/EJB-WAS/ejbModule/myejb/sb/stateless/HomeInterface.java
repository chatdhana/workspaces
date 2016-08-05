package myejb.sb.stateless;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * 
 * @author dgovindan
 * 
 */
public interface HomeInterface extends EJBHome{
	/**
	 * Creates a default instance of Session Bean.
	 */
	public RemoteInterface create() throws CreateException,RemoteException;
}
