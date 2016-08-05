package mine.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * A root resource class is a resource class annotated with @Path. Root resource
 * classes provide the roots of the resource class tree and provide access to
 * sub-resources.
 * 
 * A resource class is a Java class (POJO) that uses JAX-RS annotations to
 * implement a corresponding Web resource. Resource classes are POJOs that have
 * at least one method annotated with @Path or a request method designator
 * (@GET, @POST,..).
 * 
 * 
 * @author 1352755
 * 
 */
@Path("/rootres")
public class RootResource {

	/**
	 * <p>
	 * Resource method
	 * </p>
	 * 
	 * Resource methods are public methods of a resource class annotated with a
	 * request method designator (@GET, @POST,.) that is used to handle requests
	 * on the corresponding resource.
	 * 
	 */
	@GET
	public String resourceMethod() {
		return "This is from RootResource's resourceMethod() method";
	}

	/**
	 * <p>
	 * Sub-resource method
	 * </p>
	 * Sub-resource methods are Java methods with a @Path annotation and a @HttpMethod
	 * annotated annotation (@GET, @POST, @PUT, @DELETE). They are used to
	 * handle requests on a sub-resource of the corresponding resource.
	 */
	@GET
	@Path("/subres/ss")
	public String subResourceMethod() {
		return "This is from RootResource's subResourceMethod() method";
	}
	

	/**
	 * <p>
	 * Sub-resource locator
	 * </p>
	 * Sub-resource locators are Java methods which have only @Path annotation.
	 * They are different than sub-resource methods because they do not have any
	 * HTTP method annotation. They are used to locate sub-resource of the
	 * corresponding resource, particularly useful when requests must be further
	 * resolved by other objects.
	 */
	@Path("/subloc")
	public Object subResourceLocator() {
		return SubResource.getSubResource();
	}
}
