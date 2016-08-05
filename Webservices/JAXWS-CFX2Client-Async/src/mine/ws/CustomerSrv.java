package mine.ws;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7 2013-11-22T15:54:28.967+05:30 Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://ws.mine", name = "CustomerSrv")
@XmlSeeAlso({ ObjectFactory.class, mine.bean.ObjectFactory.class })
public interface CustomerSrv {

	@WebResult(name = "enquireCustomerReturn", targetNamespace = "http://ws.mine")
	@RequestWrapper(localName = "enquireCustomer", targetNamespace = "http://ws.mine", className = "mine.ws.EnquireCustomer")
	@WebMethod
	@ResponseWrapper(localName = "enquireCustomerResponse", targetNamespace = "http://ws.mine", className = "mine.ws.EnquireCustomerResponse")
	public mine.bean.Customer enquireCustomer(@WebParam(name = "cust", targetNamespace = "http://ws.mine") mine.bean.Customer cust);

	@WebResult(name = "createCustomerReturn", targetNamespace = "http://ws.mine")
	@RequestWrapper(localName = "createCustomer", targetNamespace = "http://ws.mine", className = "mine.ws.CreateCustomer")
	@WebMethod
	@ResponseWrapper(localName = "createCustomerResponse", targetNamespace = "http://ws.mine", className = "mine.ws.CreateCustomerResponse")
	public java.lang.String createCustomer(@WebParam(name = "cust", targetNamespace = "http://ws.mine") mine.bean.Customer cust);

	@WebResult(name = "findByAadhaarIdReturn", targetNamespace = "http://ws.mine")
	@RequestWrapper(localName = "findByAadhaarId", targetNamespace = "http://ws.mine", className = "mine.ws.FindByAadhaarId")
	@WebMethod
	@ResponseWrapper(localName = "findByAadhaarIdResponse", targetNamespace = "http://ws.mine", className = "mine.ws.FindByAadhaarIdResponse")
	public mine.bean.Customer findByAadhaarId(@WebParam(name = "aadhaarId", targetNamespace = "http://ws.mine") java.lang.String aadhaarId);

	@RequestWrapper(localName = "findByAadhaarId", targetNamespace = "http://ws.mine", className = "mine.ws.FindByAadhaarId")
	@ResponseWrapper(localName = "findByAadhaarIdResponse", targetNamespace = "http://ws.mine", className = "mine.ws.FindByAadhaarIdResponse")
	@WebMethod(operationName = "findByAadhaarId")
	public Response<mine.ws.FindByAadhaarIdResponse> findByAadhaarIdAsync(
			@WebParam(name = "aadhaarId", targetNamespace = "http://ws.mine") java.lang.String aadhaarId);

	@RequestWrapper(localName = "findByAadhaarId", targetNamespace = "http://ws.mine", className = "mine.ws.FindByAadhaarId")
	@ResponseWrapper(localName = "findByAadhaarIdResponse", targetNamespace = "http://ws.mine", className = "mine.ws.FindByAadhaarIdResponse")
	@WebMethod(operationName = "findByAadhaarId")
	public Future<?> findByAadhaarIdAsync(@WebParam(name = "aadhaarId", targetNamespace = "http://ws.mine") java.lang.String aadhaarId,
			@WebParam(name = "asyncHandler", targetNamespace = "") AsyncHandler<mine.ws.FindByAadhaarIdResponse> asyncHandler);

	@WebResult(name = "updateCustomerReturn", targetNamespace = "http://ws.mine")
	@RequestWrapper(localName = "updateCustomer", targetNamespace = "http://ws.mine", className = "mine.ws.UpdateCustomer")
	@WebMethod
	@ResponseWrapper(localName = "updateCustomerResponse", targetNamespace = "http://ws.mine", className = "mine.ws.UpdateCustomerResponse")
	public java.lang.String updateCustomer(@WebParam(name = "cust", targetNamespace = "http://ws.mine") mine.bean.Customer cust);
}