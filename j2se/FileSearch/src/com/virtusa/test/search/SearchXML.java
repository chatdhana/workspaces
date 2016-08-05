package com.virtusa.test.search;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class SearchXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new SearchXML().parseXML();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	private void parseXML() throws XPathExpressionException {
		XPathFactory xPathFact = XPathFactory.newInstance();
		XPath xPath = xPathFact.newXPath();
		InputSource inputSrc = new InputSource(
				new StringReader(
						"<ISIS><Hdr><MsgId>1234</MsgId><CorrId>corrid0987</CorrId><CorrId>corrid0986</CorrId></Hdr><payload></payload></ISIS>"));
		XPathExpression xPathExp = xPath.compile("/ISIS/Hdr/CorrId1");
		String corrId = xPathExp.evaluate(inputSrc);
		System.out.println("corrId:" + corrId);
	}

}
