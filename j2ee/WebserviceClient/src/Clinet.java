import java.rmi.RemoteException;

import mine.ws.entity.DataEntity;
import mine.ws.proxy.WebserviceProxy;
import mine.ws.proxy.WebserviceProxyProxy;


public class Clinet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			WebserviceProxy wsProx = new WebserviceProxyProxy().getWebserviceProxy();
			DataEntity dataEnt = new DataEntity();
			try {
				wsProx.redirectWebserviceCall(dataEnt);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	}

}
