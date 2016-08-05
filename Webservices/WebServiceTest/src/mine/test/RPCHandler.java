package mine.test;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.handler.GenericHandler;
import javax.xml.rpc.handler.MessageContext;
import javax.xml.rpc.handler.soap.SOAPMessageContext;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang.StringEscapeUtils;

public class RPCHandler extends GenericHandler {

	@Override
	public QName[] getHeaders() {
		return null;
	}

	@Override
	public boolean handleRequest(MessageContext context) {
		printMessage(context);
		return super.handleRequest(context);
	}

	@Override
	public boolean handleResponse(MessageContext context) {
		printMessage(context);
		manipulateMessage(context);
		System.out.println("After Manipulation:");
		printMessage(context);
		return super.handleResponse(context);
	}

	void manipulateMessage(MessageContext context) {
		SOAPMessageContext smc = (SOAPMessageContext) context;
		SOAPMessage message = smc.getMessage();
		try {
			
			SOAPBody body = message.getSOAPBody();
			Iterator iter = body.getChildElements();
			for(;iter.hasNext();){
				Node node = (Node) iter.next();
				System.out.println(node.getLocalName());
				//node.setValue(StringEscapeUtils.unescapeXml(node.getValue()));
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	
	}
	private void printMessage(MessageContext context) {
		SOAPMessageContext smc = (SOAPMessageContext) context;
		SOAPMessage message = smc.getMessage();
		try {
			message.writeTo(System.out);
			System.out.println();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
