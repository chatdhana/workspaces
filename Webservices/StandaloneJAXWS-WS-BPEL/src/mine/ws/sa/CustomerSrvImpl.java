package mine.ws.sa;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import mine.bean.Customer;


/**
 * Implement the SEI in a java class called a SIB (service implementation bean).
 * 
 */
@WebService(endpointInterface = "mine.ws.sa.CustomerSrv", serviceName="CustomerSrvName", portName ="CustomerSrvPortName") // //this binds the SEI to the SIB
@HandlerChain(file = "handler-chain.xml")
public class CustomerSrvImpl {
	
	public String createCustomer(Customer cust) {
		String msg = null;
		if (cust != null) {
			msg = "Customer Created:"+cust.toString();
		} else {
			msg = "Customer Creation Failed";
		}
		
		System.out.println(msg);
		return msg;
	}

	public String updateCustomer(Customer cust) {
		return "Customer Amended:" + cust.getName();
	}

	public Customer enquireCustomer(Customer cust) {
		return cust;
	}

	public Customer findByAadhaarId(String aadhaarId) {
		Customer cust = new Customer();
		cust.setName("Name-" + aadhaarId);
		cust.setAadhaarId(aadhaarId);
		cust.setCountryOfBirth("IN");
		return cust;
	}

}
