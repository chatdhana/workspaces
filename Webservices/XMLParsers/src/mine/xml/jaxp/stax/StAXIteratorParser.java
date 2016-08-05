package mine.xml.jaxp.stax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXIteratorParser {
	private static String NEW_LINE = System.getProperty("line.separator");
	public static String readXML(String filePath) {
		XMLEventReader eventReader = null;
		StringBuilder xmlData = new StringBuilder();
		try {
			XMLInputFactory readerFactory = XMLInputFactory.newInstance();
			eventReader = readerFactory.createXMLEventReader(new FileReader(new File(filePath)));
			
			while(eventReader.hasNext()){
//				XMLEvent event = (XMLEvent) eventReader.next();
				XMLEvent event = eventReader.nextEvent();
			
				switch (event.getEventType()) {
					case XMLEvent.START_ELEMENT:
						StartElement startElement = event.asStartElement();
						xmlData.append("<" + startElement.getName().getPrefix() + ":" + startElement.getName().getLocalPart());
						for(Iterator namespaceIter = startElement.getNamespaces();namespaceIter.hasNext();){
							Namespace namespace = (Namespace) namespaceIter.next();
							xmlData.append(" xmlns:" + namespace.getPrefix()+ "=\""
									+ namespace.getNamespaceURI()+ "\"");
						}
						for(Iterator attributeIter = startElement.getAttributes();attributeIter.hasNext();){
							Attribute attribute = (Attribute) attributeIter.next();
							xmlData.append(" " + attribute.getName() + "=\""
									+ attribute.getValue() + "\"");
						}
						xmlData.append(">");
						break;
					case XMLEvent.END_ELEMENT:
						EndElement endElement = event.asEndElement();
						xmlData.append("</" + endElement.getName().getPrefix() + ":" + endElement.getName().getLocalPart() + ">");
						break;
					case XMLEvent.PROCESSING_INSTRUCTION:
						break;
					case XMLEvent.CHARACTERS:
						Characters characters = event.asCharacters();
						xmlData.append(characters.getData());
						break;
					case XMLEvent.COMMENT:
						Comment commentEvent = (Comment) event;
						xmlData.append("<!--" + commentEvent.getText() + "-->").append(NEW_LINE);
						break;
					case XMLEvent.START_DOCUMENT:
						xmlData.append("#######Start of Document#######").append(NEW_LINE);
						break;
					case XMLEvent.END_DOCUMENT:
						xmlData.append(NEW_LINE).append("#######End of Document#######");
						break;
					case XMLEvent.ENTITY_REFERENCE:
						break;
					case XMLEvent.ENTITY_DECLARATION:
						break;
					case XMLEvent.ATTRIBUTE:
						break;
					case XMLEvent.DTD:
						DTD dtd = (DTD) event;
						xmlData.append(dtd.getDocumentTypeDeclaration()).append(NEW_LINE);
//						dtd.getNotations();
//						for(Object obj: dtd.getEntities()){
//							EntityDeclaration entityDecl = (EntityDeclaration) obj;
//							entityDecl.getName();
//							entityDecl.getReplacementText();
//						}
						break;
					case XMLEvent.CDATA:
						Characters cdata = event.asCharacters();
						xmlData.append(cdata.getData());
						break;
					case XMLEvent.SPACE:
						Characters spaces = event.asCharacters();
						xmlData.append(spaces.getData());
						break;
					case XMLEvent.NAMESPACE:
						break;
					case XMLEvent.NOTATION_DECLARATION:
						break;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} finally {
			if (eventReader != null) {
				try {
					eventReader.close();
				} catch (XMLStreamException e) {
				}
			}
		}
		System.out.println(xmlData);
		return xmlData.toString();
	}

	public static boolean writeXML(String filePath) {
		XMLEventWriter eventWriter = null;
		try {
			XMLOutputFactory writerFactory = XMLOutputFactory.newInstance();
			eventWriter = writerFactory.createXMLEventWriter(new FileWriter(new File(filePath)));
			
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			eventWriter.add(eventFactory.createStartDocument());
			eventWriter.add(eventFactory.createComment("Sample input XML for checking StAX parsers"));
			eventWriter.add(eventFactory.createDTD("<!DOCTYPE Envelope [" + " <!ENTITY envelope.cdata \"#CDATA | EMPTY\">"
					+ "<!ELEMENT Envelope (Header, Body)>" + "<!ATTLIST Transaction" + " id CDATA #REQUIRED"
					+ " name CDATA #IMPLIED" + ">" + "]>"));
			
			eventWriter.add(eventFactory.createStartElement("soapenv", "http://schemas.xmlsoap.org/soap/envelope/", "Envelope"));
			eventWriter.add(eventFactory.createNamespace("soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
			eventWriter.add(eventFactory.createNamespace("soapenc", "http://schemas.xmlsoap.org/soap/encoding/"));
			eventWriter.add(eventFactory.createNamespace("xsd", "http://www.w3.org/2001/XMLSchema"));
			eventWriter.add(eventFactory.createNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
			
			eventWriter.add(eventFactory.createStartElement("soapenv", "http://schemas.xmlsoap.org/soap/envelope/", "Header"));
			eventWriter.add(eventFactory.createStartElement("headerNS", "http://header.stax.jaxp.xml.mine", "ServiceHeader"));
			eventWriter.add(eventFactory.createNamespace("headerNS", "http://header.stax.jaxp.xml.mine"));
			eventWriter.add(eventFactory.createStartElement("headerNS", "http://header.stax.jaxp.xml.mine", "clientId"));
			eventWriter.add(eventFactory.createCharacters("StAXParser"));
			eventWriter.add(eventFactory.createEndElement("headerNS", "http://header.stax.jaxp.xml.mine", "clientId"));
			
			eventWriter.add(eventFactory.createEndElement("headerNS", "http://header.stax.jaxp.xml.mine", "ServiceHeader"));
			
			eventWriter.add(eventFactory.createEndElement("soapenv", "http://schemas.xmlsoap.org/soap/envelope/", "Header"));

			eventWriter.add(eventFactory.createStartElement("soapenv", "http://schemas.xmlsoap.org/soap/envelope/", "Body"));
			
			eventWriter.add(eventFactory.createStartElement("bodyNS", "http://body.stax.jaxp.xml.mine", "Transaction"));
			eventWriter.add(eventFactory.createNamespace("bodyNS", "http://body.stax.jaxp.xml.mine"));
			eventWriter.add(eventFactory.createAttribute("id", "10"));
			eventWriter.add(eventFactory.createAttribute("name", "ten"));
			
			eventWriter.add(eventFactory.createStartElement("bodyNS", "http://body.stax.jaxp.xml.mine", "transAmount"));
			eventWriter.add(eventFactory.createCharacters("30000000"));
			eventWriter.add(eventFactory.createEndElement("bodyNS", "http://body.stax.jaxp.xml.mine", "transAmount"));
			
			eventWriter.add(eventFactory.createStartElement("bodyNS", "http://body.stax.jaxp.xml.mine", "creditNarration"));
			eventWriter.add(eventFactory.createCData("7037339:::30000000"));
			eventWriter.add(eventFactory.createEndElement("bodyNS", "http://body.stax.jaxp.xml.mine", "creditNarration"));
			
			eventWriter.add(eventFactory.createEndElement("bodyNS", "http://body.stax.jaxp.xml.mine", "Transaction"));
			
			eventWriter.add(eventFactory.createEndElement("soapenv", "http://schemas.xmlsoap.org/soap/envelope/", "Body"));
			
			eventWriter.add(eventFactory.createEndElement("soapenv", "http://schemas.xmlsoap.org/soap/envelope/", "Envelope"));
			eventWriter.add(eventFactory.createEndDocument());
			eventWriter.flush();
			return true;
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (eventWriter != null) {
				try {
					eventWriter.close();
				} catch (XMLStreamException e) {
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String inFilePath = "./io/input.xml";
		String outFilePath = "./io/output_iterator.xml";
		readXML(inFilePath);
		writeXML(outFilePath);
	}
}
