package myejb.sb.stateless;

import javax.ejb.EJBException;
import javax.ejb.EJBLocalObject;

public interface LocalInterface extends EJBLocalObject {
	String hello(String name) throws EJBException;
}
