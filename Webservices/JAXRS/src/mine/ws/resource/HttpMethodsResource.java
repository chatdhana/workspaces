package mine.ws.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/HttpMethodsResource")
public class HttpMethodsResource {

	@GET
	public String getMethod() {
		return "Get Method";
	}

	@POST
	public String postMethod() {
		return "Post Method";
	}

	@PUT
	public String putMethod() {
		return "Put Method";
	}

	@DELETE
	public String deleteMethod() {
		return "Delete Method";
	}

	@HEAD
	public String headMethod() {
		return "Head Method";
	}

	@OPTIONS
	public String optionMethod() {
		return "Options Method";
	}
}
