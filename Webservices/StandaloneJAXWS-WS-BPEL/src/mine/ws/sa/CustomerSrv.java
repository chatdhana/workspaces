package mine.ws.sa;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import mine.bean.Customer;

/**
 * 
 * Design a SEI, service endpoint interface, which is basically a java interface with web-service annotations. This is
 * not mandatory, it's just a point of good design from basic OOP.
 * 
 */
@WebService(name = "CustomerSrv")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
public interface CustomerSrv {
	@WebMethod
	public String createCustomer(Customer cust);

	@WebMethod
	public String updateCustomer(Customer cust);

	@WebMethod
	public Customer enquireCustomer(Customer cust);

	@WebMethod
	public Customer findByAadhaarId(String aadhaarId);
}
