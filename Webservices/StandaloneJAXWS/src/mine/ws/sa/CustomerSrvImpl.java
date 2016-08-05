package mine.ws.sa;

import javax.jws.WebService;

import mine.bean.Customer;


/**
 * Implement the SEI in a java class called a SIB (service implementation bean).
 * 
 */
@WebService(endpointInterface = "mine.ws.sa.CustomerSrv", serviceName="CustomerSrvName", portName ="CustomerSrvPortName") // //this binds the SEI to the SIB
public class CustomerSrvImpl {
	
	public String createCustomer(Customer cust) {
		return "Customer Created:" + cust.getName();
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
