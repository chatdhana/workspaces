package mine.ws;

import mine.bean.Customer;

public class CustomerSrv {
	
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
