package mine.ws.sa;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.commons.lang.StringEscapeUtils;

public class SOAPLogHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outboundProperty = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			System.out.println("\nOutbound message:");
		} else {
			System.out.println("\nInbound message:");
		}
		

		SOAPMessage message = context.getMessage();
		try {
			message.writeTo(System.out);
			/*SOAPBody body = message.getSOAPBody();
			Iterator iter = body.getChildElements();
			for(;iter.hasNext();){
				Node node = (Node) iter.next();
//				node.setTextContent(StringEscapeUtils.escapeXml(node.getTextContent()));
				node.setValue(StringEscapeUtils.unescapeXml(node.getValue()));
//				System.out.println(node.getValue());
			}*/
			
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		SOAPBody body = null;
//		try {
//			body = message.getSOAPBody();
//		} catch (SOAPException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(Iterator iter = body.getChildElements();iter.hasNext();){
//			Node node = (Node) iter.next();
//			System.out.println(node.getValue());
//		}
//		System.out.println("** Message: " + context.getMessage());
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
