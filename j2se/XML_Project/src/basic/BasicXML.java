package basic;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BasicXML {

	/**
	 * @author dgovindan
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse(new File("src/sample.xml"));
		System.out.println("<" + doc.getFirstChild().getNodeName() + ">");
		loop(doc.getDocumentElement());
		System.out.println("</" + doc.getFirstChild().getNodeName() + ">");

	}

	static void loop(Element ele) {
		NodeList nodeList = ele.getChildNodes();
		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			switch (node.getNodeType()) {
			case Node.PROCESSING_INSTRUCTION_NODE:
				System.out.println("PROCESSING_INSTRUCTION_NODE");
				break;
			case Node.ENTITY_NODE:
				System.out.println("ENTITY_NODE");
				break;
			case Node.DOCUMENT_NODE:
				System.out.println("DOCUMENT_NODE");
				break;
			case Node.ELEMENT_NODE:
				System.out.print("<" + node.getNodeName() + ">");
				loop((Element) node.getChildNodes());
				System.out.println("</" + node.getNodeName() + ">");
				break;
			case Node.TEXT_NODE:
				if (node.getNodeValue().trim().length() >= 1)
					System.out.print(node.getNodeValue());
				break;
			case Node.ATTRIBUTE_NODE:
				System.out.println("ATTRIBUTE_NODE");
				break;
			case Node.COMMENT_NODE:
				System.out.println("COMMENT_NODE");
				break;
			case Node.NOTATION_NODE:
				System.out.println("NOTATION_NODE");
				break;

			}

		}
	}

}
