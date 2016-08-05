package mine.ws.resource;

import java.io.InputStream;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.wink.common.model.atom.AtomFeed;
import org.apache.wink.common.model.atom.AtomText;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

@Path("/ProducesConsumesResource")
public class ProducesConsumesResource {

	@GET
	@Produces("text/xml")
	public Response produceXML() {
		String entity = "<X><Y/></X>";
		return Response.ok(entity).type("text/xml").build();
	}

	@POST
	@Path("/{mediaType}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	public Object producesJsonOrAtom(InputStream requestBodyStream, @PathParam("mediaType") String mediaType) {
		Object retObj = null;
		/*byte[] readByte = new byte[9999];
		BufferedInputStream biffIn = new BufferedInputStream(requestBodyStream);
		try {
			biffIn.read(readByte);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				biffIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/

		if (mediaType != null && "JSON".equals(mediaType)) {

			JSONObject jsonEntity = null;
			try {
				jsonEntity = new JSONObject(requestBodyStream);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			retObj = jsonEntity;

		} else {
			AtomFeed atomEntity = new AtomFeed();
			atomEntity.setId("http://example.com/atomfeed");
			atomEntity.setTitle(new AtomText("Example"));
			atomEntity.setUpdated(new Date());
			retObj = atomEntity;
		}
		return retObj;
	}
}
