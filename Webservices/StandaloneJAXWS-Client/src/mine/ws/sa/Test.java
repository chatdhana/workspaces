package mine.ws.sa;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Test {

	public static void main(String[] args) {
		try {
			CustomerSrvNameLocator locator = new CustomerSrvNameLocator();
			CustomerSrv port = locator.getCustomerSrvPortName();
			
			Customer cust = new Customer();
			cust.setAadhaarId("AUID-1");
			cust.setName("MyName");
			port.createCustomer(cust);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
