package mine.spring.aop;

public interface CustomerServiceIface {

	void pingService();

	String createCustomer(Object obj);

	String updateCustomer(Object obj);

	Object enquireCustmer(String name);
}
