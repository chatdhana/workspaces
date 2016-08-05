package mine.ws.client;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class WinkClient {

	private static RestClient restClient = new RestClient();

	public static void main(String[] args) {
//		testRootResource();
//		testContextInfo();
//		testReturnTypes();
//		testProducesConsumesTypes();
//		testParameters();
		testHttpMethods();
	}

	private static void testRootResource() {
		{
			System.out.println("Testing Root Resource");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/rootres");
			ClientResponse response = res.accept("text/html").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData -->" + content);
		}

		{
			System.out.println("Testing Sub Resource Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/rootres/subres/prashant?sss=10");
			ClientResponse response = res.accept("text/html").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
		}

		{
			System.out.println("Testing Sub Resource Locator");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/rootres/subloc");
			ClientResponse response = res.accept("text/html").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
		}

	}
	
	private static void testContextInfo() {
		System.out.println("Testing @Context");
		Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ContextInfoResource?X=10&y=20");
		res.cookie("Cookie");
		res.header("MyKheaderKey", "Value");
		ClientResponse response = res.accept("text/html").get();
		
		String content = response.getEntity(String.class);
		System.out.println("ServerData -->" + content);
	}
	
	private static void testReturnTypes() {
		
		{
			System.out.println("Testing Return Type; Void");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ReturnTypeResource/void");
			ClientResponse response = res.accept("text/html").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
		}
		
		{
			System.out.println("Testing Return Type; GenericEntity");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ReturnTypeResource/entity");
			ClientResponse response = res.accept("*/*").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
		}
		
		{
			System.out.println("Testing Return Type; Response");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ReturnTypeResource/response");
			ClientResponse response = res.accept("text/html").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
		}
		
		{
			System.out.println("Testing Return Type; Other");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ReturnTypeResource/other");
			ClientResponse response = res.accept("text/html").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
		}
		
	}

	private static void testProducesConsumesTypes() {

		{
			System.out.println("Testing Produces");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ProducesConsumesResource");
			ClientResponse response = res.accept(MediaType.TEXT_XML).contentType("text/plain").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);

		}

		{
			System.out.println("Testing Produces/Consumes");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ProducesConsumesResource/JSON");
			String body = "{Data:\"This is body content\"}";
			ClientResponse response = res.accept(MediaType.APPLICATION_JSON).contentType(MediaType.TEXT_PLAIN).post(body);
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);

		}
		
		{
			System.out.println("Testing Produces/Consumes");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ProducesConsumesResource/Atom");
			String body = "Atom Content";
			ClientResponse response = res.accept(MediaType.APPLICATION_ATOM_XML).contentType(MediaType.TEXT_PLAIN).post(body);
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);

		}
	}
	
	
	private static void testParameters() {

		{
			System.out.println("Testing Parameters");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ParametersResource/MyPathURI;matrixParamId=MatrixVal1?queryParamKey=QueryParamVal");
			res.header("headerFieldId", "Header Field Value");
			Cookie cookie= new Cookie("cookieId", "Cookie Value");
			res.cookie(cookie);
			ClientResponse response = res.accept(MediaType.TEXT_XML).contentType("text/plain").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
		
		{
			System.out.println("Testing Matrix Parameters");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/ParametersResource/path1;matrixParamId=MatrixVal1,MatrixVal2;matrixParamId1=MatrixVal1,MatrixVal2");
			ClientResponse response = res.accept(MediaType.TEXT_XML).contentType("text/plain").get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}

	}
	
	
	private static void testHttpMethods(){
		{
			System.out.println("Testing Get Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/HttpMethodsResource");
			ClientResponse response = res.accept(MediaType.TEXT_PLAIN).contentType(MediaType.TEXT_PLAIN).get();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
		
		{
			System.out.println("Testing Post Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/HttpMethodsResource");
			ClientResponse response = res.accept(MediaType.TEXT_PLAIN).contentType(MediaType.TEXT_PLAIN).post("Test Data");
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
		
		{
			System.out.println("Testing Delete Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/HttpMethodsResource");
			ClientResponse response = res.accept(MediaType.TEXT_PLAIN).contentType(MediaType.TEXT_PLAIN).delete();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
		
		{
			System.out.println("Testing Put Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/HttpMethodsResource");
			ClientResponse response = res.accept(MediaType.TEXT_PLAIN).contentType(MediaType.TEXT_PLAIN).post("Test Data");
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
		
		{
			System.out.println("Testing Head Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/HttpMethodsResource");
			ClientResponse response = res.accept(MediaType.TEXT_PLAIN).contentType(MediaType.TEXT_PLAIN).head();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
		
		{
			System.out.println("Testing Options Method");
			Resource res = restClient.resource("http://localhost:8080/JAXRS/rest/HttpMethodsResource");
			ClientResponse response = res.accept(MediaType.TEXT_PLAIN).contentType(MediaType.TEXT_PLAIN).options();
			String content = response.getEntity(String.class);
			System.out.println("ServerData-->" + content);
			
		}
	}
	
	
	private static void testAsyncRequest(){
		{
		}
	}

}
