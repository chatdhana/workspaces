package mine.ws.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/ParametersResource")
public class ParametersResource {

	@GET
	@Path("{pathId}")
	public void resourceMethod(@QueryParam("queryParamKey") String queryParam, @PathParam("pathId") String pathParam,
			@CookieParam("cookieId") String cookieParam, @HeaderParam("headerFieldId") String headerParam,
			@MatrixParam("matrixParamId") String matrixParam) {
		System.out.println("queryParam:" + queryParam);
		System.out.println("pathParam:" + pathParam);
		System.out.println("cookieParam:" + cookieParam);
		System.out.println("headerParam:" + headerParam);
		System.out.println("matrixParam:" + matrixParam);
	}

	@GET
	@Path("/path1")
	public void handleMatrixParam(@MatrixParam("matrixParamId") String matrixParam) {
		System.out.println("matrixParam:" + matrixParam);
	}

}
