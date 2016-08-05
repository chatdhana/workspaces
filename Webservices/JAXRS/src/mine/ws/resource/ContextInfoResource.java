package mine.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

@Path("/ContextInfoResource")
public class ContextInfoResource {

	@Context
	private HttpHeaders headers; // provides access to request header information either in map form or via strongly
									// typed convenience methods
	@Context
	private Application app; // Access to the Application subclass instance allows configuration information

	@Context
	private UriInfo info; // provides both static and dynamic, per-request information, about the components of a
							// request URI.
	@Context
	private Request req;// simplifies support for content negotiation and preconditions

	@Context
	private SecurityContext security; // provide access to the current user principal, information about roles assumed
										// by the requester, whether the request arrived over a secure channel and the
										// authentication scheme used.
	@Context
	private Providers providers; // allows for lookup of provider instances based on a set of search criteria.

	// @Context
	// private ResourceContext resCtx; // provides access to instantiation and initialization of resource or subresource
	// classes in the default per-request scope.

	// @Context
	// private Configuration config; // client and the server runtime configurations
	
	@GET
	public void resourceMethod(@Context UriInfo uriInfo, @Context HttpHeaders headers, @Context Request req) {
		System.out.println("QueryParameters:"+uriInfo.getQueryParameters());
		System.out.println("Headers:"+headers.getRequestHeaders());
		System.out.println("Req Method:" + req.getMethod());
	}
}
