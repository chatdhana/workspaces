package mine.ws.sa;

import javax.xml.ws.Endpoint;

/**
 * Expose the service using an Endpoint import javax.xml.ws.Endpoint.
 * 
 */
public class CustomerSrvEndPoint {

	public static void main(String[] args) {
		Endpoint endPoint = Endpoint.create(new CustomerSrvImpl());
		// supply your desired URL to the publish method to expose the service.
		endPoint.publish("http://localhost:9090/CustomerSrv");
		System.out.println("Published webservice! Awaiting request...");
	}

}
