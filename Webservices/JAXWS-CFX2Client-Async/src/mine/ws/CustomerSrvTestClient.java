package mine.ws;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public final class CustomerSrvTestClient {

	private static final QName SERVICE_NAME = new QName("http://ws.mine", "CustomerSrvService");

	private CustomerSrvTestClient() {
	}

	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = CustomerSrvService.WSDL_LOCATION;
		if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
			File wsdlFile = new File(args[0]);
			try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL(args[0]);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		CustomerSrvService ss = new CustomerSrvService(wsdlURL, SERVICE_NAME);
		CustomerSrv port = ss.getCustomerSrv();

		{
			System.out.println("Invoking findByAadhaarId...");
			mine.bean.Customer customerResult = port.findByAadhaarId("AadhaarId");
			System.out.println("findByAadhaarId.result=" + customerResult);

		}
		{
			System.out.println("Invoking findByAadhaarIdAsync using Polling model...");
			Response<mine.ws.FindByAadhaarIdResponse> response = port.findByAadhaarIdAsync("AadhaarIdPolling");
			while (!response.isDone()) {
				// do some other operation
			}
			mine.ws.FindByAadhaarIdResponse responseBean = (mine.ws.FindByAadhaarIdResponse) response.get();
			mine.bean.Customer customerResult = responseBean.getFindByAadhaarIdReturn();
			System.out.println("findByAadhaarIdAsync.result=" + customerResult.getAadhaarId());

		}
		{
			System.out.println("Invoking findByAadhaarIdAsync using Callback model...");
			AsyncHandler<mine.ws.FindByAadhaarIdResponse> findByAadhaarIdAsyncHandler = new MyAsyncHandler();
			Future<?> future = port.findByAadhaarIdAsync("AadhaarIdCallback", findByAadhaarIdAsyncHandler);

			System.out.println("findByAadhaarIdAsync.result (Callback)=" + "<Handler will process the response.>");
			while (!future.isDone()) {
				// do some other operation
			}
			System.out.println("Operation completed.");
		}

		System.exit(0);
	}

}

class MyAsyncHandler implements AsyncHandler<mine.ws.FindByAadhaarIdResponse> {

	@Override
	public void handleResponse(Response<FindByAadhaarIdResponse> res) {
		System.out.println("Handling FindByAadhaarIdResponse at handler..");
		mine.ws.FindByAadhaarIdResponse responseBean;
		try {
			responseBean = (mine.ws.FindByAadhaarIdResponse) res.get();
			mine.bean.Customer customerResult = responseBean.getFindByAadhaarIdReturn();
			System.out.println("findByAadhaarIdAsync.result=" + customerResult.getAadhaarId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}