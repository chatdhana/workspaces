package mine.xml.jaxp.stax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.XMLEvent;

import mine.bean.Header;
import mine.bean.Transaction;

/**
 * Simple Cursor API based StAX parser, which provides method for reading and writing XML document.
 * 
 * @author 1352755
 *
 */
public class StAXCursorParser {

	static final String NEW_LINE = System.getProperty("line.separator");
	
	/**
	 * Event types CHARACTERS, COMMENT, CDATA, SPACE, ENTITY_REFERENCE, DTD are valid for getText().
	 * 
	 * Event types START_ELEMENT, END_ELEMENT are valid for getName().
	 */
	public static String readXML(String filePath) {
		XMLStreamReader streamReader = null;
		StringBuilder xmlData = new StringBuilder();
		try {
			XMLInputFactory readerFactory = XMLInputFactory.newInstance();
//			 readerFactory.setProperty("report-cdata-event", Boolean.TRUE);
			streamReader = readerFactory.createXMLStreamReader(new FileReader(new File(filePath)));
			while (streamReader.hasNext()) {
				int eventType = streamReader.getEventType();
				switch (eventType) {
					case XMLEvent.START_ELEMENT:
						xmlData.append("<" + streamReader.getPrefix() + ":" + streamReader.getLocalName());
						if (streamReader.getNamespaceCount() > 0) {
							for (int i = 0; i < streamReader.getNamespaceCount(); i++) {
								xmlData.append(" xmlns:" + streamReader.getNamespacePrefix(i) + "=\""
										+ streamReader.getNamespaceURI(i) + "\"");
							}
						}
						if (streamReader.getAttributeCount() > 0) {
							for (int i = 0; i < streamReader.getAttributeCount(); i++) {
								xmlData.append(" " + streamReader.getAttributeName(i) + "=\""
										+ streamReader.getAttributeValue(i) + "\"");
							}
						}
						xmlData.append(">");
						break;
					case XMLEvent.END_ELEMENT:
						xmlData.append("</" + streamReader.getPrefix() + ":" + streamReader.getLocalName() + ">");
						break;
					case XMLEvent.PROCESSING_INSTRUCTION:
						break;
					case XMLEvent.CHARACTERS:
						xmlData.append(streamReader.hasText() ? streamReader.getText() : "");
						break;
					case XMLEvent.COMMENT:
						xmlData.append("<!--" + (streamReader.hasText() ? streamReader.getText() : "") + "-->").append(NEW_LINE);
						break;
					case XMLEvent.START_DOCUMENT:
						xmlData.append("#######Start of Document#######").append(NEW_LINE);
						break;
					case XMLEvent.END_DOCUMENT:
						xmlData.append(NEW_LINE).append("#######End of Document#######");
						break;
					case XMLEvent.ENTITY_REFERENCE:
						xmlData.append(streamReader.hasText() ? streamReader.getText() : "");
						break;
					case XMLEvent.ENTITY_DECLARATION:
						break;
					case XMLEvent.ATTRIBUTE:
						break;
					case XMLEvent.DTD:
						xmlData.append(streamReader.hasText() ? streamReader.getText() : "");
						break;
					case XMLEvent.CDATA:
						xmlData.append(streamReader.hasText() ? streamReader.getText() : "");
						break;
					case XMLEvent.SPACE:
						xmlData.append(streamReader.hasText() ? streamReader.getText() : "");
						break;
					case XMLEvent.NAMESPACE:
						break;
					case XMLEvent.NOTATION_DECLARATION:
						break;
				}
				streamReader.next(); // check for next event
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} finally {
			if (streamReader != null) {
				try {
					streamReader.close();
				} catch (XMLStreamException e) {
				}
			}
		}
		System.out.println("Parsed XML data: " +xmlData.toString());
		return xmlData.toString();
	}

	/**
	 * Builds XML data and writes into the file system at the mentioned file path.
	 * 
	 * Example covers writing: Elements, attributes, name space, characters, CData, comments,..
	 * 
	 * @param filePath
	 * @return status
	 */
	public static boolean writeXML(String filePath) {
		XMLStreamWriter streamWriter = null;
		try {
			XMLOutputFactory writerFactory = XMLOutputFactory.newInstance();
			streamWriter = writerFactory.createXMLStreamWriter(new FileWriter(new File(filePath)));
			Header hdr = getHeaderBean();
			Transaction txn = getTransactionBean();
			
			streamWriter.writeStartDocument();//("utf-8", "1.0");
			streamWriter.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			streamWriter.setPrefix("headerNS", "http://header.stax.jaxp.xml.mine");
			streamWriter.setPrefix("bodyNS", "http://body.stax.jaxp.xml.mine");
			
			streamWriter.writeComment("Sample output XML for checking StAX parsers");
	
			// Start of Envelope
			streamWriter.writeStartElement("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
			streamWriter.writeNamespace("soapenv","http://schemas.xmlsoap.org/soap/envelope/");
			streamWriter.writeNamespace("soapenc","http://schemas.xmlsoap.org/soap/encoding/");
			streamWriter.writeNamespace("xsd","http://www.w3.org/2001/XMLSchema");
			streamWriter.writeNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
			
			// Start of Header
			streamWriter.writeStartElement("http://schemas.xmlsoap.org/soap/envelope/", "Header");
			// Start ServiceHeader
			streamWriter.writeStartElement("http://header.stax.jaxp.xml.mine", "ServiceHeader");
			streamWriter.writeNamespace("headerNS", "http://header.stax.jaxp.xml.mine");
			// Start of credential
			streamWriter.writeStartElement("http://header.stax.jaxp.xml.mine", "credential");
			
			streamWriter.writeStartElement("http://header.stax.jaxp.xml.mine", "userName");
			streamWriter.writeCharacters(hdr.getUserName());
			streamWriter.writeEndElement();
			
			streamWriter.writeEmptyElement("http://header.stax.jaxp.xml.mine", "password");
			
			streamWriter.writeEndElement(); // End of credential
			
			streamWriter.writeStartElement("http://header.stax.jaxp.xml.mine", "clientId");
			streamWriter.writeCharacters(hdr.getClientId());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("http://header.stax.jaxp.xml.mine", "clientCountry");
			streamWriter.writeCharacters(hdr.getClientCountry());
			streamWriter.writeEndElement();
			
			streamWriter.writeEndElement(); // End of ServiceHeader
			streamWriter.writeEndElement(); // End of Header
			// Start of Body
			streamWriter.writeStartElement("http://schemas.xmlsoap.org/soap/envelope/", "Body");
			// Start of Transaction
			streamWriter.writeStartElement("http://body.stax.jaxp.xml.mine", "Transaction");
			streamWriter.writeNamespace("bodyNS", "http://body.stax.jaxp.xml.mine");
			streamWriter.writeAttribute("id", "10");
			streamWriter.writeAttribute("name", "ten");
			
			
			streamWriter.writeStartElement("http://body.stax.jaxp.xml.mine", "transAmount");
			streamWriter.writeCharacters(txn.getTransAmount());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("http://body.stax.jaxp.xml.mine", "accountNumber");
			streamWriter.writeCharacters(txn.getAccountNumber());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("http://body.stax.jaxp.xml.mine", "currencyCode");
			streamWriter.writeCharacters(txn.getCurrencyCode());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("http://body.stax.jaxp.xml.mine", "creditDebitFlag");
			streamWriter.writeCharacters(txn.getCreditDebitFlag());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("http://body.stax.jaxp.xml.mine", "creditNarration");
			streamWriter.writeCData(txn.getCreditNarration());
			streamWriter.writeEndElement();
			
			streamWriter.writeEndElement(); // End of Transaction
			streamWriter.writeEndElement(); // End of Body
			
			streamWriter.writeEndElement(); // End of Envelope
			streamWriter.writeEndDocument();
			
			streamWriter.flush();
			return true;
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (streamWriter != null) {
				try {
					streamWriter.close();
				} catch (XMLStreamException e) {
				}
			}
		}
		return false;
	}
	
	private static Transaction getTransactionBean() {
		Transaction txn = new Transaction();
		txn.setAccountNumber("30608661926");
		txn.setTransAmount("30000000");
		txn.setCreditDebitFlag("C");
		txn.setCurrencyCode("INR");
		txn.setCreditNarration("7037339:::30000000");
		return txn;
	}

	private static Header getHeaderBean() {
		Header hdr = new Header();
		hdr.setClientCountry("IND");
		hdr.setClientId("StAXParser");
		hdr.setUserName("StAX");
		hdr.setPassword("");
		return hdr;
	}

	public static void main(String[] args) {
		String inFilePath = "./io/input.xml";
		String outFilePath = "./io/output_cursor.xml";
		readXML(inFilePath);
		writeXML(outFilePath);
	}
}
