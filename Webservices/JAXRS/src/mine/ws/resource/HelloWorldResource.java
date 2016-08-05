package mine.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/helloworld")
public class HelloWorldResource {
	@GET
	public Response createCustomer(@QueryParam("msg") String message) {
		System.out.println("Web service message:" + message);
		Response.status(Status.ACCEPTED);
		return Response.ok().build();
	}
}
