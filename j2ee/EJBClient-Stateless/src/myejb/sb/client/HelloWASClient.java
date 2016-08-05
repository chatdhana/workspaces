package myejb.sb.client;

import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import myejb.sb.stateless.HomeInterface;
import myejb.sb.stateless.RemoteInterface;

public class HelloWASClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws RemoteException,
			CreateException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.ibm.websphere.naming.WsnInitialContextFactory");
		// env.put(Context.PROVIDER_URL, "172.25.205.32:1099");
		try {
			Context ctx = new InitialContext(env);
			Object retObj = (Object) ctx.lookup("myejb/hello");
			System.out
					.println("Object: " + (retObj instanceof RemoteInterface));
			System.out.println("Object: " + (retObj instanceof HomeInterface));

			/*
			 * HomeInterface retObj = (HomeInterface) ctx.lookup("myejb/hello");
			 * RemoteInterface remote = (RemoteInterface) retObj.create();
			 */

			RemoteInterface remote = (RemoteInterface) retObj;
			System.out.println("From Server: " + remote.hello("Dhananjayan"));
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
