package myejb.sb.stateless;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface LocalHomeInterface extends EJBHome {
	public RemoteInterface create() throws CreateException;
}
