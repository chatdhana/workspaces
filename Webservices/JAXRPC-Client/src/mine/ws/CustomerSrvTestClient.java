package mine.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import mine.bean.Customer;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.transport.http.HTTPConstants;

public class CustomerSrvTestClient {

	public static void main(String[] args) {
//		findCustomerByAadhaarId();
		findCustomerByAadhaarIdAdvanced();
//		createCustomer();
	}

	private static void findCustomerByAadhaarId() {
		try {
			/* Access web service using Service Locator */
			CustomerSrv webServUsingLocator = new CustomerSrvServiceLocator().getCustomerSrv();
			System.out.println(webServUsingLocator.findByAadhaarId("Using Service Locator").getName());

			/* Access web service using Binding Stub */

			CustomerSrv webServUsingStub = new CustomerSrvSoapBindingStub(new URL("http://localhost:8080/JAXWS/services/CustomerSrv"), null);
			System.out.println(webServUsingStub.findByAadhaarId("Using Binding Stub").getName());

			/* Access web service using Proxy */
			CustomerSrv webServUsingProxy = new CustomerSrvProxy().getCustomerSrv();
			System.out.println(webServUsingProxy.findByAadhaarId("Using Proxy").getName());

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void findCustomerByAadhaarIdAdvanced() {
		try {
			/* Access web service using Service Locator */
			CustomerSrv webServUsingLocator = new CustomerSrvServiceLocator().getCustomerSrv();
			// Basic HTTP Authentication
			((Stub)webServUsingLocator)._setProperty(Call.USERNAME_PROPERTY, "dhana");
			((Stub)webServUsingLocator)._setProperty(Call.PASSWORD_PROPERTY, "pwd");
			
//			javax.xml.rpc.Call call = new CustomerSrvServiceLocator().createCall();
//			call.setProperty(Call.USERNAME_PROPERTY, "dhana");
//			call.setProperty(Call.PASSWORD_PROPERTY, "pwd");
			
			
			// Session Based Auth (Using Cookie/HTTP Header)
			((Stub)webServUsingLocator)._setProperty(Call.SESSION_MAINTAIN_PROPERTY, true);
			((Stub)webServUsingLocator)._setProperty(HTTPConstants.HEADER_COOKIE, "CookieId=Value");
			
			// Adding SOAP envelope header
			((Stub)webServUsingLocator).setHeader("ns:nameSpace","HeaderElement","Value");
			Customer cust = webServUsingLocator.findByAadhaarId("Using Service Locator");
			if(cust != null){
				System.out.println("Found Customer with AadhaarId:"+cust.getAadhaarId());	
			}
			

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	

	private static void createCustomer() {
		Customer cust = new Customer();
		cust.setName("Dhananjayan");
		cust.setAadhaarId("1234567890");
		Calendar cal = Calendar.getInstance();
//		cal.set(1987, 0, 27);
		cal.setTime(new Date());
		cust.setDob(cal);
		cust.setCountryOfBirth("IN");
		cust.setAnnualIncome(1200000L);

		CustomerSrv webServUsingLocator;
		try {
			webServUsingLocator = new CustomerSrvServiceLocator().getCustomerSrv();
			System.out.println(webServUsingLocator.createCustomer(cust));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
