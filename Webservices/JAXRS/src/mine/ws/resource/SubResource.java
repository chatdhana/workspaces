package mine.ws.resource;

import javax.ws.rs.GET;

/**
 * A Sub-resource has no @Path annotation and has one or more resource methods
 * or resource locators.
 * 
 */
public class SubResource {

	public static SubResource getSubResource() {
		return new SubResource();
	}

	@GET
	public String resourceMethod() {
		return "This is from SubResource's resourceMethod() method";
	}
}
