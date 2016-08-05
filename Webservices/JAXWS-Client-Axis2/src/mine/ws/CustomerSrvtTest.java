package mine.ws;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.ws.CustomerSrvServiceStub.CreateCustomer;
import mine.ws.CustomerSrvServiceStub.CreateCustomerResponse;
import mine.ws.CustomerSrvServiceStub.Customer;

import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import com.sun.xml.internal.ws.util.ServiceFinder;

/**
 * Servlet implementation class CustomerSrvtTest
 */
public class CustomerSrvtTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSrvtTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerSrvServiceStub stub = new CustomerSrvServiceStub();
		
		//
		
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername("dhana");
		basicAuth.setPassword("pwd");
		//
		ServiceClient srvClient = stub._getServiceClient();
		srvClient.getOptions().setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
		
		//
		srvClient.getOptions().setProperty("javax.xml.rpc.security.auth.username", "dhana");
		srvClient.getOptions().setProperty("javax.xml.rpc.security.auth.password", "pwd");
		//
		Customer cust = new Customer();
		cust.setName("Dhananjayan");
		cust.setAadhaarId("1234567890");
		Calendar cal = Calendar.getInstance();
//		cal.set(1987, 0, 27);
		cal.setTime(new Date());
		cust.setDob(cal);
		cust.setCountryOfBirth("IN");
		cust.setAnnualIncome(1200000L);

		CreateCustomer createCust = new CreateCustomer();
		createCust.setCust(cust);
		
		CreateCustomerResponse  custResp = stub.createCustomer(createCust);
		System.out.println(custResp.getCreateCustomerReturn());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
