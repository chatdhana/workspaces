package mine.spring.aop;

public class CustomerService implements CustomerServiceIface {

	@Override
	public void pingService() {
		System.out.println("Pinging Customer Service...");
		System.out.println("Customer Service Available!");
	}

	@Override
	public String createCustomer(Object obj) {
		System.out.println("Creating Customer...");
		return "Customer Created.";
	}

	@Override
	public String updateCustomer(Object obj) {
		System.out.println("Updating Customer...");
		return "Customer Updated.";
	}

	@Override
	public Object enquireCustmer(String name) {
		System.out.println("Enquiring about a Customer...");
		return "Cust6011278";
	}

}
