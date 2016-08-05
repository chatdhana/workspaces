package mine.test;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.HandlerRegistry;

import org.eclipse.bpel.sample.CallerLocator;
import org.eclipse.bpel.sample.CallerPortType;
import org.eclipse.bpel.sample.CallerRequest;
import org.eclipse.bpel.sample.CallerResponse;

public class CallerMain {
	public static void main(String[] args) {
		try {
			CallerLocator locator = new CallerLocator();
			CallerPortType callerPort = locator.getCallerPort();
			
			HandlerRegistry handlerReg = locator.getHandlerRegistry();
			List handlerChnList = handlerReg.getHandlerChain(new QName("http://eclipse.org/bpel/sample", "CallerPort"));
			HandlerInfo handlerInfo = new HandlerInfo();
			handlerInfo.setHandlerClass(RPCHandler.class);
			handlerChnList.add(handlerInfo);
			handlerReg.setHandlerChain(new QName("http://eclipse.org/bpel/sample", "CallerPort"), handlerChnList);
			
			CallerRequest req = new CallerRequest();
			req.setInput("Input Value");
		      
			CallerResponse resp = callerPort.process(req);
			System.out.println(resp.getResult());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
