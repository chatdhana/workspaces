package mine.ws.sa;

import javax.xml.ws.Endpoint;

/**
 * Expose the service using an Endpoint import javax.xml.ws.Endpoint.
 * 
 */
public class CustomerSrvEndPoint {

	public static void main(String[] args) {
		Endpoint endPoint1 = Endpoint.create(new CustomerSrvImpl());
		//Endpoint endPoint2 = Endpoint.create(new CustomerSrvImpl());
		// supply your desired URL to the publish method to expose the service.
		endPoint1.publish("http://localhost:9090/CustomerSrv1");
		//endPoint2.publish("http://localhost:9090/CustomerSrv2");
		System.out.println("Published webservice! Awaiting request...");
	}

}
