package mine.ws.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;


/**
 * Resource methods may return void, Response, GenericEntity, or another Java type, these return types are mapped to a
 * response entity body.
 * 
 * • void – Results in an empty entity body with a status code 204 (No Content) 
 * 
 * • Response – Results in an entity body
 * mapped from the property of the Response (with status code 204, if not given).
 * 
 * • GenericEntity - Results in an entity
 * body mapped from the property of the Entity.
 * 
 * • Other - Results in an entity body mapped from the property of the
 * returned instance. In all of the last 3 cases, server returns status code as 204 (No Content), if not set.
 * 
 * 
 * @author 1352755
 * 
 */
@Path("/ReturnTypeResource")
public class ReturnTypeResource {

	@GET
	@Path("/void")
	public void returnVoid() {
	}

	@GET
	@Path("/entity")
	public GenericEntity<List<String>> returnEntity() {
		List<String> items = new ArrayList<String>();
		items.add("I1");
		items.add("I2");
		items.add("I3");
		GenericEntity<List<String>> entity = new GenericEntity<List<String>>(items) {};
		return entity;
	}

	@GET
	@Path("/response")
	public Response returnResponse() {
		return Response.ok().build();
	}
	
	@GET
	@Path("/other")
	public String returnString() {
		return "";
	}
}
